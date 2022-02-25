package com.kh.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.vo.Review;
import com.kh.search.model.service.SearchService;
import com.kh.search.model.vo.SearchMovie;
import com.kh.theater.model.vo.Theater;

/**
 * Servlet implementation class SearchMainController
 */
@WebServlet("/search.all")
public class SearchMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		ArrayList<SearchMovie> movieList = new SearchService().searchMovieAll(search);
		ArrayList<Theater> theaterList = new SearchService().searchTheaterAll(search);
		ArrayList<Review> reviewList = new SearchService().searchReviewAll(search);
		
		request.setAttribute("movieList", movieList);
		request.setAttribute("theaterList", theaterList);
		request.setAttribute("reviewList", reviewList);
		
		request.getRequestDispatcher("views/user/search/searchResult.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
