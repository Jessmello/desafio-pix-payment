package com.desafio.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * RecurrenceDTO
 */
public class RecurrenceDTO   {
  @JsonProperty("finalDate")
  private Date finalDate = null;

  /**
   * payment status
   */
  public enum FrequencyEnum {
    SEMANAL("SEMANAL"),
    
    MENSAL("MENSAL"),
    
    TRIMESTRAL("TRIMESTRAL"),
    
    SEMESTRAL("SEMESTRAL");

    private String value;

    FrequencyEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FrequencyEnum fromValue(String text) {
      for (FrequencyEnum b : FrequencyEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("frequency")
  private FrequencyEnum frequency = null;

  public RecurrenceDTO finalDate(Date finalDate) {
    this.finalDate = finalDate;
    return this;
  }

  /**
   * Get finalDate
   * @return finalDate
   **/
  @Schema(description = "")
  
    @Valid
    public Date getFinalDate() {
    return finalDate;
  }

  public void setFinalDate(Date finalDate) {
    this.finalDate = finalDate;
  }

  public RecurrenceDTO frequency(FrequencyEnum frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * payment status
   * @return frequency
   **/
  @Schema(description = "payment status")
  
    public FrequencyEnum getFrequency() {
    return frequency;
  }

  public void setFrequency(FrequencyEnum frequency) {
    this.frequency = frequency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecurrenceDTO recurrence = (RecurrenceDTO) o;
    return Objects.equals(this.finalDate, recurrence.finalDate) &&
        Objects.equals(this.frequency, recurrence.frequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(finalDate, frequency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecurrenceDTO {\n");
    
    sb.append("    finalDate: ").append(toIndentedString(finalDate)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
