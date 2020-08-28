# Docker Practice Task


### Requirements:

- Install JDK 8 according to your OS and processor architecture.
- Install Maven 3.6.0
- Install Docker


### To install application:

use `mvn clean install`

### To run application:

use `java -jar events-rest/target/events-rest-1.0-SNAPSHOT.jar`

### Docker hub:

link to docker hub image: https://hub.docker.com/repository/docker/yevhenlieposhkin/event-service

to run image from docker hub: `docker run yevhenlieposhkin/event-service`

### Swagger

link to the swagger: http://localhost:8080/swagger-ui.html

link to the swagger if run with `docker-entrypoint.sh` : http://localhost:7080/swagger-ui.html
