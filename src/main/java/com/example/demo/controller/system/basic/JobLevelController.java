package com.example.demo.controller.system.basic;

import com.example.demo.bean.JobLevel;
import com.example.demo.bean.Position;
import com.example.demo.bean.RespBean;
import com.example.demo.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-01-29 18:18
 **/
@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevels(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevels(jobLevel) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}