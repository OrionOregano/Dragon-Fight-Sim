@echo off

if not exist bin mkdir bin

javac -d bin -sourcepath src src/Game/Main.java

java -cp bin Game.Main

pause