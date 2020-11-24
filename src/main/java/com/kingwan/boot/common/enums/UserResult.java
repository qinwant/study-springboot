package com.kingwan.boot.common.enums;

import lombok.Getter;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
@Getter
public enum UserResult {
    USER_SUCCESS(200,"操作成功"),
    USER_FAILED(100,"响应失败"),
    USER_VALIDATE_FAILED(101,"参数校验失败"),
    USER_ERROR(103,"服务器错误"),
    USER_NOT_EXIT(101,"用户不存在"),
    USER_EMPTY(102,"暂无用户数据");
    private int code;
    private String msg;
    UserResult(int code, String msg){
        this.code = code;
        this.msg =msg;
    }
}
