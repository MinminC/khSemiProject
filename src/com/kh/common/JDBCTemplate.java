package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		
		Connection conn = null;
		
		// 읽어들이고자하는 파일의 물리적인 경로
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		
		try {
			// prop으로부터 load메소드를 이용해서 각 키에 해당하는 벨류를 가져올것임
			prop.load(new FileInputStream(fileName));
			
			// prop으로부터 getProperty메소드를 이용해서 각 키에 해당되는 밸류를 뽑아서 배치
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), 
											   prop.getProperty("username"), 
											   prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		// Connection 객체를 반환
		return conn;
		}
	
		// 2. 전달받은 JDBC용 객체를 반납시켜주는 메소드(각 객체별로)
		// 2_1. Conn 객체 닫아주는 메소드
		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 2_2. Statement 전달받아서 반납시켜주는 메소드
		public static void close(Statement stmt) {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//2_3. ResultSet 객체를 전달받아서 반납시켜주는 메소드
		public static void close(ResultSet rset) {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		// 3. 전달받은 Connection 객체를 가지고 트래잭션 처리를 해주는 메소드
		// 3_1. 전달받은 Connection 객채를 가지고 COMMIT 시켜주는 메소드
		public static void commit(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 3_2. rollback
		public static void rollback(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	
}// 클래스
