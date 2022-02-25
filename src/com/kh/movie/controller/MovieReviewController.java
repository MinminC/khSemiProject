package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;

/**
 * Servlet implementation class MovieReviewController
 */
@WebServlet("/review.mo")
public class MovieReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리뷰페이지에서 리뷰를 제외한 나머지파트 조회하는 Servlet
		int movieNo = Integer.parseInt(request.getParameter("mno"));
		
		int memberNo = 0;
		if((Member)request.getSession().getAttribute("loginUser") != null)
			memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		Movie mvSummary= new MovieService().selectMovieSummary(movieNo, memberNo);
		
		ArrayList<Picture> picList = new MovieService().selectPicture(movieNo);
		
		request.setAttribute("mv", mvSummary);
		request.setAttribute("picList", picList);
		
		request.getRequestDispatcher("views/user/movie/movieReviewView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
