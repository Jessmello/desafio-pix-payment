package com.desafio.builder;

import com.desafio.enums.FrequencyEnum;
import com.desafio.model.DestinationDTO;
import com.desafio.model.PaymentDTO;
import com.desafio.model.RecurrenceDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestsBuilder {

    public static PaymentDTO buildRecurrencePaymentWeek(LocalDate date, Double value) {
        PaymentDTO paymentDTO = buildPaymentDTO(date, value);
        paymentDTO.setRecurrence(RecurrenceDTO.builder()
                .finalDate(LocalDate.now().plusWeeks(1))
                .frequency(FrequencyEnum.SEMANAL)
                .build());
        return paymentDTO;
    }

    public static PaymentDTO buildPaymentDTO(LocalDate date, Double value) {
        return PaymentDTO.builder()
                .date(date)
                .value(BigDecimal.valueOf(value))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .build())
                .build();
    }

    public static PaymentDTO buildRecurrencePaymentMonths(LocalDate date, double value) {
        PaymentDTO paymentDTO = buildPaymentDTO(date, value);
        paymentDTO.setRecurrence(RecurrenceDTO.builder()
                .finalDate(LocalDate.now().plusMonths(1))
                .frequency(FrequencyEnum.MENSAL)
                .build());
        return paymentDTO;
    }

    public static PaymentDTO buildRecurrencePaymentQuarterly(LocalDate date, double value) {
        PaymentDTO paymentDTO = buildPaymentDTO(date, value);
        paymentDTO.setRecurrence(RecurrenceDTO.builder()
                .finalDate(LocalDate.now().plusMonths(3))
                .frequency(FrequencyEnum.TRIMESTRAL)
                .build());
        return paymentDTO;
    }

    public static PaymentDTO buildRecurrencePaymentSemiannual(LocalDate date, double value) {
        PaymentDTO paymentDTO = buildPaymentDTO(date, value);
        paymentDTO.setRecurrence(RecurrenceDTO.builder()
                .finalDate(LocalDate.now().plusMonths(6))
                .frequency(FrequencyEnum.SEMESTRAL)
                .build());
        return paymentDTO;
    }
}
