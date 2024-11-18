package org.example.exception;

public class AuthException extends RuntimeException{
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public AuthException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
