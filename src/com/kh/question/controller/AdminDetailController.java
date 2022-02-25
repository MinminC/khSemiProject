package com.kh.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.Q_Attachment;
import com.kh.question.model.vo.Question;
import com.kh.question.model.vo.QuestionMethod;

/**
 * Servlet implementation class AdminDetailController
 */
@WebServlet("/adminDetail.qu")
public class AdminDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		System.out.println("??");
		Question Qdetail = new QuestionService().selectQuestionDetail(qno);
		Q_Attachment Qat = new QuestionService().selectQAttachment(qno);
		
		String qtxt = QuestionMethod.changeQType(Qdetail.getAskTypeNo());
		Qdetail.setAskTypeTxt(qtxt);
		String status = QuestionMethod.changeQType(Qdetail.getComment());
		Qdetail.setStatus(status);
		if(Qdetail.getComment() == null) {
			Qdetail.setComment("");
		}
		
		//값 가지고 보내기
		request.setAttribute("Qdetail", Qdetail);
		request.setAttribute("Qat", Qat);
		request.getRequestDispatcher("/views/admin/question/questionDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
