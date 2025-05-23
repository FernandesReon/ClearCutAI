package com.reon.clearcutai_backend.exception;

public class OTPExpiredException extends RuntimeException{
    public OTPExpiredException(String message) {
        super(message);
    }
}
