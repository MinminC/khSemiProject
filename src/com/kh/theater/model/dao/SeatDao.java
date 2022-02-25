package com.kh.theater.model.dao;


import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.theater.model.vo.TheaterAuditorium;

public class SeatDao {

	private Properties prop = new Properties();
	
	
	public SeatDao() {
		
		String fileName = SeatDao.class.getResource("/sql/theater/seat-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertSeatOne(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 11; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 11; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
			}
			
			if(result != 100) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int insertSeatTwo(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 11; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 13; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
			}
			
			if(result != 120) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int insertSeatSix(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 17; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 17; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
			}
			
			if(result != 160) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateSeatOne(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 11; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 11; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
				System.out.println("seatDao의 result : " + result);
			}
			
			if(result != 100) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateSeatTwo(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 11; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 13; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
				System.out.println("2seatDao의 result : " + result);
			}
			
			if(result != 120) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateSeatSix(Connection conn, int auditoriumNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateSeat");
		
		String str = null;
		
		try {

			for(int i = 1; i < 11; i++) {
				switch(i) {
				case 1 : str = "A";
				break;
				case 2 : str = "B";
				break;
				case 3 : str = "C";
				break;
				case 4 : str = "D";
				break;
				case 5 : str = "E";
				break;
				case 6 : str = "F";
				break;
				case 7 : str = "G";
				break;
				case 8 : str = "H";
				break;
				case 9 : str = "I";
				break;
				case 10 : str = "J";
				break;
				}
				for(int j = 1; j < 17; j++) {
					pstmt = conn.prepareStatement(sql);
					
					String str2 = str + "열 " + j;
					
					pstmt.setString(1, str2);
					
					pstmt.executeUpdate();
					result++;
				}
			}
			
			if(result != 160) {
				result = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	
	public int deleteSeat(Connection conn, int theaterNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteSeat");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, theaterNo);
			
			pstmt.executeUpdate();
			result++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
