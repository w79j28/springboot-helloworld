FROM java:8 
VOLUME /tmp 
ADD springboot-0.0.3.jar app.jar 
RUN bash -c 'touch /app.jar' 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]