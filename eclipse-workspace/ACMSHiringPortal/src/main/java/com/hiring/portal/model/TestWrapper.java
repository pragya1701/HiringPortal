package com.hiring.portal.model;

public class TestWrapper {
	private Long tid;

	private Long cordid;

	private String tdate;

	private String ttimer;

	private String subject;
	
	private String body;
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getTtimer() {
		return ttimer;
	}

	public void setTtimer(String ttimer) {
		this.ttimer = ttimer;
	}
}
