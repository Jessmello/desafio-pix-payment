package com.desafio.services.impl;

import com.desafio.model.PaymentDTO;
import com.desafio.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void insertPayment(PaymentDTO payment) {



    }

    @Override
    public void updatePayment(PaymentDTO payment) {

    }

    @Override
    public void deletePayment(PaymentDTO payment) {

    }

    @Override
    public List<PaymentDTO> getPayment(PaymentDTO payment) {
        return null;
    }
}
