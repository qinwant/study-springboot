package com.kingwan.boot.common;

import com.kingwan.boot.common.enums.ResultCode;
import com.kingwan.boot.common.enums.UserResult;
import lombok.Getter;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：统一返回格式
 */
@Getter
public class ResponseDO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseDO(){

    }

    /**
     * 普通方式
     * @param code
     * @param msg
     * @param data
     */
    public ResponseDO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 封装了一个枚举的返回结果
     * @param resultCode
     * @param data
     */
    public ResponseDO(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    /**
     * 封装了一个枚举的返回结果
     * @param userResult
     * @param data
     */
    public ResponseDO(UserResult userResult, T data){
        this.code = userResult.getCode();
        this.msg = userResult.getMsg();
        this.data = data;
    }

}
