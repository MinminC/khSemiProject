package com.kh.question.model.vo;

public class Question {
	private int askNo; //ASK_NO	NUMBER
	private String askDate; //ASK_DATE	DATE
	private int askTypeNo; // ASK_TYPE INT
	private String askTypeTxt; // 문자로 바꿔서 보여주기
	private String askTitle; //ASK_TITLE	VARCHAR2(20 BYTE)
	private String askContent; //ASK_CONTENT	VARCHAR2(1000 BYTE)
	private String commentDate; //COMMENT_DATE	DATE
	private String comment; //COMMENT	VARCHAR2(1000 BYTE)
	private int memberNo; //MEMBER_NO --askWriter	NUMBER
	private String status; // 답변 상태
	private String memberId; // 작성잔

	public Question() {
		super();
	}
	public Question(int askNo, String askDate, int askTypeNo, String askTypeTxt, String askTitle, String askContent,
			String commentDate, String comment, int memberNo) {
		super();
		this.askNo = askNo;
		this.askDate = askDate;
		this.askTypeNo = askTypeNo;
		this.askTypeTxt = askTypeTxt;
		this.askTitle = askTitle;
		this.askContent = askContent;
		this.commentDate = commentDate;
		this.comment = comment;
		this.memberNo = memberNo;
	}
	
	public Question(String askDate, int askTypeNo, String askTitle, String askContent, String commentDate,
			String comment, int memberNo) {
		super();
		this.askDate = askDate;
		this.askTypeNo = askTypeNo;
		this.askTitle = askTitle;
		this.askContent = askContent;
		this.commentDate = commentDate;
		this.comment = comment;
		this.memberNo = memberNo;
	}
	public Question(int askNo, String askDate, int askTypeNo, String askTitle, String commentDate, int memberNo) {
		super();
		this.askNo = askNo;
		this.askDate = askDate;
		this.askTypeNo = askTypeNo;
		this.askTitle = askTitle;
		this.commentDate = commentDate;
		this.memberNo = memberNo;
	}
	public Question(int askNo, String askDate, String askTitle, String comment, String memberId) {
		super();
		this.askNo = askNo;
		this.askDate = askDate;
		this.askTitle = askTitle;
		this.comment = comment;
		this.memberId = memberId;
	}
	public Question(int askNo, String askDate, int askTypeNo, String askTitle, String askContent, String commentDate,
			String comment, int memberNo) {
		super();
		this.askNo = askNo;
		this.askDate = askDate;
		this.askTypeNo = askTypeNo;
		this.askTitle = askTitle;
		this.askContent = askContent;
		this.commentDate = commentDate;
		this.comment = comment;
		this.memberNo = memberNo;
	}
	public int getAskNo() {
		return askNo;
	}
	public void setAskNo(int askNo) {
		this.askNo = askNo;
	}
	public String getAskDate() {
		return askDate;
	}
	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}
	public int getAskTypeNo() {
		return askTypeNo;
	}
	public void setAskTypeNo(int askTypeNo) {
		this.askTypeNo = askTypeNo;
	}
	public String getAskTypeTxt() {
		return askTypeTxt;
	}
	public void setAskTypeTxt(String askTypeTxt) {
		this.askTypeTxt = askTypeTxt;
	}
	public String getAskTitle() {
		return askTitle;
	}
	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "Question [askNo=" + askNo + ", askDate=" + askDate + ", askTypeNo=" + askTypeNo + ", askTypeTxt="
				+ askTypeTxt + ", askTitle=" + askTitle + ", askContent=" + askContent + ", commentDate=" + commentDate
				+ ", comment=" + comment + ", memberNo=" + memberNo + ", status=" + status + ", memberId=" + memberId
				+ "]";
	}
	
}
