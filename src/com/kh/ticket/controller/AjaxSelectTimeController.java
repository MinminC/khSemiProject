package com.kh.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ticket.model.service.TicketService;
import com.kh.ticket.model.vo.Ticket;

/**
 * Servlet implementation class AjaxSelectTimeController
 */
@WebServlet("/selectTime.ti")
public class AjaxSelectTimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxSelectTimeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mName = request.getParameter("mName");
		String theater = request.getParameter("theater");
		// String date = request.getParameter("date");
		
		String date = "2/01";
		
		ArrayList<Ticket> list = new TicketService().selectTime(mName, theater, date);
		
		// 상영시간 자르기
		for(Ticket t : list) {
			String runSch = t.getRunSch();
			t.setRunSch(runSch.substring(11,16));
		}
		
		// Gson으로 응답
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
