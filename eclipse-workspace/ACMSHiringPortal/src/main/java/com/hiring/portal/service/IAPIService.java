package com.hiring.portal.service;

import com.hiring.portal.model.*;
import java.util.List;

public interface IAPIService {
   
     boolean doRegister(Coordinator std);
     boolean doLogin(String username, String password);
     Long getCordID(String username);
     List<Coordinator> getCordDetails(Long cordid);
     
     List<Question> getAllMCQQuestions(String level);
     List<Category> getAllMCQCategories();
     List<Category> getAllCodeCategories();
  
     Long getCategoryID(String category);
     boolean addMCQQuestion(Question qmcq);
     boolean addCategory(Category c);
     Long getCategoryIDWithLevel(String categoryWithLevel);
     List<Question> getAllMCQCatQuestionsWithLevel(String category);
     List<Question> getAllCodeQuestions(String level);
     Long findMax();
     
     //For Email
     List<String> getAllStudents();
     List<String> getAllOrganizations();
     List<Student> getEmailStudents(String org);
     List<String> getAllStudents(String organization);
     
     //Create Test
     List<Question> showTest();
     boolean createTest(Test test);
     
     //get all tests
     List<Test> getAllTests();
     
     //user mapping
     void userCordMap(TestWrapper testwrapper);
     
     Long getTestID(String test);
     
     List<TestHistoryWrapper> getTestHistory(Long cordid);
     List<String> getAllUsersWithTest(Long testid);
     
     //logging
     Integer countAllStudents();
} 
