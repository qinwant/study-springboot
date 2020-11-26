package com.kingwan.boot.service.impl;

import com.kingwan.boot.dao.UserMapper;
import com.kingwan.boot.pojo.User;
import com.kingwan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        //添加用户前判断是否存在
        User u = userMapper.queryUserByName(user.getUsername());
        if(u == null){
            //设置用户创建时间
            user.setCreateTime(new Date());
            return userMapper.saveUser(user);
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        //更新用户前判断用户名是否已存在
        User u = userMapper.queryUserByName(user.getUsername());
        if(u == null || u.getId()==user.getId()){
            return userMapper.updateUser(user);
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
