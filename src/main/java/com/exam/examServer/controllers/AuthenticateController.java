package com.exam.examServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.config.JwtUtil;
import com.exam.examServer.modals.JwtRequest;
import com.exam.examServer.modals.JwtResponse;
import com.exam.examServer.service.implementation.UserDetailsServiceImp;

@RestController
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		
		try {
			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("user not found");
		}
		UserDetails userDetails=userDetailsServiceImp.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username,String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			throw new Exception("User is disabled "+ e.getMessage());
		}catch (BadCredentialsException e) {
			throw new Exception("password is not correct "+ e.getMessage());
		}
	}

}
