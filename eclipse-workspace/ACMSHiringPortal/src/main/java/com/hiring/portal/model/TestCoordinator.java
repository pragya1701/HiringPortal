package com.hiring.portal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "testcoordinator")
@EntityListeners(AuditingEntityListener.class)

public class TestCoordinator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tcid;
	
	private Long tid;
	
	private Long cordid;

	private String sdate;
	
	private String edate;

	public Long getTcid() {
		return tcid;
	}

	public void setTcid(Long tcid) {
		this.tcid = tcid;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getCordid() {
		return cordid;
	}

	public void setCordid(Long cordid) {
		this.cordid = cordid;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}
}
