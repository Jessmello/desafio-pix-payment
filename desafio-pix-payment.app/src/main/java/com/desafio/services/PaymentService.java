package com.desafio.services;

import com.desafio.enums.StatusEnum;
import com.desafio.model.PaymentDTO;

import java.util.List;

public interface PaymentService {

    String insertPayment(PaymentDTO payment);

    void updatePayment(PaymentDTO payment);

    void deletePayment(PaymentDTO payment);

    List<PaymentDTO> getPayment(StatusEnum status);

}
