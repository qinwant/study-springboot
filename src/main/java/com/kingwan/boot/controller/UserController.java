package com.kingwan.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingwan.boot.common.ResponseDO;
import com.kingwan.boot.common.enums.ResultCode;
import com.kingwan.boot.common.enums.UserResult;
import com.kingwan.boot.pojo.User;
import com.kingwan.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/query")
    public ResponseDO queryUserByName(String name){
        User user = userService.queryUserByName(name);
        if(user != null){
            return new ResponseDO(ResultCode.SUCCESS,user);
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,null);
    }

    @GetMapping("/queryAll")
    public ResponseDO queryAll(){
        List<User> users = userService.queryAll();
        if(users != null){
            return new ResponseDO(ResultCode.SUCCESS,users);
        }
        return new ResponseDO(UserResult.USER_EMPTY,null);
    }

    @GetMapping("/queryAllInfo")
    public ResponseDO queryAll(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        //开启分页，设置页数及每页记录数
        PageHelper.startPage(pageNum,5);
        List<User> users = userService.queryAll();
        //分页信息加载
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        if(users != null){
            return new ResponseDO(ResultCode.SUCCESS,userPageInfo.getList());
        }
        return new ResponseDO(UserResult.USER_EMPTY,null);
    }

    @PutMapping("/update")
    public ResponseDO updateUser(User user){
        User u = userService.queryUserById(user.getId());
        if(u != null){
            userService.updateUser(user);
            return new ResponseDO(UserResult.USER_SUCCESS,"update success");
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,"更新失败");
    }

    @DeleteMapping("/delete")
    public ResponseDO deleteUser(Integer id){
        int del = userService.deleteUser(id);
        if(del>0){
            return new ResponseDO(UserResult.USER_SUCCESS,"delete success");
        }
        return new ResponseDO(UserResult.USER_EMPTY,"delete failed");
    }
}
