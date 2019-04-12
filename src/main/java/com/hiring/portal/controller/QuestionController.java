package com.hiring.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiring.portal.model.CodeQuestion;
import com.hiring.portal.model.McqQuestion;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.service.ImplQuestionService;

@RestController
public class QuestionController {

	@Autowired
	private ImplQuestionService questionService;
	
	@PostMapping("/addquestion")
	public void addQuestion(@RequestBody Question q ) {
		questionService.addQues(q);
	}
	
	@GetMapping(path="/getQuestion/{id}" , produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Question getQuestionTable(@PathVariable(value = "id") Long id) {
		Question q= questionService.getQues(id);
		System.out.println(q.getQuestion());
		return q;
	}
	
	@GetMapping(path="/getAll" )
	public Iterable<Question> getAllQuestion(){
		return questionService.getAllQues();
	}
	
	@GetMapping("/clear")
	public void clearQuestions() {
		questionService.clearAllQues();
	}
	
	@GetMapping("/getQuestionPaper")
	public Iterable<TestQuestion> getQuestionPaper() {
		return questionService.getQuestionPaper();
	}
	
	@GetMapping("/codeQuestion/{testid}")
	public Iterable<CodeQuestion> getCodeQuestion(@PathVariable(value = "testid") Long testid){
		System.out.println(testid);
		return questionService.getCodeQuestion(testid);
	}
	
	@GetMapping("/mcqQuestion/{testid}")
	public Iterable<McqQuestion> getMcqQuestion(@PathVariable(value = "testid") Long testid){
		System.out.println(testid);
		return questionService.getMcqQuestion(testid);
	}
	
	@PostMapping("/addQuestionPaper")
	public void addQuestionPaper(@RequestBody TestQuestion p) {
		questionService.addToQuestionPaper(p);
	}
	
	/*@GetMapping(path="/getMcqResponse/{id}" , produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Iterable<UserResponse> getMcqResponse(@PathVariable(value = "id") Long id) {
		return questionService.getMCQResponse(id);
	}*/
}
