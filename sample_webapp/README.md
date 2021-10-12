## Testing the application

### Public endpoints
* Calls to below actuator endpoints must be open
  * [/actuator/health](http://localhost:8080/actuator/health)
  * [/actuator/info](http://localhost:8080/actuator/info)

## Protected endpoints
* Go to [localhost:8080/me](http://localhost:8080/me). You will be redirected to Keycloak login page
* Authenticate by providing valid credentials
* Upon successful authentication, user information will be shown
* Go to [localhost:8080/me/orders](http://localhost:8080/me/orders)

## API authentication with bearer token
* Using a REST API test utility (like postman)
    * Make an API call to [http://localhost:8080/actuator/env](http://localhost:8080/actuator/env) by providing access token as *Authorization* header. Valid response must be returned.
    * Make an API call to [localhost:9000/orders?customerId=valid_customer_id](localhost:9000/orders?customerId=valid_customer_id) by providing access token as *Authorization* header. Valid response must be returned.
