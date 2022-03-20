package com.desafio.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * payment status
 */
public enum StatusEnum {
    AGENDADO("AGENDADO"),

    EFETUADO("EFETUADO"),

    PENDENTE("PENDENTE"),

    CANCELADO("CANCELADO");

    private final String value;

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