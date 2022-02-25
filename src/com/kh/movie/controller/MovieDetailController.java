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
 * Servlet implementation class MovieDetailController
 */
@WebServlet("/detail.mo")
public class MovieDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieNo = Integer.parseInt(request.getParameter("mno"));
		
		int memberNo = 0;
		Member mem = (Member)request.getSession().getAttribute("loginUser");
		if(mem != null)
			memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		
		Movie mv = new MovieService().selectMovieDetail(movieNo, memberNo);
		ArrayList<Picture> picList = new MovieService().selectPicture(movieNo);
		
		String[] actorList;
		if(mv.getActor()!=null) {
			actorList = mv.getActor().split(",");
		}else {
			actorList = null;
		}
		
		request.setAttribute("mv", mv);
		request.setAttribute("picList", picList);
		request.setAttribute("actorList", actorList);
		
		if(mv!= null && picList.size() > 0) {//성공. 포스터는 필수이므로 size는 항상 0보다 크다
			request.getRequestDispatcher("views/user/movie/movieDetailView.jsp").forward(request, response);
		}else {//실패
			request.setAttribute("errorMsg", "영화 상세 페이지에 접근 실패했습니다.");
			request.getRequestDispatcher("views/user/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
