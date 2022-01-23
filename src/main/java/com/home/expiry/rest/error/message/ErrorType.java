package com.home.expiry.rest.error.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorType {

    NOT_FOUND("/errors/not-found"),
    BAD_REQUEST("/errors/bad-request"),
    UNAUTHORIZED("/errors/unauthorized"),
    UNEXPECTED("/errors/unexpected");

    private final String type;

    @Override
    public String toString() {
        return type;
    }
}
