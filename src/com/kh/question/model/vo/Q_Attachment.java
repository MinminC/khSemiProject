package com.kh.question.model.vo;

import java.sql.Date;

public class Q_Attachment {
	private int fileNo; // FILE_NO	NUMBER
	private String originName; // ORIGIN_NAME	VARCHAR2(255 BYTE)
	private String changeName; // CHANGE_NAME	VARCHAR2(255 BYTE)
	private String filePath; // FILE_PATH	VARCHAR2(1000 BYTE)
	private Date uploadDate; // UPLOAD_DATE	DATE
	private int refNo; //ASK_NO	NUMBER
	public Q_Attachment() {
		super();
	}
	public Q_Attachment(int fileNo, String originName, String changeName, String filePath, Date uploadDate, int refNo) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.refNo = refNo;
	}

	public Q_Attachment(int fileNo, String originName, String changeName, String filePath) {
		super();
		this.fileNo = fileNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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
	public int getRefNo() {
		return refNo;
	}
	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}
	@Override
	public String toString() {
		return "Q_Attachment [fileNo=" + fileNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", refNo=" + refNo + "]";
	}
	
}
