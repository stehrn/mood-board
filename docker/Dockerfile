# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY mood-board-0.0.1-SNAPSHOT.jar /app.jar
# set env variable
ENV mood_not_found_message default for docker
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]