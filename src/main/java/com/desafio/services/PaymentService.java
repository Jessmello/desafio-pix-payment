package com.desafio.services;

import com.desafio.model.PaymentDTO;

import java.util.List;

public interface PaymentService {

    void insertPayment(PaymentDTO payment);

    void updatePayment(PaymentDTO payment);

    void deletePayment(PaymentDTO payment);

    List<PaymentDTO> getPayment(PaymentDTO payment);

}
