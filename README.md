
#  MusalaSoft Drones #

This README would normally document whatever steps are necessary to get your application up and running.

## Assumptions

All these configurations were made using:

* Eclipse Oxygen.3a Release (4.7.3a).
* IntelliJ IDEA 2020.1.2 (Ultimate Edition).

## Prerequisites

* Install docker >= 19.03.0+
* Install docker-compose >= 1.27.0+
* Install Java 11. (Only for deployment in local environment)
* Install Maven, download it from [here](https://maven.apache.org/download.cgi). (Only for deployment in local 
  environment) Also, a good article to know [how to configure Maven on Windows](https://www.mkyong.
  com/maven/how-to-install-maven-in-windows/).

## Steps for configuration

1) Make the following files inside the folder:

| Filename                       | Location             | Rename to                     |
|--------------------------------|----------------------|-------------------------------|
| `application-local.properties` | src/main/resources   | application-local.properties  |

2) In you IDE, create a SpringBoot run configuration and use profile `local` for its execution:

3) Add the following properties to the properties file `application-local.properties`

| Property (if external properties file is used) | Example | Description                                                                                                 |
|------------------------------------------------|---------|-------------------------------------------------------------------------------------------------------------|
| `server.port`                                  | 6868    | Port on which the application is running. The default port is 6868 but it can be changed to your preference |
| `musalasoft.general.limit-drones`              | 10      | Number of drones that can be created                                                                        |
| `musalasoft.general.default-battery-capacity`  | 100     | Battery capacity value when the drone is created. Value expressed in percentage                             |
| `musalasoft.general.battery-level-below`       | 25      | Minimum battery level required to load the drones with medications. Value expressed in percentage           |
| `musalasoft.scheduled-job-delay`               | 10000   | Delay time to validate the battery level of each drone. Value expressed in milliseconds.                    |

## Project deployment in LOCAL environment

1) Run the following command to initialize a container with MySQL:

```bash
docker-compose up mysqldb
```

2) Run the following command to initialize the data model schema with migrations:

```bash
mvn clean liquibase:update
```

3) How to run it, Verify that the project compiles correctly, from CLI:

```bash
mvn clean install
```

4) Run your SpringBoot project and test it with:

```bash
cd target
java -jar drones-1.0.0.jar
```

## Project deployment in DOCKER environment

1) Run the following command to initialize all containers:

```bash
docker-compose up -d
```

## Wiki documentation

Wiki for documentation of all endpoints available on Swagger V3

Local environment
```bash
http://localhost:8080/musala-soft/api/swagger-ui/index.html
```

docker environment
```bash
http://localhost:6868/musala-soft/api/swagger-ui/index.html
```

## Postman Collection V2.1
```bash
./source/musala-soft-drones-api.postman_collection.json
```