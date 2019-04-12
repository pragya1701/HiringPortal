package com.hiring.portal.dao;

import java.util.List;

import org.aspectj.weaver.ast.Test;

import com.hiring.portal.model.Student;
import com.hiring.portal.model.UserHistoryWrapper;

public interface APIDao {
	List<Student> getuserdetails(String email);
	List<Test> getTests(String semail);
	List<UserHistoryWrapper> getTestHistory(String email);
	String getSid(String username);
	boolean checkTestTaken(UserHistoryWrapper userHistoryWrapper);
}
