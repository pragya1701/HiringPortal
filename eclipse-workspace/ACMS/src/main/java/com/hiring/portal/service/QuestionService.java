package com.hiring.portal.service;

import java.util.List;

import com.hiring.portal.model.CodeQuestion;
import com.hiring.portal.model.McqQuestion;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.model.UserMarks;
import com.hiring.portal.model.UserResponse;

public interface QuestionService {
	
	Question getQues(Long id);
	
	List<Question> getAllQues();
	
	void addQues(Question q);
	
	void clearAllQues(); 
	
	void addToQuestionPaper(TestQuestion p);
	
	List<TestQuestion> getQuestionPaper();
	
	List<CodeQuestion> getCodeQuestion(Long testid);
	
	List<McqQuestion> getMcqQuestion(Long testid);
	
	void addUserResponse(UserResponse r);
	
	void generateSingleUserMarks(UserResponse r);
	
	public void calculateMyMarks(UserResponse r);
	
	void setMarks(Long rid, int m);
	
	UserMarks getSingleUserMarks(UserMarks m);
	
	List<UserMarks> getAllUsersReport(UserMarks m);
	
	}
