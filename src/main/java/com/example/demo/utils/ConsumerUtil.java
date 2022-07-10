package com.example.demo.utils;

import com.example.demo.model.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class ConsumerUtil {
    /**
     * 获取当前登陆用户信息
     * @return 用户信息
     */
    public static SysUser getUserDetails() {
        return (SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
