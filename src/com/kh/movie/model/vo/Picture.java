package com.kh.movie.model.vo;

import java.sql.Date;

public class Picture {

	private int fileNo;
	private int refNo;
	private int fileLevel;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String status;
	public Picture() {
		super();
	}
	public Picture(int fileNo, int refNo, int fileLevel, String originName, String changeName, String filePath,
			Date uploadDate, String status) {
		super();
		this.fileNo = fileNo;
		this.refNo = refNo;
		this.fileLevel = fileLevel;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Picture [fileNo=" + fileNo + ", refNo=" + refNo + ", fileLevel=" + fileLevel + ", originName="
				+ originName + ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate
				+ ", status=" + status + "]";
	}
	
	
}
