package com.desafio.kafka.producer;

import com.desafio.model.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, PaymentEntity> kafkaTemplate;

    public void send(PaymentEntity payment){

        kafkaTemplate.send(topicName, payment);
    }

}