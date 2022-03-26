package com.exam.examServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examServer.modals.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
