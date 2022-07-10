package com.example.demo.config.handler;

import com.example.demo.model.RespBean;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        //返回json数据
        RespBean respBean = RespBean.error(exception.getMessage());
        if (exception instanceof AccountExpiredException) {
            //账号过期
            respBean.setMsg("账号已过期");
        } else if (exception instanceof BadCredentialsException) {
            //密码错误
            respBean.setMsg("密码错误");
        } else if (exception instanceof CredentialsExpiredException) {
            //密码过期
            respBean.setMsg("密码过期");
        } else if (exception instanceof DisabledException) {
            //账号不可用
            respBean.setMsg("账号不可用");
        } else if (exception instanceof LockedException) {
            //账号锁定
            respBean.setMsg("账号锁定");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            //用户不存在
            respBean.setMsg("用户不存在");
        }else if (exception instanceof AuthenticationServiceException){
            respBean.setMsg("验证码不正确");
        } else {
            //其他错误
            respBean.setMsg("请求失败");
        }
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
