package com.ankang.auth.respone;

public class TokenAuthenticationException extends RuntimeException {

    public TokenAuthenticationException() {
        super();
    }

    public TokenAuthenticationException(int code, String message) {
        super(code + message);
    }
}