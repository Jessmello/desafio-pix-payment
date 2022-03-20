package com.desafio.services;

import com.desafio.model.PaymentDTO;

import java.util.List;


public interface RecurrenceService {

    List<PaymentDTO> getRecurrencePayments(PaymentDTO paymentDTO);

}
