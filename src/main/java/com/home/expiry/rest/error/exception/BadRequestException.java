package com.home.expiry.rest.error.exception;

import com.home.expiry.rest.error.message.ErrorMessage;

public class BadRequestException extends ApiErrorException {

    public BadRequestException(ErrorMessage errorMessage){
        super(errorMessage);
    }

    public BadRequestException(ErrorMessage errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
