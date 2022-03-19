package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.modals.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);


}
