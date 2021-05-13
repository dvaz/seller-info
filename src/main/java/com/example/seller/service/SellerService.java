package com.example.seller.service;

import com.example.seller.controller.dto.SellerState;
import com.example.seller.service.exception.InvalidCpfException;
import com.example.seller.util.ValidateCPF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SellerService {

    public SellerState getStateSeller(String cpf) {
        log.debug("get state with cpf {}", cpf);
        if (ValidateCPF.isValidCPF(cpf)) {
            return SellerState.randomState();
        }
        log.error("cpf {} invalid" , cpf);
        throw new InvalidCpfException("Invalid cpf");
    }
}
