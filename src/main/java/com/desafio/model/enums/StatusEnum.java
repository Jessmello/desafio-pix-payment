package com.desafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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