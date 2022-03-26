package com.exam.examServer.service;

import java.util.Set;

import com.exam.examServer.modals.exam.Question;
import com.exam.examServer.modals.exam.Quiz;

public interface QuestionService {
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Question getQuestion(Long quesId);
	public Set<Question> getQuestions();
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	public void deleteQuestion(Long id);
	

}
