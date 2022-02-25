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
import com.kh.movie.model.vo.Picture;

/**
 * Servlet implementation class AjaxRecommendPictureController
 */
@WebServlet("/recommendPicture.mo")
public class AjaxRecommendPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxRecommendPictureController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//받아온 영화의 번호를 담기
		String recommendNoString = request.getParameter("recommendNo");
		String[] recommendNo = recommendNoString.split(",");

		ArrayList<Picture> picList = new ArrayList<>();
		//받아온 영화의 포스터들만 조회
		if(recommendNo.length > 0)
			picList = new MovieService().selectPosterList(recommendNo);
	
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(picList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
