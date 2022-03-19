package com.desafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
