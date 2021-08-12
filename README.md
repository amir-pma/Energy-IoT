# Energy-IOT

Overview
-------------------------
This project is an api for processing energy meters and their data.
Tools and technologies used by this project: microservices, spring boot, kafka, eureka, hystrix and swagger, flyway, postgres and etc.


Suspicious Senario
-------------------------

Couldn't find a good suspicous senario that doesn't require machine learning to detect suspicious electricity consumption. The suspicious senario implemented in this project is that an alert will be sent if an energy meter's usage in each week is more than 5 times of it's previous week's usage.


Architecture
-------------------------

![alt text](https://github.com/amir-pma/Energy-IoT/blob/5147a09ae0c4b8b448b2bc13a5a107a5470840c8/architecture.jpg)


API Documentation
-------------------------

Swagger api documentations for different microservices:

Gateway Service:
http://localhost:9191/swagger-ui.html

Energy Meter Service:
http://localhost:9192/swagger-ui.html

Tariff Service:
http://localhost:9193/swagger-ui.html

Alert Service:
http://localhost:9194/swagger-ui.html

Meter Data Message Producer Service:
http://localhost:9195/swagger-ui.html


How To Build And Run
-------------------------

1- Run tariff and energy meter postgres database servers.

2- Start Zookeeper server:
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

3- Start Kafka server:
    .\bin\windows\kafka-server-start.bat .\config\server.properties

4- Run microservices applications in this order:
    a) Service Registry  b) Cloud Gateway  c) Tariff Service  d) Alert Service  e) Meter Data Message Producer Service  f) Energy Meter Service  g) Hystrix Dashboard


Usefull Commands
-------------------------

Hystrix Dashboad Address:
http://localhost:9196/hystrix

Hystrix Stream Address:
http://localhost:9191/actuator/hystrix.stream

Create Topic:
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic test

List Down All Available Topics:
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181

Produce A Message:
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test

Consume A Message:
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test