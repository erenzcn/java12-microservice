package org.example.basket.exception;


import org.example.basket.response.BaseResponse;

public class BasketException extends RuntimeException {
    public BaseResponse response;

    public BasketException(BaseResponse response) {
        this.response = response;
    }
}
