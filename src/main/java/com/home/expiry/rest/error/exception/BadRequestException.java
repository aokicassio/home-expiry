package com.home.expiry.rest.error.exception;

public class BadRequestException extends ApiErrorException {

    public BadRequestException(String errorMessage){
        super(errorMessage);
    }

    public BadRequestException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
