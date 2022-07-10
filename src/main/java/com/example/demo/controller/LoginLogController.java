package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.PageBean;
import com.example.demo.model.RespBean;
import com.example.demo.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "登录日志")
@RestController
@RequestMapping("/log/LoginLog")
public class LoginLogController {
    @Autowired
    LoginLogService loginLogService;

    @GetMapping("/")
    public PageBean getLoginLogPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {
        return loginLogService.getLoginLogByPage(page, size, keywords);
    }

    @Log(logType = LogConst.LOG_TYPE_DELETE)
    @ApiOperation(value = "删除登录日志")
    @DeleteMapping("/")
    public RespBean deleteLoginLog(Integer[] ids) {
        if (loginLogService.deleteLoginLog(ids) == ids.length) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
