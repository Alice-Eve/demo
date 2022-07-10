package com.example.demo.mapper;

import com.example.demo.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);

    List<Integer> selectPermByUid(Integer uid);

    void deleteByUid(Integer uid);

    Integer insertRecord(@Param("uid") Integer uid,@Param("rids") Integer[] rids);
}