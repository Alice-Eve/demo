package com.example.demo.service;

import com.example.demo.mapper.SysMenuRoleMapper;
import com.example.demo.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermService {
    @Autowired
    SysUserRoleMapper userRoleMapper;
    @Autowired
    SysMenuRoleMapper menuRoleMapper;

    public List<Integer> selectPermByUid(Integer uid) {
        return userRoleMapper.selectPermByUid(uid);
    }

    public List<Integer> selectPermByRid(Integer rid) {
        return menuRoleMapper.selectPermByRid(rid);
    }

    public boolean upPermRole(Integer uid, Integer[] rids) {
        if (userRoleMapper.selectPermByUid(uid).size() != 0) {
            userRoleMapper.deleteByUid(uid);
        }
        if (uid == null || rids.length == 0) {
            return true;
        }
        Integer result = userRoleMapper.insertRecord(uid,rids);
        return result == rids.length;
    }

    public boolean upPermMenu(Integer rid, Integer[] mids) {
        if (menuRoleMapper.selectPermByRid(rid).size() != 0) {
            menuRoleMapper.deleteByRid(rid);
        }
        if (rid == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        return result == mids.length;
    }
}
