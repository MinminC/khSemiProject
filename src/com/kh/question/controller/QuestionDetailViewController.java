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
 * Servlet implementation class QuestionDetailView
 */
@WebServlet("/detail.qu")
public class QuestionDetailViewController extends HttpServlet implements QuestionMethod{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 뽑기
		int questionNo = Integer.parseInt(request.getParameter("qno"));
		// service로 보내기
		Question Qdetail = new QuestionService().selectQuestionDetail(questionNo);
		Q_Attachment Qat = new QuestionService().selectQAttachment(questionNo);
		
		// 값 바꿔주기
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
		request.getRequestDispatcher("views/user/question/questionDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
