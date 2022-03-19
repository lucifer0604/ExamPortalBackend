package com.exam.examServer.modals;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Authority implements GrantedAuthority {
	private String authority;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
