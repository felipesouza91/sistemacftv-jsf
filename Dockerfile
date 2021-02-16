FROM maven:3.6.3-jdk-8-slim as BUILD
WORKDIR /usr/app
COPY pom.xml .
RUN mvn dependency:resolve
RUN mvn dependency:resolve-plugins
COPY ./src ./src
RUN mvn install 


FROM tomcat:8.5.55-jdk8-openjdk
COPY --from=BUILD /root/.m2/repository/mysql/mysql-connector-java/8.0.22/mysql-connector-java-8.0.22.jar   $CATALINA_HOME/lib/
COPY --from=BUILD /usr/app/target/sistema.war   $CATALINA_HOME/webapps/sistema.war
