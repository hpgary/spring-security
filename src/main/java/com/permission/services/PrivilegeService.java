package com.permission.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.permission.mapper.PrivilegeMapper;
import com.permission.model.Privilege;

/**
 * Created by Administrator on 2017/3/9.
 */
@Service
public class PrivilegeService {
    @Autowired
    private PrivilegeMapper privilegeMapper;
    public List<Privilege> findPrivilegeByUserId(Integer id){
        return privilegeMapper.findPrivilegeByUserId(id);
    }
    public List<Privilege> findPrivilegeByUrl(String url){
        return privilegeMapper.findPrivilegeByUrl(url);
    }
}
