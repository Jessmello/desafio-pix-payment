USE Desafio;

CREATE TABLE payment (
    id_payment integer not null auto_increment,
    ds_status varchar(10) not null,
    dt_inclusion datetime not null,
    dt_payment datetime not null,
    vl_payment float not null,
	ds_payment varchar(200),
	ds_key varchar(200) not null,
	cd_key varchar(10) not null,
	dt_final datetime,
	ds_frequecy varchar(10),
	PRIMARY KEY (id_payment) 
);

CREATE TABLE proof_payment (
    id_proof_payment integer not null auto_increment,
    id_payment integer not null,
    dt_inclusion datetime not null,
    dt_payment datetime not null,
    vl_payment float not null,
	ds_payment varchar(200),
	ds_key varchar(200) not null,
	cd_key varchar(10) not null,
	dt_final datetime,
	ds_frequecy varchar(10),
	PRIMARY KEY (id_proof_payment),
	FOREIGN KEY (id_payment) REFERENCES payment(id_payment)
);



SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;