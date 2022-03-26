package com.exam.examServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examServer.modals.exam.Quiz;
import com.exam.examServer.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;

	@PostMapping("/addquiz")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(quizService.addQuiz(quiz));
	}
	
	@PutMapping("/updatequiz")
	public Quiz updateQuiz(@RequestBody Quiz quiz)
	{
		return quizService.updateQuiz(quiz);
	}
	
	@GetMapping("getquiz/{id}")
	public Quiz getQuiz(@PathVariable("id") Long id)
	{
		return quizService.getQuiz(id);
	}
	
	@GetMapping("getquizzes")
	public ResponseEntity<?> getquizzes()
	{
		return ResponseEntity.ok(quizService.getQuizzes());
	}
	
	@DeleteMapping("deletequiz/{id}")
	public void deleteQuiz(@PathVariable("id") Long id)
	{
		 quizService.deleteQuiz(id);
	}
}
