package com.kh.ticket.model.vo;

public class Ticket {
	private int rNum; // ROWNUM
	
	private int payNo; // PAYMENT
	private String payStatus; // PAYMENT
	private String payDate; //PAYMENT
	private String payment; //PAYMENT
	private int memberNo; //PAYMENT
	
	private String memberId; // MEMBER
	
	private int ticketNo; // TICKET
	private String ticketType; //TICKET
	
	private int seatPk; // SEAT
	private String seatNo; // SEAT
	
	private int auditoriumNo; // AUDITORIUM
	private String auditoriumName; // AUDITORIUM
	private int seatNum; // AUDITORIUM
	
	private int theaterNo; // THEATER
	private String theaterName; //THEATER
	
	private int runNo; //SCHEDULE
	private String runSch; //SCHEDULE
	
	private int mNo; //MOVIE
	private String mName; // MOVIE
	private String genre; // MOVIE
	private int rTime; // MOVIE
	private String rate; // MOVIE
	
	private String cancleDate; // 예매 취소 가능일
	private String runDay; // 상영일
	private String runTime; // 상영 시간
	private String endTime; // 끝나는 시간 구하기
	private String Dday; // 디데이
	private int ticketCount; // 티켓 장수
	private String typeCount; // 타입  X 수
	private int remain; // 남은 좌석

	public Ticket() {
		super();
	}

	public Ticket(int payNo, String payDate, int ticketNo, String ticketType, int seatPk, String seatNo, String auditoriumName,
			String theaterName, String runSch, int mNo, String mName, String rate,int rTime) {
		super();
		this.payNo = payNo;
		this.payDate = payDate;
		this.ticketNo = ticketNo;
		this.ticketType = ticketType;
		this.seatPk = seatPk;
		this.seatNo = seatNo;
		this.auditoriumName = auditoriumName;
		this.theaterName = theaterName;
		this.runSch = runSch;
		this.mNo = mNo;
		this.mName = mName;
		this.rate = rate;
		this.rTime = rTime;
	}

	public Ticket(String payment, String theaterName, String runSch, String mName, String cancleDate) {
		super();
		this.payment = payment;
		this.theaterName = theaterName;
		this.runSch = runSch;
		this.mName = mName;
		this.cancleDate = cancleDate;
	}
	
	public Ticket(int payNo, String payStatus, String payDate, String payment, String memberId, String ticketType,
			int runNo, String mName, int ticketCount) {
		super();
		this.payNo = payNo;
		this.payStatus = payStatus;
		this.payDate = payDate;
		this.payment = payment;
		this.memberId = memberId;
		this.ticketType = ticketType;
		this.runNo = runNo;
		this.mName = mName;
		this.ticketCount = ticketCount;
	}
	
	public Ticket(String memberId, String auditoriumName, String theaterName,int runNo, String runSch, String mName, String rate,
			int remain) {
		super();
		this.memberId = memberId;
		this.auditoriumName = auditoriumName;
		this.theaterName = theaterName;
		this.runNo = runNo;
		this.runSch = runSch;
		this.mName = mName;
		this.rate = rate;
		this.remain = remain;
	}

	public Ticket(String payment, int memberNo, String ticketType, int seatPk, int runNo) {
		super();
		this.payment = payment;
		this.memberNo = memberNo;
		this.ticketType = ticketType;
		this.seatPk = seatPk;
		this.runNo = runNo;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
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

	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public int getSeatPk() {
		return seatPk;
	}
	public void setSeatPk(int seatPk) {
		this.seatPk = seatPk;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public int getAuditoriumNo() {
		return auditoriumNo;
	}
	public void setAuditoriumNo(int auditoriumNo) {
		this.auditoriumNo = auditoriumNo;
	}
	public String getAuditoriumName() {
		return auditoriumName;
	}
	public void setAuditoriumName(String auditoriumName) {
		this.auditoriumName = auditoriumName;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getTheaterNo() {
		return theaterNo;
	}
	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getRunNo() {
		return runNo;
	}
	public void setRunNo(int runNo) {
		this.runNo = runNo;
	}
	public String getRunSch() {
		return runSch;
	}
	public void setRunSch(String runSch) {
		this.runSch = runSch;
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
	public int getrTime() {
		return rTime;
	}
	public void setrTime(int rTime) {
		this.rTime = rTime;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getCancleDate() {
		return cancleDate;
	}
	public void setCancleDate(String cancleDate) {
		this.cancleDate = cancleDate;
	}
	public String getRunDay() {
		return runDay;
	}
	public void setRunDay(String runDate) {
		this.runDay = runDate;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getDday() {
		return Dday;
	}
	public void setDday(String dday) {
		Dday = dday;
	}
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getTypeCount() {
		return typeCount;
	}

	public void setTypeCount(String typeCount) {
		this.typeCount = typeCount;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	@Override
	public String toString() {
		return "Ticket [payNo=" + payNo + ", payStatus=" + payStatus + ", payDate=" + payDate + ", payment=" + payment
				+ ", memberNo=" + memberNo + ", ticketNo=" + ticketNo + ", ticketType=" + ticketType + ", seatPk="
				+ seatPk + ", seatNo=" + seatNo + ", auditoriumNo=" + auditoriumNo + ", auditoriumName="
				+ auditoriumName + ", seatNum=" + seatNum + ", theaterNo=" + theaterNo + ", theaterName=" + theaterName
				+ ", runNo=" + runNo + ", runSch=" + runSch + ", mNo=" + mNo + ", mName=" + mName + ", genre=" + genre
				+ ", rTime=" + rTime + ", rate=" + rate + "]";
	}
}
