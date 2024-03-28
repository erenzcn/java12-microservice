package org.example.auth.exception;

import org.example.auth.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.OK)
    BaseResponse authException(AuthException exception) {
        return exception.response;
    }
}
