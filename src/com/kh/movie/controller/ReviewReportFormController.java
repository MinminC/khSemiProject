package com.kh.movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.vo.Review;

/**
 * Servlet implementation class ReviewReportFormController
 */
@WebServlet("/reportForm.re")
public class ReviewReportFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReportFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String reviewWriter = request.getParameter("reviewWriter");
		String reviewContent = request.getParameter("reviewContent");//10자 추출
		
		Review re = new Review();
		re.setReviewNo(reviewNo);
		re.setReviewWriter(reviewWriter);
		re.setReviewContent(reviewContent);
		
		request.setAttribute("re", re);
		
		request.getRequestDispatcher("views/user/movie/movieReviewReport.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
