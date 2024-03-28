package org.example.stock.exception;


import org.example.stock.response.BaseResponse;

public class StockException extends RuntimeException {
    public BaseResponse response;

    public StockException(BaseResponse response) {
        this.response = response;
    }
}
