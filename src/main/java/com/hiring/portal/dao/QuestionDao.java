package com.hiring.portal.dao;

import java.util.List;

import com.hiring.portal.model.CodeQuestion;
import com.hiring.portal.model.McqQuestion;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.model.UserMarks;
import com.hiring.portal.model.UserResponse;

public interface QuestionDao {
	
	/* -- Creation and retrieval of questions -- */
	Question getQues(Long id);
	
	List<Question> getAllQues();
	
	void addQues(Question q);
	
	void clearAllQues(); 
	
	void addToQuestionPaper(TestQuestion p);
	
	List<TestQuestion> getQuestionPaper();
	
	List<CodeQuestion> getCodeQuestion(Long testid);
	
	List<McqQuestion> getMcqQuestion(Long testid);
	
	
	/* -- Saving and Evaluating User Response -- */
	void addUserResponse(UserResponse r);
	
	boolean checkresult(UserMarks m);
	
	List<UserResponse> getMyMCQResponse(UserResponse r);
	
	List<UserResponse> getMyCodeResponse(UserResponse r);
	
	void setMarks(Long rid, int m);
	
	void generateMyMarks(UserResponse r);
	
	UserMarks getMyReport(UserMarks m);
	
	List<UserMarks> getAllUsersReport(UserMarks m);
	
}
