package com.example.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final Long serialVersionId = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldItem;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldItem) {
        super(resourceName + "not found with" + fieldName + " : " + fieldItem);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldItem = fieldItem;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldItem() {
        return fieldItem;
    }
}
