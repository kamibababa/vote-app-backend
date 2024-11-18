package org.example.exception;

import org.example.response.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public ApiResponse<String> handldAuthException(AuthException exception){
        return ApiResponse.error(exception.getCode(), exception.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handldError(Exception exception){
        return ApiResponse.error(250, exception.getMessage());
    }
}
