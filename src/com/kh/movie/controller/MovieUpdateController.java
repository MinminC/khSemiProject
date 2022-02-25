package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyfileRenamePolicy;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;
import com.kh.movie.model.vo.Schedule;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MovieUpdateController
 */
@WebServlet("/update.mo")
public class MovieUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (ServletFileUpload.isMultipartContent(request)) {
			String savePath = request.getSession().getServletContext().getRealPath("/resource/image/movie_upfiles/");
			int maxSize = 1024 * 1024 * 4;// 4MB 크기 제한
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyfileRenamePolicy());
			
			int movieNo = Integer.parseInt(multiRequest.getParameter("mno"));
			String movieName = multiRequest.getParameter("title");
			String director = multiRequest.getParameter("director");
			String rate = multiRequest.getParameter("rate");
			
			String genre = multiRequest.getParameter("genre");
			String actors = multiRequest.getParameter("actors");
			int runtime = Integer.parseInt(multiRequest.getParameter("runtime"));
			String synopsis = multiRequest.getParameter("synopsis");
			
			String picChange = multiRequest.getParameter("picChange");//사진 변경 여부
			
			Movie mv = new Movie();
			mv.setMovieNo(movieNo);
			mv.setMovieName(movieName);
			mv.setGenre(genre);
			mv.setDirector(director);
			mv.setActor(actors);
			mv.setRuntime(runtime);
			mv.setRate(rate);
			mv.setSynopsis(synopsis);
			
			ArrayList<Schedule> schedules = new ArrayList<>();
			String schParameter = "";
			if(!multiRequest.getParameter("schedules").equals("/")) {
				schParameter = multiRequest.getParameter("schedules");
				
				String[] schRows = schParameter.split(",");
				for(String s : schRows) {
					String[] schBundle = s.split("/");
					Schedule sch = new Schedule();
					sch.setAuditoriumNo(Integer.parseInt(schBundle[0]));
					String runsch = schBundle[1].replace("-","").replace("T","").replace(":", "");
					sch.setRunSch(runsch);
					
					schedules.add(sch);
				}
			}
			//재개봉일은 가장 처음 상영하는 날짜
			if(schedules.size() != 0) {
				mv.setStatus("Y");
				mv.setReleaseDate(schedules.get(0).getRunSch().substring(0,8));
			}
			else
				mv.setStatus("N");
			
			ArrayList<Picture> picList = new ArrayList<>();
			//파일 변경 없으면 실행하지 않음
			if(picChange.equals("Y")) {
				for (int i = 0; i < 5; i++) {
					String key = "pic"+i;
					if (multiRequest.getOriginalFileName(key) != null) {
						Picture pic = new Picture();
						pic.setOriginName(multiRequest.getOriginalFileName(key));
						pic.setChangeName(multiRequest.getFilesystemName(key));
						pic.setFilePath("/resource/image/movie_upfiles/");
						
						if(i == 0)
							pic.setFileLevel(1);
						else
							pic.setFileLevel(2);
						
						picList.add(pic);
					}
				}
			}
			
			int result = new MovieService().updateMovie(mv, schedules, picChange, picList);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "영화 수정에 성공했습니다.");
				response.sendRedirect(request.getContextPath()+"/adminList.mo");
			}
			else {
				request.getSession().setAttribute("alertMsg", "영화 수정에 실패했습니다.");
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
