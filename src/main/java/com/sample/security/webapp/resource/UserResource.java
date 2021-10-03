package com.sample.security.webapp.resource;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/me")
@Slf4j
public class UserResource {

    @GetMapping
    public String getDetails(Principal principal) {
        KeycloakAuthenticationToken kcPrincipal = (KeycloakAuthenticationToken) principal;
        KeycloakSecurityContext kcSecContext = (KeycloakSecurityContext) kcPrincipal.getCredentials();
        return kcSecContext.getTokenString();
    }
}
