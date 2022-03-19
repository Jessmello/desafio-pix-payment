package com.desafio.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * payment status
 */
public enum KeyTypeEnum {
    CPF("CPF"),

    E_MAIL("E-MAIL"),

    TELEFONE("TELEFONE"),

    ALEATORIA("ALEATORIA");

    private String value;

    KeyTypeEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static KeyTypeEnum fromValue(String text) {
        for (KeyTypeEnum b : KeyTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}