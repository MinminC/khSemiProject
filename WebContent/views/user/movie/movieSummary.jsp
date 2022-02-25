<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.*" %>
<%
	Movie mv = (Movie)request.getAttribute("mv");
	ArrayList<Picture> picList = (ArrayList<Picture>)request.getAttribute("picList");
%>

	<!-- 해결해야하는 문제점
1. slide 이미지가 로딩 안되는 것 
2. 포스터와 텍스트가 엇갈리게 나오는것
3. 찜하기에 하트 제대로 넣기 -->

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>영화 요약</title>
		<link rel="stylesheet" href="resource/css/user/movie/movieList.css">
		<link rel="stylesheet" href="resource/css/user/movie/movieSummary.css">
		</style>
	</head>

	<body>
		<!-- movie-summary 전체 감싸는 영역-->
				<div id="demo" class="carousel slide height600" data-ride="carousel">

				<!-- 슬라이드 좌우 버튼 -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<% for(int i = 1; i<picList.size()-1; i++){ %>
						<li data-target="#demo" data-slide-to="<%= i %>"></li>
					<% } %>
				</ul>

				<!-- 슬라이드 영역 -->
				<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<%= contextPath %><%= picList.get(1).getFilePath()+picList.get(1).getChangeName() %>" alt="">
				</div>
				<% if (picList.size()>0){ %>
					<% for(int i = 2; i<picList.size(); i++){ %>
						<div class="carousel-item">
							<img src="<%= contextPath %><%= picList.get(i).getFilePath()+picList.get(i).getChangeName() %>" alt="">
						</div>
					<% } %>
				<% } %>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				<a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>

			</div>


			<!-- 영화 요약 정보 영역 -->
			<div class="movie-summary">
				<div id="movie-summary-poster">
					<img src="<%= contextPath %><%= picList.get(0).getFilePath()+picList.get(0).getChangeName() %>" alt="">
				</div>
				<div id="movie-summary-text">
					<br>
					<h3>(<%= mv.getRate()%>) <%=mv.getMovieName() %></h3>
					<ul>
						<li>
							<b>평&nbsp;&nbsp;&nbsp;&nbsp;점</b>
							<span><%= mv.getReviewAvg() %></span>
						</li>
						<li>
							<b>예매율</b>
							<span><%= mv.getAdvanceRate() %></span>
						</li>
					</ul>
					<hr>
					<ul>
						<li>
							<b>감&nbsp;&nbsp;&nbsp;&nbsp;독</b>
							<span><%= mv.getDirector() %></span>
						</li>
						<li>
							<b>재개봉</b>
							<span><%= mv.getReleaseDate() %></span>
						</li>
						<li>
							<b>장&nbsp;&nbsp;&nbsp;&nbsp;르</b>
							<span><%= mv.getGenre() %></span>
						</li>
					</ul>

					<!-- 버튼 영역 -->
					<!-- <div class="d-flex justify-content-end"> -->
					<div id="summary-btn">
						<a onclick="movieLike();" id="movieLike">
							<span>
							
								<% if(mv.getMyLike().equals("Y")){ %>
									♥
								<% }else{ %>
									♡
								<% } %>
							</span>
							<b><%= mv.getMovieLike() %></b>
						</a>
						<% if(mv.getStatus().equals("Y")){ %>
							<a href="<%=contextPath %>/MoView.ti?mName=<%= mv.getMovieName() %>" class="btn btn-danger">예매하기</a>
						<% } %>
					</div>
					<script>
						function movieLike(){
							if($('#movieLike>span').text().trim()=='♥'){
								isLike = "Y";
							}else{
								isLike = "N";
							}
							
							<% if(loginUser != null){ %>
								$.ajax({
									url: 'like.mo',
									data: {
										'mno': <%= mv.getMovieNo() %>,
										'isLike': isLike
									},
									success: function(result){
										if(result>0){
											if(isLike=='Y'){
												$('#movieLike>span').text('♡');
												$('#movieLike>b').text(Number($('#movieLike>b').text())-1);
											}else{
												$('#movieLike>span').text('♥');
												$('#movieLike>b').text(Number($('#movieLike>b').text())+1);
											}
										}else{
											alert('등록 실패');
										}
									},
									error: function(){
										alert('AJAX 실패');
									}
								})
							<% } %>
						}
					</script>
				</div>
			</div>
		</div>
		<br clear="all">
	</body>

	</html>