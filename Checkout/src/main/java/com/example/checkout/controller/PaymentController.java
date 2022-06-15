package com.example.checkout.controller;

import com.example.checkout.common.PaymentFactory;
import com.example.checkout.model.CheckoutOrderDTO;
import com.example.checkout.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/gateway/")
public class PaymentController {

    private final PaymentFactory paymentFactory;


    @Autowired
    public PaymentController(PaymentFactory paymentFactory){
        this.paymentFactory=paymentFactory;
    }



    @PostMapping(value = "/pay")
    public ResponseEntity pay(@RequestBody PaymentRequest paymentRequest) {
        return new ResponseEntity<>(paymentFactory.getPaymentType(paymentRequest.getPaymentType()).pay(paymentRequest), HttpStatus.OK);

    }
}
