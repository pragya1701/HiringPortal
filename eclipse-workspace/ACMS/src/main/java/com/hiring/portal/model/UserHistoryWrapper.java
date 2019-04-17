package com.hiring.portal.model;

public class UserHistoryWrapper {
	
	private String tname;
	private String startdate;
	private String enddate;
	private String timer;
	private Long cordid;
	private Long tid;
	private String email;
	private Integer testtimeflag;
	
	public Integer getTesttimeflag() {
		return testtimeflag;
	}
	public void setTesttimeflag(Integer testtimeflag) {
		this.testtimeflag = testtimeflag;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCordid() {
		return cordid;
	}
	public void setCordid(Long cordid) {
		this.cordid = cordid;
	}
	public String getTimer() {
		return timer;
	}
	public void setTimer(String timer) {
		this.timer = timer;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
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
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


}