## Application Description
#### Application gets notifications via rest api then redirects to a kafka producer.
#### Next, the application kafka listener receives the notifications and stores them in PostgresSQL     
```json
{
  "description": "I am notification"
}
```
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
### response body should look like bellow json object
```json
{
  "_embedded": {
    "notification": [
      {
        "description": "I am notification",
        "createdAt": "2024-03-17T09:08:35.921991Z",
        "_links": {
          "self": {
            "href": "http://localhost:8081/notification/1"
          },
          "notificationEntity": {
            "href": "http://localhost:8081/notification/1"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8081/notification?page=0&size=20"
    },
    "profile": {
      "href": "http://localhost:8081/profile/notification"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 1,
    "totalPages": 1,
    "number": 0
  }
}
```

## Check Notification sending, receiving and creation using commands at bellow directory 
    /request/request.http