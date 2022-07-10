package com.example.demo.mapper;

import com.example.demo.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getAllMenusWithRole();

    List<SysMenu> getMenusByUserId(Integer id);

    Integer deleteMenus(@Param("ids") Integer[] ids);

    List<SysMenu> getAllMenus();

    List<SysMenu> getMenusByUserId2(Integer id);
}