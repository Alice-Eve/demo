package com.example.demo.security;

import com.example.demo.bean.Hr;
import com.example.demo.bean.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Hr hr = (Hr) authentication.getPrincipal();
        hr.setPassword(null);
        out.write(new ObjectMapper().writeValueAsString(RespBean.ok("登陆成功", hr)));
        out.flush();
        out.close();
    }
}
