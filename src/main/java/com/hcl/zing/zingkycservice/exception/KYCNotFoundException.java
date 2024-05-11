package com.hcl.zing.zingkycservice.exception;

public class KYCNotFoundException extends RuntimeException {

    public KYCNotFoundException() {
        super("KYC details not found");
    }

    public KYCNotFoundException(String message) {
        super(message);
    }

    public KYCNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

