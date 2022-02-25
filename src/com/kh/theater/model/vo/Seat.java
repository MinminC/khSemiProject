package com.kh.theater.model.vo;

public class Seat {

	private int runNo;
	private int auditoriumNo;
	private String seatStatus;
	private String seatNo;
	
	
	public Seat() {
		super();
	}


	public Seat(int runNo, int auditoriumNo, String seatStatus, String seatNo) {
		super();
		this.runNo = runNo;
		this.auditoriumNo = auditoriumNo;
		this.seatStatus = seatStatus;
		this.seatNo = seatNo;
	}


	public int getRunNo() {
		return runNo;
	}


	public void setRunNo(int runNo) {
		this.runNo = runNo;
	}


	public int getAuditoriumNo() {
		return auditoriumNo;
	}


	public void setAuditoriumNo(int auditoriumNo) {
		this.auditoriumNo = auditoriumNo;
	}


	public String getSeatStatus() {
		return seatStatus;
	}


	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}


	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	@Override
	public String toString() {
		return "Seat [runNo=" + runNo + ", auditoriumNo=" + auditoriumNo + ", seatStatus=" + seatStatus + ", seatNo="
				+ seatNo + "]";
	}

	
	
}