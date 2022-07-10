package com.example.demo.service;

import com.example.demo.mapper.SysMenuMapper;
import com.example.demo.model.SysMenu;
import com.example.demo.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    SysMenuMapper menuMapper;

    public List<SysMenu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    public List<SysMenu> getMenusByUserId() {
        List<SysMenu> menus = menuMapper.getMenusByUserId(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        List<SysMenu> menusByUserId= menuMapper.getMenusByUserId2(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        menus.addAll(menusByUserId);
        return  menus;
    }

    public Integer addMenu(SysMenu menu) {
        menu.setCreateTime(new Date());
        menu.setCreateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return menuMapper.insertSelective(menu);
    }

    public Integer deleteMenus(Integer[] ids) {
        return menuMapper.deleteMenus(ids);
    }

    public List<SysMenu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public Integer upMenu(SysMenu menu) {
        menu.setUpdateTime(new Date());
        menu.setUpdateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return menuMapper.updateByPrimaryKeySelective(menu);
    }
}
