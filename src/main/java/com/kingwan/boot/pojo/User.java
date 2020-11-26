package com.kingwan.boot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：用户表
 */
@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private Date createTime; //创建时间
    private Date loginTime; //登陆时间
    private Date lastLoginTime; //上次登陆时间
}
