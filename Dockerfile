FROM openjdk:22-slim

COPY target/kafka-dummy-producer.jar app.jar

CMD ["java", "-jar", "app.jar"]