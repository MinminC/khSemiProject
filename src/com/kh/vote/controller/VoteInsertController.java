package com.kh.vote.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyfileRenamePolicy;
import com.kh.vote.model.service.VoteService;
import com.kh.vote.model.vo.Vote;
import com.kh.vote.model.vo.VoteResult;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class VoteInsertController
 */
@WebServlet("/insert.vot")
public class VoteInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (ServletFileUpload.isMultipartContent(request)) {
			String savePath = request.getSession().getServletContext().getRealPath("/resource/image/vote_upfiles/");
			int maxSize = 1024 * 1024 * 4;// 4MB 크기 제한

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyfileRenamePolicy());
			String voteTitle = multiRequest.getParameter("voteTitle");
			String sDate = multiRequest.getParameter("sDate");
			String eDate  = multiRequest.getParameter("eDate");
	        Vote v = new Vote();
	        v.setsDate(java.sql.Date.valueOf(sDate));
	        v.seteDate(java.sql.Date.valueOf(eDate));
	        v.setVoteTitle(voteTitle);
			ArrayList<VoteResult> list = new ArrayList<VoteResult>();
			
			for(int i=1; i<=4; i++) {
				VoteResult vr = null;
				if(multiRequest.getOriginalFileName("file"+i) != null) {
					// 첨부파일이 있다면 VO객체로 가공
					vr = new VoteResult();
					
					// 수정파일명 알아오기 : 실제 서버에 업로드된 파일의 이름을 리턴해주는 메소드
					// multiRequest.getFilesystemName("키값");
					vr.setVreFilePath("/resource/image/vote_upfiles/" + multiRequest.getFilesystemName("file"+i)); // 수정파일명
					vr.setVreTitle(multiRequest.getParameter("vreTitle"+i));
					vr.setVreGenre(multiRequest.getParameter("vreGenre"+i));
					vr.setVreSynopsis(multiRequest.getParameter("synopsis"+i));
					list.add(vr);
				}
			}
			int result = new VoteService().voteInsert(v, list);
			if(result >0 ) {
				request.getSession().setAttribute("alertMsg", "등록 성공.");
				response.sendRedirect(request.getContextPath()+"/manage.vot1");
			}
			else {
				request.getSession().setAttribute("alertMsg", "투표 등록 실패");
				request.getRequestDispatcher("/views/user/common/errorPage.jsp").forward(request, response);
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
