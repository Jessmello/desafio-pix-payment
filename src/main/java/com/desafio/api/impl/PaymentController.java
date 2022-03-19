package com.desafio.api.impl;

import com.desafio.model.PaymentDTO;
import com.desafio.services.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Add a new payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Void> addPayment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        log.info("Entrou addPayment {}", body);
        paymentService.insertPayment(body);
        log.info("saindo addPayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Delete payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        log.info("entrou deletePayment {}", body);
        paymentService.deletePayment(body);
        log.info("saindo deletePayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Consult payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<List<PaymentDTO>> payment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        log.info("entrou payment {}", body);
        return ResponseEntity.ok(paymentService.getPayment(body));
    }

    @Operation(summary = "update payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePayment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        log.info("entrou updatePayment {}", body);
        paymentService.updatePayment(body);
        log.info("saindo updatePayment");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
