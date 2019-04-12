package com.hiring.portal.service;

import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiring.portal.dao.APIDao;
import com.hiring.portal.model.Student;
import com.hiring.portal.model.UserHistoryWrapper;

@Service
public class ImlAPIService implements APIService{

	@Autowired
	private APIDao apidao;

	@Override
	public String getSid(String username) {
		return apidao.getSid(username);
	}

	@Override
	public List<Test> getTests(String semail) {
		return apidao.getTests(semail);
	}

	@Override
	public List<UserHistoryWrapper> getTestHistory(String email) {
		return apidao.getTestHistory(email);
	}

	@Override
	public List<Student> getuserdetails(String email) {
		return apidao.getuserdetails(email);
	}
	
	@Override
	public boolean checkTestTaken(UserHistoryWrapper userHistoryWrapper) {
		return apidao.checkTestTaken(userHistoryWrapper);
	}

}
