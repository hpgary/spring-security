package com.permission.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Administrator on 2017/3/9.
 */
public class MySecurityUser extends User {
	
	private static final long serialVersionUID = 6048276240800272974L;

	//继承了User类之后，多出了一个构造方法
    public MySecurityUser(String username, String password, boolean enabled,
                          boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                          Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
