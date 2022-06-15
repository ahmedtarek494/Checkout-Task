package com.example.checkout.service;

import com.example.checkout.integration.PaymentIntegrationManager;
import com.example.checkout.model.PaymentIntegrationDTO;
import com.example.checkout.model.PaymentRequest;
import com.example.checkout.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class VisaPayment implements PaymentService{

    private final Environment env;
    private final PaymentIntegrationManager paymentIntegrationManager;

    @Autowired
    public VisaPayment(Environment env, PaymentIntegrationManager paymentIntegrationManager) {
        this.env = env;
        this.paymentIntegrationManager = paymentIntegrationManager;
    }

    @Override
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        /* 1)pay the amount of the order through any payment gateway tool
          for example here we will simulate this through mock server
         1)do here any bussines logic needed ( save request to DB or some thing like this)
         2) return success message to the user */
        PaymentIntegrationDTO request= new PaymentIntegrationDTO(paymentRequest.getToken(),paymentRequest.getAmount(),"EGP");
       String status= paymentIntegrationManager.pay(request,env.getProperty("payment.gatway.mock.server.url"));
        return new PaymentResponse("The amount of the order paid successfully and will be received on the expected time ",status);

    }
}
