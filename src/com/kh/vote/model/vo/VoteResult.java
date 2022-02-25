package com.kh.vote.model.vo;

public class VoteResult {

	private int vreNo;//VRE_NO	NUMBER
	private String vreTitle;//VRE_TITLE	VARCHAR2(100 BYTE)
	private String vreGenre;//VRE_GENRE	VARCHAR2(50 BYTE)
	private String vreFilePath;//VRE_FILEPATH	VARCHAR2(500 BYTE)
	private String vreSynopsis;//VRE_SYNOPSIS	VARCHAR2(2000 BYTE)
	private int voteNo;//VOTE_NO	NUMBER
	private int count;
	public VoteResult() {
		super();
	}

	public VoteResult(int vreNo, String vreTitle, String vreGenre, String vreFilePath, String vreSynopsis, int voteNo,
			int count) {
		super();
		this.vreNo = vreNo;
		this.vreTitle = vreTitle;
		this.vreGenre = vreGenre;
		this.vreFilePath = vreFilePath;
		this.vreSynopsis = vreSynopsis;
		this.voteNo = voteNo;
		this.count = count;
	}
	
	
	public VoteResult(String vreTitle, String vreFilePath, int count) {
		super();
		this.vreTitle = vreTitle;
		this.vreFilePath = vreFilePath;
		this.count = count;
	}
	public int getVreNo() {
		return vreNo;
	}
	public void setVreNo(int vreNo) {
		this.vreNo = vreNo;
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
	public String getVreFilePath() {
		return vreFilePath;
	}
	public void setVreFilePath(String vreFilePath) {
		this.vreFilePath = vreFilePath;
	}
	public String getVreSynopsis() {
		return vreSynopsis;
	}
	public void setVreSynopsis(String vreSynopsis) {
		this.vreSynopsis = vreSynopsis;
	}
	public int getVoteNo() {
		return voteNo;
	}
	public void setVoteNo(int voteNo) {
		this.voteNo = voteNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "VoteResult [vreNo=" + vreNo + ", vreTitle=" + vreTitle + ", vreGenre=" + vreGenre + ", vreFilePath="
				+ vreFilePath + ", vreSynopsis=" + vreSynopsis + ", voteNo=" + voteNo + ", count=" + count + "]";
	}
	
		
}
