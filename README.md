## About
Simple/Sample project showing how to use slf4j with log4j

## Overwriting log4j.properties with command line
Windows

`-Dlog4j.configuration="file:/c:/dev/my-log4j.properties"`

## Build
`mvn clean package dependency:copy-dependencies`

`java -cp "target/{project-name-version}.jar;target/dependency/*" MainClassToExecute`
