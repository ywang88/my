package com.evan.my.result;

import lombok.Data;

/**
 * @author mc
 * @create 2020-01-28 17:28
 * 登录状态码
 **/
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
}
