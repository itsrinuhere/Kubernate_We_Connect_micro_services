$docker build -t webapi:01 .
$docker run -p 8080:8080 webapi:01


FROM jetty
ADD sample.war /var/lib/jetty/webapps/root.war
EXPOSE 8080

Then it’s time to build and run the docker container.

Build the container:


docker build -t jetty .

Run the container:


docker run -p 8080:8080 jetty