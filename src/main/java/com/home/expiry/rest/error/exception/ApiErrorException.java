package com.home.expiry.rest.error.exception;

import com.home.expiry.rest.error.message.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiErrorException extends IllegalArgumentException {

    private final ErrorMessage errorMessage;

    public ApiErrorException(ErrorMessage errorMessage){
        super(errorMessage.getTitle());
        this.errorMessage = errorMessage;
    }

    public ApiErrorException(ErrorMessage errorMessage, Throwable err){
        super(errorMessage.getTitle(), err);
        this.errorMessage = errorMessage;
    }

}
