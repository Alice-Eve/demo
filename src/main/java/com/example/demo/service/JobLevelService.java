package com.example.demo.service;

import com.example.demo.bean.JobLevel;
import com.example.demo.mapper.JobLevelMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-01-29 18:20
 **/

@Service
public class JobLevelService {
    @Autowired
    JobLevelMapper JobLevelMapper;

    public List<JobLevel> getAllJobLevels() {
        return JobLevelMapper.getAllJobLevels();
    }

    public Integer addJobLevel(JobLevel JobLevel) {
        JobLevel.setEnabled(true);
        JobLevel.setCreateDate(new Date());
        return JobLevelMapper.insertSelective(JobLevel);
    }

    public Integer updateJobLevels(JobLevel JobLevel) {
        return JobLevelMapper.updateByPrimaryKeySelective(JobLevel);
    }

    public Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids) {
        return JobLevelMapper.deleteJobLevelsByIds(ids);
    }
}