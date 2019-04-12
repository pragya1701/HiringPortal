package com.hiring.portal.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.aspectj.weaver.ast.Test;
import org.springframework.stereotype.Repository;

import com.hiring.portal.model.Student;
import com.hiring.portal.model.TestUser;
import com.hiring.portal.model.UserHistoryWrapper;

@Transactional
@Repository
public class ImplAPIDao implements APIDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public String getSid(String username) {
		String hql = "Select stu.email FROM Student as stu where stu.username=?1";
		// System.out.println(hql);
		return (String) entityManager.createQuery(hql).setParameter(1, username).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getTests(String semail) {
		String hql = "FROM TestUser as tu WHERE tu.email = ?1";
		return (List<Test>) entityManager.createQuery(hql).setParameter(1, semail).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getuserdetails(String semail) {
		String hql = "FROM Student as tu WHERE tu.email = ?1";
		return (List<Student>) entityManager.createQuery(hql).setParameter(1, semail).getResultList();
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<UserHistoryWrapper> getTestHistory(String email) {

		String hql = "FROM TestUser as tu where tu.email = ?1";
		List<TestUser> temp = (List<TestUser>) entityManager.createQuery(hql).setParameter(1, email).getResultList();
		List<UserHistoryWrapper> userHistoryWrapper = new ArrayList<UserHistoryWrapper>(temp.size());

		if (temp.size() != 0) {
			for (int i = 0; i < temp.size(); i++) {
				String testNameQuery = "select test.tname FROM Test as test where test.tid = ?1";
				String tname = entityManager.createQuery(testNameQuery).setParameter(1, temp.get(i).getTid())
						.getSingleResult().toString();

				UserHistoryWrapper userHistoryObj = new UserHistoryWrapper();
				userHistoryObj.setTname(tname);
				userHistoryObj.setStartdate(temp.get(i).getStartdate());
				userHistoryObj.setEnddate(temp.get(i).getEnddate());
				userHistoryObj.setTid(temp.get(i).getTid());
				userHistoryObj.setCordid(temp.get(i).getCordid());

				// Timer Logic
				String endTime[] = temp.get(i).getEnddate().split("T");
				String startTime[] = temp.get(i).getStartdate().split("T");
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				Date date1 = null;
				Date date2 = null;
				try {
					date1 = format.parse(endTime[1]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					date2 = format.parse(startTime[1]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long timer = date2.getTime() - date1.getTime();

				userHistoryObj.setTimer(Long.toString(timer));
				userHistoryWrapper.add(userHistoryObj);
			}
		}
		for (int i = 0; i < temp.size(); i++) {
			System.out.println("Display Value::" + userHistoryWrapper.get(i).getTname());
		}
		return userHistoryWrapper;
	}

	@Override
	public boolean checkTestTaken(UserHistoryWrapper userHistoryWrapper) {
		String checktest = "select tu.testtaken FROM TestUser as tu where tu.tid = ?1 AND tu.startdate = ?2 AND tu.enddate = ?3 AND tu.cordid = ?4 AND tu.email = ?5";
		Character check = (Character) entityManager.createQuery(checktest).setParameter(1, userHistoryWrapper.getTid())
				.setParameter(2, userHistoryWrapper.getStartdate()).setParameter(3, userHistoryWrapper.getEnddate())
				.setParameter(4, userHistoryWrapper.getCordid()).setParameter(5, userHistoryWrapper.getEmail())
				.getSingleResult();

		if (check.equals('N')) {
			int count = (entityManager.createQuery(
					"update TestUser tu set tu.testtaken =?6 where tu.tid = ?1 AND tu.startdate = ?2 AND tu.enddate = ?3 AND tu.cordid = ?4 AND tu.email = ?5"))
							.setParameter(1, userHistoryWrapper.getTid())
							.setParameter(2, userHistoryWrapper.getStartdate())
							.setParameter(3, userHistoryWrapper.getEnddate())
							.setParameter(4, userHistoryWrapper.getCordid())
							.setParameter(5, userHistoryWrapper.getEmail()).setParameter(6, 'Y').executeUpdate();

			return false;

		} else {
			return true;
		}
	}
}
