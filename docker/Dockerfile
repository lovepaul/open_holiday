FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD open-holiday.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java  -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8083