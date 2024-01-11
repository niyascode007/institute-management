FROM openjdk:17
COPY build/libs/institute-0.0.1-SNAPSHOT.jar institute-1.0.0.jar
ENTRYPOINT ["java","-jar","/institute-1.0.0.jar"]