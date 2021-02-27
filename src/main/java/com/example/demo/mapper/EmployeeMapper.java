package com.example.demo.mapper;

import com.example.demo.bean.Employee;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(String keyword);

    Integer maxWorkID();

    Integer addEmps(@org.apache.ibatis.annotations.Param("list") List<Employee> list);
}