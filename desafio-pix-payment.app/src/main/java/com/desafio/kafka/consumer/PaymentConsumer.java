package com.desafio.kafka.consumer;

import com.desafio.model.entity.PaymentEntity;
import com.desafio.services.ProofOfPaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private ProofOfPaymentService proofOfPaymentService;

    @Autowired
    public PaymentConsumer(ProofOfPaymentService proofOfPaymentService) {
        this.proofOfPaymentService = proofOfPaymentService;
    }

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, PaymentEntity> payload){
        PaymentEntity value = payload.value();
        proofOfPaymentService.saveProofOfPayment(value);
    }

}