package com.desafio.services.impl;

import com.desafio.model.entity.PaymentEntity;
import com.desafio.model.PaymentDTO;
import com.desafio.enums.StatusEnum;
import com.desafio.model.mapper.PaymentMapper;
import com.desafio.kafka.producer.PaymentProducer;
import com.desafio.repository.PaymentRepository;
import com.desafio.services.PaymentService;
import com.desafio.services.RecurrenceService;
import com.desafio.util.ValidateUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * PaymentService
 * Responsavel por efetuar as regras de inclusão de pagamento
 */
@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentMapper mapper;
    private RecurrenceService recurrenceService;
    private PaymentProducer kafkaProducer;

    /**
     * Método responsavel por validar as regras de inserção de pagamento
     * @param payment Body recebido na entrada
     * @return String -> Mensagem de sucesso ou Warn do retorno da inclusão
     */
    @Override
    public String insertPayment(PaymentDTO payment) {

        String message = "Pagamento incluido com sucesso!";
        if(isValidRecurrence(payment)){
            return this.saveRecurrence(payment);
        }
        if(payment.getRecurrence() != null){
            return "Recorrencia invalida! Verifique os prazos maximos e valores minimos para inclusão de recorrencia!";
        }

        if(isExistingPayment(payment)){
            message = "Pagamento incluido com sucesso, porém existe um pagamento com os mesmos dados cadastrados!";
        }

        savePayment(payment);


        return message;
    }

    /**
     * Salva a recorrencia de pagamento
     * @param payment Body recebido na entrada
     * @return String -> Mensagem de sucesso ou Warn do retorno da inclusão
     */
    private String saveRecurrence(PaymentDTO payment) {
        List<PaymentDTO> payments = recurrenceService.getRecurrencePayments(payment);
        payments.forEach(this::savePayment);
        return "Recorrencia salva com sucesso!";
    }

    /**
     * Salva Pagamento
     * @param payment Body recebido na entrada
     */
    private void savePayment(PaymentDTO payment) {
        PaymentEntity entity = this.paymentRepository.save(mapper.toEntity(payment));
        if(StatusEnum.EFETUADO.name().equals(entity.getStatus())){
            kafkaProducer.send(entity);
        }
    }

    /**
     * Verifica se o pagamento é um recorrencia valida
     * @param payment Body recebido na entrada
     * @return boolean -> True se é valida, False se não
     */
    private boolean isValidRecurrence(PaymentDTO payment) {
        return payment.getRecurrence() != null &&
                ValidateUtil.isValidRecurrenceFrequency(payment.getRecurrence().getFrequency(), LocalDate.now() , payment.getRecurrence().getFinalDate()) &&
                ValidateUtil.isValidRecurrenceValue(payment.getRecurrence().getFrequency(), payment.getValue());
    }

    /**
     * Valida se existe um pagamento com as mesmas informações
     * @param payment Body recebido na entrada
     * @return boolean -> True se existe pagamento, False caso não exista
     */
    private boolean isExistingPayment(PaymentDTO payment) {
        List<PaymentEntity> paymentEntity = paymentRepository.getByDateAndValueAndPixKey(payment.getDate(), payment.getValue(), payment.getDestination().getPixKey());
        return !paymentEntity.isEmpty();
    }

    /**
     * Realiza o update de um pagamento
     * @param payment Pagamento a ser realizado o update
     */
    @Override
    public void updatePayment(PaymentDTO payment) {
        PaymentEntity byId = paymentRepository.getById(payment.getId().intValue());
        this.paymentRepository.save(mapper.updatePayment(byId, mapper.toEntity(payment)));
    }

    /**
     * Realiza o delete negocial do pagamento, o pagamento não é apagado
     * da base para fins de histórico, porem seu status é alterado para cancelado.
     * @param payment Pagamento a ser deletado da base
     */
    @Override
    public void deletePayment(PaymentDTO payment) {
        payment.setStatus(StatusEnum.CANCELADO);
        this.updatePayment(payment);
    }

    /**
     * Busca listagem de pagamentos por Status
     * @param status Status a ser filtrado
     * @return Lista de pagamentos com o status recebido
     */
    @Override
    public List<PaymentDTO> getPayment(StatusEnum status) {
        return mapper.listToDtoList(paymentRepository.getByStatus(status.name()));
    }
}
