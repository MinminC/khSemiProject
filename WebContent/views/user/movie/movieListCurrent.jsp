<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Movie> currentList = (ArrayList<Movie>)request.getAttribute("currentList");
	ArrayList<Picture> picList = (ArrayList<Picture>)request.getAttribute("picList");
%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>영화 현재 상영작</title>
        <link rel="stylesheet" href="resource/css/user/movie/movieList.css">
    </head>

    <body>
        <!--header-->
        <%@ include file="../common/header.jsp" %>
            <div id="container">
                <h3 class="headline">현재상영작</h3>
                <!-- 현재상영작 목록 -->
                <div class="movie-list">
                <% if(currentList == null){ %>
                    	영화가 존재하지 않습니다.
                <% }else{ %>
	                <% for(int i = 0; i < currentList.size();i++){ %>
	                    <div class="movie-one">
	                        <img src="<%=contextPath %><%= picList.get(i).getFilePath()+picList.get(i).getChangeName() %>" alt="" class="movie-poster">
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
	                                <em><%= currentList.get(i).getAdvanceRate() %></em>
	                            </li>
	                        </ul>
	                    </div>
	                <% } %>    
	                    <!-- 페이징 처리 -->
	                    <ul class="pagination">
		                    <% if( pi.getStartPage() != 1 ){ %>
		                        <li class="page-item"><a class="page-link" href="<%= contextPath %>/currentList.mo?currentPage=<%= pi.getEndPage()-pi.getPageLimit()+1 %>">&lt;</a></li>
		                    <% } %>
		                    
		                    <% for(int i = pi.getStartPage(); i<=pi.getEndPage();i++){ %>
		                    	<% if(i == pi.getCurrentPage()){ %>
		                        	<li class="page-item active"><a class="page-link"><%= i %></a></li>
		                        <% }else{ %>
		                        	<li class="page-item"><a class="page-link" href="<%= contextPath %>/currentList.mo?currentPage=<%= i %>"><%= i %></a></li>
		                    	<% } %>
		                    <% } %>
		                    
		                    <% if(pi.getEndPage()!= pi.getMaxPage()){ %>
		                        <li class="page-item"><a class="page-link" href="<%= contextPath %>/currentList.mo?currentPage=<%= pi.getStartPage()+pi.getPageLimit() %>">&gt;</a></li>
		                    <% } %>
	                    </ul>
                    <% } %>
                </div>
				<br><br clear="both">
                <!-- 스틸컷 이미지 -->
                <div class="ad-pic">
                    <a href="#">
                        <img src="" alt="">
                    </a>
                </div>

            </div>
            </div>
            <!--footer : 나중에 경로 교체-->
            <%@ include file="../common/footer.jsp" %>
    </body>

    </html>