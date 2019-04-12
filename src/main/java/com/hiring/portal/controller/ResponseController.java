package com.hiring.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiring.portal.executor.Handler;
import com.hiring.portal.model.CodeArea;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.UserMarks;
import com.hiring.portal.model.UserResponse;
import com.hiring.portal.service.ImplQuestionService;

@Controller
public class ResponseController {
	
	@Autowired
	private ImplQuestionService questionService;
	private Question q;
	
	@PostMapping(path = "/sampleCase/{id}" , produces = "application/json; charset=UTF-8")
	@ResponseBody
	public CodeArea getSampleOutput(@PathVariable(value="id") Long id , @RequestBody CodeArea c) {
		CodeArea x = new CodeArea();
		Handler h = new Handler();
		q = (questionService.getQues(id));
		x.setContent(c.getContent());
		h.getSample(x , q);
		return x;
		//return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/codeSubmit/{id}")
	public void storeFinalOutput(@PathVariable(value="id") Long id, @RequestBody UserResponse r) {
		r.setQuestionid(id);
		r.setType("code");
		questionService.addUserResponse(r);
	}
	
	@GetMapping(path="/getMcq/{id}" , produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Question getMcq(@PathVariable(value="id") Long id) {
		return questionService.getQues(id);
	}
	
	@PostMapping(path="/saveMcq/{id}")
	public void saveMcq(@PathVariable(value="id") Long id, @RequestBody UserResponse r) { 
		//System.out.println("in save mcq");
		r.setQuestionid(id);
		r.setType("mcq");
		questionService.addUserResponse(r);
	}
	
	@PostMapping(path="/generateMarks")
	public void generateSingleUserMarks(@RequestBody UserResponse r){
		questionService.generateSingleUserMarks(r);
	}
	
	@PostMapping(path="/getMyMarks", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public UserMarks getSingleUserMarks(@RequestBody UserMarks m) {
		return questionService.getSingleUserMarks(m);
	}
	
	@PostMapping(path="/getReport", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<UserMarks> getAllUsersReport(@RequestBody UserMarks m){
		return questionService.getAllUsersReport(m);
	}
	
	@GetMapping("/mcqtest")
	public String demo() {
		return "mcqtest";
	}
	
	@GetMapping("/coding")
	public String parent() {
		return "coding";
	}
	
	@GetMapping("/evaluate")
	public String end() {
		return "evaluate";
	}
	
	@GetMapping("/successsubmit")
	public String submit() {
		return "successsubmit";
	}
	
	@GetMapping("/userdashboard")
	public String userdashboard() {
		return "userdashboard";
	}
	
}
