package com.home.expiry.rest.error.exception;

import com.home.expiry.rest.error.message.ErrorMessage;

public class NotFoundException extends ApiErrorException {

    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }

    public NotFoundException(ErrorMessage errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
