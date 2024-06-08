FROM openjdk:17

ARG JAR_FILE=./target/all4ocean-0.0.1-SNAPSHOT.jar

ENV APP_HOME=/usr/src/app

ENV PATH=/opt/openjdk-17/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
ENV JAVA_HOME=/opt/openjdk-17
WORKDIR $APP_HOME

COPY $JAR_FILE $APP_HOME/app.jar

EXPOSE 8080

RUN useradd -m appuser
USER appuser

CMD java -jar app.jar

