package com.kh.theater.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Auditorium;
import com.kh.theater.model.vo.Theater;
import com.kh.theater.model.vo.TheaterAuditorium;

/**
 * Servlet implementation class AMovieTheaterListController
 */
@WebServlet("/atList.th")
public class AMovieTheaterListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AMovieTheaterListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 페이징 처리
				// 필요한 변수들
				int listCount;
				int currentPage;
				int pageLimit;
				int boardLimit;
				
				int maxPage;
				int startPage;
				int endPage;
				
				listCount = new TheaterService().selectListCount();
				
				currentPage = Integer.parseInt(request.getParameter("currentPage")); // "1"
				
				pageLimit = 10;
				
				boardLimit = 8;
				
				maxPage = (int)Math.ceil((double)listCount / boardLimit);
				
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
				endPage = startPage + pageLimit - 1;
				
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
				// 여기까지 총 7개의 변수 할당
				// 7개의 변수를 가지고 해당되는 범위에 따른 게시글 10개씩만 SELECT
				// Service단으로 7개의 변수 토스
				
				PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
						maxPage, startPage, endPage);
				
				ArrayList<Theater> theaterList = new TheaterService().aSelectList(pi);
				
				ArrayList<Auditorium> auditoriumList = new TheaterService().aSelectAuditorium(pi);
				
				request.getSession().setAttribute("theaterList", theaterList);
				request.getSession().setAttribute("auditoriumList", auditoriumList);

				request.setAttribute("pi", pi);
				
				request.getRequestDispatcher("views/admin/theater/aMovieTheaterList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
