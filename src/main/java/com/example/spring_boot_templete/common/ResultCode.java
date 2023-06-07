package com.example.spring_boot_templete.common;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    DATA_SUCCESS(HttpStatus.OK, "00000", "정상처리 되었습니다."),
    NOT_FOUND(HttpStatus.OK, "-10000", "찾을 수 없는 페이지입니다."),
;
    private final HttpStatus status;
    private final String statusCode;
    private final String statusMessage;

    ResultCode(HttpStatus status, String statusCode, String statusMessage) {
        this.status = status;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
