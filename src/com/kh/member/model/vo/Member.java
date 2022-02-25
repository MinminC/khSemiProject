package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memberNo; // MEMBER_NO	NUMBER -> 번호
	private String memberId; //NENBER_ID VARCHAR2(20 BYTE) -> 아이디(UNIQUE)
	private String memberPwd; // MEMBER_PWD	VARCHAR2(1000 BYTE) - > 패스워드
	private String memberName; // MEMBER_NAME	VARCHAR2(30 BYTE) - > 이름
	private String birth; // BIRTH	VARCHAR2(20 BYTE) - > 생년월일
	private String gender; // GENDER	VARCHAR2(3 BYTE) -> 성별
	private String email; //EMAIL	VARCHAR2(40 BYTE) -> 이메일(UNIQUE)
	private String phone; // PHONE	VARCHAR2(15 BYTE) -> 전화번호
	private String interest; // INTEREST VARCHAR2(500 BYTE) ->관리장르
	private int point; // POINT	NUMBER -> 멤버쉽 포인트 
	private Date createDate; // CREATE_DATE	DATE -> 가입 일자
	private String memberStatus; // MEMBER_STATUS	VARCHAR2(3 BYTE) ->탈퇴 여부
	
	public Member () {
		
	}
	
	//MEMBER_NO, MEMBER_ID, MEMBER_NAME, BIRTH, GENDER, EMAIL, PHONE
	public Member(int memberNo, String memberId, String memberName, String birth, String gender, String email, String phone, String memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.memberStatus = memberStatus;
	}
	public Member(String memberId, Date createDate) { // 아이디찾기 할 때 사용
		super();
		this.memberId = memberId;
		this.createDate = createDate;
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberName) {

		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
	}
	public Member(String memberId, String email) { // 비밀번호찾기 할 때 사용
		super();
		this.memberId = memberId;
		this.email = email;
	}

	
	// 비밀번호 제외한 모든 정보
	public Member(int memberNo, String memberId, String memberName, String birth, String gender, String email,
			String phone, String interest, int point, Date createDate, String memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.interest = interest;
		this.point = point;
		this.createDate = createDate;
		this.memberStatus = memberStatus;
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberName, String birth, String gender,
			String email, String phone, String interest, int point, Date createDate, String memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.interest = interest;
		this.point = point;
		this.createDate = createDate;
		this.memberStatus = memberStatus;
	}
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", birth=" + birth + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", interest=" + interest + ", point=" + point + ", createDate=" + createDate + ", memberStatus="
				+ memberStatus + "]";
	}
	
}

	