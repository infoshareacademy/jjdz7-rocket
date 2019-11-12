#!/bin/sh

echo "<<<========= RUN MAVEN ==========>>>"
mvn clean install
echo "<<<========= KILL CONTAINERS ==========>>>"
docker-compose down
echo "<<<========= BUILD CONTAINERS ==========>>>"
docker-compose build
echo "<<<========= RUN CONTAINERS ==========>>>"
docker-compose up -d
echo "<<<========= TWÓJ STARY ==========>>>"
