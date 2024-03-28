package org.example.auth.exception;

import org.example.auth.response.BaseResponse;

public class AuthException extends RuntimeException {
    public BaseResponse response;

    public AuthException(BaseResponse response) {
        this.response = response;
    }
}
