$ErrorActionPreference = "Stop"

$project = "C:\Users\WELCOME\Documents\Java Class\Railway"
$tomcat = "C:\Program Files\Apache Software Foundation\Tomcat 10.1_Tomcat10.1.59"

$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.1"
$env:CATALINA_HOME = $tomcat

$src = "$project\src"
$web = "$project\web"
$classes = "$web\WEB-INF\classes"
$tomcatApp = "$tomcat\webapps\Railway"

Write-Host "Railway deployment" -ForegroundColor Cyan
Write-Host "Project : $project"
Write-Host "Tomcat  : $tomcat"
Write-Host ""

# Stop Tomcat if it is running.
& "$tomcat\bin\shutdown.bat" 2>$null
Start-Sleep -Seconds 3

# Prepare local classes directory.
New-Item -ItemType Directory -Force -Path $classes | Out-Null

# Clean old local classes.
Remove-Item "$classes\*" -Recurse -Force -ErrorAction SilentlyContinue

Write-Host "Compiling Java files..." -ForegroundColor Yellow
$javaFiles = Get-ChildItem "$src" -Filter "*.java" -Recurse | ForEach-Object { $_.FullName }

javac -cp "$project\servlet-api.jar" -d "$classes" $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation FAILED." -ForegroundColor Red
    exit 1
}

Write-Host "Compilation successful." -ForegroundColor Green

# Clean old Tomcat application deployment.
if (Test-Path $tomcatApp) {
    Remove-Item "$tomcatApp\*" -Recurse -Force
}
New-Item -ItemType Directory -Force -Path $tomcatApp | Out-Null

Write-Host "Deploying application..." -ForegroundColor Yellow
Copy-Item "$web\*" "$tomcatApp\" -Recurse -Force

Write-Host "Deployment successful." -ForegroundColor Green

# Start Tomcat only after compilation and deployment.
Write-Host "Starting Tomcat..." -ForegroundColor Yellow
& "$tomcat\bin\startup.bat"

Start-Sleep -Seconds 5

Write-Host ""
Write-Host "Application:" -ForegroundColor Cyan
Write-Host "http://localhost:8080/Railway/employeePreference.html"
Write-Host ""
Write-Host "Login:" -ForegroundColor Cyan
Write-Host "http://localhost:8080/Railway/sessionLogin.html"
Write-Host ""
Write-Host "Done." -ForegroundColor Green
