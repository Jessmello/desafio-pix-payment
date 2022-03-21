package com.desafio.services.impl;

import com.desafio.model.PaymentDTO;
import com.desafio.model.mapper.ProofOfPaymentMapper;
import com.desafio.repository.ProofOfPaymentRepository;
import com.desafio.services.ProofOfPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProofOfPaymentServiceImpl implements ProofOfPaymentService {

    private ProofOfPaymentRepository paymentRepository;
    private ProofOfPaymentMapper mapper;

    @Override
    public void saveProofOfPayment(PaymentDTO payment) {

        //TODO
    }

    @Override
    public List<PaymentDTO> getProofOfPayment() {
        //TODO
        return new ArrayList<>();
    }
}
