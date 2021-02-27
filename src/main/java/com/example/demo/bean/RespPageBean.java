package com.example.demo.bean;

import lombok.Data;

import java.util.List;

/**
 * @作者 lei
 * @公众号
 * @微信号 null_bt
 * @GitHub https://github.com/Alice-Eve
 * @博客 http://
 * @网站 http://
 * @时间 2021-02-16 20:02
 **/
@Data
public class RespPageBean {
    private Long total;
    private List<?> data;
}