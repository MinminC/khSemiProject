package com.kh.loginLogout.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class LoginDao {
	
	private Properties prop = new Properties();
	
	public LoginDao() {
		
		String fileName = LoginDao.class.getResource("/sql/loginLogout/loginLogout-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public Member selectMember(Connection conn, String memberId, String changedPwd) {

		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, changedPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("MEMBER_NO")
									  , rset.getString("MEMBER_ID")
									  , rset.getString("MEMBER_NAME")
									  , rset.getString("BIRTH")
									  , rset.getString("GENDER")
									  , rset.getString("EMAIL")
									  , rset.getString("PHONE")
									  , rset.getString("INTEREST")
									  , rset.getInt("POINT")
									  , rset.getDate("CREATE_DATE")
									  , rset.getString("MEMBER_STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	public Member searchId(Connection conn, Member m) {
		
		Member searchMem = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getBirth());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchMem = new Member(rset.getString("MEMBER_ID")
									 , rset.getDate("CREATE_DATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return searchMem;
	}

	public Member searchPwd(Connection conn, String memberId) {

		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getString("MEMBER_ID")
							 , rset.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public Member pwdCertify(Connection conn, String memberId, String email) {

		Member m = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("pwdCertify");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getString("MEMBER_ID")
							 , rset.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int updateImsyPwd(Connection conn,String memberId, String changedPwd) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateImsyPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changedPwd);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
