package com.kh.question.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyfileRenamePolicy;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.Q_Attachment;
import com.kh.question.model.vo.Question;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class QuestionInsertController
 */
@WebServlet("/insert.qu")
public class QuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST => 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		//  enctype이 multipart/form-data인 경우
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 사진 용량 정하기
			int maxSize = 1024 * 1024 * 50; // 5Mbyte
			
			// 저장할 서버 폴더 경로 정하기
			String savePath = request.getSession().getServletContext().getRealPath("/resource/image/question_upfiles/");
			
			// 파일명 수정 및 서버 업로드
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyfileRenamePolicy());
		
			// 값 뽑기
			// 타입 번호, 제목, 내용, 작성 회원 번호
			String Qtitle = multiRequest.getParameter("Qtitle");
			int Qtype = Integer.parseInt(multiRequest.getParameter("Qtype"));
			String Qcontent = multiRequest.getParameter("Qcontent");
			int memberNo = Integer.parseInt(multiRequest.getParameter("memberNo"));
			
			Question q = new Question();
			q.setAskTitle(Qtitle);
			q.setAskTypeNo(Qtype);
			q.setAskContent(Qcontent);
			q.setMemberNo(memberNo);
			
			// 사진 insert(첨부파일 있을 경우에만 insert)
			Q_Attachment at = null; 
			
			// 원본명, 수정파일명, 파일 경로
			// 첨부파일이 있을 경우
			if(multiRequest.getOriginalFileName("Qpic") != null) {
				// vo객체로 가공
				at = new Q_Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("Qpic")); // 원본명
				at.setChangeName(multiRequest.getFilesystemName("Qpic"));// 수정파일명
				at.setFilePath("/resource/image/question_upfiles/"); // 파일경로
			}
			
			// 서비스 요청
			int result = new QuestionService().insertQuestion(q, at);

			if(result > 0) { // 성공
				request.getSession().setAttribute("alertMsg", "게시글 작성 성공! 마이페이지 1:1문의로 이동합니다.");
				response.sendRedirect(request.getContextPath() + "/list.qu");
			} else { // 실패
				if(at != null) {
					// delete메소드 호출
					new File(savePath + at.getChangeName()).delete();
				}
				request.getSession().setAttribute("alertMsg", "게시글 작성 실패");
				request.getRequestDispatcher("/enroll-form.qu").forward(request, response);;
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
