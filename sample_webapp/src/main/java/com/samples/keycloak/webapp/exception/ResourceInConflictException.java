package com.samples.keycloak.webapp.exception;

import lombok.Getter;

@Getter
public class ResourceInConflictException extends RuntimeException {

    private String resourceType;
    private String propertyName;
    private String propertyValue;

    public ResourceInConflictException(String resourceType, String propertyName, String propertyValue) {
        super();
        this.resourceType = resourceType;
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }
}
