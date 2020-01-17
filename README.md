## Profile of Application
It is a simple REST service which you can return details of given Github repository.
Use simple GET request look like:

```GET /repositories/{owner}/{repository-name}```

You should get information look like:
```
{
"fullName": "...",
"description": "...",
"cloneUrl": "...",
"stars": 0,
"createdAt": "...
}
```

### Run application
* I way - using intellij IDE:
    * set active profile for application configuration```Run -> EditConfiguration -> Active profile```
    * run Application class
    
* II way - using spring-boot plugins
    * use use a command line
        ```mvn spring-boot:run```

### Run application test
* I way - using intellij IDE and run test classes
        
* II way - using maven plugins
    * use use a command line
        ```mvn test```