package com.desafio.model;

import com.desafio.enums.FrequencyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

/**
 * RecurrenceDTO
 */
@Getter
@ToString
@Setter
@Builder
@EqualsAndHashCode
public class RecurrenceDTO   {

  @JsonProperty("finalDate")
  @JsonFormat(pattern="yyyy-MM-dd")
  @ApiModelProperty(dataType = "java8-localdatetime")
  private LocalDate finalDate;

  @JsonProperty("frequency")
  private FrequencyEnum frequency;


}
