package com.evan.my.result;

/**
 * @author mc
 * @create 2020-03-29 13:42
 **/
public enum ResultCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);
    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
