package com.kh.theater.model.vo;

public class TheaterAuditorium {
	
	// 영화관
	private int theaterNo;
	private String theaterName;
	private int auditoriumNum;
	private int seatNum; // 영화관의 좌석 총 개수
	private String address;
	private String phone;
	private String traffic;
	private String location;
	private String parking;
	private int theaterImg;
	private String uploadDate;
	
	// 상영관
	private int auditoriumNo;
	private String auditoriumName;
	private String auditoriumSeatNum; // 상영관의 좌석수
	
	
	public TheaterAuditorium() {
		super();
	}


	public TheaterAuditorium(int theaterNo, String theaterName, int auditoriumNum, int seatNum, String address,
			String phone, String traffic, String location, String parking, int theaterImg, String uploadDate,
			int auditoriumNo, String auditoriumName, String auditoriumSeatNum) {
		super();
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.auditoriumNum = auditoriumNum;
		this.seatNum = seatNum;
		this.address = address;
		this.phone = phone;
		this.traffic = traffic;
		this.location = location;
		this.parking = parking;
		this.theaterImg = theaterImg;
		this.uploadDate = uploadDate;
		this.auditoriumNo = auditoriumNo;
		this.auditoriumName = auditoriumName;
		this.auditoriumSeatNum = auditoriumSeatNum;
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


	public int getAuditoriumNum() {
		return auditoriumNum;
	}


	public void setAuditoriumNum(int auditoriumNum) {
		this.auditoriumNum = auditoriumNum;
	}


	public int getSeatNum() {
		return seatNum;
	}


	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTraffic() {
		return traffic;
	}


	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public int getTheaterImg() {
		return theaterImg;
	}


	public void setTheaterImg(int theaterImg) {
		this.theaterImg = theaterImg;
	}


	public String getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
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


	public String getAuditoriumSeatNum() {
		return auditoriumSeatNum;
	}


	public void setAuditoriumSeatNum(String auditoriumSeatNum) {
		this.auditoriumSeatNum = auditoriumSeatNum;
	}


	@Override
	public String toString() {
		return "TheaterAuditorium [theaterNo=" + theaterNo + ", theaterName=" + theaterName + ", auditoriumNum="
				+ auditoriumNum + ", seatNum=" + seatNum + ", address=" + address + ", phone=" + phone + ", traffic="
				+ traffic + ", location=" + location + ", parking=" + parking + ", theaterImg=" + theaterImg
				+ ", uploadDate=" + uploadDate + ", auditoriumNo=" + auditoriumNo + ", auditoriumName=" + auditoriumName
				+ ", auditoriumSeatNum=" + auditoriumSeatNum + "]";
	}
	
	
	
	
	
	
	
}
