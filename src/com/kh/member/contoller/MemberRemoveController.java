package com.kh.member.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberRemoveController
 */
@WebServlet("/remove.me")
public class MemberRemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberRemoveController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Member loginUser =(Member)request.getSession().getAttribute("loginUser");
		String memberId = loginUser.getMemberId();
		if(memberId.equals("admin") && loginUser != null) {
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));

			int result = new MemberService().MemberRemove(memberNo);
			if (result > 0) {
				request.setAttribute("msg", "복구 성공");
				request.getRequestDispatcher("/memberList.me?currentPage=1").forward(request, response);
			} else {
				request.setAttribute("msg", "복구 실패 다시 시도");
				request.getRequestDispatcher("/memberList.me?currentPage=1").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("index.do").forward(request, response);
		}
		
		
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
