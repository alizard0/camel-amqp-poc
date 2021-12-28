# camel-amqp-poc
proof of concept for camel-amqp using camel-rest for exposing amqp routes.

**run rabbitmq locally**
```bash
$ cd rabbitmq
$ docker build -t my-rabbit .
$ docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 my-rabbit:latest
```

**run application**
```bash
$ mvn clean package
$ java -jar target/camel-amqp-poc-0.0.1-SNAPSHOT.jar 
```

**test with POST**
```bash
$ curl -X POST localhost:8080/api/event -d '{"key1":"value1", "key2":"value2"}' -H 'Content-type: application/json'
```

**expected output**
```json
{
    "key1" : "value1",
    "key2" : "value2"
}
```

**expected logs**
```bash
publishEventDirectRoute                  : Publishing event {key1=value1, key2=value2}
org.apache.qpid.jms.JmsConnection        : Connection ID:3... connected to server: amqp://localhost:5672
route1                                   : Message received {key1=value1, key2=value2}
```