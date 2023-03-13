mvn clean package
echo "jar file is being exported please wait "
docker build --tag=we-connect:latest .
echo "docker build successfull "
docker run -p 9090:9090 we-connect:latest