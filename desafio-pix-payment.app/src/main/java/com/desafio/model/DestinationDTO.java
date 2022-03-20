package com.desafio.model;

import com.desafio.model.enums.KeyTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * DestinationDTO
 */
@Getter
@ToString
@Setter
public class DestinationDTO   {

  @NotEmpty(message = "Key is mandatory")
  @JsonProperty("pixKey")
  private String pixKey = null;

  @JsonProperty("keyType")
  private KeyTypeEnum keyType = null;

}
