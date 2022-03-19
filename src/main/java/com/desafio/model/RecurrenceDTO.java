package com.desafio.model;

import com.desafio.model.enums.FrequencyEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * RecurrenceDTO
 */
@Getter
@ToString
public class RecurrenceDTO   {

  @JsonProperty("finalDate")
  @JsonFormat(pattern="yyyy-MM-dd")
  @ApiModelProperty(dataType = "java8-localdatetime")
  private LocalDate finalDate = null;

  @JsonProperty("frequency")
  private FrequencyEnum frequency = null;


}
