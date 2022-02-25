package com.kh.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;

/**
 * Servlet implementation class MovieDeleteController
 */
@WebServlet("/delete.mo")
public class MovieDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String list = request.getParameter("list");
		String[] deleteList = list.split(",");
		
		int result = new MovieService().deleteMovie(deleteList);
	
		if(result > 0) {//삭제 성공
			request.getSession().setAttribute("alertMsg", "삭제 성공했습니다");
		}else {
			request.getSession().setAttribute("alertMsg", "삭제에 실패했습니다.");
		}
		
		response.sendRedirect("adminList.mo");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
