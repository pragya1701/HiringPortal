package com.hiring.portal.service;

import java.util.List;

import org.aspectj.weaver.ast.Test;

import com.hiring.portal.model.Student;
import com.hiring.portal.model.UserHistoryWrapper;

public interface APIService {
	boolean doRegister(Student std);
	boolean doLogin(String username, String password);
	List<Test> getTests(String semail);
    List<UserHistoryWrapper> getTestHistory(String email);
    String getSid(String username);
    List<Student> getuserdetails(String email);
    boolean checkTestTaken(UserHistoryWrapper userHistoryWrapper);
}
