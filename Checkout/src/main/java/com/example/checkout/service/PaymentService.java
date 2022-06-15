package com.example.checkout.service;

import com.example.checkout.model.PaymentRequest;
import com.example.checkout.model.PaymentResponse;


public interface PaymentService {


     PaymentResponse pay(PaymentRequest paymentRequest);
}
