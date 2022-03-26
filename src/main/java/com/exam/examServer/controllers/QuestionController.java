package com.exam.examServer.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.exam.examServer.modals.exam.Question;
import com.exam.examServer.modals.exam.Quiz;
import com.exam.examServer.service.QuestionService;
import com.exam.examServer.service.QuizService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuizService quizService;

	@PostMapping("/addquestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(questionService.addQuestion(question));
	}
	
	@PutMapping("/updatequestion")
	public Question updateQuestion(@RequestBody Question question)
	{
		return questionService.updateQuestion(question);
	}
	
	@GetMapping("/getquestion/{id}")
	public Question getQuestion(@PathVariable("id") Long id)
	{
		return questionService.getQuestion(id);
	}
	
	@GetMapping("/getquestions")
	public ResponseEntity<?> getquestion()
	{
		return ResponseEntity.ok(questionService.getQuestions());
	}
	@GetMapping("/getquestionsofQuiz/{id}")
	public ResponseEntity<?> getquestionOfQuiz(@PathVariable("id") Long id)
	{
		Quiz quiz=this.quizService.getQuiz(id);
		Set<Question> questions=quiz.getQuestions(); 
		List list=new ArrayList(questions);
		
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		
		Collections.shuffle(list);
		
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public void deletequestion(@PathVariable("id") Long id)
	{
		 this.questionService.deleteQuestion(id);
	}

}
