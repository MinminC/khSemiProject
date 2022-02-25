<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.Movie, com.kh.movie.model.vo.Picture" %>
<%
	ArrayList<Movie> currentList = (ArrayList<Movie>)request.getAttribute("currentList");
	ArrayList<Picture> currentPicList = (ArrayList<Picture>)request.getAttribute("currentPicList");
	String[] genres = (String[])request.getAttribute("genres");
	ArrayList<Movie> recommendList = (ArrayList<Movie>)request.getAttribute("recommendList");
	ArrayList<Picture> recommendPicList = (ArrayList<Picture>)request.getAttribute("recommendPicList");
%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>영화 목록 메인</title>
		<link rel="stylesheet" href="resource/css/user/movie/movieList.css">
    </head>

    <body>
        <!--header-->
        <%@ include file="../common/header.jsp" %>
            <div id="container">
				<div>
					<h3 class="headline">현재상영작</h3>
					<a href="<%= contextPath %>/currentList.mo">더보기</a>
					<br clear="both">
					<!-- 현재상영작 목록 -->
					<div class="movie-list">
					<% if(currentList == null){ %>
							영화가 존재하지 않습니다.
					<% }else{ %>
						<% for(int i = 0; i < currentList.size();i++){ %>
							<div class="movie-one">
								<img src="<%=contextPath %><%= currentPicList.get(i).getFilePath()+currentPicList.get(i).getChangeName() %>" alt="" class="movie-poster">
								<!-- 바로 전 요소에 마우스 오버하면 나오는 영역 -->
								<div class="poster-button">
									<br>
									<a href="<%=contextPath %>/MoView.ti?mName=<%= currentList.get(i).getMovieName() %>" class="btn btn-light">예매하기</a><br><br>
									<a href="<%=contextPath %>/detail.mo?mno=<%= currentList.get(i).getMovieNo() %>" class="btn btn-light">상세정보</a>
								</div>
								<ul>
									<li>
										<span><%= currentList.get(i).getMovieName() %></span>
									</li>
									<li>
										<span>예매율</span>
										<em><%= currentList.get(i).getAdvanceRate()  %></em>
									</li>
								</ul>
							</div>
						<% } %>   
					<% } %>   
					</div>
				</div>
				<hr>
				<div>
	                <h3 class="headline">추천상영작</h3>
	                <a href="<%= contextPath %>/recommendList.mo">선택하기</a>
	                <!-- 추천버튼 -->
	                <!-- 로그인 되어있지 않으면 무작위로 하나, 로그인 되어있으면 선택한 내용으로 class btn-primary 교체 -->
	                <div id="btn-list">
		               <button class="btn btn-sm btn-light">공포</button>
		               <button class="btn btn-sm btn-light">드라마</button>
		               <button class="btn btn-sm btn-light">미스터리</button>
		               <button class="btn btn-sm btn-light">범죄</button>
		               <button class="btn btn-sm btn-light">로맨스</button>
		               <button class="btn btn-sm btn-light">사극</button>
		               <button class="btn btn-sm btn-light">스릴러</button>
		               <button class="btn btn-sm btn-light">액션</button>
		               <button class="btn btn-sm btn-light">판타지</button>
		               <button class="btn btn-sm btn-light">코미디</button>
		               <button class="btn btn-sm btn-light">19세</button>
		               <button class="btn btn-sm btn-light">SF</button>
	                </div>
	                <script>
	                	$(function(){
	                		//로그인한 유저가 1개이상 선택했을 때는 선택한 장르, 아니면 랜덤장르 1개 불 들어오고 영화 선택됨
	            			var $genreBtn = $('#btn-list>button');
	            			<% for(String str : genres){ %>
	                		for(var i = 0 ; i< $genreBtn.length; i++){
	                			if('<%= str %>' == $genreBtn.eq(i).text()){
	                				$genreBtn.eq(i).addClass('btn-primary');
	                                $genreBtn.eq(i).removeClass('btn-light');
	                			}
	                		}
	            		<% } %>
	                	})
	                </script>
	                <!-- 추천영화 목록 10개 예매율 DESC, 가나다 ASC -->
	                <div class="movie-list">
	                    <% if(recommendList.size() == 0){ %>
	                    	영화가 존재하지 않습니다.
	                    <% }else{ %>
		                    <% for(int i = 0; i < recommendList.size();i++){ %>
			                    <div class="movie-one">
			                        <img src="<%=contextPath %><%= recommendPicList.get(i).getFilePath()+recommendPicList.get(i).getChangeName() %>" alt="" class="movie-poster">
			                        <!-- 바로 전 요소에 마우스 오버하면 나오는 영역 -->
			                        <div class="poster-button"><br>
			                            <a href="<%=contextPath %>/MoView.ti?mName=<%= recommendList.get(i).getMovieName() %>" class="btn btn-light">예매하기</a><br><br>
			                            <a href="<%=contextPath %>/detail.mo?mno=<%= recommendList.get(i).getMovieNo() %>" class="btn btn-light">상세정보</a>
			                        </div>
			                        <ul>
			                            <li>
			                                <span><%= recommendList.get(i).getMovieName() %></span>
			                            </li>
			                            <li>
			                                <span>예매율</span>
			                                <em><%= recommendList.get(i).getAdvanceRate() %></em>
			                            </li>
			                        </ul>
			                    </div>
			              <% } %> 
			          <% } %> 
			        </div> 
		        </div>
                <div class="ad-pic">
                    <a href="#">
                        <img src="" alt="">
                    </a>
                </div>
            </div>
            <!--footer : 나중에 경로 교체-->
            <%@ include file="../common/footer.jsp" %>
    </body>

    </html>