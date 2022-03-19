package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.modals.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
