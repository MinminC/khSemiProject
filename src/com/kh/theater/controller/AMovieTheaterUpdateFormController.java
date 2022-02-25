package com.kh.theater.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Auditorium;
import com.kh.theater.model.vo.TheaterAuditorium;

/**
 * Servlet implementation class AMovieTheaterUpdateFormController
 */
@WebServlet("/atUpdateForm.th")
public class AMovieTheaterUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMovieTheaterUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("UPDATEFORM");
		
		int theaterNo = Integer.parseInt(request.getParameter("tno"));
		
		ArrayList<TheaterAuditorium> taList = new TheaterService().aSelectTheater(theaterNo);
		
		ArrayList<Auditorium> auList =  new TheaterService().selectAuditorium(theaterNo);
		
		
		
		if(taList != null) {
			
			request.setAttribute("taList", taList);

			request.setAttribute("auList", auList);
			
			request.getRequestDispatcher("views/admin/theater/aMovieTheaterUpdate.jsp").forward(request, response);
			
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
