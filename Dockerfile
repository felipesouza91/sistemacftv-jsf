FROM tomcat:8.5.55-jdk8-openjdk
RUN MAVEN_VERSION=3.3.9 \
  && cd /usr/share \
  && wget http://ftp.unicamp.br/pub/apache/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -O - | tar xzf - \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

WORKDIR /home/app
COPY . .
RUN mvn -T 1C install \
  && mv ./target/*.war $CATALINA_HOME/webapps
