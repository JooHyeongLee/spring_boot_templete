package com.example.spring_boot_templete.exception;

import com.example.spring_boot_templete.common.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private final ResultCode resultCode;
}
