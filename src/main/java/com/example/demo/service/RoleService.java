package com.example.demo.service;

import com.example.demo.mapper.SysMenuRoleMapper;
import com.example.demo.mapper.SysRoleMapper;
import com.example.demo.mapper.SysUserRoleMapper;
import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    SysRoleMapper roleMapper;
    @Autowired
    SysMenuRoleMapper menuRoleMapper;
    @Autowired
    SysUserRoleMapper userRoleMapper;

    public List<SysRole> getRoles() {
        return roleMapper.getRoles();
    }

    public Integer intRole(SysRole role) {
        role.setCreateTime(new Date());
        role.setCreateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getNickname());
        return roleMapper.insertSelective(role);
    }

    public Integer upRole(SysRole role) {
        role.setUpdateTime(new Date());
        role.setUpdateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getNickname());
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    public Integer deleteRole(Integer[] ids) {
        return roleMapper.deleteRole(ids);
    }
}
