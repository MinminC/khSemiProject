package com.kh.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Review;

/**
 * Servlet implementation class ArajReviewInsertController
 */
@WebServlet("/insert.re")
public class AjaxReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int movieNo = Integer.parseInt(request.getParameter("mno"));
		String memberNo = request.getParameter("uno");
		
		String reviewContent = request.getParameter("reviewContent");
		int starCount = 10;
		if(request.getParameter("starCount") != null)
			starCount = Integer.parseInt(request.getParameter("starCount"));
		Review re = new Review();
		re.setMovieNo(movieNo);
		re.setReviewWriter(memberNo);
		re.setReviewContent(reviewContent);
		re.setReviewGrade(starCount);
//		re.setPayNo();
		
		int result = new MovieService().insertReview(re);
		
		response.getWriter().print(result);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
