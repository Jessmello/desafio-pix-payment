package com.desafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * payment status
 */
@Getter
public enum FrequencyEnum {
    SEMANAL("SEMANAL", 50, 12),

    MENSAL("MENSAL", 100, 24),

    TRIMESTRAL("TRIMESTRAL", 130, 36),

    SEMESTRAL("SEMESTRAL", 150, 42);

    private String frequency;
    private BigDecimal minimumValue;
    private BigDecimal maximumPeriod;

    FrequencyEnum(String frequency, int minimumValue, int maximumPeriod) {
        this.frequency = frequency;
        this.minimumValue = BigDecimal.valueOf(minimumValue);
        this.maximumPeriod = BigDecimal.valueOf(maximumPeriod);
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(frequency);
    }

    @JsonCreator
    public static FrequencyEnum fromValue(String text) {
        for (FrequencyEnum b : FrequencyEnum.values()) {
            if (String.valueOf(b.frequency).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
