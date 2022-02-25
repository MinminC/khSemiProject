package com.kh.vote.model.vo;

import java.sql.Date;

public class VoteList {
	
	//V.VOTE_NO, V.VOTE_TITLE, VR.VRE_FILEPATH, COUNT, V.S_DATE, V.E_DATE, VR.VRE_TITLE, VR.VRE_GENRE, VR.VRE_SYNOPSIS
	//VOTE_NO, S_DATE, E_DATE, VOTE_TITLE, VRE_TITLE, VRE_GENRE, VRE_FILEPATH,
	
	private int voteNo;
	private int vreNo;
	private Date sDate;
	private Date eDate;
	private String voteTitle;
	private int count; 
	private String vreTitle;
	private String vreGenre;
	private String vreSynopsis;
	private String vreFilePath;
	
	
	
	public VoteList() {
		super();
	}

	

	public VoteList(int voteNo, Date sDate, Date eDate, String voteTitle) {
		super();
		this.voteNo = voteNo;
		this.sDate = sDate;
		this.eDate = eDate;
		this.voteTitle = voteTitle;
	}



	public VoteList(int voteNo, int vreNo, Date sDate, Date eDate, String voteTitle, int count, String vreTitle,
			String vreGenre, String vreSynopsis, String vreFilePath) {
		super();
		this.voteNo = voteNo;
		this.vreNo = vreNo;
		this.sDate = sDate;
		this.eDate = eDate;
		this.voteTitle = voteTitle;
		this.count = count;
		this.vreTitle = vreTitle;
		this.vreGenre = vreGenre;
		this.vreSynopsis = vreSynopsis;
		this.vreFilePath = vreFilePath;
	}



	public int getVoteNo() {
		return voteNo;
	}



	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}



	public int getVreNo() {
		return vreNo;
	}



	public void setVreNo(int vreNo) {
		this.vreNo = vreNo;
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



	public String getVoteTitle() {
		return voteTitle;
	}



	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public String getVreTitle() {
		return vreTitle;
	}



	public void setVreTitle(String vreTitle) {
		this.vreTitle = vreTitle;
	}



	public String getVreGenre() {
		return vreGenre;
	}



	public void setVreGenre(String vreGenre) {
		this.vreGenre = vreGenre;
	}



	public String getVreSynopsis() {
		return vreSynopsis;
	}



	public void setVreSynopsis(String vreSynopsis) {
		this.vreSynopsis = vreSynopsis;
	}



	public String getVreFilePath() {
		return vreFilePath;
	}



	public void setVreFilePath(String vreFilePath) {
		this.vreFilePath = vreFilePath;
	}



	@Override
	public String toString() {
		return "VoteList [voteNo=" + voteNo + ", vreNo=" + vreNo + ", sDate=" + sDate + ", eDate=" + eDate
				+ ", voteTitle=" + voteTitle + ", count=" + count + ", vreTitle=" + vreTitle + ", vreGenre=" + vreGenre
				+ ", vreSynopsis=" + vreSynopsis + ", vreFilePath=" + vreFilePath + "]";
	}
	
	
	
	
	
}
