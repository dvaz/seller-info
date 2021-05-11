package com.example.seller.controller;

import com.example.seller.controller.dto.SellerResponse;
import com.example.seller.controller.dto.SellerState;
import com.example.seller.util.ValidateCPF;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sellers")
public class SellerController {

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<SellerResponse> info(@PathVariable(name = "cpf") String cpf) {
        boolean validCPF = ValidateCPF.isValidCPF(cpf);
        return ResponseEntity.ok(new SellerResponse(cpf, SellerState.randomState()));
    }
}

