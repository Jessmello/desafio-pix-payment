package com.desafio.services;

import com.desafio.model.ProofOfPaymentDTO;
import com.desafio.model.entity.PaymentEntity;

import java.util.List;

public interface ProofOfPaymentService {

    void saveProofOfPayment(PaymentEntity payment);

    List<ProofOfPaymentDTO> getProofOfPayment();

}
