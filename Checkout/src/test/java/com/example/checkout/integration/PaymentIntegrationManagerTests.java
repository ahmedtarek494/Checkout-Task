package com.example.checkout.integration;

import com.example.checkout.exception.CheckoutValidationException;
import com.example.checkout.exception.PaymentIntegrationException;
import com.example.checkout.model.PaymentIntegrationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
@ActiveProfiles(value = "junit")
public class PaymentIntegrationManagerTests {

    @Autowired
    Environment env;
    @Autowired
    PaymentIntegrationManager manager;
    @Test
    void payment_success_with_payment_gateway()
    {

        PaymentIntegrationDTO request= new PaymentIntegrationDTO(anyString(),anyDouble(),"EGP");

        assertEquals(manager.pay(request,env.getProperty("payment.gatway.mock.server.url")),"Payment Successfull");
    }

    @Test
    void payment_failure_with_payment_gateway()
    {

        PaymentIntegrationDTO request= new PaymentIntegrationDTO(anyString(),anyDouble(),"EGP");


        assertThrows(PaymentIntegrationException.class,() -> manager.pay(request,"sfsfsgssgs"));

    }
}
