package com.example.demo.mapper;

import com.example.demo.model.Oplog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OplogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Oplog record);

    int insertSelective(Oplog record);

    Oplog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Oplog record);

    int updateByPrimaryKeyWithBLOBs(Oplog record);

    int updateByPrimaryKey(Oplog record);

    Long getTotal(@Param("keywords") String keywords);

    List<Oplog> getOplogPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keywords") String keywords);

    Integer deleteOplog(@Param("ids") Integer[] ids);
}