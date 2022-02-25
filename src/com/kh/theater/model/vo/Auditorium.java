package com.kh.theater.model.vo;

public class Auditorium {

	private int auditoriumNo;
	private String auditoriumName;
	private String seatNum;
	private int theaterNo;
	
	public Auditorium() {
		super();
	}

	public Auditorium(int auditoriumNo, String auditoriumName, String seatNum, int theaterNo) {
		super();
		this.auditoriumNo = auditoriumNo;
		this.auditoriumName = auditoriumName;
		this.seatNum = seatNum;
		this.theaterNo = theaterNo;
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

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public int getTheaterNo() {
		return theaterNo;
	}

	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}

	@Override
	public String toString() {
		return "Auditorium [auditoriumNo=" + auditoriumNo + ", auditoriumName=" + auditoriumName + ", seatNum="
				+ seatNum + ", theaterNo=" + theaterNo + "]";
	}

	
	
}
