package com.hiring.portal.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.hiring.portal.model.CodeQuestion;
import com.hiring.portal.model.McqQuestion;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.model.UserMarks;
import com.hiring.portal.model.UserResponse;


@Transactional
@Repository
public class ImplQuestionDao implements QuestionDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Question getQues(Long id) {
		String hql = "from Question as q where q.qid =?1";
		@SuppressWarnings("unchecked")
		List<Question> q = (List<Question>) entityManager.createQuery(hql).setParameter(1, id).getResultList();
		return q.get(0);
	}

	@Override
	public List<Question> getAllQues() {
		String hql = "from Question";
		@SuppressWarnings("unchecked")
		List<Question> resultList = (List<Question>) entityManager.createQuery(hql).getResultList();
		return resultList;
	}

	@Override
	public void addQues(Question q) {
		entityManager.persist(q);
	}

	@Override
	public void clearAllQues() {
		String hql = "delete from Question";
		entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addUserResponse(UserResponse r) {
		Long uid = r.getUserid();
		Long tid = r.getTestid();
		Long qid = r.getQuestionid();
		String hql = "from UserResponse where userid = ?1 and testid = ?2 and questionid = ?3";
		int count = entityManager.createQuery(hql).setParameter(1, uid).setParameter(2, tid).setParameter(3, qid).getResultList().size();
		if (count==0) {
		entityManager.persist(r);
		}
		else {
		hql = "update UserResponse set response=?1 where userid=?2 and testid=?3 and questionid = ?4";
		System.out.println("Marks: "+r.getMarks());
		entityManager.createQuery(hql).setParameter(1, r.getResponse()).setParameter(2, uid).setParameter(3, tid).setParameter(4, qid).executeUpdate();
		}
	}

	@Override
	public List<CodeQuestion> getCodeQuestion(Long testid) {
		String hql = "select q.qid, q.question, q.prototype from Question as q, TestQuestion as p "+ 
				"where q.qid = p.qid and q.type='code' and p.tid = ?1 ";
		TypedQuery<Object[]> query	= entityManager.createQuery(hql, Object[].class).setParameter(1, testid);
		List<Object[]> results = query.getResultList();
		List<CodeQuestion> c = new ArrayList<CodeQuestion>();
		  for (Object[] result : results) {
			  CodeQuestion ob = new CodeQuestion();
			  String s;
			  ob.setQuestionid((Long)result[0]);
			  s= (String) result[1];
			  ob.setQuestion(s);
			  s = (String) result[2];
			  ob.setPrototype(s);
			  c.add(ob);
		      //System.out.println("Question: " + result[0] + ", Prototype: " + result[1]);
		  }
		return c;
	}
	
	@Override
	public List<McqQuestion> getMcqQuestion(Long testid) {
		String hql = "select q.qid, q.question, q.option1, q.option2, q.option3, q.option4 from Question as q, TestQuestion as p "+ 
				"where q.qid = p.qid and q.type='mcq' and p.tid = ?1";
		TypedQuery<Object[]> query	= entityManager.createQuery(hql, Object[].class).setParameter(1, testid);
		List<Object[]> results = query.getResultList();
		List<McqQuestion> m = new ArrayList<McqQuestion>();
		  for (Object[] result : results) {
			  McqQuestion ob = new McqQuestion();
			  String s;
			  ob.setQuestionid((Long)result[0]);
			  s= (String) result[1];
			  ob.setQuestion(s);
			  s = (String) result[2];
			  ob.setOption1(s);
			  s = (String) result[3];
			  ob.setOption2(s);
			  s = (String) result[4];
			  ob.setOption3(s);
			  s = (String) result[5];
			  ob.setOption4(s);
			  m.add(ob);
		     // System.out.println("Question: " + result[0] + "\n1:" + result[1]);
		  }
		return m;
	}

	@Override
	public void addToQuestionPaper(TestQuestion p) {
		entityManager.persist(p);
		
	}

	@Override
	public List<TestQuestion> getQuestionPaper() {
		String hql = "from TestQuestion";
		@SuppressWarnings("unchecked")
		List<TestQuestion> resultList = (List<TestQuestion>) entityManager.createQuery(hql).getResultList();
		return resultList;
	}

	
	@Override
	public boolean checkresult(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		
		String hql = "from UserMarks where testid = ?1 and cordid=?2 and starttime=?3 and endtime=?4";
		int count = entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).getResultList().size();
		if(count==0) return false;
		else return true; 
	}
	
		
	@Override
	public List<UserResponse> getMyMCQResponse(UserResponse m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		Long u = m.getUserid();
		
		String hql = "from UserResponse as u where u.testid=?1 and u.cordid=?2 and u.starttime=?3 and u.endtime=?4 and u.userid=?5 and u.type='mcq'";
		@SuppressWarnings("unchecked")
		List<UserResponse> resultList =  (List<UserResponse>) entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).setParameter(5,u).getResultList();
		return resultList;
	}

	@Override
	public List<UserResponse> getMyCodeResponse(UserResponse m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		Long u = m.getUserid();
		
		String hql = "from UserResponse as u where u.testid=?1 and u.cordid=?2 and u.starttime=?3 and u.endtime=?4 and userid=?5 and u.type='code'";
		@SuppressWarnings("unchecked")
		List<UserResponse> resultList =  (List<UserResponse>) entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).setParameter(5,u).getResultList();
		return resultList;
	}

	@Override
	public void setMarks(Long rid, int m) {
		String hql = "update UserResponse set marks=?1 where rid=?2 ";
		entityManager.createQuery(hql).setParameter(1, m).setParameter(2, rid).executeUpdate();
	}
	
	@Override
	public void generateMyMarks(UserResponse m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		Long u = m.getUserid();
		String hql = "select s.email, u.marks from UserResponse u, Student s where userid=sid and testid = ?1 and cordid=?2 and starttime=?3 and endtime=?4 and userid=?5" ;
		TypedQuery<Object[]> query	= entityManager.createQuery(hql, Object[].class).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).setParameter(5, u);
		List<Object[]> results = query.getResultList();
		
		System.out.println("Tid: " + tid + "Cid: " + cid + "S: " + s + "E: " + e + "U: " + u);
		System.out.println(results.size());
		
		int score=0;
		String mail_id="";
		for(Object[] result : results)
		{
			score = score + (int)result[1];
			mail_id = (String)result[0];
		}
		
		System.out.println("score: "+score );
		UserMarks ob = new UserMarks();
		ob.setTestid(tid);
		ob.setCordid(cid);
		ob.setUserid(u);
		ob.setStarttime(s);
		ob.setEndtime(e);
		ob.setEmail(mail_id);
		ob.setTotalmarks(score);
		
		entityManager.persist(ob);
	}
	
	@Override
	public UserMarks getMyReport(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		Long u = m.getUserid();
		
		String hql = "from UserMarks as u where u.testid=?1 and u.cordid=?2 and u.starttime=?3 and u.endtime=?4 and userid=?5";
		@SuppressWarnings("unchecked")
		List<UserMarks> result =  (List<UserMarks>) entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).setParameter(5,u).getResultList();
		
		System.out.println("result" + result.get(0));
		
		return result.get(0);
	}
	
	@Override 
	public List<UserMarks> getAllUsersReport(UserMarks m){
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		String email = m.getEmail();
		
		System.out.println("Tid: " + tid + "Cid: "+cid+"start: "+s+"end: "+e+"email: "+email );
		
		String hql = "select email , totalmarks , (SELECT 1 + COUNT(totalmarks) from UserMarks u2 where u2.totalmarks > u1.totalmarks "+""
				+ "and testid =?1 and cordid=?2 and starttime=?3 and endtime=?4) as rank"+
				" from UserMarks u1 where testid =?1 and cordid=?2 and starttime=?3 and endtime=?4 order by rank";
		TypedQuery<Object[]> query	= entityManager.createQuery(hql, Object[].class).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e);
		List<Object[]> results = query.getResultList();
		
		List<UserMarks> marksList = new ArrayList<>();
		for(Object[] result : results) {
			UserMarks ob = new UserMarks();
			ob.setCordid(cid);
			ob.setTestid(tid);
			ob.setStarttime(s);
			ob.setEndtime(e);
			ob.setEmail(email);
			ob.setEmail((String) result[0]);
			ob.setTotalmarks((int) result[1]);
			ob.setRank((Long) result[2]);
			System.out.println("Email: "+email +"Rank:"+ ob.getRank());
			marksList.add(ob);
		}
		
		return marksList;
		
	}
	
	/* Evaluation module configured when user marks generation is initiated by admin
	 * instead of action on user submit
	
	@Override
	public void generateMarks(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		String hql = "select userid, sum(marks) from UserResponse where testid = ?1 and cordid=?2 and starttime=?3 and endtime=?4 group by userid order by sum(marks) desc" ;
		TypedQuery<Object[]> query	= entityManager.createQuery(hql, Object[].class).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e);
		List<Object[]> results = query.getResultList();
		for(Object[] result : results) {
			UserMarks ob = new UserMarks();
			ob.setTestid(tid);
			ob.setCordid(cid);
			ob.setStarttime(s);
			ob.setEndtime(e);
			ob.setUserid((Long) result[0]);
			ob.setTotalmarks((int) result[1]);
			entityManager.persist(ob);
		}
	}

	@Override
	public List<UserMarksWrapper> getTotalMarks(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		String hql = "select s.email, u1.totalmarks, (SELECT 1 + COUNT(totalmarks) from UserMarks u2 where u2.totalmarks > u1.totalmarks) as rank"+
		" from UserMarks u1, Student s where sid = userid and testid =?1 and cordid=?2 and starttime=?3 and endtime=?4 order by rank";
		TypedQuery<Object[]> query =  entityManager.createQuery(hql , Object[].class).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e);
		List<Object[]> results = query.getResultList();
		List<UserMarksWrapper> m1 = new ArrayList<>();
		for (Object[] result : results) {
			UserMarksWrapper ob = new UserMarksWrapper();
			ob.setEmail((String) result[0]);
			ob.setMarks((Long) result[1]);
			ob.setRank((Long) result[2]);
			m1.add(ob);
		}
		return m1;
	}
 
	 
	@Override
	public List<UserResponse> getMCQResponse(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
		
		String hql = "from UserResponse as u where u.testid=?1 and u.cordid=?2 and u.starttime=?3 and u.endtime=?4 and u.type='mcq'";
		@SuppressWarnings("unchecked")
		List<UserResponse> resultList =  (List<UserResponse>) entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).getResultList();
		return resultList;
	}

	@Override
	public List<UserResponse> getCodeResponse(UserMarks m) {
		Long tid = m.getTestid();
		Long cid = m.getCordid();
		String s = m.getStarttime();
		String e = m.getEndtime();
	
		String hql = "from UserResponse as u where u.testid=?1 and u.cordid=?2 and u.starttime=?3 and u.endtime=?4 and u.type='code'";
		@SuppressWarnings("unchecked")
		List<UserResponse> resultList =  (List<UserResponse>) entityManager.createQuery(hql).setParameter(1, tid).setParameter(2, cid).setParameter(3, s).setParameter(4, e).getResultList();
		return resultList;
	}

	*/


}
