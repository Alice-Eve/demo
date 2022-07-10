package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.RespBean;
import com.example.demo.model.SysRole;
import com.example.demo.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<SysRole> getRoles() {
        return roleService.getRoles();
    }

    @Log(logType = LogConst.LOG_TYPE_SAVE)
    @ApiOperation(value = "添加角色")
    @PostMapping("/")
    public RespBean setRole(@RequestBody SysRole role) {
        if (roleService.intRole(role) == 1) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Log(logType = LogConst.LOG_TYPE_DELETE)
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/")
    public RespBean deleteRole(Integer[] ids) {
        if (roleService.deleteRole(ids) == ids.length) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @Log(logType = LogConst.LOG_TYPE_UPDATE)
    @ApiOperation(value = "修改角色")
    @PutMapping("/")
    public RespBean upRole(@RequestBody SysRole role) {
        if (roleService.upRole(role) == 1) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }
}
