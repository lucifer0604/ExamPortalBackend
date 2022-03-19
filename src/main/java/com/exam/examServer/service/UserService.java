package com.exam.examServer.service;

import java.util.Set;

import com.exam.examServer.modals.User;
import com.exam.examServer.modals.UserRole;

public interface UserService {
	
	
	public User createUser(User user,Set<UserRole> userRole) throws Exception;
	public User getUser(String username);
	
	public User updateUser(User user,Set<UserRole> userRole) throws Exception;
	
	public void deleteUser(Long  id);

}
