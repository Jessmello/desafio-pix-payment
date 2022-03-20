package com.desafio.repository;

import com.desafio.model.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

    List<PaymentEntity> getByDateAndValueAndPixKey(LocalDate date, BigDecimal value, String pixKey);

    List<PaymentEntity> getByStatus(String status);

}
