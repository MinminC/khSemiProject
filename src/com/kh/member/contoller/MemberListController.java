package com.kh.member.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList.me")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		Member loginUser =(Member)request.getSession().getAttribute("loginUser");
		String memberId = loginUser.getMemberId();
		if(memberId.equals("admin") && loginUser != null) {
			int listCount = new MemberService().memberListCount(keyword);; //현재 일반게시판의 게시글 총 갯수  - > COUNT(*)
			int currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재페이지(사용자가 요청한 페이지)
			int pageLimit = 10; // 페이지 하단에 보여질 페이징바의 최대 갯수
			int boradLimit = 10; //한페이지에 보여질 최대 갯수
			
			int maxPage = (int)Math.ceil((double)listCount / boradLimit); //가장 마지막 페이지(총페이지 갯수)
			int startPage = (currentPage -1) / pageLimit * pageLimit + 1; // 첫번쨰 페이지
			int endPage = startPage + pageLimit - 1; // 마지막 페이지
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
			if(keyword == null || keyword == "") {
				keyword = "";
			}
			PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boradLimit, maxPage, startPage, endPage);
			
			ArrayList<Member> list = new MemberService().memberList(keyword, pi);
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/member/memberListPage.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.do").forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
