package com.example.demo.mapper;

import com.example.demo.model.SysRole;
import com.example.demo.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser loadUserByUsername(String username);

    List<SysRole> getUserRoleyId(Integer id);

    List<SysUser> getAllUser(@Param("keywords") String keywords);

    Integer deleteUsers(@Param("ids") Integer[] ids);
}