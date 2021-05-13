package com.example.seller.controller;

import com.example.seller.controller.dto.SellerResponse;
import com.example.seller.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sellers")
@Slf4j
public class SellerController {

    private final SellerService service;

    public SellerController(SellerService service) {
        this.service = service;
    }

    @GetMapping(path = "/{cpf}")
    public ResponseEntity<SellerResponse> info(@PathVariable(name = "cpf") String cpf) {
        log.debug("call with cpf {}", cpf);
        return ResponseEntity.ok(new SellerResponse(cpf, service.getStateSeller(cpf)));
    }
}

