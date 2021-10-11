package com.samples.keycloak.webapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private String itemId;
    private double pricePerItem;
    private int quantity;
    private float discountPercent;
    private double totalPrice;

}
