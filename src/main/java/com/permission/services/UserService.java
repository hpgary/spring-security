package com.permission.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.permission.mapper.SysUserMapper;
import com.permission.model.SysUser;


/**
 * Created by Administrator on 2017/2/24.
 */
@Service
public class UserService {
    @Autowired
    private SysUserMapper userMapper;
    
    public SysUser findByUserName(String username){
        return userMapper.findByUserName(username);
    }
}
