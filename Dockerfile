FROM adoptopenjdk/openjdk11-openj9:alpine-jre

ENV APP_TARGET target
ENV APP desafio.jar

RUN mkdir -p /opt
COPY ${APP_TARGET}/${APP} /opt

CMD java -Dspring.profiles.active=${SPRING_PROFILES} ${JAVA_OPTS} \
    -Xms${JAVA_XMS:-512m} \
    -Xmx${JAVA_XMX:-1024m} \
    -jar /opt/${APP}