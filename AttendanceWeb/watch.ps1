$project = "C:\Users\WELCOME\Documents\Java Class\AttendanceWeb"
$tomcat = "C:\Program Files\Apache Software Foundation\Tomcat 10.1_Tomcat10.1.59"

$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.1"
$env:CATALINA_HOME = $tomcat

$src = "$project\src"
$web = "$project\web"
$servletApi = "$project\servlet-api.jar"

$classes = "$web\WEB-INF\classes"
$tomcatApp = "$tomcat\webapps\AttendanceWeb"

Write-Host "========================================"
Write-Host " AttendanceWeb - Tomcat Deployment"
Write-Host "========================================"
Write-Host ""

if (!(Test-Path $classes)) {
    New-Item -ItemType Directory -Path $classes -Force | Out-Null
}

if (!(Test-Path $tomcatApp)) {
    New-Item -ItemType Directory -Path $tomcatApp -Force | Out-Null
}

Write-Host "Compiling Java files..."
Write-Host ""

$javaFiles = Get-ChildItem $src -Filter "*.java" -Recurse |
    ForEach-Object { $_.FullName }

if ($javaFiles.Count -eq 0) {
    Write-Host "No Java files found." -ForegroundColor Red
    exit
}

javac `
    -cp "$servletApi" `
    -d "$classes" `
    $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "Compilation FAILED." -ForegroundColor Red
    exit
}

Write-Host ""
Write-Host "Compilation successful." -ForegroundColor Green

Write-Host ""
Write-Host "Deploying application..."
Copy-Item -Recurse -Force `
    "$web\*" `
    "$tomcatApp\"

Write-Host "Deployment successful." -ForegroundColor Green

Write-Host ""
Write-Host "Starting Tomcat..."

& "$tomcat\bin\startup.bat"

Start-Sleep -Seconds 5

Write-Host ""
Write-Host "========================================"
Write-Host " Application started"
Write-Host "========================================"
Write-Host ""
Write-Host "Home:"
Write-Host "http://localhost:8080/AttendanceWeb/"
Write-Host ""
Write-Host "Attendance:"
Write-Host "http://localhost:8080/AttendanceWeb/attendance"
Write-Host ""
Write-Host "Watching: $src"
Write-Host "Press Ctrl+C to stop watching."
Write-Host ""
$lastWrite = @{}

foreach ($file in $javaFiles) {
    $lastWrite[$file] = (Get-Item $file).LastWriteTimeUtc
}

while ($true) {

    $files = Get-ChildItem $src -Filter "*.java" -Recurse

    foreach ($file in $files) {

        $time = $file.LastWriteTimeUtc

        if (!$lastWrite.ContainsKey($file.FullName)) {

            $lastWrite[$file.FullName] = $time
            continue
        }

        if ($lastWrite[$file.FullName] -ne $time) {

            $lastWrite[$file.FullName] = $time

            Write-Host ""
            Write-Host "========================================"
            Write-Host "Java file changed: $($file.Name)"
            Write-Host "Recompiling..."
            Write-Host "========================================"
            $javaFiles = Get-ChildItem $src -Filter "*.java" -Recurse |
                ForEach-Object { $_.FullName }

            javac `
                -cp "$servletApi" `
                -d "$classes" `
                $javaFiles

            if ($LASTEXITCODE -eq 0) {

                Write-Host ""
                Write-Host "Compilation successful." -ForegroundColor Green

                Copy-Item -Recurse -Force `
                    "$web\*" `
                    "$tomcatApp\"

                Write-Host "Application redeployed." -ForegroundColor Green
                Write-Host ""
                Write-Host "Open:"
                Write-Host "http://localhost:8080/AttendanceWeb/attendance"
            }
            else {
                Write-Host ""
                Write-Host "Compilation FAILED." -ForegroundColor Red
            }
        }
    }

    Start-Sleep -Milliseconds 500
}