# Keycloak Spring Boot demo app

## Setup

### Keycloak

* Download [Keycloak zip](https://www.keycloak.org/downloads) and unzip it
* Run *bin/standalone.bat -Djboss.http.port=9090*

### Keycloak data
* Create realm, client, users and roles using below instructions
  * Create realm - Run [Realm Setup](postman/1_Realm_Setup.postman_collection.json) postman collection
  * Create client - Run [Create client](postman/2_Create_client_app.postman_collection.json) postman collection
  * Manage user roles - Run [Manage user roles](postman/3_Manage_user_roles.postman_collection.json) postman collection

### Regenerate client secret
* Login to keycloak admin console
  * Open [http://localhost:9090](http://localhost:9090)
  * Login with admin credentials created during Keycloak installation
* Switch realm to *Oauth2-demo*
* Go to *Credentials* tab
* Click on *Regenerate Secret*
* Create new environment variable *keycloak.credentials.secret* with generated secret as its value
  * If you are using an IDE (IntelliJ IDEA or Eclipse or others) edit **Run/Debug configuration** to add environment variable

## Testing the application
* Go to [localhost:8080/me](http://localhost:8080/me). You will be redirected to Keycloak login page
* Authenticate by providing valid credentials
* Upon successful authentication, access token will be shown
* Using a REST API test utility (like postman)
  * Make an API call to [/actuator/env](http://localhost:8080/actuator/env)
  * Provide access token as *Authorization* header

## Reset Keycloak
* Delete realm - Run [Reset](postman/4_Reset.postman_collection.json) postman collection