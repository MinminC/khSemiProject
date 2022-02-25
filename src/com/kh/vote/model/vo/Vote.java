package com.kh.vote.model.vo;

import java.sql.Date;

public class Vote {

	private int voteNo;//VOTE_NO	NUMBER
	private String voteTitle;//VOTE_TITLE	VARCHAR2(100 BYTE)
	private Date sDate;//S_DATE	DATE
	private Date eDate;//E_DATE	DATE
	public Vote() {
		super();
	}
	public Vote(int voteNo, String voteTitle, Date sDate, Date eDate) {
		super();
		this.voteNo = voteNo;
		this.voteTitle = voteTitle;
		this.sDate = sDate;
		this.eDate = eDate;
	}
	public int getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}
	public String getVoteTitle() {
		return voteTitle;
	}
	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	public Date geteDate() {
		return eDate;
	}
	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
	@Override
	public String toString() {
		return "Vote [voteNo=" + voteNo + ", voteTitle=" + voteTitle + ", sDate=" + sDate + ", eDate=" + eDate + "]";
	}
	

}
