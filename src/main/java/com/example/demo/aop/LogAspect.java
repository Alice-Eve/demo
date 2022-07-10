package com.example.demo.aop;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.Log;
import com.example.demo.model.Oplog;
import com.example.demo.service.OplogService;
import com.example.demo.utils.ConsumerUtil;
import com.example.demo.utils.IpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;


@Aspect
@Component
public class LogAspect {

    @Autowired
    OplogService oplogService;

    /**
     * 日志切入点
     */
    @Pointcut("@annotation(com.example.demo.annotation.Log)")
    public void logPointCut() {
    }

    @Transactional(rollbackFor = Exception.class)
    @AfterReturning(value = "logPointCut()", returning = "response")
    public void around(JoinPoint joinPoint, Object response) {

        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) Objects.requireNonNull(requestAttributes).resolveReference(RequestAttributes.REFERENCE_REQUEST);

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 获取操作
        Api api = (Api) signature.getDeclaringType().getAnnotation(Api.class);
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        Log log = method.getAnnotation(Log.class);
        // 获取类名
        String className = joinPoint.getTarget().getClass().getName();
        String name = method.getName();
        String methodName = className + "." + name;

        Oplog oplog = new Oplog();
        System.out.println(new Date());
        oplog.setOptTime(new Date());
        oplog.setResponseData(JSON.toJSONString(response));
        oplog.setOptIp(IpUtil.getIpAddress(request));
        oplog.setOptName(ConsumerUtil.getUserDetails().getNickname());
        oplog.setOptUrl(request.getRequestURI());
        oplog.setOptAddress(IpUtil.getIpSource(IpUtil.getIpAddress(request)));
        oplog.setRequestParam(getParameterToJson(joinPoint));
        oplog.setRequestType(Objects.requireNonNull(request).getMethod());
        oplog.setTitle(api.tags()[0]);
        oplog.setMethodUrl(methodName);
        oplog.setMethodName(apiOperation.value());
        oplog.setBusinessType(log.logType());
        oplogService.save(oplog);
    }
    /**
     * 获 取 参数（转换json格式）
     */
    public String getParameterToJson(JoinPoint point) {
        List<Object> argList = new ArrayList<>();
        //参数值
        Object[] argValues = point.getArgs();
        //参数名称
        String[] argNames = ((MethodSignature)point.getSignature()).getParameterNames();
        if(argValues != null){
            for (int i = 0; i < argValues.length; i++) {
                Map<String, Object> map = new HashMap<>();
                String key = argNames[i];
                map.put(key, argValues[i]);
                argList.add(map);
                map = null;
            }
        }
        if (argList.size() == 0) {
            return "";
        }
        return argList.size() == 1 ? JSON.toJSONString(argList.get(0)) : JSON.toJSONString(argList);
    }
}
