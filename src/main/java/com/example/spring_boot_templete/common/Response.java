package com.example.spring_boot_templete.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class Response<T> extends ResponseEntity<ResponseBody> {
    public Response() {
        super(new ResponseBody<T>(HttpStatus.OK, null, null, null), HttpStatus.OK);
    }

    public Response(T body) {
        super(new ResponseBody<>(HttpStatus.OK, null, null, body), HttpStatus.OK);
    }

    public Response(ResultCode resultCode) {
        super(new ResponseBody<>(resultCode.getStatus(), resultCode.getStatusCode(), resultCode.getStatusMessage(), null), HttpStatus.OK);
    }

    public Response(@Nullable T body, HttpStatus status) {
        super(new ResponseBody<>(status, null, null, body), status);
    }

    public Response(@Nullable T body, ResultCode resultCode) {
        super(new ResponseBody<>(resultCode.getStatus(), resultCode.getStatusCode(), resultCode.getStatusMessage(), body), HttpStatus.OK);
    }

    public Response(@Nullable T body, HttpStatus status, ResultCode resultCode) {
        super(new ResponseBody<>(status, resultCode.getStatusCode(), resultCode.getStatusMessage(), body), HttpStatus.OK);
    }
}
