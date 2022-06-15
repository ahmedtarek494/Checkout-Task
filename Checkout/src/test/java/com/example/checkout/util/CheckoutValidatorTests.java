package com.example.checkout.util;

import com.example.checkout.exception.CheckoutValidationException;
import com.example.checkout.exception.PaymentIntegrationException;
import com.example.checkout.model.CheckoutOrderDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutValidatorTests {

    @Test
    void item_available(){
        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",120.0,true);

        assertDoesNotThrow(()->CheckoutValidator.validateAvailability(order));
    }
    @Test
    void item_not_available(){
        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",120.0,false);
        assertThrows(CheckoutValidationException.class,()->CheckoutValidator.validateAvailability(order));

    }
    @Test
    void items_valid_above_100(){
        assertDoesNotThrow(()->CheckoutValidator.validateCheckoutPrices(150.0));

    }
    @Test
    void items_fail_below_100(){
        assertThrows(CheckoutValidationException.class,()->CheckoutValidator.validateCheckoutPrices(70.0));

    }


    @Test
    void items_fraud_above_1500(){
        assertThrows(CheckoutValidationException.class,()->CheckoutValidator.validateCheckoutPrices(1700.0));

    }
}
