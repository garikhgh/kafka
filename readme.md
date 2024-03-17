## Application Description
#### Application gets notifications via rest api then redirects to a kafka producer.
#### Next, the application kafka listener receives the notifications and stores then in PostgreSQL     

### In Order to Run the project just follow to the bellow steps.
### Build the project

```bash
$ ./gradlew clean build
```

Startup the project, run the bellow command:
```bash
$ cd ./docker/
$ docker-compose up -d
```

To stop the running Docker containers.
```bash
$ cd ./docker/
$ docker-compose down
```

## Run on Linux
### Send notification via Kafka and store
#### wait for 20 seconds in order to establish kafka connection
```bash
$ curl  -X POST http://localhost:8081/api/v1/notification -H "Content-Type: application/json" -d "{\"description\":\"I am notification\"}'"
```

## Check if the notifications are created.
```bash
curl  -X GET localhost:8081/notification -H "Content-Type: application/json"
```

## Check Notification sending, receiving and creation using 
    /request/request.http