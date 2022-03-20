package com.desafio.api.impl;

import com.desafio.model.PaymentDTO;
import com.desafio.services.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class PaymentController {

    private PaymentService paymentService;


    @ApiOperation(value  = "Add a new payment")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Void> addPayment( @Valid @RequestBody PaymentDTO body) {
        log.info("Entrou addPayment {}", body);
        paymentService.insertPayment(body);
        log.info("saindo addPayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Delete payment")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete( @Valid @RequestBody PaymentDTO body) {
        log.info("entrou deletePayment {}", body);
        paymentService.deletePayment(body);
        log.info("saindo deletePayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Consult payment")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<PaymentDTO>> payment( @Valid @RequestBody PaymentDTO body) {
        log.info("entrou payment {}", body);
        return ResponseEntity.ok(paymentService.getPayment(body));
    }

    @ApiOperation(value = "update payment")
    @ApiResponses(value = {
            @ApiResponse(code = 405, message  = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePayment( @Valid @RequestBody PaymentDTO body) {
        log.info("entrou updatePayment {}", body);
        paymentService.updatePayment(body);
        log.info("saindo updatePayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
