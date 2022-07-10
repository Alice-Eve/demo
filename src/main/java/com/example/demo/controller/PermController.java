package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.RespBean;
import com.example.demo.service.PermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "权限管理")
@RestController
@RequestMapping("/system/perm")
public class PermController {
    @Autowired
    PermService permService;

    @GetMapping("/ur/{uid}")
    public List<Integer> selectPermByUid(@PathVariable Integer uid) {
        return permService.selectPermByUid(uid);
    }

    @Log(logType = LogConst.LOG_TYPE_UPDATE)
    @PutMapping("/ur/")
    @ApiOperation(value = "修改用户权限")
    public RespBean upPermRole(Integer uid, Integer[] rids) {
        if (permService.upPermRole(uid,rids)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/mr/{rid}")
    public List<Integer> selectPermByRid(@PathVariable Integer rid) {
        return permService.selectPermByRid(rid);
    }

    @Log(logType = LogConst.LOG_TYPE_UPDATE)
    @PutMapping("/mr/")
    @ApiOperation(value = "修改菜单权限")
    public RespBean upPermMenu(Integer rid, Integer[] mids) {
        if (permService.upPermMenu(rid,mids)) {
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
}
