package com.hiring.portal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "testuser")
@EntityListeners(AuditingEntityListener.class)

public class TestUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tuid;
	
	private Long tid;
	
	private Long cordid;

	private String email;
	
	private String startdate;
	
	private String enddate;
	
	private Character testtaken;
	
	public Character getTesttaken() {
		return testtaken;
	}

	public void setTesttaken(Character testtaken) {
		this.testtaken = testtaken;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Long getCordid() {
		return cordid;
	}

	public void setCordid(Long cordid) {
		this.cordid = cordid;
	}

	public Long getTuid() {
		return tuid;
	}

	public void setTuid(Long tuid) {
		this.tuid = tuid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
