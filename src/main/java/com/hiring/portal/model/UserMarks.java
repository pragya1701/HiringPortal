package com.hiring.portal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "usermarks")
@EntityListeners(AuditingEntityListener.class)
public class UserMarks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;

	private Long userid;

	private Long cordid;
	
	private Long testid;
	
	private String starttime;
	
	private String endtime;
	
	private int totalmarks;

	private String email;
	
	private Long rank;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Long getMid() {
	return mid;
	}
	
	public void setMid(Long mid) {
	this.mid = mid;
	}
	
	public Long getUserid() {
	return userid;
	}
	
	public void setUserid(Long userid) {
	this.userid = userid;
	}
	
	public Long getCordid() {
	return cordid;
	}
	
	public void setCordid(Long cordid) {
	this.cordid = cordid;
	}
	
	public Long getTestid() {
	return testid;
	}
	
	public void setTestid(Long testid) {
	this.testid = testid;
	}
	
	public int getTotalmarks() {
	return totalmarks;
	}
	
	public void setTotalmarks(int totalmarks) {
	this.totalmarks = totalmarks;
	}
}
