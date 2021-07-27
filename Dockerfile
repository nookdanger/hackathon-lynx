FROM adoptopenjdk/openjdk11-openj9:alpine-jre

VOLUME /tmp

RUN mkdir /app

ADD build/libs/lynx-0.0.1-SNAPSHOT.jar /app.jar

COPY Bangkok /etc/localtime

RUN echo Asia/Bangkok > /etc/timezone

ENTRYPOINT exec java $JAVA_OPTS $TIME_ZONE -jar /app.jar --spring.config.location=/home/application.yml