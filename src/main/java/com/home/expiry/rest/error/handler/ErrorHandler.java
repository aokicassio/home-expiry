package com.home.expiry.rest.error.handler;

import com.home.expiry.rest.error.exception.BadRequestException;
import com.home.expiry.rest.error.exception.NotFoundException;
import com.home.expiry.rest.error.message.ErrorMessage;
import com.home.expiry.rest.response.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ApiError apiError = new ApiError();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setTitle("Unexpected Error occurred");
        apiError.setDetail("An unexpected error occurred. Please contact the system administrator.");
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return handleExceptionInternal(ex, apiError,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError resourceNotFoundException(NotFoundException ex, WebRequest request) {
        ApiError apiError = getApiError(ex.getErrorMessage());
        apiError.setType("/errors/not-found");
        apiError.setStatus(HttpStatus.NOT_FOUND.value());
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI().toString());
        return apiError;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError resourceNotFoundException(BadRequestException ex, WebRequest request) {
        ApiError apiError = getApiError(ex.getErrorMessage());
        apiError.setType("/errors/bad-request");
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());
        apiError.setInstance(((ServletWebRequest)request).getRequest().getRequestURI().toString());

        return apiError;
    }

    private ApiError getApiError(ErrorMessage errorMessage){
        ApiError apiError = new ApiError();
        apiError.setTitle(errorMessage.getTitle());
        apiError.setDetail(errorMessage.getDescription());
        return apiError;
    }
}
