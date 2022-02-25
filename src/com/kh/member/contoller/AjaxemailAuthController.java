package com.kh.member.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.common.MailSend;
import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxemailAuthController
 */
@WebServlet("/emailAuth.me")
public class AjaxemailAuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxemailAuthController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		int result = new MemberService().emailCheck(email); 
		
		
		if(result == 1) {
			response.setContentType("application/json; charset=UTF-8");
			int check = result;
			JSONObject jObj = new JSONObject();
			jObj.put("check" , check);
			response.getWriter().print(jObj);
			
		}else {
			int check = result;
			
			MailSend ms = new MailSend();
			
			int authNumber = (int)(Math.random() * 899998)+100000;
			ms.welcomeMailSend(email, authNumber, 1);
			
			response.setContentType("application/json; charset=UTF-8");
			JSONObject jObj = new JSONObject();
			jObj.put("check" , check);
			jObj.put("authNumber" , authNumber);
			
			response.getWriter().print(jObj);
			
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
