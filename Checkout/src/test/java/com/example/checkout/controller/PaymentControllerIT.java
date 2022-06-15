package com.example.checkout.controller;


import com.example.checkout.integration.PaymentIntegrationManager;

import com.example.checkout.model.PaymentRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


public class PaymentControllerIT extends BaseControllerTest{

    @Autowired
    PaymentIntegrationManager manager;
    private static final String uri="/gateway/pay";
    @Test
    void pay_cash_success_response() throws Exception {

        PaymentRequest request =new PaymentRequest(anyString(),anyDouble(),"cash");

        String inputJson = super.mapToJson(request);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void pay_visa_success_response() throws Exception {

        PaymentRequest request =new PaymentRequest(anyString(),anyDouble(),"visa");

        String inputJson = super.mapToJson(request);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

}
