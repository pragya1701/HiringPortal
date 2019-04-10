package com.hiring.portal.dao;

import java.util.List;
import com.hiring.portal.model.*;;
public interface IAPIDao {
	
	// Rgistration and Login
	void doRegister(Student std);
	Long getCordID(String username);
	List<Coordinator> getCordDetails(Long cordid);
	boolean registerExists(String username, String email);
    boolean loginExists(String username, String password);
  
    // Adding questions and categories
    void addMCQQuestion(Question qmcq);
	void addCategory(Category c);
	boolean questionExists(String question);
	boolean categoryExists(String categoty);
	
    //Show all questions and categories
    List<Question> getAllMCQQuestions(String level);
    List<Question> getAllCodeQuestions(String level);
    List<Question> getAllMCQCatQuestionsWithLevel(String categoryWithLevel);
	List<Category> getAllMCQCategories();
	List<Category> getAllCodeCategories();
	Long getCategoryID(String category);
	Long getCategoryIDWithLevel(String categoryWithLevel);
	
	Long getTestID(String test);
	Long findMax();
	
	//Email
	List<String> getAllStudents();
    List<String> getAllOrganizations();
	List<Student> getEmailStudents(String org);
	List<String> getAllStudents(String organization);
	
	//create Test
	List<Question> showTest();
	void createTest(Test test);
	boolean testExists(String tname);
	
	//get all tests
	List<Test> getAllTests();
	
	List<TestHistoryWrapper> getTestHistory(Long cordid);
	List<String> getAllUsersWithTest(Long testid);
	
	//User map
	void userCordMap(TestWrapper testwrapper);
	
} 