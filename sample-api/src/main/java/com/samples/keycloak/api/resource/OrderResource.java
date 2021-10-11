package com.samples.keycloak.api.resource;

import com.samples.keycloak.api.dto.Order;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderResource {

    @GetMapping
    @RolesAllowed("ROLE_order-api-user")
    public List<Order> getOrders(@RequestParam @NotNull String customerId) {
        return createOrders(customerId);
    }

    private List<Order> createOrders(String customerId) {
        if ("valid_customer_id".equals(customerId)) {
            return List.of(
                    Order.builder().itemId("item1").pricePerItem(10d).quantity(3).totalPrice(30d).build(),
                    Order.builder().itemId("item2").pricePerItem(50d).quantity(10).totalPrice(400d).discountPercent(10).build()
            );
        } else {
            return Collections.emptyList();
        }
    }

}
