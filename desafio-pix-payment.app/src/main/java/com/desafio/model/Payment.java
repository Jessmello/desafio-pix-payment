package com.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name="id_payment")
    Long id;

    @Column(name = "ds_status")
    String status;




}
