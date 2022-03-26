package com.exam.examServer.service.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examServer.modals.exam.Quiz;
import com.exam.examServer.repository.QuizRepository;
import com.exam.examServer.service.QuizService;

@Service
public class QuizServiceImp implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz getQuiz(Long qId) {
		
		return this.quizRepository.findById(qId).get();
	}

	@Override
	public Set<Quiz> getQuizzes() {
		
		return new HashSet<Quiz>(this.quizRepository.findAll());
	}

	@Override
	public void deleteQuiz(Long qid) {
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
		this.quizRepository.delete(quiz);

	}

}
