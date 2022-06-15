package com.example.checkout.service;

import com.example.checkout.model.PaymentRequest;
import com.example.checkout.model.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class CashPayment implements PaymentService {


    @Override
    public PaymentResponse pay(PaymentRequest paymentRequest) {
        // 1)do here any bussines logic needed ( save request to DB or some thing like this)
        // 2) return success message to the user
        return new PaymentResponse("Your order submitted successfully and will be received on the expected time ","OK!");
    }
}
