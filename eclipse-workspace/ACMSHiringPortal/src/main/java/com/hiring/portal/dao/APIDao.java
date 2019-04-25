package com.hiring.portal.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hiring.portal.model.Category;
import com.hiring.portal.model.Coordinator;
import com.hiring.portal.model.Question;
import com.hiring.portal.model.Student;
import com.hiring.portal.model.Test;
import com.hiring.portal.model.TestCoordinator;
import com.hiring.portal.model.TestHistoryWrapper;
import com.hiring.portal.model.TestQuestion;
import com.hiring.portal.model.TestUser;
import com.hiring.portal.model.TestWrapper;
import com.hiring.portal.model.Values;

@Transactional
@Repository
public class APIDao implements IAPIDao {
	@PersistenceContext
	private EntityManager entityManager;
	private PassEncryption ps = new PassEncryption("bhavisjbfweauioe");

	@Override
	public void doRegister(Coordinator cord) {
//		try {
//			String enpass = ps.encrypt(std.getPassword());
//			std.setPassword(ps.encrypt(std.getPassword()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		entityManager.persist(std);
		
		entityManager.persist(cord);
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getCordID(String username) {
		String userNum = "Select cord.cid FROM Coordinator as cord WHERE cord.username = ?1";
		List<Long> userID = (List<Long>) entityManager.createQuery(userNum).setParameter(1, username).getResultList();
		Long userVal = userID.get(0);
		return userVal;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Coordinator> getCordDetails(Long cordid) {
		String hql = "FROM com.hiring.portal.model.Coordinator as cord WHERE cord.cid = ?1";
		return (List<Coordinator>) entityManager.createQuery(hql).setParameter(1, cordid).getResultList();
	}

	@Override
	public boolean registerExists(String username, String email) {
		String hql = "FROM com.hiring.portal.model.Student as std WHERE std.username = ?1 or std.email = ?2";

		int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2, email).getResultList()
				.size();

		System.out.println("count:" + count);
		return count > 0 ? true : false;
	}

	@Override
	public boolean loginExists(String username, String password) {
		// String aespass;
		try {
			// aespass = ps.encrypt(password);
			String hql = "FROM com.hiring.portal.model.Coordinator as cord WHERE cord.username = ?1 and cord.password = ?2";
//			int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2, aespass)
//					.getResultList().size();

			int count = entityManager.createQuery(hql).setParameter(1, username).setParameter(2, password)
					.getResultList().size();
			System.out.println("count" + count);
			return count > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean questionExists(String question) {
		String hql = "FROM com.hiring.portal.model.Question as qmcq WHERE qmcq.question = ?1";

		int count = entityManager.createQuery(hql).setParameter(1, question).getResultList().size();

		System.out.println("count:" + count);
		return count > 0 ? true : false;
	}

	@Override
	public boolean categoryExists(String category) {
		String hql = "FROM com.hiring.portal.model.Category as c WHERE c.categoryname = ?1";
		int count = entityManager.createQuery(hql).setParameter(1, category).getResultList().size();
		System.out.println("count:" + count);
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllMCQQuestions(String level) {
		String hql = "FROM Question as qmcq where qmcq.type = ?1 AND qmcq.level = ?2";
		return (List<Question>) entityManager.createQuery(hql).setParameter(1, "mcq").setParameter(2, level)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllCodeQuestions(String level) {
		String hql = "FROM Question as qmcq where qmcq.type = ?1 AND qmcq.level = ?2";
		return (List<Question>) entityManager.createQuery(hql).setParameter(1, "code").setParameter(2, level)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getAllMCQCatQuestionsWithLevel(String categoryWithLevel) {
		String[] temp = categoryWithLevel.split("_");
		String category = temp[0];
		String level = temp[1];
		String catNum = "Select cat.cid FROM Category as cat WHERE cat.categoryname = ?1";
		List<Long> catID = (List<Long>) entityManager.createQuery(catNum).setParameter(1, category).getResultList();
		Long cat = catID.get(0);
		System.out.println("cat::" + cat);
		String hql = "FROM Question as qmcq where qmcq.cid = ?1 AND qmcq.level = ?2";
		return (List<Question>) entityManager.createQuery(hql).setParameter(1, cat).setParameter(2, level)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllMCQCategories() {
		String hql = "FROM Category as cat where cat.type = 'mcq'";
		return (List<Category>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCodeCategories() {
		String hql = "FROM Category as cat where cat.type = 'code'";
		return (List<Category>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getCategoryID(String category) {
		String catNum = "Select cat.cid FROM Category as cat WHERE cat.categoryname = ?1";
		List<Long> catID = (List<Long>) entityManager.createQuery(catNum).setParameter(1, category).getResultList();
		// Long catID = Long.parseLong(catNum);
		Long cat = catID.get(0);
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getCategoryIDWithLevel(String categoryWithLevel) {
		String[] res = categoryWithLevel.split("_");
		String category = res[0];
		String level = res[1];
		String catNum = "Select cat.cid FROM Category as cat WHERE cat.categoryname = ?1 AND cat.level = ?2";
		List<Long> catID = (List<Long>) entityManager.createQuery(catNum).setParameter(1, category)
				.setParameter(2, level).getResultList();
		// Long catID = Long.parseLong(catNum);
		Long cat = catID.get(0);
		return cat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long getTestID(String test) {
		String testNum = "Select test.tid FROM Test as test WHERE test.tname = ?1";
		List<Long> testID = (List<Long>) entityManager.createQuery(testNum).setParameter(1, test).getResultList();

		Long testVal = testID.get(0);
		return testVal;
	}

	// Finding Maximum for Unique Value
	public Long findMax() {
		String hql = "SELECT MAX(q.qid) FROM com.hiring.portal.model.Question as q";
		List<Long> temp = entityManager.createQuery(hql).getResultList();
		return temp.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllStudents() {
		String hql = "Select stu.username FROM Student as stu";
		String emailHql = "Select stu.email FROM Student as stu";
		Values.emailList = (List<String>) entityManager.createQuery(emailHql).getResultList();
		return (List<String>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllOrganizations() {
		String hql = "Select distinct(stu.organization) FROM Student as stu";
		return (List<String>) entityManager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getEmailStudents(String org) {
		String hql = "FROM Student as stu where stu.organization=org";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addMCQQuestion(Question qmcq) {
		entityManager.persist(qmcq);
	}

	@Override
	public void addCategory(Category c) {
		entityManager.persist(c);
	}

	// Email Module
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllStudents(String organiz) {
		String hql = "Select stu.username FROM Student as stu where stu.organization=?1";
		String emailHql = "Select stu.email FROM Student as stu where stu.organization=?1";
		Values.emailList = (List<String>) entityManager.createQuery(emailHql).setParameter(1, organiz).getResultList();
		return (List<String>) entityManager.createQuery(hql).setParameter(1, organiz).getResultList();
	}

	// show Test
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Question> showTest() {
		Values.questionIdTemp = new ArrayList<Long>(Values.questionId);
		List<Question> temp;
		List<Question> rtemp = new ArrayList<Question>();
		for (int i = 0; i < Values.questionIdTemp.size(); i++) {
			String hql = "From Question as q where q.qid = ?1";
			temp = (List<Question>) entityManager.createQuery(hql).setParameter(1, Values.questionIdTemp.get(i))
					.getResultList();
			System.out.println(temp.get(0));
			rtemp.add(i, temp.get(0));
		}

		return rtemp;
	}

	// create Test
	@SuppressWarnings("unchecked")
	@Override
	public void createTest(Test test) {
		entityManager.persist(test);
		String testidhql = "SELECT MAX(test.tid) FROM com.hiring.portal.model.Test as test";
		List<Long> testID = entityManager.createQuery(testidhql).getResultList();
		Long tid = testID.get(0);

		Values.questionIdTemp = new ArrayList<Long>(Values.questionId);
		List<String> temp;
		for (int i = 0; i < Values.questionIdTemp.size(); i++) {
			String hql = "Select q.question from Question as q where q.qid = ?1";
			temp = entityManager.createQuery(hql).setParameter(1, Values.questionIdTemp.get(i)).getResultList();
			Values.questions.add(i, temp.get(0));
			TestQuestion testquestion = new TestQuestion();
			testquestion.setTid(tid);
			testquestion.setQid(Values.questionIdTemp.get(i));
			System.out.println("inside the method:::::" + i);
			entityManager.persist(testquestion);
		}
	}

	@Override
	public boolean testExists(String tname) {
		String hql = "FROM com.hiring.portal.model.Test as test WHERE test.tname = ?1";

		int count = entityManager.createQuery(hql).setParameter(1, tname).getResultList().size();

		System.out.println("count:" + count);
		return count > 0 ? true : false;
	}

	// show all tests
	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getAllTests() {
		String hql = "FROM Test as test";
		return (List<Test>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public List<TestHistoryWrapper> getTestHistory(Long cordid) {
		String hql = "FROM TestCoordinator as tcord where tcord.cordid = ?1";
		@SuppressWarnings("unchecked")
		List<TestCoordinator> temp = (List<TestCoordinator>) entityManager.createQuery(hql).setParameter(1, cordid)
				.getResultList();
		List<TestHistoryWrapper> testHistoryWrapper = new ArrayList<TestHistoryWrapper>(temp.size());
		for (int i = 0; i < temp.size(); i++) {
			System.out.println("values:::::" + temp.get(i).getSdate());
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDateTemp = new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date currentDate = null;
		try {
			currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDateTemp);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (temp.size() != 0) {
			for (int i = 0; i < temp.size(); i++) {
				String testNameQuery = "select test.tname FROM Test as test where test.tid = ?1";
				String tname = entityManager.createQuery(testNameQuery).setParameter(1, temp.get(i).getTid())
						.getSingleResult().toString();
				TestHistoryWrapper obj = new TestHistoryWrapper();
				obj.setTname(tname);
				obj.setStartdate(temp.get(i).getSdate());
				obj.setEnddate(temp.get(i).getEdate());
				obj.setTid(temp.get(i).getTid());

				String endTime[] = temp.get(i).getEdate().split("T");
				String startTime[] = temp.get(i).getSdate().split("T");
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				Date date1 = null;
				Date date2 = null;

				Date startDate = null;
				Date endDate = null;
				try {
					date1 = format.parse(startTime[1]);
					date2 = format.parse(endTime[1]);
					startDate = dateFormat.parse(startTime[0]);
					endDate = dateFormat.parse(endTime[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (currentDate.compareTo(endDate) > 0) {
					System.out.println("Past Tests::" + currentDate + ":::" + endDate + "::" + obj.getTname());
					obj.setCordFlag(0);
				} else if (currentDate.compareTo(endDate) < 0) {
					System.out.println("Future Tests ::" + currentDate + ":::" + endDate + "::" + obj.getTname());
					obj.setCordFlag(2);
				} else {
					Date currentTime = new Date();
					DateFormat currentTimeFormat = new SimpleDateFormat("HH:mm");
					String c = format.format(currentTime);
					DateFormat sdf = new SimpleDateFormat("HH:mm");
					Date current = null;
					try {
						current = sdf.parse(c);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (current.getTime() > date2.getTime()) {
						System.out.println(
								"Past Time::" + current.getTime() + ":::" + date2.getTime() + "::" + obj.getTname());
						obj.setCordFlag(0);
					} else if (current.getTime() < date1.getTime()) {
						System.out.println(
								"Future Time::" + current.getTime() + ":::" + date1.getTime() + "::" + obj.getTname());
						obj.setCordFlag(2);
					} else {
						System.out.println("Current Time::" + current.getTime() + ":::" + date2.getTime() + "::"
								+ date1.getTime() + "::" + obj.getTname());
						obj.setCordFlag(1);
					}
				}
				testHistoryWrapper.add(obj);
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			System.out.println("Display Value::" + testHistoryWrapper.get(i).getTname());
		}
		return testHistoryWrapper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllUsersWithTest(Long testid) {
		String usersOfTest = "select user.email FROM TestUser as user where user.tid=?1";
		return (List<String>) entityManager.createQuery(usersOfTest).setParameter(1, testid).getResultList();
	}

	// User Mapping
	@Override
	public void userCordMap(TestWrapper testwrapper) {

		TestCoordinator testcoordinator = new TestCoordinator();
		testcoordinator.setCordid(testwrapper.getCordid());
		testcoordinator.setTid(testwrapper.getTid());
		testcoordinator.setSdate(testwrapper.getTdate());

		// Time conversion
		String timeArray[] = testwrapper.getTdate().split("T");
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		Date d = null;
		try {
			d = df.parse(timeArray[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, Integer.parseInt(testwrapper.getTtimer()));
		String newTime = df.format(cal.getTime());
		newTime = timeArray[0].concat("T" + newTime);
		testcoordinator.setEdate(newTime);

		entityManager.persist(testcoordinator);

		for (int i = 0; i < Values.emailList.size(); i++) {
			TestUser testuser = new TestUser();
			testuser.setTid(testwrapper.getTid());
			testuser.setCordid(testwrapper.getCordid());
			testuser.setEmail(Values.emailList.get(i));
			testuser.setStartdate(testwrapper.getTdate());
			testuser.setEnddate(newTime);
			testuser.setTesttaken('N');
			entityManager.persist(testuser);
		}

		if (Values.emailCustomList != null) {
			for (int i = 0; i < Values.emailCustomList.length; i++) {
				TestUser testuser = new TestUser();
				testuser.setTid(testwrapper.getTid());
				testuser.setCordid(testwrapper.getCordid());
				testuser.setEmail(Values.emailCustomList[i]);
				testuser.setStartdate(testwrapper.getTdate());
				testuser.setEnddate(newTime);
				testuser.setTesttaken('N');
				entityManager.persist(testuser);
			}
		}
	}
	
	public Integer countAllStudents() {
		String hql = "FROM Student as std";
		Integer count = entityManager.createQuery(hql).getResultList().size();
		return count;
	 }
}
