package com.example.spring_boot_templete.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody<T> {
    private HttpStatus status;
    private ResultCode resultCode;
    private String code;
    private String message;

    private T data;

    public ResponseBody(HttpStatus status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "status=" + status +
                ", resultCode=" + resultCode +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
