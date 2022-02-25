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
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateContoller
 */
@WebServlet("/update.me")
public class MemberUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));

		Member beforeM = new MemberService().memberDetail(memberNo);
		String memberPwd = request.getParameter("memberPwd2");
		// SHA256으로 암호화된 비밀번호
		String pwdSHA = "";
		if (memberPwd == null || memberPwd == "") {
			pwdSHA = beforeM.getMemberPwd();
		} else {
			SHA256 sha256 = new SHA256();
			try {
				pwdSHA = sha256.encrypt(memberPwd);
				// System.out.println(pwdSHA);
				// 일치하는지 확인
				// System.out.println(pwdSHA.equals(sha256.encrypt(memberPwd)));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		String memberName = request.getParameter("memberName");
		String birth = request.getParameter("yyyy") + "-" + request.getParameter("mm") + "-"
				+ request.getParameter("dd");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String interestArr[] = request.getParameterValues("interest");
		String interest = "";
		if (interestArr != null) {
			interest = String.join(",", interestArr);
		}

		Member m = new Member();
		m.setMemberNo(memberNo);
		m.setMemberPwd(pwdSHA);
		m.setMemberName(memberName);
		m.setBirth(birth);
		m.setGender(gender);
		m.setEmail(email);
		m.setPhone(phone);
		m.setInterest(interest);

		int result = new MemberService().memberUpdate(m);
		if (result > 0) {
			Member afterM = new MemberService().memberDetail(memberNo);
			request.setAttribute("m", afterM);
			request.getRequestDispatcher("views/user/mypage/memberDetail.jsp").forward(request, response);
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
