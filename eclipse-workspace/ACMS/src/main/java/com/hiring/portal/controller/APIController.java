package com.hiring.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hiring.portal.model.Login;
import com.hiring.portal.model.Student;
import com.hiring.portal.model.UserHistoryWrapper;
import com.hiring.portal.service.ImlAPIService;

@RestController
@RequestMapping(value = "/api")
public class APIController {
	@Autowired
	private ImlAPIService imlapiservice;
	
	@PostMapping("/register")
	public ResponseEntity<Void> doRegistration(@Valid @RequestBody Student std, UriComponentsBuilder builder) {
		boolean flag = imlapiservice.doRegister(std);
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> doLogin(@Valid @RequestBody Login lg, UriComponentsBuilder builder) {
		System.out.println("username::" + lg.getUsername());
		System.out.println("password::" + lg.getPassword());
		boolean flag = imlapiservice.doLogin(lg.getUsername(), lg.getPassword());
		if (flag == true) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	@GetMapping("/getuserdetails/{semail}")
	public ResponseEntity<List<Student>> getuserdetails(@PathVariable(value = "semail") String semail) {
		List<Student> list = imlapiservice.getuserdetails(semail);
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	@GetMapping("/gettesthistory/{email}")
	public ResponseEntity<List<UserHistoryWrapper>> getTestHistory(@PathVariable(value = "email") String email){
		List<UserHistoryWrapper> list = imlapiservice.getTestHistory(email);
		return new ResponseEntity<List<UserHistoryWrapper>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/email/{username}")
	public String getSid(@PathVariable(value = "username") String username){
		return imlapiservice.getSid(username);
	}
	
	@GetMapping("/getTests/{semail}")
	public List<Test> getSelectedTest(@PathVariable(value = "semail") String semail) {
		return (List<Test>) imlapiservice.getTests(semail);
	}
	
	@PostMapping("/checktesttaken")
	public ResponseEntity<Void> checkTestTaken(@Valid @RequestBody UserHistoryWrapper userHistoryWrapper, UriComponentsBuilder builder){
		boolean flag = imlapiservice.checkTestTaken(userHistoryWrapper);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	
	}
	
	
}
