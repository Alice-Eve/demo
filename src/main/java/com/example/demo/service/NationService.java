package com.example.demo.service;

import com.example.demo.bean.Nation;
import com.example.demo.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-02-17 22:33
 **/
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;
    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}