<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>영화 상세 정보</title>
	</head>

	<body>
		<!--header-->
		<%@ include file="../common/header.jsp" %>
			<div id="container">
				
				<!--영화 정보 상단 -->
				<%@ include file="movieSummary.jsp" %>
				<% String[] actorList = (String[])request.getAttribute("actorList"); %>
					<br clear="all">
					<!-- 영화정보/평점 및 리뷰 버튼 영역 -->
					<div class="movie-body">
					
						<div class="movie-toggle">
							<a href="<%= contextPath %>/detail.mo?mno=<%= mv.getMovieNo() %>" class="movie-menu-half movie-active-menu">영화 정보</a><a
							href="<%= contextPath %>/review.mo?mno=<%= mv.getMovieNo() %>" class="movie-menu-half">평점 및 리뷰 </a>
						</div>
						
						<br>

						<!-- 영화 정보 영역 -->
						<div class="movie-detail">
							<div class="synopsis">
								<h4>시놉시스</h4>
								<p><%= mv.getSynopsis() %></p>
							</div>
							<hr>
							<div class="actor">
								<h4>등장인물</h4>
								<ul>
								<% for(String s : actorList){ %>
									<li><%= s %></li>
								<% } %>
								</ul>
							</div>
						</div>
					</div>
			</div>
			<!--footer-->
			<%@ include file="../common/footer.jsp" %>
	</body>

	</html>