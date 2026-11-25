# --------- Stage 1: Compilation & Packaging ---------
FROM maven:3.10.0-eclipse-temurin-25-noble AS builder
LABEL author="Stiwar" version="1.0-SNAPSHOT" description="Simple REST API"
WORKDIR /app
# Copy parent POM and the module POMs.
COPY pom.xml .
COPY controller/pom.xml ./controller/
COPY service/pom.xml ./service/
COPY persistence/pom.xml ./persistence/
COPY model/pom.xml ./model/
# Copy the source code of each module and Service unit tests
COPY controller/src ./controller/src
COPY service/src ./service/src
COPY persistence/src ./persistence/src
COPY model/src ./model/src

# Package the multi-module project
RUN mvn clean package

# --------- Stage 2: Execution ---------
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=builder /app/controller/target/people-rest-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
