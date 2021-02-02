package com.example.demo.controller.system.basic;

import com.example.demo.bean.Menu;
import com.example.demo.bean.RespBean;
import com.example.demo.bean.Role;
import com.example.demo.service.MenuService;
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
 * @时间 2021-02-01 19:22
 **/

@RestController
@RequestMapping("/system/basic/per")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid) { return menuService.getMidsByRid(rid);}
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids) {
        if (menuService.updateMenuRole(rid,mids)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @DeleteMapping("/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}