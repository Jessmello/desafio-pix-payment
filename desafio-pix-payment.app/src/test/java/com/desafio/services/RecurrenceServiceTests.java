package com.desafio.services;

import com.desafio.builder.TestsBuilder;
import com.desafio.enums.FrequencyEnum;
import com.desafio.enums.KeyTypeEnum;
import com.desafio.enums.StatusEnum;
import com.desafio.model.DestinationDTO;
import com.desafio.model.PaymentDTO;
import com.desafio.model.RecurrenceDTO;
import com.desafio.model.mapper.PaymentMapperImpl;
import com.desafio.services.impl.RecurrenceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RecurrenceServiceTests {


    public RecurrenceService recurrenceService;

    @BeforeEach
    void init(){
        recurrenceService = new RecurrenceServiceImpl(new PaymentMapperImpl());
    }

    @Test
    void recurrencePayments_happyPath_frequencyWeeks2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentWeek(date, 100.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyWeeks(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected, recurrencePayments);
    }

    @Test
    void recurrencePayments_happyPath_frequencyMonths2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentMonths(date, 101.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyMonths(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected, recurrencePayments);
    }



    @Test
    void recurrencePayments_happyPath_frequencyQuarterly2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentQuarterly(date, 131.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencyQuarterly(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected, recurrencePayments);
    }


    @Test
    void recurrencePayments_happyPath_frequencySemiannual2Payments() {
        LocalDate date = LocalDate.now();
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentSemiannual(date, 151.00);

        List<PaymentDTO> recurrenceExpected = getExpectedListFrequencySemiannual(date);

        List<PaymentDTO> recurrencePayments = recurrenceService.getRecurrencePayments(paymentDTO);

        assertEquals(recurrenceExpected, recurrencePayments);
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
                .value(BigDecimal.valueOf(101.00))
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
                .value(BigDecimal.valueOf(101.00))
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
                .value(BigDecimal.valueOf(131.00))
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
        recurrenceExpected.add(PaymentDTO.builder()
                .status(StatusEnum.AGENDADO)
                .date(date.plusMonths(3))
                .value(BigDecimal.valueOf(131.00))
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
                .value(BigDecimal.valueOf(151.00))
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
                .value(BigDecimal.valueOf(151.00))
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
