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

    public Result(int code){
        this.code=code;
    }
}
