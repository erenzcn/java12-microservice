package org.example.basket.exception;

import org.example.basket.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BasketException.class)
    @ResponseStatus(HttpStatus.OK)
    BaseResponse authException(BasketException exception) {
        return exception.response;
    }
}
