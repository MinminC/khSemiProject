package com.kh.loginLogout.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.SHA256;
import com.kh.loginLogout.model.service.LoginService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.log")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		SHA256 sha256 = new SHA256();
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		String changedPwd = null;
		
		try {
			changedPwd = sha256.encrypt(memberPwd);
			
//			System.out.println(memberPwd); // 입력된 비밀번호 확인
			
//			System.out.println(changedPwd.equals(sha256.encrypt(memberPwd))); // 암호화된 비밀번호화 일치하는지 확인
			
//			System.out.println(changedPwd);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		Member loginUser = new LoginService().selectMember(memberId, changedPwd);
		
		if(loginUser != null && loginUser.getMemberId().equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			request.getRequestDispatcher("memberList.me?currentPage=1").forward(request, response);
			// 관리자 아이디로 로그인 시 관리자페이지 첫메뉴바인 회원관리페이지로 보내기
			
		}else if(loginUser != null){
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser); 
			
			session.setAttribute("alertMsg", "로그인하셨습니다.");
			
			response.sendRedirect("/cinemaHeaven/index.do");
			// 로그인정보, 경고메세지들고 메인페이지로 이동
			
//			PrintWriter out = response.getWriter();
//			out.print("<script>");
//			out.print("location.href='<%= contextPath%>/index.do'");
//			out.print("history.go(-3)");
//			out.print("</script>");
			
		}else {
			
			request.getSession().setAttribute("alertMsg", "다시 로그인하세요.");
			
			response.sendRedirect(request.getContextPath()+"/loginForm.log");
			// 경고메세지들고 다시 로그인폼으로 이동
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
