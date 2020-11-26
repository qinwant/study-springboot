package com.kingwan.boot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingwan.boot.common.ResponseDO;
import com.kingwan.boot.common.enums.ResultCode;
import com.kingwan.boot.common.enums.UserResult;
import com.kingwan.boot.pojo.User;
import com.kingwan.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kingwan on 2020/11/23.
 * 说明：
 */
@RestController
@Api(tags = "用户信息管理")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    @ApiOperation(value = "添加用户",notes = "必填，用户名不允许重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "form"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,paramType = "form")
    })
    public ResponseDO saveUser(User user){
        int i = userService.saveUser(user);
        if(i>0){
            return new ResponseDO(ResultCode.SUCCESS,i);
        }
        return new ResponseDO(233,"保存用户信息失败","用户名已存在");
    }

    @GetMapping("/query/{id}")
    @ApiOperation(value = "根据id查找用户",notes = "必填")
    @Cacheable(value = "user",key = "#id")
    public ResponseDO queryUserById(@PathVariable Integer id){
        User user = userService.queryUserById(id);
        if(user != null){
            return new ResponseDO(ResultCode.SUCCESS,user);
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,null);
    }

    @GetMapping("/query")
    @ApiOperation(value = "根据用户名查找用户",notes = "必填")
    public ResponseDO queryUserByName(String name){
        User user = userService.queryUserByName(name);
        if(user != null){
            return new ResponseDO(ResultCode.SUCCESS,user);
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,null);
    }

    @GetMapping("/queryAll")
    @ApiOperation(value = "查找所有用户")
    public ResponseDO queryAll(){
        List<User> users = userService.queryAll();
        if(users != null){
            return new ResponseDO(ResultCode.SUCCESS,users);
        }
        return new ResponseDO(UserResult.USER_EMPTY,null);
    }

    @ApiOperation(value = "查找所有用户",notes = "分页")
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
    @ApiOperation(value = "更新用户信息",notes = "必填")
    @Transactional(propagation = Propagation.REQUIRED)
    @CacheEvict(value = "user",key = "#user.id")
    public ResponseDO updateUser(User user){
        User u = userService.queryUserById(user.getId());
        if(u != null){
            userService.updateUser(user);
            return new ResponseDO(UserResult.USER_SUCCESS,"update success");
        }
        return new ResponseDO(UserResult.USER_NOT_EXIT,"update failed");
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "根据id删除用户",notes = "必填")
    public ResponseDO deleteUser(Integer id){
        int del = userService.deleteUser(id);
        if(del>0){
            return new ResponseDO(UserResult.USER_SUCCESS,"delete success");
        }
        return new ResponseDO(UserResult.USER_EMPTY,"delete failed");
    }
}
