package com.kh.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ticket.model.service.TicketService;
import com.kh.ticket.model.vo.Ticket;

/**
 * Servlet implementation class SelectSeatController
 */
@WebServlet("/selectSeat.ti")
public class SelectSeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSeatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MemberId = request.getParameter("memberId");
		String mName = request.getParameter("mName");
		String rate = request.getParameter("movieAge");
		String selectedTheater = request.getParameter("selectedTheater");
		String auditoriumSeat = request.getParameter("AuditoriumSeat");
		String remainSeatString = request.getParameter("remainSeat"); // XX석
		int remainSeat = Integer.parseInt(remainSeatString.substring(0,remainSeatString.length()-1));
		// String movieDate = 2022.02.01 (화);
		String runSch = request.getParameter("runningTime");
		int runNo = Integer.parseInt(request.getParameter("runNo"));
		
		Ticket selected = new Ticket(MemberId, auditoriumSeat, selectedTheater, runNo, runSch, mName, rate, remainSeat);
		
		ArrayList<String> ssList = new TicketService().selectedSeat(runNo);
		
		// 좌석 행열 나누기
		ArrayList<String[]> selectedSeatList = new ArrayList<>();
		
		for(String s : ssList) {
			String[] sArr = s.split(" ");
			selectedSeatList.add(sArr);
		}

		request.setAttribute("selectedSeatList", selectedSeatList);
		request.setAttribute("selected", selected);
		request.getRequestDispatcher("/views/user/ticketing/selectSeat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
