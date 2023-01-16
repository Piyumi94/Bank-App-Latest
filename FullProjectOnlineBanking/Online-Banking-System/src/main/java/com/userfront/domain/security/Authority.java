package com.userfront.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Granting "permission" or a "right" to users
 * 
 * @author Piyumi
 *
 */
public class Authority implements GrantedAuthority {

	private final String authority;

	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}
}
