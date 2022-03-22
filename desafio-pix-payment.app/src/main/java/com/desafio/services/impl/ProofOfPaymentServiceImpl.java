package com.desafio.services.impl;

import com.desafio.model.ProofOfPaymentDTO;
import com.desafio.model.entity.PaymentEntity;
import com.desafio.model.mapper.ProofOfPaymentMapper;
import com.desafio.repository.ProofOfPaymentRepository;
import com.desafio.services.ProofOfPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProofOfPaymentServiceImpl implements ProofOfPaymentService {

    private ProofOfPaymentRepository paymentRepository;
    private ProofOfPaymentMapper mapper;

    @Override
    public void saveProofOfPayment(PaymentEntity payment) {
        paymentRepository.save(mapper.toEntity(payment));
    }

    @Override
    public List<ProofOfPaymentDTO> getProofOfPayment() {
        return mapper.listToDtoList(paymentRepository.findAll());
    }
}
