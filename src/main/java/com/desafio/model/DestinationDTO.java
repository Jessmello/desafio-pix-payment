package com.desafio.model;

import com.desafio.model.enums.KeyTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * DestinationDTO
 */
@Getter
@ToString
public class DestinationDTO   {

  @JsonProperty("pixKey")
  @Schema(required = true, description = "")
  private String pixKey = null;

  @JsonProperty("keyType")
  @Schema(description = "payment status")
  @NotNull
  private KeyTypeEnum keyType = null;

}
