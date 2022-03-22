package com.desafio.api.impl;

import com.desafio.enums.StatusEnum;
import com.desafio.model.PaymentDTO;
import com.desafio.services.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @ApiOperation(value  = "Add a new payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 405, message = "Entrada invalida"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PostMapping(value = "/payments",
            consumes = { "application/json" })
    public ResponseEntity<String> addPayment( @Valid @RequestBody PaymentDTO body) {
        return ResponseEntity.ok(paymentService.insertPayment(body));
    }

    @ApiOperation(value = "Delete payment")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Sucesso"),
            @ApiResponse(code = 405, message = "Entrada invalida"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @DeleteMapping(value = "/payments",
            consumes = { "application/json" })
    public ResponseEntity<Void> delete( @Valid @RequestBody PaymentDTO body) {
        paymentService.deletePayment(body);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Consult payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 405, message = "Entrada invalida"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping(value = "/payments",
            params = {"status"})
    public ResponseEntity<List<PaymentDTO>> payment( @Valid StatusEnum status) {
        return ResponseEntity.ok(paymentService.getPayment(status));
    }

    @ApiOperation(value = "update payment")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Sucesso"),
            @ApiResponse(code = 405, message = "Entrada invalida"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @PutMapping(value = "/payments",
            consumes = { "application/json" })
    public ResponseEntity<Void> updatePayment( @Valid @RequestBody PaymentDTO body) {
        paymentService.updatePayment(body);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
