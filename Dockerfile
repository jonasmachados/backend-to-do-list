# Build stage
FROM maven AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

# Package stage
FROM adoptopenjdk:15-jre-hotspot
COPY --from=build /target/backend-to-do-list-0.0.1-SNAPSHOT.jar backend-to-do-list.jar

# ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java","-jar","backend-to-do-list.jar"]
