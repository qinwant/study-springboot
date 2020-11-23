package com.kingwan.boot.controller;

import com.kingwan.boot.common.ResponseDO;
import com.kingwan.boot.common.enums.ResultCode;
import com.kingwan.boot.common.enums.UserResult;
import com.kingwan.boot.pojo.User;
import com.kingwan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseDO saveUser(User user){
        int i = userService.saveUser(user);
        if(i>0){
            return new ResponseDO(ResultCode.SUCCESS,i);
        }
        return new ResponseDO(233,"保存用户信息失败","用户名已存在");
    }

    @GetMapping("/query/{id}")
    public ResponseDO queryUserById(@PathVariable Integer id){
        User user = userService.queryUserById(id);
        if(user != null){
            return new ResponseDO(ResultCode.SUCCESS,user);
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,null);
    }
}
