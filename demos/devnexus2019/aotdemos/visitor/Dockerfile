FROM openjdk:8-jdk-alpine 
RUN apk --no-cache add curl
COPY build/libs/*.jar deepdive.jar
CMD java ${JAVA_OPTS} -jar deepdive.jar