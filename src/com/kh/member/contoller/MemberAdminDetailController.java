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
 * Servlet implementation class MemberAdminDetailController
 */
@WebServlet("/adminDetail.me")
public class MemberAdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberAdminDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser =(Member)request.getSession().getAttribute("loginUser");
		String memberId = loginUser.getMemberId();
		if(memberId.equals("admin") && loginUser != null) {
			int MemberNo = Integer.parseInt(request.getParameter("memberNo"));
			
			Member m = new MemberService().adminDetail(MemberNo);
			request.setAttribute("m", m);
			request.getRequestDispatcher("views/admin/member/memberDetailPage.jsp").forward(request, response);
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
