FROM openjdk:17

# Add the application's jar to the container
ADD out/artifacts/MavenApp_jar/MavenApp.jar MavenApp.jar
ENTRYPOINT ["java", "-jar","MavenApp.jar"]