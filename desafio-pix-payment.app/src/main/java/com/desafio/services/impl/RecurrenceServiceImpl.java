package com.desafio.services.impl;

import com.desafio.enums.FrequencyEnum;
import com.desafio.model.PaymentDTO;
import com.desafio.model.RecurrenceDTO;
import com.desafio.model.mapper.PaymentMapper;
import com.desafio.services.RecurrenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecurrenceServiceImpl implements RecurrenceService {

    private PaymentMapper mapper;

    @Override
    public List<PaymentDTO> getRecurrencePayments(PaymentDTO paymentDTO) {
        List<PaymentDTO> paymentList = new ArrayList<>();
        RecurrenceDTO recurrence = paymentDTO.getRecurrence();
        LocalDate date = LocalDate.now();
        while (!date.isAfter(recurrence.getFinalDate())){
            paymentList.add(mapper.copyDTOWithRecurrenceDate(paymentDTO, date));
            date = getNextDate(recurrence.getFrequency(), date);
        }

        return paymentList;
    }

    private LocalDate getNextDate(FrequencyEnum frequency, LocalDate date) {
        switch (frequency){

            case SEMANAL:
                return date.plusWeeks(1);
            case MENSAL:
                return date.plusMonths(1);
            case TRIMESTRAL:
                return date.plusMonths(3);
            case SEMESTRAL:
                return date.plusMonths(6);
            default:
                return LocalDate.now();

        }
    }


}
