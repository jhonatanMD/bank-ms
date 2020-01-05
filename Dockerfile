FROM openjdk:8
VOLUME /tmp
ADD ./target/bank-ms-0.0.1-SNAPSHOT.jar bank-ms.jar
ENTRYPOINT ["java","-jar","/bank-ms.jar"]