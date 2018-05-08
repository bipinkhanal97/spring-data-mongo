This is a very basic example of Spring Boot with Mongo.


## Installation
*for newbies : Install Mongodb 

## Configuration
/src/main/resources/application.yml



`spring:
  data:
    mongodb:
      database: test_db
      uri: mongodb://localhost:27017

server:
  port: 8090

logging:
  level:
    org.springframework.web: ERROR
    root: INFO
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
`	

## Dependencies
Spring Boot: 1.5.2.RELEASE

## Information

Run gradle task build and then bootRun - application will be available on port 8090	
