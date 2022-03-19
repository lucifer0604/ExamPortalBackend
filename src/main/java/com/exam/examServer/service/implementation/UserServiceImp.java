package com.exam.examServer.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.examServer.modals.User;
import com.exam.examServer.modals.UserRole;
import com.exam.examServer.repository.RoleRepository;
import com.exam.examServer.repository.UserRepository;
import com.exam.examServer.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {
		User local= userRepository.findByUsername(user.getUsername());
		if(local !=null)
		{
			throw new Exception("User Already exist");
		}
		else
		{
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
			String password=user.getPassword();
			user.setPassword(passwordEncoder.encode(password));
			for(UserRole ur:userRole)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRole);
			local=userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User updateUser(User user, Set<UserRole> userRole) throws Exception {
		for(UserRole ur:userRole)
		{
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRole);
		User local=userRepository.save(user);
		
		return local;
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
		
	}
	

}
