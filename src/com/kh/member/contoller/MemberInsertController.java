package com.kh.member.contoller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.SHA256;
import com.kh.member.model.vo.Member;
import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 가공
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		SHA256 sha256 = new SHA256();

		// SHA256으로 암호화된 비밀번호
		String pwdSHA = "";
		try {
			pwdSHA = sha256.encrypt(memberPwd);
			System.out.println(pwdSHA);
			
			// 일치하는지 확인
			System.out.println(pwdSHA.equals(sha256.encrypt(memberPwd)));
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}

		String memberName = request.getParameter("memberName");
		String birth = request.getParameter("yyyy") + "-" + request.getParameter("mm") + "-" + request.getParameter("dd");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String interestArr[] = request.getParameterValues("interest");
		String interest = "";
		if (interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = new Member();
		
		m.setMemberId(memberId);
		m.setMemberPwd(pwdSHA);
		m.setMemberName(memberName);
		m.setBirth(birth);
		m.setGender(gender);
		m.setEmail(email);
		m.setPhone(phone);
		m.setInterest(interest);
		System.out.println(m);
		
		
		//서비스 호출
		int result = new MemberService().memberInsert(m);
		
		if(result > 0 ) {
			// 메인페이지로 보내기
			response.sendRedirect(request.getContextPath()+"/index.do");
		}else {
			System.out.println("실패 ?? 와이 ?? ");
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
