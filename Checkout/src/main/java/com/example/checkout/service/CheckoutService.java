package com.example.checkout.service;

import com.example.checkout.model.CheckoutSuccessResponse;
import com.example.checkout.model.CheckoutOrderDTO;
import com.example.checkout.util.CheckoutValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {


    public CheckoutSuccessResponse createSession(List<CheckoutOrderDTO> checkoutOrderDtoList){
            double totalPrice=0.0;
        for(CheckoutOrderDTO item :checkoutOrderDtoList){
            CheckoutValidator.validateAvailability(item);
            totalPrice+= item.getPrice();
        }
        CheckoutValidator.validateCheckoutPrices(totalPrice);
        return new CheckoutSuccessResponse("Checkout Session Created Successfully",totalPrice);
    }


}
