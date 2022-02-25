package com.kh.member.contoller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.SHA256;
import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int memberNo  = Integer.parseInt(request.getParameter("deleteNo"));
		String memberPwd = request.getParameter("deletePwd");
		
		SHA256 sha256 = new SHA256();

		// SHA256으로 암호화된 비밀번호
		String pwdSHA = "";
		try {
			pwdSHA = sha256.encrypt(memberPwd);
			//System.out.println(pwdSHA);
			
			// 일치하는지 확인
			//System.out.println(pwdSHA.equals(sha256.encrypt(memberPwd)));
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		int result = new MemberService().deleteMember(memberNo, pwdSHA);
		
		if(result > 0) {
			request.getSession().invalidate();
			
			request.getSession().setAttribute("alertMsg", "탈퇴하셨습니다.");
			
			response.sendRedirect(request.getContextPath()+"/index.do");
		}else {
			response.sendRedirect(request.getContextPath()+"/index.do");
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
