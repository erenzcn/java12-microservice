package org.example.stock.exception;

import org.example.stock.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(StockException.class)
    @ResponseStatus(HttpStatus.OK)
    BaseResponse authException(StockException exception) {
        return exception.response;
    }
}
