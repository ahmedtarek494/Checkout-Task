package com.example.checkout.util;

import com.example.checkout.exception.CheckoutValidationException;
import com.example.checkout.model.CheckoutOrderDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CheckoutValidator {


    public static void validateAvailability(CheckoutOrderDTO item){

        if(!item.isAvailability())
            throw new CheckoutValidationException(String.format("Item : %s not available in stock",item.getProductName()));
    }

    public static void validateCheckoutPrices(double totalPrice){

        if(totalPrice<100)
            throw new CheckoutValidationException("Total amount of items must be above 100");
        else if (totalPrice>1500)
            throw new CheckoutValidationException("Total amount of items may be not real one");
    }
}
