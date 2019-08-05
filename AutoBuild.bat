@ECHO OFF
call mvn test
call mvn clean compile assembly:single

