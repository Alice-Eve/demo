package com.example.demo.service;

import com.example.demo.bean.Menu;
import com.example.demo.bean.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-02-01 19:25
 **/

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if (role.getName().startsWith("ROLE_")) {
            role.setName(("ROLE_"+role.getName()));
        }
        return roleMapper.insert(role);
    }
    public Integer deleteRoleById(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }
}