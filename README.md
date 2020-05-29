# micronaut-kotlin
micronaut-kotlin integration

#build
./gradlew clean build installDist

#run on docker
docker-compose -f docker-compose.yml up -d --build

#how to call REST-API
$curl -X POST http://192.168.99.100:8080/test/131wfgfg23\
$curl http://192.168.99.100:8080/test/

