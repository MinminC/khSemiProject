package com.kh.search.model.service;

import static com.kh.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Review;
import com.kh.search.model.dao.SearchDao;
import com.kh.search.model.vo.SearchMovie;
import com.kh.theater.model.vo.Theater;

public class SearchService {

	
public ArrayList<SearchMovie> searchMovieAll(String search) {
		
		Connection conn = getConnection();
		
		ArrayList<SearchMovie> list = new SearchDao().searchMovieAll(conn, search);
	
		close(conn);
		
		return list;
}


public ArrayList<Theater> searchTheaterAll(String search) {
	
	Connection conn = getConnection();
	
	ArrayList<Theater> list = new SearchDao().searchTheaterAll(conn, search);

	close(conn);
	
	return list;
}

public ArrayList<Review> searchReviewAll(String search) {
	
	Connection conn = getConnection();
	
	ArrayList<Review> list = new SearchDao().searchReviewAll(conn, search);
	
	close(conn);
	
	return list;
}

}
