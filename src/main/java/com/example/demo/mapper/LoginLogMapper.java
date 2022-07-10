package com.example.demo.mapper;

import com.example.demo.model.LoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);

    Long getTotal(@Param("keywords") String keywords);

    List<LoginLog> getLoginLogByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keywords") String keywords);

    Integer deleteLoginLog(@Param("ids") Integer[] ids);
}