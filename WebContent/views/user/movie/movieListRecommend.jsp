<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String[] genres = (String[])request.getAttribute("genres");
	ArrayList<Movie> recommendList = (ArrayList<Movie>)request.getAttribute("recommendList");
	ArrayList<Picture> picList = (ArrayList<Picture>)request.getAttribute("picList");
%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>영화 추천 상영작</title>
		<link rel="stylesheet" href="resource/css/user/movie/movieList.css">
    </head>

    <body>
        <!--header-->
        <%@ include file="../common/header.jsp" %>
            <div id="container">
                <h3 class="headline">추천상영작</h3>
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
                		//선택된 애들 불 켜고 끄기
                		$('#btn-list>button').click(function(){
                			var light = $(this).siblings('.btn-primary').length;
        					if($(this).hasClass('btn-light')){
       							if(light < 3){
	       							$(this).removeClass('btn-light');
	       							$(this).addClass('btn-primary');
       							}else{
           							alert('3개 이하의 장르를 선택해주세요');
       							}
        					}else{
        						if($(this).siblings('.btn-primary').length != 0){
	        						$(this).removeClass('btn-primary');
	        						$(this).addClass('btn-light');
        						}else{
        							alert('적어도 1개의 장르를 선택해주세요');
        						}
        					}
        					ajaxRecommend();
        				})
                		
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
            			
            			//현재 선택된 장르들 리스트 가져오기
            			ajaxRecommend();
                	})
                	
                	function ajaxRecommend(){
                		//현재 선택된 장르를 구하기
                		var genres =[];
        				for(var i in $('#btn-list').children()){
        					var $btnTarget = $('#btn-list').children().eq(i);

        					if($btnTarget.hasClass('btn-primary'))
        						genres.push($btnTarget.text());
        				}
        				var genreString = genres.join(',');
        				console.log(genreString);
        				//구한 장르를 보내서 리스트 받아오기
        				var recommendNo = [];
        				var recommendList = [];
                		$.ajax({
                			url:'recommendMovie.mo',
                			data:{'genres': genreString},
                			success: function(list){
                				for(var i in list){
                					recommendNo.push(list[i].movieNo);
                					recommendList.push(list[i]);
                				}
                				var recommendNoString = recommendNo.join(',');
                				if(recommendNoString != ''){
	                				$.ajax({
	                					url:'recommendPicture.mo',
	                					data:{'recommendNo': recommendNoString},
	                					success: function(picList){
		                					var result = '';
	                						for(var i = 0; i<picList.length; i++){
		                        				result += '<div class="movie-one">'
		                							+'<img src="<%=contextPath %>'+picList[i].filePath+picList[i].changeName+'" alt="'+picList[i].originName+'" class="movie-poster">'
		                							+'<div class="poster-button"><br>'
		                							+'<a href="<%=contextPath %>/MoView.ti?mName='+recommendList[i].movieName+'" class="btn btn-light">예매하기</a><br><br>'
		                							+'<a href="<%=contextPath %>/detail.mo?mno='+recommendNo[i]+'" class="btn btn-light">상세정보</a>'
		                							+'</div><ul><li><span>'+recommendList[i]['movieName']+'</span></li><li>'
		                							+'<span>예매율</span><em>'+recommendList[i].advanceRate+'</em></li></ul></div>';
	                						}
	                						$('.movie-list').html(result);
	                					}
	                				})
                				}else{
                					$('.movie-list').html('<div class="not">영화가 존재하지 않습니다.</div>');
                				}
                			}
                		})
                	}
                </script>
                <div class="movie-list">
                    <% if(recommendList.size() == 0){ %>
                    	<div class="not">영화가 존재하지 않습니다.</div>
                    <% }else{ %>
	                <% for(int i = 0; i < recommendList.size();i++){ %>
		                 <div class="movie-one">
		                    <img src="<%=contextPath %><%= picList.get(i).getFilePath()+picList.get(i).getChangeName() %>" alt="" class="movie-poster">
		                    <!-- 바로 전 요소에 마우스 오버하면 나오는 영역 -->
		                    <div class="poster-button">
			  	        <br>
		                        <a href="#" class="btn btn-light">예매하기</a><br><br>
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
                <!-- 스틸컷 이미지 -->
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
