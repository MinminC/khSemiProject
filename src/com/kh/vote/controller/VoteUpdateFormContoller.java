package com.kh.vote.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.vote.model.service.VoteService;
import com.kh.vote.model.vo.VoteList;

/**
 * Servlet implementation class VoteUpdateContoller
 */
@WebServlet("/voteUpdateForm.vot")
public class VoteUpdateFormContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteUpdateFormContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int voteNo = Integer.parseInt(request.getParameter("voteNo"));
		
		ArrayList<VoteList> list = new VoteService().selectVote(voteNo);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/admin/vote/voteUpdateManager.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
