# Load balancing
To test the behind a proxy with multiple instances running

## Ports
* Load balancer port: 8080
* Web application instance 1 port: 8090
* Web application instance 2 port: 8091

## Start 2 instances of web application
Navigate to `sample_webapp` folder and start first instance with port 8090
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8090 --keycloak.credentials.secret=<keycloak_client_secret>"
```

Start second instance with port 8091
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8091 --keycloak.credentials.secret=<keycloak_client_secret>"
```

**Note:** Make sure both instances are up and running before starting the load balancer

## Start 1 instance of api application
Navigate to `sample-api` folder and start application with port 9000
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=9000"
```

## Start load balancer
* Navigate to `http_load_balancer` folder in terminal and start application with below command
```
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8080"
```