package com.kh.theater.model.vo;

public class Theater {

	private int theaterNo;
	private String theaterName;
	private int auditoriumNum;
	private int seatNum;
	private String address;
	private String phone;
	private String traffic;
	private String location;
	private String parking;

	private int theaterNum; // 특정 지역의 영화관 수
	private int theaterImg;
	private String uploadDate;
	
	public Theater() {
		super();
	}
	
	public Theater(int theaterNo, String theaterName, int auditoriumNum, int seatNum, String address, String phone,
			String traffic, String location, String parking, int theaterImg, String uploadDate) {
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
	}

	public Theater(int theaterNo, String theaterName, String address) {
		super();
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.address = address;
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
	
	public int getTheaterNum() {
		return theaterNum;
	}

	public void setTheaterNum(int theaterNum) {
		this.theaterNum = theaterNum;
	}

	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "Theater [theaterNo=" + theaterNo + ", theaterName=" + theaterName + ", auditoriumNum=" + auditoriumNum
				+ ", seatNum=" + seatNum + ", address=" + address + ", phone=" + phone + ", traffic=" + traffic
				+ ", location=" + location + ", parking=" + parking + ", theaterImg=" + theaterImg + ", uploadDate="
				+ uploadDate + "]";
	}
	
	
}
	

