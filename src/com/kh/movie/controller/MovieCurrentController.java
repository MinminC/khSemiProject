package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;

/**
 * Servlet implementation class MovieListController
 */
@WebServlet("/currentList.mo")
public class MovieCurrentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieCurrentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = 1;
		if(request.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int listCount= new MovieService().countCurrentMovie();
		int pageLimit = 10;
		int boardLimit = 5;
		
		PageInfo pi = new PageInfo().calcPageInfo(listCount, currentPage, pageLimit, boardLimit);
		
		
		ArrayList<Movie> currentList = new MovieService().selectCurrentList(pi.getStartRow(), pi.getEndRow());
		//해당하는 영화 번호 추출
		ArrayList<Integer> movieNoList = new ArrayList<>();
		for(Movie mv : currentList)
			movieNoList.add(mv.getMovieNo());
		//추출된 번호로 포스터 조회해오기
		ArrayList<Picture> picList = new MovieService().selectPosterList(movieNoList);
	
		
		request.setAttribute("pi", pi);
		request.setAttribute("currentList", currentList);
		request.setAttribute("picList", picList);
		
		request.getRequestDispatcher("views/user/movie/movieListCurrent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
