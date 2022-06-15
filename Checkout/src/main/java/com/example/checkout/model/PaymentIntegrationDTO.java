package com.example.checkout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentIntegrationDTO {

    private String token;
    private double amount;
    private String currency;
}
