package com.home.expiry.rest.error.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    PRODUCT_NOT_FOUND(1, "Product could not be found", "Product could not be found with specified id"),
    INVALID_PRODUCT(2, "Invalid Product", "Invalid product. Please consider reviewing data.");


    private final int code;
    private final String title;
    private final String description;


    @Override
    public String toString() {
        return code + ": " + description;
    }
}
