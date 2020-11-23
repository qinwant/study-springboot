package com.kingwan.boot.common.enums;

import lombok.Getter;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
@Getter
public enum ResultCode {
    SUCCESS(200,"操作成功"),
    FAILED(100,"响应失败"),
    VALIDATE_FAILED(101,"参数校验失败"),
    ERROR(103,"服务器错误");
    private int code;
    private String msg;
    ResultCode(int code, String msg){
        this.code = code;
        this.msg =msg;
    }
}
