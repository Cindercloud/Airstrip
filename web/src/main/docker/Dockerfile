FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

# add directly the war
ADD airstrip.jar /airstrip/airstrip.jar
ADD application.yml /airstrip/application.yml

EXPOSE 8081
CMD java -Dspring.config.location=/airstrip/ -Djava.security.egd=file:/dev/./urandom -jar /airstrip/airstrip.jar
