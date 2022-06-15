package com.example.checkout.service;

import com.example.checkout.exception.PaymentIntegrationException;
import com.example.checkout.integration.PaymentIntegrationManager;
import com.example.checkout.model.PaymentIntegrationDTO;
import com.example.checkout.model.PaymentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class VisaPaymentServiceTests {


    VisaPayment service;


    @Autowired
    Environment env;
    @Autowired
    PaymentIntegrationManager paymentIntegrationManager;
    @BeforeEach
    void init() {
        service=new VisaPayment(env,paymentIntegrationManager);
    }
    @Test
    void pay_with_visa_success(){
        PaymentRequest request =new PaymentRequest(anyString(),anyDouble(),"visa");

        assertEquals(service.pay(request).getMessage(),"The amount of the order paid successfully and will be received on the expected time ");

    }


}
