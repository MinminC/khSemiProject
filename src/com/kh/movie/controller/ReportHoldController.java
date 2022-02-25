package com.kh.movie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/holdByReport.re")
public class ReportHoldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportHoldController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String list = request.getParameter("list");
		String[] holdList = list.split(",");
		
		int result = new MovieService().holdReportByReport(holdList);
	
		if(result>0) {//삭제 성공
			request.getSession().setAttribute("alertMsg", "리뷰신고 보류 처리 성공했습니다");
		}else {
			request.getSession().setAttribute("errorMsg", "리뷰신고 보류 처리  실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath()+"/reportList.re");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
