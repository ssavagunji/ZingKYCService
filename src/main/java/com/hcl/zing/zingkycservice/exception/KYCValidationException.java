package com.hcl.zing.zingkycservice.exception;

public class KYCValidationException extends RuntimeException {

    public KYCValidationException() {
        super("KYC validation failed");
    }

    public KYCValidationException(String message) {
        super(message);
    }

    public KYCValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
