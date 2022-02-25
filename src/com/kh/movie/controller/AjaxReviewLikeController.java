package com.kh.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;

/**
 * Servlet implementation class AjaxReviewLikeController
 */
@WebServlet("/like.re")
public class AjaxReviewLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));

		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		String isLike = request.getParameter("isLike");//해당 리뷰를 내가 '좋아요' 눌렀을 경우 1, 아닐 경우 0을 반환
		
		int result = 0;
		
		if(isLike.equals("Y")) {//reviewlike존재함
			result = new MovieService().deleteReviewLike(memberNo, reviewNo);
		}else {
			result = new MovieService().insertReviewLike(memberNo, reviewNo);
		}
		
		response.setContentType("text/html; charset=UTF-8");
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
