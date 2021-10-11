package com.samples.keycloak.webapp.resource;

import com.samples.keycloak.webapp.dto.Order;
import com.samples.keycloak.webapp.security.AuthenticatedUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/me")
@Slf4j
public class UserResource {

    @Autowired
    private KeycloakRestTemplate restTemplate;

    @GetMapping
    public AuthenticatedUserInfo getDetails() {
        return AuthenticatedUserInfo.get();
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        var ucBuilder = UriComponentsBuilder
                .fromHttpUrl("http://localhost:9000/orders")
                .queryParam("customerId", "valid_customer_id");
        var orderResponse = restTemplate.exchange(ucBuilder.toUriString(),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
                });
        return orderResponse.getBody();
    }
}
