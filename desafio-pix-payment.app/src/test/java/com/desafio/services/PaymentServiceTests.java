package com.desafio.services;

import com.desafio.builder.TestsBuilder;
import com.desafio.kafka.producer.PaymentProducer;
import com.desafio.model.PaymentDTO;
import com.desafio.model.entity.PaymentEntity;
import com.desafio.model.mapper.PaymentMapper;
import com.desafio.repository.PaymentRepository;
import com.desafio.services.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTests {

    @InjectMocks
    public PaymentServiceImpl paymentService;

    @Mock
    public PaymentRepository paymentRepository;

    @Mock
    public PaymentMapper paymentMapper;

    @Mock
    public RecurrenceService recurrenceService;

    @Mock
    public PaymentProducer producer;


    @BeforeTestClass
    void init(){
        Mockito.when(paymentRepository.save(ArgumentMatchers.any())).thenReturn(new PaymentEntity());
    }


    @Test
    void insertPayment_happyPath_insertNewPayment() {

        Mockito.when(paymentRepository.getByDateAndValueAndPixKey(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(new ArrayList<>());
        PaymentDTO paymentDTO = TestsBuilder.buildPaymentDTO(LocalDate.now(), 50.00);
        String s = paymentService.insertPayment(paymentDTO);
        assertEquals("Pagamento incluido com sucesso!", s);
    }



    @Test
    void insertPayment_badPath_warn() {
        PaymentDTO paymentDTO = TestsBuilder.buildPaymentDTO(LocalDate.now(), 50.00);
        List<PaymentEntity> payments = Collections.singletonList(new PaymentEntity());
        Mockito.when(paymentRepository.getByDateAndValueAndPixKey(ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(payments);
        String s = paymentService.insertPayment(paymentDTO);
        assertEquals("Pagamento incluido com sucesso, porém existe um pagamento com os mesmos dados cadastrados!", s);
    }

    @Test
    void insertRecurrencePayment_happyPath_insertValidRecurrencePayment() {
        PaymentDTO paymentDTO = TestsBuilder.buildRecurrencePaymentWeek(LocalDate.now(), 52.00);
        String s = paymentService.insertPayment(paymentDTO);
        assertEquals("Recorrencia salva com sucesso!", s);
    }


}
