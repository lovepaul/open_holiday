FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD open-holiday-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java  -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8083