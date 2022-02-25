package com.kh.movie.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;
import com.kh.movie.model.vo.Picture;
import com.kh.movie.model.vo.Report;
import com.kh.movie.model.vo.Review;
import com.kh.movie.model.vo.Schedule;
import com.kh.theater.model.vo.Auditorium;

import static com.kh.common.JDBCTemplate.*;

public class MovieService {

	/**
	 * 영화 현재 상영작 Service
	 * 
	 * @param sCount
	 * @param eCount
	 * @return
	 */
	public ArrayList<Movie> selectCurrentList(int sCount, int eCount) {
		Connection conn = getConnection();

		ArrayList<Movie> list = new MovieDao().selectCurrentList(conn, sCount, eCount);

		close(conn);

		return list;
	}

	/**
	 * 영화 하나에 대한 정보 + 시놉시스 + 배우 Service
	 * 
	 * @param movieNo
	 * @return
	 */
	public Movie selectMovieDetail(int movieNo, int memberNo) {
		Connection conn = getConnection();

		Movie mv = new MovieDao().selectMovieDetail(conn, movieNo, memberNo);

		close(conn);

		return mv;
	}

	/**
	 * 리뷰 페이지 용, 영화 하나에 대한 정보
	 * 
	 * @param movieNo
	 * @return
	 */
	public Movie selectMovieSummary(int movieNo, int memberNo) {
		Connection conn = getConnection();

		Movie mv = new MovieDao().selectMovieSummary(conn, movieNo, memberNo);

		close(conn);
		
		return mv;
	}

	/**
	 * 리뷰 리스트 상위 10개 Service
	 * 
	 * @param movieNo
	 * @return
	 */
	public ArrayList<Review> selectReviewList(int movieNo, int memberNo, int sCount, int eCount) {
		Connection conn = getConnection();

		ArrayList<Review> list = new MovieDao().selectReviewList(conn, movieNo, memberNo, sCount, eCount);

		close(conn);

		return list;
	}

	/**
	 * 영화 하나에 대한 picture들 조회
	 * 
	 * @param movieNo
	 * @return
	 */
	public ArrayList<Picture> selectPicture(int movieNo) {
		Connection conn = getConnection();

		ArrayList<Picture> list = new MovieDao().selectPicture(conn, movieNo);

		close(conn);

		return list;
	}

	/**
	 * 영화 리스트에 뿌릴 포스터들 조회
	 * 
	 * @param movieNoList
	 * @return
	 */
	public ArrayList<Picture> selectPosterList(ArrayList<Integer> movieNoList) {
		Connection conn = getConnection();

		ArrayList<Picture> list = new MovieDao().selectPosterList(conn, movieNoList);

		close(conn);

		return list;
	}

