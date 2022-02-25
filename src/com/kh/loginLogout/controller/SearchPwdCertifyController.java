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
 * Servlet implementation class SearchPwdCertifyController
 */
@WebServlet("/spwdcerti.sch")
public class SearchPwdCertifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdCertifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String email = request.getParameter("email");
		
		Member searchMem = new LoginService().pwdCertify(memberId, email);
		
		if(searchMem != null) {
			
			request.setAttribute("searchMem", searchMem);
			
			request.getRequestDispatcher("views/user/loginLogout/searchPwd_imsyPwd.jsp").forward(request, response);
			// 임시비밀번호 발급 페이지로 잘 이동
		} else {
			
			request.getRequestDispatcher("views/user/loginLogout/searchPwd_failCertifyForm.jsp").forward(request, response);
			// 인증실패 페이지로 잘 이동
			
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
