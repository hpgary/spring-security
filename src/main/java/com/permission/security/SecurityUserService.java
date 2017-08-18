package com.permission.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.permission.model.Privilege;
import com.permission.model.SysUser;
import com.permission.services.PrivilegeService;
import com.permission.services.UserService;

/**
 * Created by Administrator on 2017/3/8.
 */
@Component
public class SecurityUserService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Autowired
	private PrivilegeService privilegeService;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		SysUser sysUser = userService.findByUserName(s);
		UserDetails userDetails = null;
		userDetails = new MySecurityUser(s, sysUser.getPassword(), true, true, true, true,
				findUserAuthorities(sysUser.getId()));
		return userDetails;
	}

	public Collection<GrantedAuthority> findUserAuthorities(Integer id) {
		List<GrantedAuthority> autthorities = new ArrayList<GrantedAuthority>();

		List<Privilege> privilegeList = this.privilegeService.findPrivilegeByUserId(id);

		if (privilegeList == null || privilegeList.size() == 0) {
			return autthorities;
		} else {
			for (Privilege p : privilegeList) {
				autthorities.add(new SimpleGrantedAuthority(String.valueOf(p.getId())));
			}
			return autthorities;
		}
	}
}
