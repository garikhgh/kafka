FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY /build/libs/kafka-exam-0.0.1-SNAPSHOT.jar kafka-exam.jar
EXPOSE 8081
CMD ["java", "-jar", "kafka-exam.jar"]