	public int insertReview(Review re) {
		Connection conn = getConnection();

		int result = new MovieDao().insertReview(conn, re);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int deleteReviewLike(int memberNo, int reviewNo) {
		Connection conn = getConnection();

		int result = new MovieDao().deleteReviewLike(conn, memberNo, reviewNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int insertReviewLike(int memberNo, int reviewNo) {
		Connection conn = getConnection();

		int result = new MovieDao().insertReviewLike(conn, memberNo, reviewNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int deleteMovieLike(int movieNo, int memberNo) {
		Connection conn = getConnection();

		int result = new MovieDao().deleteMovieLike(conn, movieNo, memberNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int insertMovieLike(int movieNo, int memberNo) {
		Connection conn = getConnection();

		int result = new MovieDao().insertMovieLike(conn, movieNo, memberNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();

		int result = new MovieDao().deleteReview(conn, reviewNo);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int reportReview(int reviewNo, int reportReason) {
		Connection conn = getConnection();

		int result = new MovieDao().reportReview(conn, reviewNo, reportReason);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int countReport() {
		Connection conn = getConnection();

		int count = new MovieDao().countReport(conn);

		close(conn);

		return count;
	}

	public ArrayList<Report> selectReportList(int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Report> list = new MovieDao().selectReportList(conn, startRow, endRow);

		close(conn);

		return list;
	}

	public int deleteReviewByReport(String[] deleteReviewList, String[] updateReportList) {
		Connection conn = getConnection();

		int deleteReview = new MovieDao().deleteReviewByReport(conn, deleteReviewList);
		int processReport = 0;

		int result = 0;

		if (deleteReview == deleteReviewList.length) {
			processReport = new MovieDao().processReport(conn, updateReportList);
			if (processReport == updateReportList.length) {
				commit(conn);
				result = 1;
			}
		} else
			rollback(conn);

		return result;
	}

	public int holdReportByReport(String[] holdList) {
		Connection conn = getConnection();
		int result = 0;
		int rows = new MovieDao().holdReviewByReport(conn, holdList);

		if (rows == holdList.length) {
			commit(conn);
			result = 1;
		} else
			rollback(conn);

		return result;
	}

	public int countAllMovie() {
		Connection conn = getConnection();

		int count = new MovieDao().countAllMovie(conn);

		close(conn);

		return count;
	}

	public ArrayList<Movie> selectMovieAdminList(int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Movie> list = new MovieDao().selectMovieAdminList(conn, startRow, endRow);

		close(conn);

		return list;
	}

	public int deleteMovie(String[] deleteList) {
		Connection conn = getConnection();
		int result = 0;
		int rows = new MovieDao().deleteMovie(conn, deleteList);

		if (rows == deleteList.length) {
			commit(conn);
			result = 1;
		} else
			rollback(conn);
		
		return result;
	}

	public int insertMovie(Movie mv, ArrayList<Schedule> schedules, ArrayList<Picture> picList) {
		Connection conn = getConnection();
		
		int result = 0;
		int insertMovie = 0;
		int insertSchedule = 1;
		int insertPicture = 0;
		
		if(mv.getStatus().equals("Y")) {//영화가 개봉하는 경우
			insertMovie = new MovieDao().insertMovie(conn, mv);
			insertSchedule = new MovieDao().insertSchedule(conn, schedules);
			
		}else {
			insertMovie = new MovieDao().insertMovieNotRelease(conn, mv);
		}
		
		insertPicture = new MovieDao().insertPicture(conn, picList);
		
		result = insertMovie*insertSchedule*insertPicture;
		
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	/**
	 * 안쓸것같음 나중에 확인
	 * @param genre
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public ArrayList<Movie> selectRecommendOne(String genre, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Movie> list = new MovieDao().selectRecommendOne(conn, genre, startRow, endRow);

		close(conn);

		return list;
	}

	public ArrayList<Movie> selectRecommendList(String[] genres, int startRow, int endRow) {
		Connection conn = getConnection();
		
		ArrayList<Movie> list = new ArrayList<>();
		switch(genres.length) {
			case 3: list = new MovieDao().selectRecommendThree(conn, genres, startRow, endRow);break;
			case 2: list = new MovieDao().selectRecommendTwo(conn, genres, startRow, endRow);break;
			case 1: 
				String genre = genres[0];
				list = new MovieDao().selectRecommendOne(conn, genre, startRow, endRow);
		}

		close(conn);

		return list;
	}

	public int countCurrentMovie() {
		Connection conn = getConnection();

		int count = new MovieDao().countCurrentMovie(conn);

		close(conn);

		return count;
	}

	public int countRecommendMovie(String[] genres) {
		Connection conn = getConnection();

		int count = 0;
		switch(genres.length) {
			case 3: count = new MovieDao().countRecommendThree(conn, genres);break;
			case 2: count = new MovieDao().countRecommendTwo(conn, genres);break;
			case 1: count = new MovieDao().countRecommendOne(conn, genres); break;
		}
		
		close(conn);

		return count;
	}

	public ArrayList<Auditorium> selectAuditoriumList() {
		Connection conn = getConnection();

		ArrayList<Auditorium> list = new MovieDao().selectAuditoriumList(conn);

		close(conn);

		return list;
	}

	public Movie selectOneMovie(int movieNo) {
		Connection conn = getConnection();

		Movie mv = new MovieDao().selectOneMovie(conn, movieNo);

		close(conn);

		return mv;
	}

	public ArrayList<Schedule> selectOneSchedule(int movieNo) {
		Connection conn = getConnection();

		ArrayList<Schedule> list = new MovieDao().selectOneSchedule(conn, movieNo);

		close(conn);

		return list;
	}

	public int updateMovie(Movie mv, ArrayList<Schedule> schedules, String picChange, ArrayList<Picture> picList) {
		Connection conn = getConnection();
		
		int result = 0;
		int updateMovie = 0;
		int updateSchedule = 1;
		int updatePicture = 1;
		int deleteSchedule = 0;
		int deletePicture = 0;
		
		if(mv.getReleaseDate() == null)
			updateMovie = new MovieDao().updateMovieNotRelease(conn, mv);
		else
			updateMovie = new MovieDao().updateMovie(conn, mv);
		
		deleteSchedule = new MovieDao().deleteSchedule(conn, mv.getMovieNo());
		if(schedules.size()>0)
			updateSchedule = new MovieDao().updateSchedule(conn, schedules, mv.getMovieNo());
		
		if(picChange.equals("Y")) {
			deletePicture = new MovieDao().deletePicture(conn, mv.getMovieNo());
			if(deletePicture>0)
				updatePicture = new MovieDao().updatePicture(conn, picList, mv.getMovieNo());
		}
		
		result = updateMovie*updateSchedule*updatePicture;
		
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public double[] countReview(int movieNo) {
		Connection conn = getConnection();

		double[] countReview = new MovieDao().countReview(conn, movieNo);

		close(conn);

		return countReview;
	}

	public ArrayList<Movie> selectRecommendList(String[] genres) {
		Connection conn = getConnection();

		ArrayList<Movie> list = new ArrayList<>();
		switch(genres.length) {
		case 3: list = new MovieDao().selectRecommendThreeAll(conn, genres);break;
		case 2: list = new MovieDao().selectRecommendTwoAll(conn, genres);break;
		case 1: 
			String genre = genres[0];
			list = new MovieDao().selectRecommendOneAll(conn, genre);
	}

		close(conn);

		return list;
	}

	public ArrayList<Picture> selectPosterList(String[] recommendNo) {
		Connection conn = getConnection();

		ArrayList<Picture> list = new MovieDao().selectPosterList(conn, recommendNo);

		close(conn);

		return list;
	}

	public int countMovieByKeyword(String keyword) {
		Connection conn = getConnection();

		int count = new MovieDao().countMovieByKeyword(conn, keyword);

		close(conn);

		return count;
	}

	public ArrayList<Movie> searchMovieByKeyword(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();

		ArrayList<Movie> list = new MovieDao().searchMovieByKeyword(conn, keyword, startRow, endRow);

		close(conn);

		return list;
	}

}
