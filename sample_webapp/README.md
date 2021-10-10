## Testing the application

### Public endpoints
* Calls to below actuator endpoints must be open
  * [/actuator/health](http://localhost:8080/actuator/health)
  * [/actuator/info](http://localhost:8080/actuator/info)

## Protected endpoints
* Go to [localhost:8080/me](http://localhost:8080/me). You will be redirected to Keycloak login page
* Authenticate by providing valid credentials
* Upon successful authentication, access token will be shown

## API authentication with bearer token
* Using a REST API test utility (like postman)
    * Make an API call to [/actuator/env](http://localhost:8080/actuator/env)
    * Provide access token as *Authorization* header