package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;

/**
 * Servlet implementation class MovieMainListController
 */
@WebServlet("/list.mo")
public class MovieMainListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieMainListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재상영작
		int startRow = 1;
		int endRow = 5;
		ArrayList<Movie> currentList = new MovieService().selectCurrentList(1, 5);
		//해당하는 영화 번호 추출
		ArrayList<Integer> currentNoList = new ArrayList<>();
		for(Movie mv : currentList)
			currentNoList.add(mv.getMovieNo());
		//추출된 번호로 포스터 조회해오기
		ArrayList<Picture> currentPicList = new MovieService().selectPosterList(currentNoList);
			
				
				
		//추천상영작
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");//로그인 유저 조회
		ArrayList<Movie> recommendList = new ArrayList<>();
		String[] genres = null;
		//로그인한 유저가 아니면 랜덤 장르 하나 선택해오기
		//로그인한 유저는 장르 가져오기,선택한게 없다면 랜덤장르 하나
		if(loginUser != null && !loginUser.getInterest().equals("")) {
			String genre = "";
			genre = loginUser.getInterest();
			genres = genre.split(",");
		}
		else {
			//장르는 랜덤 1개인데 나중에 시간나면 테이블로 빼서 하나 선택해오도록->다른것들도 버튼같은거 다 이런식으로 조회해서 만드는것도 좋음
			//해당 부분 영화나 멤버의 VO객체에 넣어서 메소드로 호출하고 싶은데 어디넣을지
			String genre = "";
			int ranNum = (int)Math.ceil(Math.random()*12);
			switch(ranNum) {
				case 1: genre = "공포"; break;
				case 2: genre = "드라마"; break;
				case 3: genre = "미스터리"; break;
				case 4: genre = "범죄"; break;
				case 5: genre = "로맨스"; break;
				case 6: genre = "사극"; break;
				case 7: genre = "스릴러"; break;
				case 8: genre = "액션"; break;
				case 9: genre = "판타지"; break;
				case 10: genre = "코미디"; break;
				case 11: genre = "19세"; break;
				default: genre = "SF";
			}
			genres = new String[1];
			genres[0] = genre;
		}
		recommendList = new MovieService().selectRecommendList(genres, startRow, endRow);
		
		//영화 번호 받아서 넘기기
		ArrayList<Integer> recommendNoList = new ArrayList<>();
		ArrayList<Picture> recommendPicList = new ArrayList<>();
		if(recommendList.size()!=0) {
			for(Movie mv : recommendList)
				recommendNoList.add(mv.getMovieNo());
			
			//추출된 번호로 포스터 조회해오기
			recommendPicList = new MovieService().selectPosterList(recommendNoList);
		}
		request.setAttribute("currentList", currentList);
		request.setAttribute("currentPicList", currentPicList);
		request.setAttribute("genres", genres);
		request.setAttribute("recommendList", recommendList);
		request.setAttribute("recommendPicList", recommendPicList);
		
		request.getRequestDispatcher("views/user/movie/movieListMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
