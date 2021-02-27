package com.example.demo.controller.system;

import com.example.demo.bean.Hr;
import com.example.demo.bean.RespBean;
import com.example.demo.bean.Role;
import com.example.demo.service.HrService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-02-10 15:25
 **/
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords) {
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRoles(Integer hrid,Integer[] rids) {
        if (hrService.updateHrRoles(hrid,rids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}