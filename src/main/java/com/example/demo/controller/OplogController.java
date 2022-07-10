package com.example.demo.controller;

import com.example.demo.annotation.Log;
import com.example.demo.model.LogConst;
import com.example.demo.model.PageBean;
import com.example.demo.model.RespBean;
import com.example.demo.service.OplogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "操作日志")
@RestController
@RequestMapping("/log/oplog")
public class OplogController {
    @Autowired
    OplogService oplogService;

    @GetMapping("/")
    public PageBean getOplogPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keywords) {
        return oplogService.getOplogPage(page,size,keywords);
    }

    @Log(logType = LogConst.LOG_TYPE_DELETE)
    @ApiOperation(value = "删除操作日志")
    @DeleteMapping("/")
    public RespBean deleteOplog(Integer[] ids) {
        if (oplogService.deleteOplog(ids) == ids.length) {
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
