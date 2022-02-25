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
 * Servlet implementation class VoteUpdateController
 */
@WebServlet("/voteUpdate.vot")
public class VoteUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteUpdateController() {
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
			int voteNo = Integer.parseInt(multiRequest.getParameter("voteNo"));
			String voteTitle = multiRequest.getParameter("voteTitle");
			String sDate = multiRequest.getParameter("sDate");
			String eDate  = multiRequest.getParameter("eDate");
	        Vote v = new Vote();
	        v.setVoteNo(voteNo);
	        v.setsDate(java.sql.Date.valueOf(sDate));
	        v.seteDate(java.sql.Date.valueOf(eDate));
	        v.setVoteTitle(voteTitle);
			ArrayList<VoteResult> list = new ArrayList<VoteResult>();
			
			for(int i=1; i<=4; i++) {
				VoteResult vr = new VoteResult();
				vr.setVreNo(Integer.parseInt(multiRequest.getParameter("vreNo"+i)));
				vr.setVreTitle(multiRequest.getParameter("vreTitle"+i));
				vr.setVreGenre(multiRequest.getParameter("vreGenre"+i));
				vr.setVreSynopsis(multiRequest.getParameter("synopsis"+i));
				if(multiRequest.getOriginalFileName("file"+i) != null) {
					vr.setVreFilePath("/resource/image/vote_upfiles/" + multiRequest.getFilesystemName("file"+i)); // 수정파일명
				}else {
					vr.setVreFilePath(multiRequest.getParameter("filePath"+i));
				}
				list.add(vr);
			}
			
			int result = new VoteService().voteUpdate(v, list);
			if (result > 0) {
				request.getSession().setAttribute("alertMsg", "수정 성공.");
				response.sendRedirect(request.getContextPath() + "/manage.vot1");
			} else {
				request.getSession().setAttribute("alertMsg", "투표 수정 실패");
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
