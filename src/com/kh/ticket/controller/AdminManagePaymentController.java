package com.kh.ticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.ticket.model.service.TicketService;
import com.kh.ticket.model.vo.Ticket;

/**
 * Servlet implementation class AdminManagePaymentController
 */
@WebServlet("/adminManage.ti")
public class AdminManagePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManagePaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new TicketService().selectListCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage")); 
		pageLimit = 10;
		boardLimit = 10;
		
		PageInfo pi = new PageInfo().calcPageInfo(listCount, currentPage, pageLimit, boardLimit);

		ArrayList<Ticket> tlist = new TicketService().selectTicketList(pi);
		
		String typeCount = null;
		
		for(Ticket t: tlist) {
			for(Ticket ti: tlist) {
				
				String ticketType =  ti.getTicketType();
				int ticketCount = ti.getTicketCount();
				typeCount = ticketType + " X " + ticketCount;
				ti.setTypeCount(typeCount);
				
			}
		}
		
		request.setAttribute("tlist", tlist);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("/views/admin/ticket/paymentListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
