package com.desafio.model;

import com.desafio.enums.KeyTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * DestinationDTO
 */
@Getter
@ToString
@Setter
@Builder
public class DestinationDTO   {

  @NotEmpty(message = "Key is mandatory")
  @JsonProperty("pixKey")
  private String pixKey;

  @JsonProperty("keyType")
  private KeyTypeEnum keyType;

}
