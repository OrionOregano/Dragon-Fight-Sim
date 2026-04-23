@echo off

if not exist bin mkdir bin

dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt

pause
