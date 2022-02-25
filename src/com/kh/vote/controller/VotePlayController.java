package com.kh.vote.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.vote.model.service.VoteService;
import com.kh.vote.model.vo.VoteList;

/**
 * Servlet implementation class VotePlayController
 */
@WebServlet("/list.vot")
public class VotePlayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotePlayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<VoteList> list = new VoteService().voting();
		Member loginUser = ((Member)request.getSession().getAttribute("loginUser"));
		if(loginUser == null) {
			request.getSession().setAttribute("alertMsg", "로그인 후 이용해주세요.");
			request.getRequestDispatcher("index.do").forward(request, response);
		}else {
			
			int memberNo = loginUser.getMemberNo();
			int vreNo = new VoteService().selectVotingMember(memberNo);
			request.setAttribute("vreNo", vreNo);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/user/vote/votePage.jsp").forward(request, response);
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
