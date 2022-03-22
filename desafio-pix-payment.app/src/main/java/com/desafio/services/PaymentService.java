package com.desafio.services;

import com.desafio.enums.StatusEnum;
import com.desafio.exceptions.NotFoundException;
import com.desafio.model.PaymentDTO;

import java.util.List;

public interface PaymentService {

    String insertPayment(PaymentDTO payment);

    void updatePayment(PaymentDTO payment) throws NotFoundException;

    void deletePayment(Long paymentId) throws NotFoundException;

    List<PaymentDTO> getPayment(StatusEnum status);

}
