# desafio-pix-payment.app
Desafio Pagamento Pix

Para rodar esse projeto é necessario possuir o docker instalado na maquina, caso não possua efetuar o download em https://www.docker.com/products/docker-desktop/ 

#Subindo Kafka:
Para executar o kafka é necessario entrar na pasta kafka e executar o seguinte comando: docker-compose up -d

#Subindo Mysql
Para executar o Mysql é necessario entrar na pasta mysql e seguir o seguintes comandos separadamente:

docker build -t desafio-db .

docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=T1Way2Slstwof3Wcbbtts3 -e MYSQL_DATABASE=Desafio -e MYSQL_USER=desafioUser -e MYSQL_PASSWORD=desafioPix2022 desafio-db
