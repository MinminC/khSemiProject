package com.kh.notice.model.vo;

import java.sql.Date;

public class Notice {
	private int noticeNo;
	private String noticeCategory;
	//notice : 중요 10, 일반 20
	//FAQ : 예매 100, 영화관 이용 200, 회원 300, 홈페이지 이용 400, 멤버십 500, 투표 600, 기타 700
	private String noticeTitle;
	private String noticeContent;
	private int noticeViews;
	private Date noticeDate;
	private String status;
	private int nextNoticeNo;
	private String nextNoticeTitle;
	private int prevNoticeNo;
	private String prevNoticeTitle;
	

	public Notice() {
		super();
	}
	public Notice(int noticeNo, String noticeTitle) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
	}
	public Notice(int noticeNo, String noticeCategory, String noticeTitle, String noticeContent, int noticeViews,
			Date noticeDate, String status, int nextNoticeNo, String nextNoticeTitle, int prevNoticeNo,
			String prevNoticeTitle) {
		super();
		this.noticeNo = noticeNo;
		this.noticeCategory = noticeCategory;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeViews = noticeViews;
		this.noticeDate = noticeDate;
		this.status = status;
		this.nextNoticeNo = nextNoticeNo;
		this.nextNoticeTitle = nextNoticeTitle;
		this.prevNoticeNo = prevNoticeNo;
		this.prevNoticeTitle = prevNoticeTitle;
	}


	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getNoticeViews() {
		return noticeViews;
	}
	public void setNoticeViews(int noticeViews) {
		this.noticeViews = noticeViews;
	}
	
	public int getNextNoticeNo() {
		return nextNoticeNo;
	}

	public void setNextNoticeNo(int nextNoticeNo) {
		this.nextNoticeNo = nextNoticeNo;
	}

	public String getNextNoticeTitle() {
		return nextNoticeTitle;
	}

	public void setNextNoticeTitle(String nextNoticeTitle) {
		this.nextNoticeTitle = nextNoticeTitle;
	}

	public int getPrevNoticeNo() {
		return prevNoticeNo;
	}

	public void setPrevNoticeNo(int prevNoticeNo) {
		this.prevNoticeNo = prevNoticeNo;
	}

	public String getPrevNoticeTitle() {
		return prevNoticeTitle;
	}

	public void setPrevNoticeTitle(String prevNoticeTitle) {
		this.prevNoticeTitle = prevNoticeTitle;
	}

	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeCategory=" + noticeCategory + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeViews=" + noticeViews + ", noticeDate=" + noticeDate
				+ ", status=" + status + ", nextNoticeNo=" + nextNoticeNo + ", nextNoticeTitle=" + nextNoticeTitle
				+ ", prevNoticeNo=" + prevNoticeNo + ", prevNoticeTitle=" + prevNoticeTitle + "]";
	}
}
