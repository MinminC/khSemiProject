package com.kh.ticket.model.vo;

public class TicketInfo {
	private String movieName;
	private String theaterNo;
	private String runSch; //상영번호(상영일)
	private String runTime;
	private String rate;
	private int ticketNumber;
	private String selectedSeat; // ,로 구분
	private int payment;
	public TicketInfo() {
		super();
	}
	
}
