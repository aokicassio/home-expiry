package com.home.expiry.rest.error.exception;

import com.home.expiry.rest.error.message.ErrorMessage;

public class UnauthorizedException extends ApiErrorException {

    public UnauthorizedException(ErrorMessage errorMessage){
        super(errorMessage);
    }

    public UnauthorizedException(ErrorMessage errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
