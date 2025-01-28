@echo off
cd /d "%~dp0"
set /p options=Enter path and options of start:
java -jar "program.jar" %options%
pause