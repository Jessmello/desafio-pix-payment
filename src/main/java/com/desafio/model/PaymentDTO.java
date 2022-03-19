package com.desafio.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * PaymentDTO
 */
public class PaymentDTO   {
  @JsonProperty("id")
  private Long id = null;

  /**
   * payment status
   */
  public enum StatusEnum {
    AGENDADO("AGENDADO"),
    
    EFETUADO("EFETUADO"),
    
    PENDENTE("PENDENTE"),
    
    CANCELADO("CANCELADO");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("inclusionDate")
  private Date inclusionDate = null;

  @JsonProperty("date")
  private Date date = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("recurrence")
  private RecurrenceDTO recurrence = null;

  @JsonProperty("destination")
  private DestinationDTO destination = null;

  public PaymentDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PaymentDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * payment status
   * @return status
   **/
  @Schema(description = "payment status")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public PaymentDTO inclusionDate(Date inclusionDate) {
    this.inclusionDate = inclusionDate;
    return this;
  }

  /**
   * Get inclusionDate
   * @return inclusionDate
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Date getInclusionDate() {
    return inclusionDate;
  }

  public void setInclusionDate(Date inclusionDate) {
    this.inclusionDate = inclusionDate;
  }

  public PaymentDTO date(Date date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public PaymentDTO value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public PaymentDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PaymentDTO recurrence(RecurrenceDTO recurrence) {
    this.recurrence = recurrence;
    return this;
  }

  /**
   * Get recurrence
   * @return recurrence
   **/
  @Schema(description = "")
  
    @Valid
    public RecurrenceDTO getRecurrence() {
    return recurrence;
  }

  public void setRecurrence(RecurrenceDTO recurrence) {
    this.recurrence = recurrence;
  }

  public PaymentDTO destination(DestinationDTO destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * @return destination
   **/
  @Schema(description = "")
  
    @Valid
    public DestinationDTO getDestination() {
    return destination;
  }

  public void setDestination(DestinationDTO destination) {
    this.destination = destination;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentDTO payment = (PaymentDTO) o;
    return Objects.equals(this.id, payment.id) &&
        Objects.equals(this.status, payment.status) &&
        Objects.equals(this.inclusionDate, payment.inclusionDate) &&
        Objects.equals(this.date, payment.date) &&
        Objects.equals(this.value, payment.value) &&
        Objects.equals(this.description, payment.description) &&
        Objects.equals(this.recurrence, payment.recurrence) &&
        Objects.equals(this.destination, payment.destination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, inclusionDate, date, value, description, recurrence, destination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    inclusionDate: ").append(toIndentedString(inclusionDate)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    recurrence: ").append(toIndentedString(recurrence)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
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
