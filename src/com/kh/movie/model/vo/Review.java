package com.kh.movie.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private String reviewContent;
	private int reviewGrade;
	private Date createDate;
	private String status;
	private int movieNo;
	private String reviewWriter;
	private int payCheck;// 결제 정보 확인
	private int reviewLike;// 리뷰 좋아요 수
	private String myLike;

	public Review() {
		super();
	}

	public Review(int reviewNo, String reviewContent, int reviewGrade, Date createDate, String status, int movieNo,
			String reviewWriter, int payCheck, int reviewLike) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.reviewGrade = reviewGrade;
		this.createDate = createDate;
		this.status = status;
		this.movieNo = movieNo;
		this.reviewWriter = reviewWriter;
		this.payCheck = payCheck;
		this.reviewLike = reviewLike;
	}

	
	public Review(int reviewNo, String reviewContent, int movieNo) {
		super();
		this.reviewNo = reviewNo;
		this.reviewContent = reviewContent;
		this.movieNo = movieNo;
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

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public int getPayCheck() {
		return payCheck;
	}

	public void setPayCheck(int payCheck) {
		this.payCheck = payCheck;
	}

	public int getReviewLike() {
		return reviewLike;
	}

	public void setReviewLike(int reviewLike) {
		this.reviewLike = reviewLike;
	}

	public String getMyLike() {
		return myLike;
	}

	public void setMyLike(String myLike) {
		this.myLike = myLike;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewContent=" + reviewContent + ", reviewGrade=" + reviewGrade
				+ ", createDate=" + createDate + ", status=" + status + ", movieNo=" + movieNo + ", reviewWriter="
				+ reviewWriter + ", payCheck=" + payCheck + ", reviewLike=" + reviewLike + ", myLike=" + myLike + "]";
	}

}
