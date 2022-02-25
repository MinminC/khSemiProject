package com.kh.member.contoller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.MailSend;
import com.kh.common.SHA256;
import com.kh.loginLogout.model.service.LoginService;

/**
 * Servlet implementation class AjaxTemporaryEmailController
 */
@WebServlet("/tempMail.me")
public class AjaxTemporaryEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxTemporaryEmailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String email = request.getParameter("email");	
		
		
		int len = 16; // 임시비밀번호 길이
		char[] charSet = new char[] { '1', '2', '3', '4', '5', '6', '7', '8',
									  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
									  'L', 'N', 'U', 'P', 'Q', 'R', 'S', 'T',
									  '!', '@', '#', '$', '%', '^', '*'}; // 임시비밀번호에 들어갈 수 있는 문자들
			
		int idx = 0; 
			
		StringBuffer sb = new StringBuffer(); 
			
			
		for (int i = 0; i < len; i++) { 
				
			idx = (int) (charSet.length * Math.random()); // 랜덤으로 들어갈 문자의 인덱스 생성
				
//			System.out.println("idx :::: "+idx); // 랜덤으로 생성되는 문자 확인
				
			sb.append(charSet[idx]); // 랜덤으로 생성된 문자를 문자열끝에 추가
		} 
			
		String imsyPwd = sb.toString();
//		System.out.println(sb); // 완성된 임시비밀번호 확인
		
		// 임시비밀번호 생성 완료
		// => 이메일에 임시비밀번호 담아서 보내기
		
		int num = 2; // 인증번호는 1, 임시비밀번호는 2로 고정해서 넘기기
		
		MailSend ms = new MailSend();
		
		ms.welcomeMailSend(email, imsyPwd, num);
		
		SHA256 sha256 = new SHA256();
		
		String changedPwd = null;
		
		try {
			changedPwd = sha256.encrypt(imsyPwd);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(imsyPwd);
		// 임시비밀번호 DB에 저장
		int result = new LoginService().updateImsyPwd(memberId, changedPwd);
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(result);

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
