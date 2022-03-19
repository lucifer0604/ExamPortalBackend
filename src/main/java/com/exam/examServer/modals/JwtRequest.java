package com.exam.examServer.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtRequest {
	
	private String username;
	private String password;
	

}
