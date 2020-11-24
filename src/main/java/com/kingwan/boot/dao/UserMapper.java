package com.kingwan.boot.dao;

import com.kingwan.boot.pojo.User;

import java.util.List;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
public interface UserMapper {
    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    User queryUserById(int id);

    User queryUserByName(String name);

    List<User> queryAll();
}
