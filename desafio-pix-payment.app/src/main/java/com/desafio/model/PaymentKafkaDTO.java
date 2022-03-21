package com.desafio.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@Builder
@ToString
public class PaymentKafkaDTO {

    private Long id;

    private String status;

    private LocalDate inclusionDate;

    private LocalDate date;

    private BigDecimal value;

    private String description;

    private LocalDate finalDate;

    private String frequency;

    private String pixKey;

    private String keyType;

}
