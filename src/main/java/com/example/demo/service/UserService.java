package com.example.demo.service;

import com.example.demo.mapper.SysUserMapper;
import com.example.demo.mapper.SysUserRoleMapper;
import com.example.demo.model.SysUser;
import com.example.demo.utils.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    SysUserMapper userMapper;
    @Autowired
    SysUserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户
        SysUser user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(userMapper.getUserRoleyId(user.getId()));
        return user;
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveUser(HttpServletRequest request,SysUser user) {
        String ipAddress = IpUtil.getIpAddress(request);
        String ipSource = IpUtil.getIpSource(ipAddress);
        user.setLoginIp(ipAddress);
        user.setLoginAddress(ipSource);
        user.setLastLoginTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    public List<SysUser> getAllUser(String keywords) {
        return userMapper.getAllUser(keywords);
    }

    public Integer intUser(SysUser user) {
        user.setCredentialsNotExpired(true);
        user.setLoginType(true);
        user.setCreateTime(new Date());
        user.setUpdateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getNickname());
        return userMapper.insertSelective(user);
    }

    public Integer upUser(SysUser user) {
        user.setUpdateTime(new Date());
        user.setUpdateUser(((SysUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getNickname());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer deleteUsers(Integer[] ids) {
        return userMapper.deleteUsers(ids);
    }
}
