## Configurando MYSQL Docker 


Executar comando dentro da pasta docker

```sh
docker-compose -f docker-mysql.yml up
```


## Configurando RabbitMQ Docker 

### Executar comando dentro da pasta docker

```sh
docker-compose -f docker-rabbitmq.yml up
```

### Acessar o admin do RabbitMQ

```sh 
http://localhost:15672/ 
```

Username: admin

Password: admin


### Criar as Queues

1. compras-aguardando
2. compras-finalizado




## Configuração do banco REDIS

Executar comando dentro da pasta docker

```sh
docker-compose -f docker-redis.yml up
```
