package com.desafio.model.mapper;

import com.desafio.model.ProofOfPaymentDTO;
import com.desafio.model.entity.PaymentEntity;
import com.desafio.model.entity.ProofOfPaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapeia os campos entre Entity e DTO
 */
@Mapper(componentModel="spring")
public interface ProofOfPaymentMapper {

    @Mapping(ignore = true, target = "id")
    @Mapping(target="paymentId", source="id")
    ProofOfPaymentEntity toEntity(PaymentEntity dto);

    List<ProofOfPaymentDTO> listToDtoList(List<ProofOfPaymentEntity> entity);


}
