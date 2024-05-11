package com.hcl.zing.zingkycservice.exception;

public class ValueNotFoundException extends RuntimeException {

    public ValueNotFoundException(String message) {
        super(message);
    }

    public ValueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
