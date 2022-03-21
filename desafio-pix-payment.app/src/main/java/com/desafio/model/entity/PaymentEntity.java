package com.desafio.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="id_payment")
    private Long id;

    @Column(name = "ds_status")
    private String status;

    @Column(name = "dt_inclusion")
    private LocalDate inclusionDate;

    @Column(name = "dt_payment")
    private LocalDate date;

    @Column(name = "vl_payment")
    private BigDecimal value;

    @Column(name = "ds_payment")
    private String description;

    @Column(name = "dt_final")
    private LocalDate finalDate;

    @Column(name = "ds_frequecy")
    private String frequency;

    @Column(name = "ds_key")
    private String pixKey;

    @Column(name = "cd_key")
    private String keyType;

}
