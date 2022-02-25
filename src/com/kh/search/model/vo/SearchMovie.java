package com.kh.search.model.vo;

public class SearchMovie {

	
	private int mNo; // M.MNO;
	private String mName;//M.MNAME,
	private String genre;//M.GENRE, 
	private String director;//M.DIRECTOR,
	private String actor;//M.ACTOR, 
	private int rTime;//M.RTIME, 
	private String filePath;//P.FILE_PATH, 
	private String changeName;//P.CHANGE_NAME
	
	public SearchMovie() {
		super();
	}

	public SearchMovie(int mNo, String mName, String genre, String director, String actor, int rTime, String filePath,
			String changeName) {
		super();
		this.mNo = mNo;
		this.mName = mName;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
		this.rTime = rTime;
		this.filePath = filePath;
		this.changeName = changeName;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getrTime() {
		return rTime;
	}

	public void setrTime(int rTime) {
		this.rTime = rTime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	@Override
	public String toString() {
		return "SearchMovie [mNo=" + mNo + ", mName=" + mName + ", genre=" + genre + ", director=" + director
				+ ", actor=" + actor + ", rTime=" + rTime + ", filePath=" + filePath + ", changeName=" + changeName
				+ "]";
	}
	
	
	
	
}
