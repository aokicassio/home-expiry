package com.home.expiry.rest.error.handler;

import com.home.expiry.rest.error.exception.BadRequestException;
import com.home.expiry.rest.error.exception.NotFoundException;
import com.home.expiry.rest.error.exception.UnauthorizedException;
import com.home.expiry.rest.error.message.ErrorMessage;
import com.home.expiry.rest.error.message.ErrorType;
import com.home.expiry.rest.response.ApiError;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.SignatureException;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ApiError handleUnexpected(RuntimeException ex, WebRequest request) {
        ApiError apiError = getApiError(ErrorMessage.UNEXPECTED_ERROR);
        apiError.setType(ErrorType.BAD_REQUEST.getType());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI());
        return apiError;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected ApiError resourceNotFoundException(NotFoundException ex, WebRequest request) {
        ApiError apiError = getApiError(ex.getErrorMessage());
        apiError.setType(ErrorType.NOT_FOUND.getType());
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI());
        return apiError;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ApiError handleBadRequestException(BadRequestException ex, WebRequest request) {
        ApiError apiError = getApiError(ex.getErrorMessage());
        apiError.setType(ErrorType.BAD_REQUEST.getType());
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI());
        return apiError;
    }

    private ApiError getApiError(ErrorMessage errorMessage){
        ApiError apiError = new ApiError();
        apiError.setTitle(errorMessage.getTitle());
        apiError.setDetail(errorMessage.getDescription());
        return apiError;
    }
}
