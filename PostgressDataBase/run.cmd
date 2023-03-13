@echoff
docker build -t my-postgres-db ./ 
docker run --name postgres-db -e POSTGRES_PASSWORD=root -p 5432:5432 -d postgres