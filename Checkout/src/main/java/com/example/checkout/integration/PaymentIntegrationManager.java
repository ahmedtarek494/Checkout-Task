package com.example.checkout.integration;


import com.example.checkout.exception.PaymentIntegrationException;
import com.example.checkout.model.PaymentIntegrationDTO;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentIntegrationManager {




    public String pay(PaymentIntegrationDTO request ,String uri) {

        RestTemplate restTemplate = new RestTemplate();

        String statusMsg = null;
        try {
            statusMsg = restTemplate.postForObject(uri, request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PaymentIntegrationException("Can't Connect to payment Gateway right now, try again later");
        }


        return statusMsg;

    }
}
