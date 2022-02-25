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
 * Servlet implementation class MemberAdminUpdateController
 */
@WebServlet("/adminUpdate.me")
public class AjaxMemberAdminUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberAdminUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String beforeEmail = request.getParameter("beforeEmail");
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberName(memberName);
		m.setEmail(email);
		m.setPhone(phone);
		
		int result = 0;
		int checkResult =0 ;
		if(beforeEmail.equals(email)) {
			result = new MemberService().adminMemberUpdate(m);
		}else {
			
			checkResult = new MemberService().emailCheck(email);
			
			if(checkResult == 1) {
				result = 2;
			}else {
				result = new MemberService().adminMemberUpdate(m);
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
