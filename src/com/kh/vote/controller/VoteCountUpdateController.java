package com.kh.vote.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.vote.model.service.VoteService;

/**
 * Servlet implementation class VoteCountUpdateController
 */
@WebServlet("/voteCount.vot")
public class VoteCountUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteCountUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int vreNo = Integer.parseInt(request.getParameter("vreNo"));
		Member loginUser = ((Member)request.getSession().getAttribute("loginUser"));
		if(loginUser == null) {
			request.getSession().setAttribute("alertMsg", "로그인 후 이용해주세요.");
			request.getRequestDispatcher("index.do").forward(request, response);
		}else {
			int memberNo = loginUser.getMemberNo();
			int result = new VoteService().countUpdate(vreNo, memberNo);
			if(result > 0) {
				request.getRequestDispatcher("/vote.re?vreNo="+vreNo).forward(request, response);
			}
			
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
