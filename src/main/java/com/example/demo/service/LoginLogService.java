package com.example.demo.service;

import com.example.demo.mapper.LoginLogMapper;
import com.example.demo.model.LoginLog;
import com.example.demo.model.PageBean;
import com.example.demo.model.SysUser;
import com.example.demo.utils.IpUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service
public class LoginLogService {
    @Autowired
    LoginLogMapper loginLogMapper;

    public PageBean getLoginLogByPage(Integer page, Integer size, String keywords) {
        if (page != null && size != null) {
            page = (page-1) * size;
        }
        List<LoginLog> data = loginLogMapper.getLoginLogByPage(page,size,keywords);
        Long total = loginLogMapper.getTotal(keywords);
        PageBean bean = new PageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    @Transactional(rollbackFor = Exception.class)
    public void setLoginLog(HttpServletRequest request,SysUser user) {
        String ipAddress = IpUtil.getIpAddress(request);
        String ipSource = IpUtil.getIpSource(ipAddress);
        UserAgent userAgent = IpUtil.getUserAgent(request);
        LoginLog loginLog = new LoginLog();
        loginLog.setIpAddress(ipAddress);
        loginLog.setIpSource(ipSource);
        loginLog.setUsername(user.getUsername());
        loginLog.setNickname(user.getNickname());
        loginLog.setBrowser(userAgent.getBrowser().getName());
        loginLog.setOs(userAgent.getOperatingSystem().getName());
        loginLog.setState("1");
        loginLog.setRemark("登录成功");
        loginLog.setLoginTime(new Date());
        loginLogMapper.insert(loginLog);
    }

    public Integer deleteLoginLog(Integer[] ids) {
        return loginLogMapper.deleteLoginLog(ids);
    }
}
