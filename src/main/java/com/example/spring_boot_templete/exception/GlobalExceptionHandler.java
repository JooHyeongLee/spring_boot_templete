package com.example.spring_boot_templete.exception;

import com.example.spring_boot_templete.common.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({CustomException.class})
    protected Response<Map<String, Object>> customException(CustomException ex) {
        return new Response<>(ex.getResultCode());
    }

}
