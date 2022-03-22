package com.desafio.model.mapper;

import com.desafio.enums.KeyTypeEnum;
import com.desafio.enums.StatusEnum;
import com.desafio.model.PaymentDTO;
import com.desafio.model.entity.PaymentEntity;
import com.desafio.util.ValidateUtil;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

/**
 * Mapeia os campos entre Entity e DTO
 */
@Mapper(componentModel="spring")
public interface PaymentMapper {

    @Mapping(target="pixKey", source="destination.pixKey")
    @Mapping(target="keyType", source="destination.pixKey", qualifiedByName = "keyType")
    @Mapping(target="finalDate", source="recurrence.finalDate")
    @Mapping(target="frequency", source="recurrence.frequency")
    @Mapping(target="status", source="date", qualifiedByName = "status")
    @Mapping(ignore = true, target = "id")
    PaymentEntity toEntity(PaymentDTO dto);

    @Mapping(target="destination.pixKey", source="dto.destination.pixKey")
    @Mapping(target="destination.keyType", source="dto.destination.pixKey", qualifiedByName = "keyType")
    @Mapping(target="recurrence.finalDate", source="dto.recurrence.finalDate")
    @Mapping(target="recurrence.frequency", source="dto.recurrence.frequency")
    @Mapping(target="status", source="recurrenceDate", qualifiedByName = "status")
    @Mapping(target="date", source="recurrenceDate")
    @Mapping(ignore = true, target = "id")
    PaymentDTO copyDTOWithRecurrenceDate(PaymentDTO dto, LocalDate recurrenceDate);

    @Mapping(target="destination.pixKey", source="pixKey")
    @Mapping(target="destination.keyType", source="keyType")
    @Mapping(target="recurrence.finalDate", source="finalDate")
    @Mapping(target="recurrence.frequency", source="frequency")
    List<PaymentDTO> listToDtoList(List<PaymentEntity> entity);

    @Mapping(target="destination.pixKey", source="pixKey")
    @Mapping(target="destination.keyType", source="keyType")
    @Mapping(target="recurrence.finalDate", source="finalDate")
    @Mapping(target="recurrence.frequency", source="frequency")
    PaymentDTO entityToDto(PaymentEntity entity);

    @Mapping(ignore = true, target = "id")
    PaymentEntity updatePayment(@MappingTarget PaymentEntity paymentSave, PaymentEntity updatedPayment);

    /**
     * Regra para definição do tipo da chave pix
     * @param pixKey chave pix recebida na entrada
     * @return KeyTypeEnum -> Tipo de chave pix recebida
     */
    @Named("keyType")
    default KeyTypeEnum getKeyType(String pixKey) {

        if(ValidateUtil.isValidEmailAddress(pixKey)){
            return KeyTypeEnum.E_MAIL;
        }
        if(ValidateUtil.isCPF(pixKey)){
            return KeyTypeEnum.CPF;
        }

        if(StringUtils.isNumeric(pixKey)){
            return KeyTypeEnum.TELEFONE;
        }

        return KeyTypeEnum.ALEATORIA;
    }

    /**
     * Regra para definição do status conforme data recebida
     * @param date Data recebida
     * @return StatusEnum -> Status do pagamento pix
     */
    @Named("status")
    default StatusEnum getStatus(LocalDate date) {

        if(date.isAfter(LocalDate.now())){
            return StatusEnum.AGENDADO;
        }

        return StatusEnum.EFETUADO;
    }

}
