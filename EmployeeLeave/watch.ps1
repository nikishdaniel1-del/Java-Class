$project = "C:\Users\WELCOME\Documents\Java Class\EmployeeLeave"
$tomcat = "C:\Program Files\Apache Software Foundation\Tomcat 10.1_Tomcat10.1.59"

$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.1"
$env:CATALINA_HOME = $tomcat

$classes = "$project\web\WEB-INF\classes"
$tomcatApp = "$tomcat\webapps\EmployeeLeave"

Write-Host "Starting Tomcat..."

& "$tomcat\bin\startup.bat"

Start-Sleep -Seconds 5

Write-Host ""
Write-Host "Compiling Java files..."

$javaFiles = Get-ChildItem "$project\src" -Filter "*.java" -Recurse |
    ForEach-Object { $_.FullName }

javac `
    -cp "$project\servlet-api.jar" `
    -d "$classes" `
    $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation FAILED." -ForegroundColor Red
    exit
}

Write-Host "Compilation successful."

Write-Host "Deploying application..."

Copy-Item -Recurse -Force `
    "$project\web\*" `
    "$tomcatApp\"

Write-Host "Deployment successful."
Write-Host "Application: http://localhost:8080/EmployeeLeave/"
Write-Host ""

$lastWrite = @{}

foreach ($file in $javaFiles) {
    $lastWrite[$file] = (Get-Item $file).LastWriteTimeUtc
}

Write-Host "Watching: $project\src"
Write-Host "Press Ctrl+C to stop."
Write-Host ""

while ($true) {

    $files = Get-ChildItem "$project\src" -Filter "*.java" -Recurse

    foreach ($file in $files) {

        $time = $file.LastWriteTimeUtc

        if (!$lastWrite.ContainsKey($file.FullName)) {

            $lastWrite[$file.FullName] = $time

            continue
        }

        if ($lastWrite[$file.FullName] -ne $time) {

            $lastWrite[$file.FullName] = $time

            Write-Host ""
            Write-Host "Java file changed: $($file.Name)"
            Write-Host "Compiling..."

            $javaFiles = Get-ChildItem "$project\src" -Filter "*.java" -Recurse |
                ForEach-Object { $_.FullName }

            javac `
                -cp "$project\servlet-api.jar" `
                -d "$classes" `
                $javaFiles

            if ($LASTEXITCODE -eq 0) {

                Write-Host "Compilation successful."

                Copy-Item -Recurse -Force `
                    "$project\web\*" `
                    "$tomcatApp\"

                Write-Host "Deployed to Tomcat."
                Write-Host "Open: http://localhost:8080/EmployeeLeave/"
            }
            else {
                Write-Host "Compilation FAILED." -ForegroundColor Red
            }
        }
    }
    Start-Sleep -Milliseconds 500
}