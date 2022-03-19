package com.desafio.model;

import com.desafio.model.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * PaymentDTO
 */
@Getter
@ToString
public class PaymentDTO   {

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("inclusionDate")
  @JsonFormat(pattern="yyyy-MM-dd")
  @ApiModelProperty(dataType = "java8-localdatetime")
  private LocalDate inclusionDate = null;

  @JsonProperty("date")
  @JsonFormat(pattern="yyyy-MM-dd")
  @ApiModelProperty(dataType = "java8-localdatetime")
  private LocalDate date = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("recurrence")
  private RecurrenceDTO recurrence = null;

  @JsonProperty("destination")
  private DestinationDTO destination = null;

}
