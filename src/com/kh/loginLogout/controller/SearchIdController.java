package com.kh.loginLogout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.loginLogout.model.service.LoginService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchIdController
 */
@WebServlet("/sid.sch")
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String memberName = request.getParameter("memberName");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		Member m = new Member();
		
		m.setMemberName(memberName);
		m.setBirth(birth);
		m.setPhone(phone);
		m.setEmail(email);
		
		Member searchMem = new LoginService().searchId(m);
		
		if(searchMem != null) {
			
			request.setAttribute("searchMem", searchMem);
			
			request.getRequestDispatcher("views/user/loginLogout/searchId_successForm.jsp").forward(request, response);
			// 찾기 성공 페이지로 이동 -> 결과확인가능
			
		} else {
			
			request.getRequestDispatcher("views/user/loginLogout/searchId_failForm.jsp").forward(request, response);
			// 찾기 실패 페이지로 이동
			
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
