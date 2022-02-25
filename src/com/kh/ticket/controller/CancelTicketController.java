package com.kh.ticket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ticket.model.service.TicketService;

/**
 * Servlet implementation class CancelTicketController
 */
@WebServlet("/cancel.ti")
public class CancelTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 회원번호 받아오기
		// int memberNo = Integer.parseInt(request.getSession().getAttribute("memberNo"));
		int memberNo = 2;
		int payNo = Integer.parseInt(request.getParameter("payNo"));
		
		int result = new TicketService().cancelTicket(memberNo, payNo);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
