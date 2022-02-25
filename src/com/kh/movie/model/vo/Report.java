package com.kh.movie.model.vo;

import java.sql.Date;

public class Report {
	private int reportNo;
	private int reviewNo;
	private String reviewContent;
	private String reason;
	private Date reportDate;
	private String status;//Y : 미처리, N : 보류(불량 신고), P : 처리
	public Report() {
		super();
	}
	public Report(int reportNo, int reviewNo, String reason, String status) {
		super();
		this.reportNo = reportNo;
		this.reviewNo = reviewNo;
		this.reason = reason;
		this.status = status;
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reviewNo=" + reviewNo + ", reason=" + reason + ", status=" + status
				+ "]";
	}
	
	
}
