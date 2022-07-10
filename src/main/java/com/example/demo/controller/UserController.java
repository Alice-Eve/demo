package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.RespBean;
import com.example.demo.model.SysUser;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<SysUser> getAllUser(String keywords) {
        return userService.getAllUser(keywords);
    }

    @Log(logType = LogConst.LOG_TYPE_SAVE)
    @ApiOperation(value = "添加用户")
    @PostMapping("/")
    public RespBean setUser(@RequestBody SysUser user) {
        if (userService.intUser(user) == 1){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Log(logType = LogConst.LOG_TYPE_DELETE)
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/")
    public RespBean deleteUser(Integer[] ids) {
        if (userService.deleteUsers(ids) == ids.length) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @Log(logType = LogConst.LOG_TYPE_UPLOAD)

    @ApiOperation(value = "修改用户")
    @PutMapping("/")
    public RespBean upUser(@RequestBody SysUser user) {
        if (userService.upUser(user) == 1) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }
}
