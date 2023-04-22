# Hostname Resolution spring boot App.

### Getting Started
All Maven plugins and dependencies are available from Maven Central. Please have installed

- JDK 1.8 (tested with both Oracle and OpenJDK)
- Maven 3.3+ (also tested with 3.5.x)
- Docker 1.13 or better (17.05.0-ce-rc2 or better for multi-stage builds)
- Docker compose for manging the build and start of containers

### Building
```
cd java-webapi
mvn clean install
```

### How to Build

```
docker-compose build
docker-compose up
```

### Test the Endpoint

```
# curl -X POST  http://localhost
   -H 'Content-Type: application/json'
   -d '{"hostname":"google.com"}'
```