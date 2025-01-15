FROM maven:3.6.3-jdk-8-slim as BUILD
WORKDIR /usr/app
COPY pom.xml .
RUN mvn dependency:resolve
RUN mvn dependency:resolve-plugins
COPY ./src ./src
RUN mvn install 


FROM tomcat:8.5.100-jre8-temurin-jammy

COPY --from=BUILD /root/.m2/repository/mysql/mysql-connector-java/8.0.22/mysql-connector-java-8.0.22.jar   $CATALINA_HOME/lib/
COPY --from=BUILD /usr/app/target/sistema.war   $CATALINA_HOME/webapps/sistema.war

RUN echo \
'<?xml version="1.0" encoding="UTF-8"?> \
<Context> <WatchedResource>WEB-INF/web.xml</WatchedResource>\
 <WatchedResource>$CATALINA_HOME/conf/web.xml</WatchedResource>\
  <Resource name="jdbc/sistema" type="javax.sql.DataSource" \
  maxActive="100" maxIdle="30" maxWait="1000" \
  url="jdbc:mysql://DATABASE_HOST:3306/databasecftv" \
   driverClassName="com.mysql.jdbc.Driver" \
    username="DATABASE_USER" password="DATABASE_PASSWORD" />\
     </Context>' > $CATALINA_HOME/conf/context.xml

CMD ["/bin/sh","-c","sed -i s#DATABASE_HOST#$DATABASE_HOST#g $CATALINA_HOME/conf/context.xml && \
     sed -i s#DATABASE_USER#$DATABASE_USER#g $CATALINA_HOME/conf/context.xml && \
     sed -i s#DATABASE_PASSWORD#$DATABASE_PASSWORD#g $CATALINA_HOME/conf/context.xml && \
     catalina.sh run"]