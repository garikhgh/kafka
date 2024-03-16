In Order to Run the project just follow to the bellow steps.

### On Linux
Go to the Docker-compose file directory.
```bash
#!/bin/bash
if [ -f docker-compose.yaml ]; then
    echo "You are in a Docker environment. Doing nothing."
else
    # Change directory to your Docker setup directory
    cd ./docker/
    echo "Switched to Docker setup directory."
fi
```

Startup the project, run the bellow command:
```bash
$ docker-compose up -d
```

To stop the running Docker containers.
```bash
$ docker-compose down
```

## Run on Linux
### Send notification via Kafka and store
```bash
$ curl  -X POST http://localhost:8081/api/v1/notification -H "Content-Type: application/json" -d "{\"description\":\"I am notification\"}'"
```

## Cech if the notifications are created.
```bash
curl  -X GET localhost:8081/notification -H "Content-Type: application/json"
```


## Run on Windows
### Send notification via Kafka and store
```bash
Invoke-WebRequest -Uri 'http://localhost:8081/api/v1/notification' -Method POST -Headers @{'Content-Type'='application/json'} -Body '{"description":"I am notification"}'
```
