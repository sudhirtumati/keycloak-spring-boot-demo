# Setup

## Overview
![Overview](https://i.ibb.co/CsVz0JN/Keycloak-POC-Setup.png)

## Keycloak

* Download [Keycloak zip](https://www.keycloak.org/downloads) and unzip it
* Run *bin/standalone.bat -Djboss.http.port=9090*
* Open a browser and navigate to [http://localhost:9090](http://localhost:9090)
* Create admin credentials to login to keycloak admin console

### Keycloak data
* Update [keycloak environment json](postman/keycloak.postman_environment.json) with correct values
* Create realm, client, users and roles using below instructions
    * Create realm - Run [Realm Setup](postman/1_Realm_Setup.postman_collection.json) postman collection
    * Create client - Run [Create client](postman/2_Create_client_app.postman_collection.json) postman collection
    * Create order-api client - Run [Create client](postman/3_Create_order-api_app.postman_collection.json) postman collection
    * Manage user roles - Run [Manage user roles](postman/4_Manage_user_roles.postman_collection.json) postman collection

### Regenerate client secret
* Login to keycloak admin console
    * Open [http://localhost:9090](http://localhost:9090)
    * Login with admin credentials created during Keycloak installation
* Switch realm to *Oauth2-demo*
* Select client app
* Go to *Credentials* tab
* Click on *Regenerate Secret*
* Repeat above steps for all client apps

**Note:**  Secret can be provided to the application either as an environment variable or as command line parameter. In
this example, all secrets are provided to application as environment variables

## Postgresql database
To demonstrate session sharing across multiple instances, [spring-session-jdbc](https://spring.io/projects/spring-session-jdbc) 
is used with PostgreSQL database (or any other database of your choice).

### Schema creation
* Execute the schema initialization scripts available in classpath at *org/springframework/session/jdbc/schema-@@platform@@.sql*
* Configure below properties in [application.yml](sample_webapp/src/main/resources/application.yml)
  * spring.datasource.url
  * spring.datasource.username
  * spring.datasource.password
