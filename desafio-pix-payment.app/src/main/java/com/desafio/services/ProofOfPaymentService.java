package com.desafio.services;

import com.desafio.model.PaymentDTO;

import java.util.List;

public interface ProofOfPaymentService {

    void saveProofOfPayment(PaymentDTO payment);

    List<PaymentDTO> getProofOfPayment();

}
