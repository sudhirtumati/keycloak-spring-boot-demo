package com.samples.keycloak.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {

    private String itemId;
    private double pricePerItem;
    private int quantity;
    private float discountPercent;
    private double totalPrice;

}
