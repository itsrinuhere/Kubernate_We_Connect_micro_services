# FROM tomcat:8.5.85-jre17-temurin-jammy--
FROM jetty

LABEL mainteiner="itsrinuhere1@gmail.com"

#ADD target/API.war /usr/local/tomcat/webapps/
ADD target/API.war    /var/lib/jetty/webapps/root.war
EXPOSE 8080

#CMD [ "catalina.sh","run" ]