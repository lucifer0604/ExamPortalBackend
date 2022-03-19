package com.exam.examServer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examServer.modals.User;
import com.exam.examServer.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=this.userRepository.findByUsername(username);
		if(user==null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("No user Found !!");
		}
		return user;
	}

}
