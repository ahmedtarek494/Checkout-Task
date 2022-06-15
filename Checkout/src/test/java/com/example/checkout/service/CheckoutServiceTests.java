package com.example.checkout.service;

import com.example.checkout.exception.CheckoutValidationException;
import com.example.checkout.model.CheckoutOrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutServiceTests {


    CheckoutService service;

    @BeforeEach
    void init() {
        service=new CheckoutService();
    }
    @Test
  void createSession_success(){

        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",120.0,true);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);

        assertEquals(service.createSession(list).getMessage(),"Checkout Session Created Successfully");


    }
    @Test
    void createSession_with_not_available_items(){

        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",120.0,false);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);

        assertThrows(CheckoutValidationException.class,() -> service.createSession(list));


    }
    @Test
    void createSession_with_wrong_amount_less_100(){

        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",20.0,false);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);

        assertThrows(CheckoutValidationException.class,() -> service.createSession(list));


    }

    @Test
    void createSession_with_fraud_amount_more_1500(){

        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",1620.0,true);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);

        assertThrows(CheckoutValidationException.class,() -> service.createSession(list));


    }
}
