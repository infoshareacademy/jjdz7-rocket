#!/bin/sh

echo "<<<========= RUN MAVEN ==========>>>"
mvn clean install
echo "<<<========= KILL CONTAINERS ==========>>>"
docker-compose down
echo "<<<========= BUILD & RUN CONTAINERS ==========>>>"
sudo docker-compose up -d --build
echo "<<<========= READY ==========>>>"
