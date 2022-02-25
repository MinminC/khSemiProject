package com.kh.search.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.search.model.vo.SearchMovie;
import com.kh.theater.model.vo.Theater;
import com.kh.search.model.dao.SearchDao;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Review;

public class SearchDao {
	
private Properties prop = new Properties();
	
	public SearchDao() {
		String fileName = SearchDao.class.getResource("/sql/search/search-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<SearchMovie> searchMovieAll(Connection conn, String search) {
		
		ArrayList<SearchMovie> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchMovieAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new SearchMovie(rset.getInt("MNO"),
										rset.getString("MNAME"),
										rset.getString("GENRE"),
										rset.getString("DIRECTOR"),
										rset.getString("ACTOR"),
										rset.getInt("RTIME"),
										rset.getString("FILE_PATH"),
										rset.getString("CHANGE_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public ArrayList<Theater> searchTheaterAll(Connection conn, String search) {
		
		ArrayList<Theater> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchTheaterAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Theater(rset.getInt("THEATER_NO"),
									 rset.getString("THEATER_NAME"),
									 rset.getString("ADDRESS")));
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Review> searchReviewAll(Connection conn, String search) {
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchReviewAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO"),
									 rset.getString("REVIEW_CONTENT"),
									 rset.getInt("MNO")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
