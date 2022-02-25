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
@WebServlet("/deleteByReport.re")
public class ReportDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteReview = request.getParameter("deleteReview");
		String updateReport = request.getParameter("updateReport");
		String[] deleteReviewList = deleteReview.split(",");//리뷰 번호
		String[] updateReportList = updateReport.split(",");//리포트 번호
		for(String str:deleteReviewList)
			for(String stt:updateReportList)
				System.out.println(str+":"+stt);
		int result = new MovieService().deleteReviewByReport(deleteReviewList, updateReportList);
		
		if(result>0) {//삭제 성공
			request.getSession().setAttribute("alertMsg", "리뷰 숨김처리 성공했습니다");
		}else {
			request.getSession().setAttribute("errorMsg", "리뷰 숨김처리  실패했습니다.");
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
