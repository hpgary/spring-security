package com.permission.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 判断当前用户拥有的权限的id是否可以匹配url需要的权限
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    //如果没有猜错，configAttributes中保存的是url需要的权限的id
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if(configAttributes.size() == 0){
            return;
        }
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while(ite.hasNext()){
            ConfigAttribute ca = ite.next();
            String needRole = (ca).getAttribute();
            for (GrantedAuthority ga:authentication.getAuthorities()){
                if(needRole.equals(ga.getAuthority())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有权限,拒绝访问!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}