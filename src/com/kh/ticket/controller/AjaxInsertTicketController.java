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
 * Servlet implementation class AjaxInsertTicketController
 */
@WebServlet("/insert.ti")
public class AjaxInsertTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxInsertTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int runNo = Integer.parseInt(request.getParameter("runNo"));
		String ticketType = request.getParameter("ticketType");
		String selectedSeatList = request.getParameter("selectedSeat");
		String payment = request.getParameter("payMoney");
		
		// 좌석 문자열 나누기
		String[] sArr = selectedSeatList.split(", ");
				
		// SEAT_PK 받아오기
		ArrayList<Integer> seatPKList = new TicketService().selectSeatPK(runNo, sArr);		
		
		// SEAT_PK 가지고있는 ArrayList
		ArrayList<Ticket> ticketList = new ArrayList<>();
		for(int i : seatPKList) {
			Ticket t = new Ticket(payment, memberNo, ticketType, i, runNo);
			ticketList.add(t);
		}
		
		// ticket에 추가하기
		int result = new TicketService().insertTicket(ticketList);
		String str = null;
		if(result > 0) {
			str = "결제 성공!";
		}
		
		response.setContentType("text/html; charset=UTF-8"); 
		response.getWriter().print(str);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
