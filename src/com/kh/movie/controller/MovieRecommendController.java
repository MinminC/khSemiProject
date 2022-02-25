package com.kh.movie.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;

/**
 * Servlet implementation class MovieRecommendController
 */
@WebServlet("/recommendList.mo")
public class MovieRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRecommendController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");//로그인 유저 조회
		int currentPage = 1;
		if(request.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		
		int pageLimit = 10;
		int boardLimit = 5;
		
		
		ArrayList<Movie> recommendList = new ArrayList<>();
		String[] genres;
		//로그인한 유저가 아니면 랜덤 장르 하나 선택해오기
		//로그인한 유저는 장르 가져오기,선택한게 없다면 랜덤장르 하나
		if(loginUser != null && !loginUser.getInterest().equals("")) {
			String genre = "";
			genre = loginUser.getInterest();
			genres = genre.split(",");
		}
		else {
			//장르는 랜덤 1개인데 나중에 시간나면 테이블로 빼서 하나 선택해오도록->다른것들도 버튼같은거 다 이런식으로 조회해서 만드는것도 좋음
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
			//recommendList = new MovieService().selectRecommendOne(genre, pi.getStartRow(), pi.getEndRow());
			genres = new String[1];
			genres[0] = genre;
		}
		
		
		int listCount= new MovieService().countRecommendMovie(genres);
		PageInfo pi = new PageInfo().calcPageInfo(listCount, currentPage, pageLimit, boardLimit);
		recommendList = new MovieService().selectRecommendList(genres, pi.getStartRow(), pi.getEndRow());
		
		
		ArrayList<Integer> movieNoList = new ArrayList<>();
		ArrayList<Picture> picList = new ArrayList<>();
		if(recommendList.size()!=0) {
			for(Movie mv : recommendList)
				movieNoList.add(mv.getMovieNo());
			
			//추출된 번호로 포스터 조회해오기
			picList = new MovieService().selectPosterList(movieNoList);
		}
		request.setAttribute("pi", pi);
		request.setAttribute("genres", genres);
		request.setAttribute("recommendList", recommendList);
		request.setAttribute("picList", picList);
		
		request.getRequestDispatcher("views/user/movie/movieListRecommend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
