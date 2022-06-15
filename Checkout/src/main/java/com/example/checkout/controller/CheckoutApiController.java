package com.example.checkout.controller;


import com.example.checkout.model.CheckoutOrderDTO;
import com.example.checkout.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order/")
public class CheckoutApiController {


    private final CheckoutService service;

    @Autowired
    public CheckoutApiController(CheckoutService service) {
        this.service = service;
    }

    @PostMapping(value = "/checkout")
    public ResponseEntity checkout(@RequestBody List<CheckoutOrderDTO> checkoutOrderDtoList) {
      return new ResponseEntity<>(service.createSession(checkoutOrderDtoList), HttpStatus.OK);

    }

}
