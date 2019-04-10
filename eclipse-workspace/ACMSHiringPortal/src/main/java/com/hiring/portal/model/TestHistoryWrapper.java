package com.hiring.portal.model;

public class TestHistoryWrapper {
	String startdate;
	String enddate;
	String tname;
	Long tid;
	int cordFlag;
	
	public int getCordFlag() {
		return cordFlag;
	}

	public void setCordFlag(int cordFlag) {
		this.cordFlag = cordFlag;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
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

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
