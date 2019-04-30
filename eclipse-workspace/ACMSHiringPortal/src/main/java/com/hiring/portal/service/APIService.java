package com.hiring.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hiring.portal.dao.*;
import com.hiring.portal.model.*;

@Service
public class APIService implements IAPIService {
	@Autowired
	private IAPIDao apiDao;

	@Override
	public synchronized boolean doRegister(Coordinator std) {

		apiDao.doRegister(std);
		System.out.println("Student is not there so added");
		return true;

	}

	@Override
	public synchronized boolean doLogin(String username, String password) {
		if (apiDao.loginExists(username, password)) {
			System.out.println("Student is already there");
			return true;

		} else {
			System.out.println("Username and password does not match");
			return false;
		}
	}

	@Override
	public Long getCordID(String username) {
		return apiDao.getCordID(username);
	}

	@Override
	public List<Coordinator> getCordDetails(Long cordid) {
		return apiDao.getCordDetails(cordid);
	}

	@Override
	public List<Question> getAllMCQQuestions(String level) {
		return apiDao.getAllMCQQuestions(level);
	}

	@Override
	public List<Category> getAllMCQCategories() {
		return apiDao.getAllMCQCategories();
	}

	@Override
	public List<Category> getAllCodeCategories() {
		return apiDao.getAllCodeCategories();
	}

	@Override
	public Long getCategoryID(String category) {
		return apiDao.getCategoryID(category);
	}

	@Override
	public synchronized boolean addMCQQuestion(Question qmcq) {
		if (apiDao.questionExists(qmcq.getQuestion())) {
			System.out.println("Question is already there");
			return false;

		} else {
			apiDao.addMCQQuestion(qmcq);
			System.out.println("Question is not there so added");
			return true;
		}
	}

	@Override
	public synchronized boolean addCategory(Category c) {
		if (apiDao.categoryExists(c)) {
			System.out.println("Category is already there");
			return false;

		} else {
			apiDao.addCategory(c);
			System.out.println("Category is not there so added");
			return true;
		}
	}

	@Override
	public Long getCategoryIDWithLevel(String categoryWithLevel) {
		return apiDao.getCategoryIDWithLevel(categoryWithLevel);
	}

	@Override
	public List<Question> getAllMCQCatQuestionsWithLevel(String category) {
		return apiDao.getAllMCQCatQuestionsWithLevel(category);
	}

	@Override
	public List<Question> getAllCodeQuestions(String level) {
		return apiDao.getAllCodeQuestions(level);
	}

	@Override
	public Long findMax() {
		return apiDao.findMax();
	}

	// Email
	@Override
	public List<String> getAllStudents() {
		// TODO Auto-generated method stub
		return apiDao.getAllStudents();
	}

	@Override
	public List<String> getAllOrganizations() {
		// TODO Auto-generated method stub
		return apiDao.getAllOrganizations();
	}

	@Override
	public List<Student> getEmailStudents(String org) {
		// TODO Auto-generated method stub
		return apiDao.getEmailStudents(org);
	}

	@Override
	public List<String> getAllStudents(String organization) {
		return apiDao.getAllStudents(organization);
	}

	// Show Test
	public List<Question> showTest() {
		return apiDao.showTest();
	}

	// Create Test
	public boolean createTest(Test test) {
		if (apiDao.testExists(test.getTname())) {
			System.out.println("Test name is already there");
			return false;

		} else {
			apiDao.createTest(test);
			System.out.println("Test is not there so added");
			return true;
		}

	}

	// get all tests
	@Override
	public List<Test> getAllTests() {
		return apiDao.getAllTests();
	}

	@Override
	public void userCordMap(TestWrapper testwrapper) {
		apiDao.userCordMap(testwrapper);
	}

	@Override
	public Long getTestID(String test) {
		return apiDao.getTestID(test);
	}

	@Override
	public List<TestHistoryWrapper> getTestHistory(Long cordid) {
		return apiDao.getTestHistory(cordid);
	}

	@Override
	public List<String> getAllUsersWithTest(Long testid) {
		return apiDao.getAllUsersWithTest(testid);
	}

	@Override
	public Integer countAllStudents() {
		return apiDao.countAllStudents();
	}
}
