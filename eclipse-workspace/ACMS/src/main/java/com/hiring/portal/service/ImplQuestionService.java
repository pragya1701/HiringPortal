package com.hiring.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiring.portal.dao.QuestionDao;
import com.hiring.portal.executor.Handler;
import com.hiring.portal.model.CodeQuestion;
import com.hiring.portal.model.McqQuestion;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.model.UserMarks;
import com.hiring.portal.model.UserResponse;

@Service
public class ImplQuestionService implements QuestionService{

	@Autowired
	private QuestionDao qd;
	
	@Override
	public Question getQues(Long id) {
		return qd.getQues(id);
	}

	@Override
	public List<Question> getAllQues() {
		return qd.getAllQues();
	}

	@Override
	public void addQues(Question q) {
		qd.addQues(q);
	}

	@Override
	public void clearAllQues() {
		qd.clearAllQues();
	}

	@Override
	public void addUserResponse(UserResponse r) {
		qd.addUserResponse(r);
	}

	@Override
	public void addToQuestionPaper(TestQuestion p) {
		qd.addToQuestionPaper(p);
		
	}

	@Override
	public List<TestQuestion> getQuestionPaper() {
		return qd.getQuestionPaper();
	}

	@Override
	public List<CodeQuestion> getCodeQuestion(Long testid) {
		return qd.getCodeQuestion(testid);
	}

	@Override
	public List<McqQuestion> getMcqQuestion(Long testid) {
		return qd.getMcqQuestion(testid);
	}

	@Override
	public void setMarks(Long rid, int m) {
		qd.setMarks(rid, m);
	}
	
	@Override
	public UserMarks getSingleUserMarks(UserMarks m) {
		return qd.getMyReport(m);
	} 

	@Override
	public void generateSingleUserMarks(UserResponse r) {
		calculateMyMarks(r);
		qd.generateMyMarks(r);
	}
	
	@Override
	public void calculateMyMarks(UserResponse r) {
		Handler h = new Handler();
		//calculate MCQ marks
		List<UserResponse> results = qd.getMyMCQResponse(r);
		Question q = new Question();
		String l;
		int p=-1,marks=1;
		for(UserResponse result : results) {
			String s1 = result.getResponse();
			q = qd.getQues(result.getQuestionid());
			l = q.getLevel();
			String s2 = q.getAnswer();
			
			if(p==-1) {
				if(l.compareToIgnoreCase("easy")==0) {
					p=1;
				}
				else if(l.compareToIgnoreCase("medium")==0) {
					p = 2;
				}
				else {
					p = 3;
				}
			}
			
			if(s1.equals(s2)) {
				qd.setMarks(result.getRid() , (marks*p));
			}
		}

		//calculate Code marks
		List<UserResponse> res = qd.getMyCodeResponse(r);
		for(UserResponse rr : res) {
			System.out.println(rr.getResponse());
			String s = rr.getResponse();
			q =  qd.getQues(rr.getQuestionid());
			l = q.getLevel();
			if(p==-1) {
				if(l.compareToIgnoreCase("easy")==0) {
					p=1;
				}
				else if(l.compareToIgnoreCase("medium")==0) {
					p = 2;
				}
				else {
					p = 3;
				}
			}
			try {
				marks = h.TestCode(s,q);
				qd.setMarks(rr.getRid() , (marks*p));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<UserMarks> getAllUsersReport(UserMarks m){
		return qd.getAllUsersReport(m);
	}
	
	/*
	 * Service to calculate and get report of all users together

	public void generateMarks(UserMarks m) {
		if(qd.checkresult(m) == false) {
			calculateMarks(m);
			qd.generateMarks(m);
		}
	}
	
	public void calculateMarks(UserMarks m) {
		Handler h = new Handler();
		//calculate MCQ marks
		List<UserResponse> results = qd.getMCQResponse(m);
		Question q = new Question();
		String l;
		int p=-1,marks=1;
		for(UserResponse result : results) {
			String s1 = result.getResponse();
			q = qd.getQues(result.getQuestionid());
			l = q.getLevel();
			String s2 = q.getAnswer();
			
			if(p==-1) {
				if(l.compareToIgnoreCase("easy")==0) {
					p=1;
				}
				else if(l.compareToIgnoreCase("medium")==0) {
					p = 2;
				}
				else {
					p = 3;
				}
			}
			
			if(s1.equals(s2)) {
				qd.setMarks(result.getRid() , (marks*p));
			}
		}

		//calculate Code marks
		List<UserResponse> res = qd.getCodeResponse(m);
		for(UserResponse r : res) {
			System.out.println(r.getResponse());
			String s = r.getResponse();
			q =  qd.getQues(r.getQuestionid());
			l = q.getLevel();
			if(p==-1) {
				if(l.compareToIgnoreCase("easy")==0) {
					p=1;
				}
				else if(l.compareToIgnoreCase("medium")==0) {
					p = 2;
				}
				else {
					p = 3;
				}
			}
			try {
				marks = h.TestCode(s,q);
				qd.setMarks(r.getRid() , (marks*p));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	*/

} 
