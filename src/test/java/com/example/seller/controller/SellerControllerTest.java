package com.example.seller.controller;

import com.example.seller.controller.dto.SellerState;
import com.example.seller.service.SellerService;
import com.example.seller.service.exception.InvalidCpfException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SellerController.class)
public class SellerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private SellerService service;

    @Test
    public void testValid() throws Exception {
        String cpf = "56019089070";

        when(service.getStateSeller(anyString())).thenReturn(SellerState.randomState());
        mockMvc.perform(get("/sellers/{cpf}", cpf).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testInValid() throws Exception {
        String cpf = "56019089072";

        when(service.getStateSeller(anyString())).thenThrow(new InvalidCpfException("Invalid cpf"));
        mockMvc.perform(get("/sellers/{cpf}", cpf).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
