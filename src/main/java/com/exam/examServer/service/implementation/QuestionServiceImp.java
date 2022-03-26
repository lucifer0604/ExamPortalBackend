package com.exam.examServer.service.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.modals.exam.Question;
import com.exam.examServer.modals.exam.Quiz;
import com.exam.examServer.repository.QuestionRepository;
import com.exam.examServer.service.QuestionService;

@Service
public class QuestionServiceImp implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question getQuestion(Long quesId) {
		
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<Question>(this.questionRepository.findAll());
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long id) {
		
		Question question=new Question();
		question.setQuesId(id);
		this.questionRepository.delete(question);
		
	}

}
