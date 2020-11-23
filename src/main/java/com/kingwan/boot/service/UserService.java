package com.kingwan.boot.service;

import com.kingwan.boot.pojo.User;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
public interface UserService {
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    User queryUserById(int id);
    User queryUserByName(String name);
}
