package com.desafio.model;

import com.desafio.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * PaymentDTO
 */
@Getter
@ToString
@Setter
public class PaymentDTO   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("status")
  private StatusEnum status;

  @NotNull(message = "Inclusion Date is mandatory")
  @JsonProperty("inclusionDate")
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate inclusionDate;

  @NotNull(message = "Date is mandatory")
  @JsonProperty("date")
  @JsonFormat(pattern="yyyy-MM-dd")
  private LocalDate date;

  @JsonProperty("value")
  @NotNull(message = "Value is mandatory")
  private BigDecimal value;

  @JsonProperty("description")
  private String description;

  @JsonProperty("recurrence")
  private RecurrenceDTO recurrence;

  @JsonProperty("destination")
  private DestinationDTO destination;

}
