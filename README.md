# user-service
# Requirement
## Java 11, MySQL

# Prepare
## Must update placeholder value in file application.properties such as username, password (DB). Make sure port in application.properties is un use.

# Start spring boot application
## Many way to run app
### Way 1: Using terminal -> ./gradlew bootRun
### Way 2: Using IDE -> In file UserServiceApplication.java -> Run UserServiceApplication.main() (IntelliJ)
### Way 3: Deep dive to know how to build and run java app
#### 3.1. Install java, gradle
#### 3.2. In terminal -> gradle build. If build successfully, run java -jar .\build\libs\*.jar