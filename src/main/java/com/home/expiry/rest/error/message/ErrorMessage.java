package com.home.expiry.rest.error.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    PRODUCT_NOT_FOUND(1, "Product could not be found", "Product could not be found with specified id"),
    INVALID_PRODUCT(2, "Invalid Product", "Invalid product. Please consider reviewing data."),
    USER_ALREADY_EXISTS(3, "User already exists", "User already exists with provided name."),
    BAD_CREDENTIALS(3, "Bad credentials", "Credentials provided are not valid. Please login."),
    JWT_TOKEN_EXPIRED(4, "Token expired", "Security token expired. Please login again."),
    UNEXPECTED_ERROR(5,"Unexpected Error occurred","An unexpected error occurred. Please contact the system administrator.");

    private final int code;
    private final String title;
    private final String description;

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
