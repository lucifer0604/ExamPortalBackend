package com.exam.examServer.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.modals.Role;
import com.exam.examServer.modals.User;
import com.exam.examServer.modals.UserRole;
import com.exam.examServer.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) throws Exception
	{
		Set<UserRole> userRoles=new HashSet<UserRole>();
		Role role=new Role();
		role.setId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoles.add(userRole);
		return this.userService.createUser(user, userRoles);
	}
	
	@GetMapping("/getuser/{username}")
	public User getuser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) throws Exception
	{
		Set<UserRole> userRoles=new HashSet<UserRole>();
		Role role=new Role();
		role.setId(45L);
		role.setRoleName("NORMAL");
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRoles.add(userRole);
		return this.userService.updateUser(user, userRoles);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id") Long id)
	{
		 this.userService.deleteUser(id);
	}

}
