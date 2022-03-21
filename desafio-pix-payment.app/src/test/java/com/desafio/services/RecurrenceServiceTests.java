package com.desafio.services;

import com.desafio.builder.TestsBuilder;
import com.desafio.enums.FrequencyEnum;
import com.desafio.enums.KeyTypeEnum;
import com.desafio.enums.StatusEnum;
import com.desafio.model.DestinationDTO;
import com.desafio.model.PaymentDTO;
import com.desafio.model.RecurrenceDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecurrenceServiceTests {

    @Autowired
    public RecurrenceService recurrenceService;

    @Test
    void recurrencePayments_happyPath_frequencyWeeks2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentWeek(date, 100.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyWeeks(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected.size(),recurrencePayments.size());
        assertEquals(recurrencePayments.get(0).getDate(), recurrenceExpected.get(0).getDate());
        assertEquals(recurrencePayments.get(1).getDate(), recurrenceExpected.get(1).getDate());
    }

    @Test
    void recurrencePayments_happyPath_frequencyMonths2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentMonths(date, 101.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyMonths(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected.size(),recurrencePayments.size());
        assertEquals(recurrencePayments.get(0).getDate(), recurrenceExpected.get(0).getDate());
        assertEquals(recurrencePayments.get(1).getDate(), recurrenceExpected.get(1).getDate());
    }



    @Test
    void recurrencePayments_happyPath_frequencyQuarterly2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentQuarterly(date, 131.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyQuarterly(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected.size(),recurrencePayments.size());
        assertEquals(recurrencePayments.get(0).getDate(), recurrenceExpected.get(0).getDate());
        assertEquals(recurrencePayments.get(1).getDate(), recurrenceExpected.get(1).getDate());
    }


    @Test
    void recurrencePayments_happyPath_frequencySemiannual2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentSemiannual(date, 151.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencySemiannual(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected.size(),recurrencePayments.size());
        assertEquals(recurrencePayments.get(0).getDate(), recurrenceExpected.get(0).getDate());
        assertEquals(recurrencePayments.get(1).getDate(), recurrenceExpected.get(1).getDate());
    }

    private List<PaymentDTO> getExpectedListFrequencyWeeks(LocalDate date) {
        List<PaymentDTO> recurrenceExpected = new ArrayList();
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.EFETUADO)
                .date(date)
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusWeeks(1))
                        .frequency(FrequencyEnum.SEMANAL)
                        .build())
                .build());
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.AGENDADO)
                .date(date.plusWeeks(1))
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusWeeks(1))
                        .frequency(FrequencyEnum.SEMANAL)
                        .build())
                .build());
        return recurrenceExpected;
    }

    private List<PaymentDTO> getExpectedListFrequencyMonths(LocalDate date) {
        List<PaymentDTO> recurrenceExpected = new ArrayList();
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.EFETUADO)
                .date(date)
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(1))
                        .frequency(FrequencyEnum.MENSAL)
                        .build())
                .build());
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.AGENDADO)
                .date(date.plusMonths(1))
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(1))
                        .frequency(FrequencyEnum.MENSAL)
                        .build())
                .build());
        return recurrenceExpected;
    }

    private List<PaymentDTO> getExpectedListFrequencyQuarterly(LocalDate date) {
        List<PaymentDTO> recurrenceExpected = new ArrayList();
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.EFETUADO)
                .date(date)
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(6))
                        .frequency(FrequencyEnum.TRIMESTRAL)
                        .build())
                .build());
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.AGENDADO)
                .date(date.plusMonths(3))
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(3))
                        .frequency(FrequencyEnum.TRIMESTRAL)
                        .build())
                .build());
        return recurrenceExpected;
    }

    private List<PaymentDTO> getExpectedListFrequencySemiannual(LocalDate date) {
        List<PaymentDTO> recurrenceExpected = new ArrayList();
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.EFETUADO)
                .date(date)
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(6))
                        .frequency(FrequencyEnum.SEMESTRAL)
                        .build())
                .build());
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.AGENDADO)
                .date(date.plusMonths(6))
                .value(BigDecimal.valueOf(100.00))
                .inclusionDate(date)
                .destination(DestinationDTO.builder()
                        .pixKey("13996268214")
                        .keyType(KeyTypeEnum.TELEFONE)
                        .build())
                .recurrence(RecurrenceDTO.builder()
                        .finalDate(date.plusMonths(6))
                        .frequency(FrequencyEnum.SEMESTRAL)
                        .build())
                .build());
        return recurrenceExpected;
    }
}
