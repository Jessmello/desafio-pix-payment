package com.desafio.api.impl;

import com.desafio.model.ProofOfPaymentDTO;
import com.desafio.services.ProofOfPaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProofPaymentController {

    private ProofOfPaymentService proofService;

    @ApiOperation(value = "Consult Proof of Payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 500, message = "Erro interno")
    })
    @GetMapping(value = "/proof/payment")
    public ResponseEntity<List<ProofOfPaymentDTO>> payment() {
        return ResponseEntity.ok(proofService.getProofOfPayment());
    }
}
