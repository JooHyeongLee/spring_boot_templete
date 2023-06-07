package com.example.spring_boot_templete.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    NOT_FOUND_DATA(NOT_FOUND, "조회된 결과 값이 없습니다.", "-11111"),
    ACCESS_PERMISSION_DENY(UNAUTHORIZED, "권한이 없습니다.", "-10005")
    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;
}
