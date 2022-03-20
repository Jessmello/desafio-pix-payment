# desafio-pix-payment.app
Desafio Pagamento Pix

#Subindo Kafka
docker-compose up -d


#Subindo MSQL
docker build -t desafio-db .

docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=T1Way2Slstwof3Wcbbtts3 -e MYSQL_DATABASE=Desafio -e MYSQL_USER=desafioUser -e MYSQL_PASSWORD=desafioPix2022 desafio-db
