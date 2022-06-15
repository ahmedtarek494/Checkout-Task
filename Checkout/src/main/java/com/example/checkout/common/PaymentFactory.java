package com.example.checkout.common;

import com.example.checkout.service.CashPayment;
import com.example.checkout.service.PaymentService;
import com.example.checkout.service.VisaPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {

    private VisaPayment visaPayment;

    private CashPayment cashPayment;

    @Autowired
    public void setVisaPayment(VisaPayment visaPayment) {
        this.visaPayment = visaPayment;
    }

    @Autowired
    public void setCashPayment(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    public PaymentService getPaymentType(String paymentType){

        if("cash".equalsIgnoreCase(paymentType))
            return this.cashPayment;
        else if ("visa".equalsIgnoreCase(paymentType))
            return this.visaPayment;
        else
            return null;
        }


    }
