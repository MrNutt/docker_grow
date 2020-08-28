FROM centos:7

MAINTAINER Yevhen L

USER root

# Repository update
RUN yum -y update && yum clean all

# Install necessary packages
RUN yum list available \*openjdk\*
RUN yum -y install java-1.8.0-openjdk

# Env variable
ARG SERVICE_LOCATION=/apps/jmp/docker/event-service

# Create directory structure
RUN mkdir -p "$SERVICE_LOCATION"

WORKDIR $SERVICE_LOCATION

ADD event-service-rest/target/event-service-rest-1.0-SNAPSHOT.jar $SERVICE_LOCATION

ENTRYPOINT ["java", "-jar", "event-service-rest-1.0-SNAPSHOT.jar"]
