package com.exam.examServer.service;

import java.util.Set;

import com.exam.examServer.modals.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Quiz getQuiz(Long qId);
	public Set<Quiz> getQuizzes();
	public void deleteQuiz(Long qid);
	
	

}
