# Virus System API
Develop a API to manage virus and its families.

## Technology Stack
- Spring Boot 
- Gradle
- MongoDB
- Java 8
- Log4j2

## Compatible IDE
- Netbeans
    - Install Gradle Plugin for Netbeans.
- Intellij
- Eclipse

## Package Anatomy

### com.system.customer.controllers.*
Use this to integrate with your front-end, 
these controllers use spring-web to expose endpoints to clients.

### com.system.customer.entities.*
In this package you will see Business Entities like Product and Brand. 
These entities are mapped directly into mondodb using spring-data-mongodb.

### com.system.customer.repositories.*
In this package you will see classes that talks to database, 
they handle low level orchestration of communication to database.

### com.system.customer.services.*
In this package you will see classes that deals with business flows, 
this is the place to orchestrate business flows. This classes
talks to its corresponding repository to fetch data from db. 

## Project Configuration
You may check on application.properties file for the default application config.
You may add environment specific config if needed e.g. application-prod.properties

## API Documentation
I have provided postman documentation, you may visit this link to view interactive API documentation of this project.
The API doc also provides you ways to integrate using many other scripting/programming languages like curl,java,c#.
https://documenter.getpostman.com/view/2693913/TVep87hc


## MongoDB Configuration
You can use Compass to inspect changes in the mongodb
 - URI: mongodb+srv://marko:qYLaaIqDFgVPHi5r@cluster0.dd8bu.mongodb.net/kbdev?retryWrites=true&w=majority
 
## In case app did not stop force it
 - sudo lsof -i :8080
 - kill -9 PID

## Authors
- Mark Anthony Ortiz - ortizmark905@gmail.com

## Reference
- https://github.com/markortiz905/virus-system-api
