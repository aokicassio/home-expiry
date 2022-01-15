package com.home.expiry.rest.error.exception;

import com.home.expiry.rest.error.message.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorException extends IllegalArgumentException {

    private ErrorMessage errorMessage;

    public ApiErrorException(String errorMessage){
        super(errorMessage);
    }

    public ApiErrorException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
