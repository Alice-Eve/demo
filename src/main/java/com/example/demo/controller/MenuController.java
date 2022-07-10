package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.RespBean;
import com.example.demo.model.SysMenu;
import com.example.demo.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "菜单管理")
@RestController
@RequestMapping("/system/menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<SysMenu> getMenusByUserId() {
        return menuService.getMenusByUserId();
    }

    @GetMapping("/all")
    public List<SysMenu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @Log(logType = LogConst.LOG_TYPE_SAVE)
    @ApiOperation(value = "添加菜单")
    @PostMapping("/")
    public RespBean setMenu(@RequestBody SysMenu menu) {
        if (menuService.addMenu(menu) == 1) {
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Log(logType = LogConst.LOG_TYPE_UPDATE)
    @ApiOperation(value = "修改菜单")
    @PutMapping("/")
    public RespBean upMenu(@RequestBody SysMenu menu) {
        if (menuService.upMenu(menu) == 1) {
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @Log(logType = LogConst.LOG_TYPE_DELETE)
    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/")
    public RespBean deleteMenus(Integer[] ids) {
        if (menuService.deleteMenus(ids) == ids.length) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
