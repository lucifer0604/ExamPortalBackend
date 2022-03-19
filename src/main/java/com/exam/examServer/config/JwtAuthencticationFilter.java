package com.exam.examServer.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.examServer.service.implementation.UserDetailsServiceImp;

import io.jsonwebtoken.ExpiredJwtException;
@Component
public class JwtAuthencticationFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailsServiceImp userDetailsServiceImp;
	
	@Autowired
	JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader=request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		
		String jwtToken=null;
		String username=null;
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken=requestTokenHeader.substring(7);
			
			try {
				username=this.jwtUtil.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				System.out.println("Token Expierd");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Invalid token, not start with bearer string");
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails =this.userDetailsServiceImp.loadUserByUsername(username);
			
			if(this.jwtUtil.validateToken(jwtToken, userDetails))
			{
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		else
		{
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
		
	}

}
