package com.home.expiry.rest.error.exception;

public class NotFoundException extends ApiErrorException {

    public NotFoundException(String errorMessage){
        super(errorMessage);
    }

    public NotFoundException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
