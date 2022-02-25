package com.kh.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.Question;
import com.kh.question.model.vo.QuestionMethod;

/**
 * Servlet implementation class AdminListViewController
 */
@WebServlet("/adminList.qu")
public class AdminListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// -------페이징 처리-------
		// 필요한 변수들
		int listCount; // 현재 일반게시판의 게시글 총 갯수 => BOARD테이블로부터 조회 COUNT(*)활용
		int currentPage; // 현재페이지(사용자가 요청한 페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 갯수 => 10개
		int boardLimit; // 한 페이지에 보여질 게시글 최대 갯수 => 10개
				
		int maxPage; // 가장 마지막페이지가 몇번 페이지인지 (== 총페이지의 갯수)
		int startPage; // 페이지 하단에 보여질 첫번째 페이징바
		int endPage; // 페이지 하단에 보여질 마지막 페이징바
		
		// * listCount : 총 게시글 갯수
		listCount = new QuestionService().selectListCount();
		// * currentPage : 현재페이지(== 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage")); // : String
		// * pageLimit : 페이징바의 최대 갯수
		pageLimit = 10;
		// * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수
		boardLimit = 10;
		// * maxPage : 가장 마지막 페이지가 몇번 페이지 인지(총 페이지의 갯수)
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		// * startPage : 페이지 하단에 보여질 페이징바의 시작수
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		// * endPage : 페이지 하단에 보여질 페이징바의 끝 수
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		// 3) vo로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
									maxPage, startPage, endPage);
		
		// 전체데이터 받아오기
		ArrayList<Question> qlist = new QuestionService().questionlistAll(pi);
		
		// 답변여부 확인하기
		for(Question q : qlist) {
			String a = QuestionMethod.changeQType(q.getComment());
			q.setStatus(a);
		}
		
		// 값 가지고 보내기
		request.setAttribute("qlist", qlist);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/admin/question/questionListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
