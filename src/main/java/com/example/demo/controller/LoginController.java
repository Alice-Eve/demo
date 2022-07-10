package com.example.demo.controller;

import com.example.demo.config.VerificationCode;
import com.example.demo.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.success("尚未登录!");
    }

    @GetMapping("/code")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode Code = new VerificationCode();
        BufferedImage image = Code.getImage();
        String text = Code.getText();
        session.setAttribute("code",text);
        VerificationCode.output(image, resp.getOutputStream());
    }
}
