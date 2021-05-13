package com.example.seller.service;

import com.example.seller.service.exception.InvalidCpfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {

    @InjectMocks
    private SellerService service;

    @Test
    public void testeInvalidCPF() {
        String cpf = "197.020.750-77";
        Assertions.assertThrows(InvalidCpfException.class, () -> service.getStateSeller(cpf));
    }

    @Test
    public void testValidCPF() {
        String cpf = "197.020.750-76";
        Assertions.assertDoesNotThrow(() -> service.getStateSeller(cpf));
    }
}
