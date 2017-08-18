package com.permission.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.permission.model.Privilege;
import com.permission.services.PrivilegeService;

/**
 * 获取当前url需要的权限
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private PrivilegeService privilegeService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String url = ((FilterInvocation) object).getRequestUrl();
        Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        //截取得到url
        int firstQuestionMarkIndex = url.indexOf("?");
        if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
        List<Privilege> urlPrivileges = privilegeService.findPrivilegeByUrl(url);
        //将我们查询的权限加入configAttributes
        if(urlPrivileges.size()>0){
            for (Privilege p:urlPrivileges){
                ConfigAttribute ca = new SecurityConfig(String.valueOf(p.getId()));
                configAttributes.add(ca);
            }
            return configAttributes;
        }else {
            return null;
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
