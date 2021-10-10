package com.samples.keycloak.webapp.resource;

import com.samples.keycloak.webapp.security.AuthenticatedUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
@Slf4j
public class UserResource {

    @GetMapping
    public AuthenticatedUserInfo getDetails() {
        return AuthenticatedUserInfo.get();
    }
}
