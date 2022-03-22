package com.desafio.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@Setter
@Builder
@JsonSerialize
public class ProofOfPaymentDTO {

    private Long id;

    private Long paymentId;

    private LocalDate inclusionDate;

    private LocalDate date;

    private BigDecimal value;

    private String description;

    private LocalDate finalDate;

    private String frequency;

    private String pixKey;

    private String keyType;
}
