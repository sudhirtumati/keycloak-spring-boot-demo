package com.samples.keycloak.webapp.security;

import lombok.Getter;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;

@Getter
public class AuthenticatedUserInfo {

    private String accessToken;
    private String idToken;
    private String refreshToken;
    private String userName;
    private Set<String> roles;

    private AuthenticatedUserInfo() {
    }

    public static AuthenticatedUserInfo get() {
        var kcPrincipal = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        var kcSecContext = (RefreshableKeycloakSecurityContext) kcPrincipal.getCredentials();
        AuthenticatedUserInfo userInfo = new AuthenticatedUserInfo();
        userInfo.accessToken = kcSecContext.getTokenString();
        userInfo.idToken = kcSecContext.getIdTokenString();
        userInfo.refreshToken = kcSecContext.getRefreshToken();
        userInfo.userName = kcSecContext.getToken().getPreferredUsername();
        userInfo.roles = kcPrincipal.getAccount().getRoles();
        return userInfo;
    }
}
