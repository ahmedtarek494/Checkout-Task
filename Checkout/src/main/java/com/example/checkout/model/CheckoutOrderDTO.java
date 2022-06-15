package com.example.checkout.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CheckoutOrderDTO {

    private int productId;

    private String productName;

    private double price;

    private boolean availability;
}
