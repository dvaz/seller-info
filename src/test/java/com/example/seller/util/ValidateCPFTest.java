package com.example.seller.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ValidateCPFTest {


    @Test
    public void testValidCpfPoints() {
        String cpf = "501.036.900-18";
        Assertions.assertTrue(ValidateCPF.isValidCPF(cpf));
    }

    @Test
    public void testValidCpf() {
        String cpf = "79454494090";
        Assertions.assertTrue(ValidateCPF.isValidCPF(cpf));
    }

    @Test
    public void testInValidCpfPoints() {
        String cpf = "501.036.900-10";
        Assertions.assertFalse(ValidateCPF.isValidCPF(cpf));
    }

    @Test
    public void testInValidCpf() {
        String cpf = "79454494091";
        Assertions.assertFalse(ValidateCPF.isValidCPF(cpf));
    }
}
