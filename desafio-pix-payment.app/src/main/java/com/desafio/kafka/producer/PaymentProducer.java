package com.desafio.kafka.producer;

import com.desafio.model.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, PaymentEntity> kafkaTemplate;

    public void send(PaymentEntity payment){
        log.info("Payload enviado: {}", payment);
        kafkaTemplate.send(topicName, payment);
    }

}