package com.samples.keycloak.webapp.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceType;
    private String resourceId;

    public ResourceNotFoundException(String resourceType, String resourceId) {
        super();
        this.resourceType = resourceType;
        this.resourceId = resourceId;
    }

}
