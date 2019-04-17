package com.hiring.portal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "testquestion")
@EntityListeners(AuditingEntityListener.class)
public class TestQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tqid;
	@NotNull
	private Long tid;
	@NotNull
	private Long qid;
	public Long getTqid() {
		return tqid;
	}
	public void setTqid(Long tqid) {
		this.tqid = tqid;
	}
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public Long getQid() {
		return qid;
	}
	public void setQid(Long qid) {
		this.qid = qid;
	}
	
}
