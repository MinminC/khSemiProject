package com.kh.theater.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;

/**
 * Servlet implementation class AMovieTheaterDeleteController
 */
@WebServlet("/atDelete.th")
public class AMovieTheaterDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMovieTheaterDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String list = request.getParameter("list");
		String[] deleteList = list.split(",");
		
		for(int i = 0; i < deleteList.length; i++) {
			
			System.out.println("deleteList[]"+deleteList[i]);
		}
		
		int result = new TheaterService().deleteTheater(deleteList);
		
		System.out.println("controller : " + result);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath() + "/atList.th?currentPage=1");			
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
