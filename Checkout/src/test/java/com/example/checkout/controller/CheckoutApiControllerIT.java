package com.example.checkout.controller;

import com.example.checkout.model.CheckoutOrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutApiControllerIT extends BaseControllerTest{

    private static final String uri="/order/checkout";
    @Test
     void checkout_with_successfull_response() throws Exception {
        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",120.0,true);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);
        String inputJson = super.mapToJson(list);


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    void checkout_with_Failure_response() throws Exception {
        CheckoutOrderDTO order =new CheckoutOrderDTO(1,"laptop",50.0,true);
        ArrayList<CheckoutOrderDTO> list= new ArrayList<>();
        list.add(order);
        String inputJson = super.mapToJson(list);


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(500, status);

    }

}
