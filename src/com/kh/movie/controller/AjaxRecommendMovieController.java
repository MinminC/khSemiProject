package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;

/**
 * Servlet implementation class AjaxRecommendMovieController
 */
@WebServlet("/recommendMovie.mo")
public class AjaxRecommendMovieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxRecommendMovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String genre = request.getParameter("genres");
		String[] genres = genre.split(",");
		
		//영화 조회
		//ArrayList<Movie> recommendList = new MovieService().selectRecommendList(genres, startRow, endRow);//해당 파트 service등 전부 지우기
		ArrayList<Movie> recommendList = new MovieService().selectRecommendList(genres);

		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(recommendList, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
