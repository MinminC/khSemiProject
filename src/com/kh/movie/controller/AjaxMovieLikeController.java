package com.kh.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;

/**
 * Servlet implementation class AjaxMovieLikeController
 */
@WebServlet("/like.mo")
public class AjaxMovieLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMovieLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieNo = Integer.parseInt(request.getParameter("mno"));
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		String isLike = request.getParameter("isLike");
		
		int result = 0;
		
		if(isLike.equals("Y")) {//reviewlike존재함
			result = new MovieService().deleteMovieLike(movieNo, memberNo);
		}else {
			result = new MovieService().insertMovieLike(movieNo, memberNo);
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
