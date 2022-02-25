package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;
import com.kh.movie.model.vo.Schedule;
import com.kh.theater.model.vo.Auditorium;

/**
 * Servlet implementation class MovieUpdateFormController
 */
@WebServlet("/updateForm.mo")
public class MovieUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieNo = Integer.parseInt(request.getParameter("mno"));
		
		Movie mv = new MovieService().selectOneMovie(movieNo);//영화 하나 정보 그대로 받아오는 것.
		
		String[] genres = mv.getGenre().split(",");
		String[] actors = mv.getActor().split(",");
		//["해리포터/ㅁㅁㅁ" , "헤르미온느/ㅁㅁㅁ"] 
		
		ArrayList<Schedule> schedules = new MovieService().selectOneSchedule(movieNo);
		
		ArrayList<Picture> picList = new MovieService().selectPicture(movieNo);

		ArrayList<Auditorium> auditoriumList = new MovieService().selectAuditoriumList();

		request.setAttribute("mv", mv);
		request.setAttribute("genres", genres);
		request.setAttribute("actors", actors);
		request.setAttribute("schedules", schedules);
		request.setAttribute("picList", picList);
		request.setAttribute("auditoriumList", auditoriumList);
		
		request.getRequestDispatcher("views/admin/movie/movieUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
