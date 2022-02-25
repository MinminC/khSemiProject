package com.kh.movie.model.vo;

import java.sql.Date;
import java.sql.Timestamp;//둘다 안쓰는것같은데 확인하고 지우기

public class Movie {
	private int movieNo;
	private String movieName;
	private String genre;
	private String director;
	private String actor;
	private int runtime;
	private String rate;
	private String synopsis;
	private String status;
	private String releaseDate;//재개봉일
	private double reviewAvg;
	private int movieLike;
	private double advanceRate;//예매율
	private String myLike;
	private String runDate;
	private int reviewCount;
	
	public Movie() {
		super();
	}
	
	public Movie(int movieNo, String movieName, String genre, String director, String actor, int runtime, String rate,
			String synopsis, String status) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
		this.runtime = runtime;
		this.rate = rate;
		this.synopsis = synopsis;
		this.status = status;
	}

	public Movie(int movieNo, String movieName, String genre, String director, String actor, int runtime, String rate,
			String synopsis, String status, double advanceRate) {
		super();
		this.movieNo = movieNo;
		this.movieName = movieName;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
		this.runtime = runtime;
		this.rate = rate;
		this.synopsis = synopsis;
		this.status = status;
		this.advanceRate = advanceRate;
	}


	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getReviewAvg() {
		return reviewAvg;
	}

	public void setReviewAvg(double reviewAvg) {
		this.reviewAvg = reviewAvg;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public double getAdvanceRate() {
		return advanceRate;
	}

	public void setAdvanceRate(double advanceRate) {
		this.advanceRate = advanceRate;
	}

	
	
	public int getMovieLike() {
		return movieLike;
	}

	public void setMovieLike(int movieLike) {
		this.movieLike = movieLike;
	}

	
	
	public String getMyLike() {
		return myLike;
	}

	public void setMyLike(String myLike) {
		this.myLike = myLike;
	}

	
	public String getRunDate() {
		return runDate;
	}

	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}

	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieName=" + movieName + ", genre=" + genre + ", director=" + director
				+ ", actor=" + actor + ", runtime=" + runtime + ", rate=" + rate + ", synopsis=" + synopsis
				+ ", status=" + status + ", releaseDate=" + releaseDate + ", reviewAvg=" + reviewAvg + ", movieLike="
				+ movieLike + ", advanceRate=" + advanceRate + ", myLike=" + myLike + "]";
	}

	
	
	
}
