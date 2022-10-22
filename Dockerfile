FROM openjdk:11-jre-slim

WORKDIR root/

ADD build/libs/demo-0.0.1-SNAPSHOT.jar ./application.jar

CMD java -server -Xmx256M -jar /root/application.jar