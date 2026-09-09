# Railway HRMS Servlet Project

## Structure

Railway/
  servlet-api.jar
  src/com/example/
    SessionLogin.java
    HRMSPreferenceServlet.java
    HRMSViewPreferenceServlet.java
  web/
    sessionLogin.html
    employeePreference.html
    WEB-INF/classes/com/example/
  watch1.ps1

## Manual compile

Open PowerShell:

    cd "C:\Users\WELCOME\Documents\Java Class\Railway"
    $env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.1"
    javac -cp ".\servlet-api.jar" -d ".\web\WEB-INF\classes" .\src\com\example\*.java

## Deploy and start

Run:

    .\watch1.ps1

The script:
1. Stops Tomcat.
2. Compiles all servlets.
3. Cleans the old Railway deployment.
4. Copies the web application.
5. Starts Tomcat.

## URLs

Login:
http://localhost:8080/Railway/sessionLogin.html

Preferences:
http://localhost:8080/Railway/employeePreference.html

## Test login

Employee ID: 1001
Password: hrms123

After successful login, the session contains employeeId=1001.

Then open employeePreference.html and save preferences.

## Important

Do not put servlet-api.jar inside WEB-INF/lib. Tomcat 10.1 supplies the Jakarta Servlet API.

All Java source files use:

    package com.example;

Servlet mappings:
- /sessionLogin
- /savePreference
- /viewPreference
