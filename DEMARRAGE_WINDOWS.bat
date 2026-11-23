@echo off
setlocal
cd /d "%~dp0"
echo Compilation de tous les microservices...
call discovery-service\mvnw.cmd -f discovery-service\pom.xml -U -DskipTests package
if errorlevel 1 (echo Echec Maven. Verifiez JAVA_HOME et Internet.& pause & exit /b 1)
for %%S in (config-service customer-service inventory-service gatewey-service billing-service) do (
  call %%S\mvnw.cmd -f %%S\pom.xml -U -DskipTests package
  if errorlevel 1 (echo Echec compilation %%S& pause& exit /b 1)
)
echo Demarrage dans des fenetres separees...
start "Eureka discovery" cmd /k "cd /d "%~dp0discovery-service" && call mvnw.cmd spring-boot:run"
timeout /t 12 /nobreak >nul
start "Config service" cmd /k "cd /d "%~dp0config-service" && call mvnw.cmd spring-boot:run"
timeout /t 8 /nobreak >nul
for %%S in (customer-service inventory-service gatewey-service billing-service) do (
  start "%%S" cmd /k "cd /d "%~dp0%%S" && call mvnw.cmd spring-boot:run"
  timeout /t 4 /nobreak >nul
)
echo Services lances. Consultez http://localhost:8761
pause
