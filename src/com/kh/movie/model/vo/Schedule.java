package com.kh.movie.model.vo;

public class Schedule {
	private int runNo;
	private String runSch;
	private int auditoriumNo;
	private int mno;
	private String theaterName;
	public Schedule() {
		super();
	}
	public Schedule(int runNo, String runSch, int auditoriumNo, int mno) {
		super();
		this.runNo = runNo;
		this.runSch = runSch;
		this.auditoriumNo = auditoriumNo;
		this.mno = mno;
	}
	public int getRunNo() {
		return runNo;
	}
	public void setRunNo(int runNo) {
		this.runNo = runNo;
	}
	public String getRunSch() {
		return runSch;
	}
	public void setRunSch(String runSch) {
		this.runSch = runSch;
	}
	public int getAuditoriumNo() {
		return auditoriumNo;
	}
	public void setAuditoriumNo(int auditoriumNo) {
		this.auditoriumNo = auditoriumNo;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	
	@Override
	/**
	 * Movie에서 schedule 추가/삭제할 때 쓰므로 변경 불가
	 */
	public String toString() {
		return theaterName + "/" + auditoriumNo + "/" + runSch;
	}
	
}
