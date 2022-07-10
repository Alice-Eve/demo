package com.example.demo.service;

import com.example.demo.mapper.OplogMapper;
import com.example.demo.model.Oplog;
import com.example.demo.model.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OplogService {
    @Autowired
    OplogMapper oplogMapper;

    public PageBean getOplogPage(Integer page, Integer size, String keywords) {
        if (page != null && size != null) {
            page = (page-1) * size;
        }
        List<Oplog> data = oplogMapper.getOplogPage(page,size,keywords);
        Long total = oplogMapper.getTotal(keywords);
        PageBean bean = new PageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer deleteOplog(Integer[] ids) {
        return oplogMapper.deleteOplog(ids);
    }

    public void save(Oplog oplog) {
        oplogMapper.insert(oplog);
    }
}
