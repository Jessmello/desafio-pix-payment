package com.desafio.util;

import com.desafio.model.enums.FrequencyEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidateUtilTests {

    public static final String D_MM_YYYY = "d/MM/yyyy";

    @Test
    public void validRecurrenceValue_happyPath_weeksWithValidValue() {
        assertTrue(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.SEMANAL, BigDecimal.valueOf(50.01)));
    }

    @Test
    public void validRecurrenceValue_happyPath_monthsWithValidValue() {
        assertTrue(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.MENSAL, BigDecimal.valueOf(100.01)));
    }

    @Test
    public void validRecurrenceValue_happyPath_quarterlyWithValidValue() {

        assertTrue(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.TRIMESTRAL, BigDecimal.valueOf(130.01)));

    }

    @Test
    public void validRecurrenceValue_happyPath_semiannualWithValidValue() {

        assertTrue(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.SEMESTRAL, BigDecimal.valueOf(150.01)));

    }

    @Test
    public void validRecurrenceValue_badPath_weeksWithNoValidValue() {
        assertFalse(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.SEMANAL, BigDecimal.valueOf(50.00)));
    }

    @Test
    public void validRecurrenceValue_badPath_monthsWithNoValidValue() {
        assertFalse(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.MENSAL, BigDecimal.valueOf(100.00)));
    }

    @Test
    public void validRecurrenceValue_badPath_quarterlyWithNoValidValue() {

        assertFalse(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.TRIMESTRAL, BigDecimal.valueOf(130.00)));

    }

    @Test
    public void validRecurrenceValue_badPath_semiannualWithNoValidValue() {

        assertFalse(ValidateUtil.isValidRecurrenceValue(FrequencyEnum.SEMESTRAL, BigDecimal.valueOf(150.00)));

    }

    @Test
    public void validRecurrenceFrequency_happyPath_weeksWithValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2022";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertTrue(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.SEMANAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_badPath_weeksWithNoValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2023";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertFalse(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.SEMANAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_happyPath_monthsWithValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2022";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertTrue(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.MENSAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_badPath_monthsWithNoValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2024";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertFalse(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.MENSAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_happyPath_quarterlyWithValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2022";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertTrue(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.TRIMESTRAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_badPath_quarterlyWithNoValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2025";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertFalse(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.TRIMESTRAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_happyPath_semiannualWithValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2022";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertTrue(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.SEMESTRAL, localDateInit, localDate));

    }

    @Test
    public void validRecurrenceFrequency_badPath_semiannualWithNoValidDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(D_MM_YYYY);
        String dateInit  = "20/03/2022";
        LocalDate localDateInit = LocalDate.parse(dateInit, formatter);
        String date = "22/04/2026";
        LocalDate localDate = LocalDate.parse(date, formatter);

        assertFalse(ValidateUtil.isValidRecurrenceFrequency(FrequencyEnum.SEMESTRAL, localDateInit, localDate));

    }

}
