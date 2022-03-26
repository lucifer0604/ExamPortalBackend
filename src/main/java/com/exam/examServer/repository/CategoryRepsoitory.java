package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.modals.exam.Category;

public interface CategoryRepsoitory extends JpaRepository<Category, Long> {

}
