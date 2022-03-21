package com.desafio.model.mapper;

import com.desafio.model.PaymentKafkaDTO;
import com.desafio.model.entity.ProofOfPaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapeia os campos entre Entity e DTO
 */
@Mapper(componentModel="spring")
public interface ProofOfPaymentMapper {

    PaymentKafkaDTO toEntity(ProofOfPaymentEntity dto);

    List<ProofOfPaymentEntity> listToDtoList(List<PaymentKafkaDTO> entity);


}
