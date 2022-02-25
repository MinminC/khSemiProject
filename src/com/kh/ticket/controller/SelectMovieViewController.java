package com.kh.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.vo.Theater;
import com.kh.ticket.model.service.TicketService;

/**
 * Servlet implementation class SelectMovieController
 */
@WebServlet("/MoView.ti")
public class SelectMovieViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovieViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service에서 DB에 있는 데이터 받아오기
		ArrayList<Movie> mlist = new TicketService().selectMovieName();
		ArrayList<Theater> tlist = new TicketService().selectTheaterAll();
		// 응답
		request.setAttribute("mlist", mlist);
		request.setAttribute("tlist", tlist);
		request.getRequestDispatcher("/views/user/ticketing/selectMovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
