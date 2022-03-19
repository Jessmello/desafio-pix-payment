package com.desafio.api.impl;

import com.desafio.model.PaymentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaymentsController {

    @Operation(summary = "Add a new payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<Void> addPayment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        return null;
    }

    @Operation(summary = "Delete payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        return null;
    }

    @Operation(summary = "Consult payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<Void> payment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        return null;
    }

    @Operation(summary = "update payment", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/payments",
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    public ResponseEntity<Void> updatePayment(@Parameter(in = ParameterIn.DEFAULT, description = "Payment object that needs to be added", required=true, schema=@Schema()) @Valid @RequestBody PaymentDTO body) {
        return null;
    }
}
