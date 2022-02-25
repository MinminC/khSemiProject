package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSearchController
 */
@WebServlet("/adminSearch.no")
public class NoticeAdminSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeAdminSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		int listCount = new NoticeService().countKeywordNotice(type, "%" + keyword + "%");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));

		int pageLimit = 10;
		int boardLimit = 5;
		
		PageInfo pi = new PageInfo().calcPageInfo(listCount, currentPage, pageLimit, boardLimit);
		ArrayList<Notice> list = new NoticeService().searchNoticeAdminList(type, "%" + keyword + "%", pi.getStartRow(), pi.getEndRow());

		request.setAttribute("type", type);
		request.setAttribute("pageType", "search");
		request.setAttribute("keyword", keyword);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin/notice/noticeListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
