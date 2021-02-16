FROM maven:3.6.3-jdk-8-slim as BUILD
WORKDIR /usr/app
COPY pom.xml .
RUN mvn dependency:resolve
COPY ./src ./src
RUN mvn install


FROM tomcat:8.5.55-jdk8-openjdk
ENV JPDA_OPTS="-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"
COPY --from=BUILD /root/.m2/repository/mysql/mysql-connector-java/6.0.6/mysql-connector-java-6.0.6.jar   $CATALINA_HOME/lib/
COPY --from=BUILD /usr/app/target/sistema.war   $CATALINA_HOME/webapps/sistema.war
ENTRYPOINT [ "catalina.sh","jpda", "run" ]