package com.example.seller.controller.dto;

public class SellerResponse {
    private String cpf;
    private SellerState status;

    public SellerResponse(String cpf, SellerState status) {
        this.cpf = cpf;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public SellerState getStatus() {
        return status;
    }

    public void setStatus(SellerState status) {
        this.status = status;
    }
}

