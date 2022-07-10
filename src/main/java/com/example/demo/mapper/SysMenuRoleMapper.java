package com.example.demo.mapper;

import com.example.demo.model.SysMenuRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenuRole record);

    int insertSelective(SysMenuRole record);

    SysMenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenuRole record);

    int updateByPrimaryKey(SysMenuRole record);

    void deleteByRid(Integer rid);

    List<Integer> selectPermByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}