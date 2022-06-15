package com.example.checkout.model;


import lombok.Getter;

import org.apache.commons.lang3.RandomStringUtils;
@Getter
public class CheckoutSuccessResponse {

    private String message;
    private String token;

    private double amount;
    public CheckoutSuccessResponse(String msg, double amount){
    this.message=msg;
    this.amount=amount;
    this.token=RandomStringUtils.random(20, true, true);

    }

}
