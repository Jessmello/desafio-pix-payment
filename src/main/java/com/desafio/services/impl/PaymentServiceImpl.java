package com.desafio.services.impl;

import com.desafio.model.PaymentDTO;
import com.desafio.model.enums.KeyTypeEnum;
import com.desafio.model.enums.StatusEnum;
import com.desafio.services.PaymentService;
import com.desafio.util.ValidateUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void insertPayment(PaymentDTO payment) {
        String message;
        payment.setStatus(getStatus(payment));
        payment.getDestination().setKeyType(getKeyType(payment.getDestination().getPixKey()));
        if(isValidRecurrence(payment)){

        }

        if(isExistingPayment(payment)){
            message = "Pagamento incluido com sucesso, porém existe um pagamento com os mesmos dados cadastrados!";
        }


    }

    private boolean isValidRecurrence(PaymentDTO payment) {
        return payment.getRecurrence() != null &&
                ValidateUtil.isValidRecurrenceFrequency(payment.getRecurrence().getFrequency(), LocalDate.now() , payment.getRecurrence().getFinalDate()) &&
                ValidateUtil.isValidRecurrenceValue(payment.getRecurrence().getFrequency(), payment.getValue());
    }


    private boolean isExistingPayment(PaymentDTO payment) {
        return false;
    }

    private KeyTypeEnum getKeyType(String pixKey) {

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

    private StatusEnum getStatus(PaymentDTO payment) {

        if(payment.getDate().isBefore(LocalDate.now())){
            return StatusEnum.AGENDADO;
        }

        return StatusEnum.EFETUADO;
    }

    @Override
    public void updatePayment(PaymentDTO payment) {

    }

    @Override
    public void deletePayment(PaymentDTO payment) {
        payment.setStatus(StatusEnum.CANCELADO);
    }

    @Override
    public List<PaymentDTO> getPayment(PaymentDTO payment) {
        return null;
    }
}
