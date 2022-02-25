<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.movie.model.vo.Movie, com.kh.common.model.vo.PageInfo" %>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Movie> list = (ArrayList<Movie>)request.getAttribute("list");
%>
<% 
	String query ="";
	String mapping = "";
	if(request.getAttribute("pageType") == null){
		query = "";
		mapping = "adminList.mo";
	}else{
		query = "keyword="+(String)request.getAttribute("keyword");
		mapping = "adminSearch.mo";
	}
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>관리자 - 영화 목록</title>
		<link rel="stylesheet" href="resource/css/admin/movie/movie.css">
	</head>

	<body>
		<div id="wrap">
			<div id="menuBar">
				<%@ include file="../common/menubar.jsp" %>
			</div>
			<div id="body-area">
				<br>
				<h3>영화 목록</h3>
				<!-- 영화 기능들 -->
				<div>
				<div id="notice-menu">
					<button type="button" class="btn btn-primary" onclick="location.href='<%= contextPath %>/insertForm.mo?'">
						추가
					</button>
					<button type="button" id="popModal" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">
						삭제
					</button>
					
					<div class="admin-search">
						<form action="adminSearch.mo" method="get">
							<input type="hidden" name="currentPage" value="1">
							<input type="search" name="keyword" required>
							<input type="submit" class="btn btn-secondary" value="검색">
						</form>
					</div>
					
					
					<!-- Modal : DeleteForm -->
					<div class="modal delete-form" id="deleteForm">
					<div class="modal-dialog">
						<div class="modal-content">
					
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">
								영화 삭제
							</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
					
						<!-- Modal body -->
						<div class="modal-body">
							<ul id="deleteList"></ul>
							<span></span>
						</div>
					
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button id="deleteSubmit" type="submit" class="btn btn-danger" data-dismiss="modal">삭제</button>
						</div>
						</div>
					</div>
					</div>
				</div>
				

				<!-- 목록 테이블 영역 -->
				<table class="table" id="notice-body">
					<thead>
						<tr>
							<th></th>
							<th>No.</th>
							<th>영화명</th>
							<th>장르</th>
							<th>런타임</th>
							<th>재개봉 여부</th>
							<th>재 개봉일</th>
						</tr>
					</thead>
					<tbody>
						<% if(list == null || list.isEmpty()){ %>
							<tr><td>
								영화가 존재하지 않습니다.
							</td></tr>
						<% }else{ %>
							<% for(Movie m : list){ %>
									<tr>
									<td><input type="checkbox" class="rows" value="<%= m.getMovieNo() %>"></td>
									<td><%= m.getMovieNo() %></td>
									<td><%= m.getMovieName() %></td>
									<td><%= m.getGenre() %></td>
									<td><%= m.getRuntime() %></td>
									<td><%= m.getStatus() %></td>
									<td>
										<% if(m.getReleaseDate() == null){ %>
											재개봉 미정
										<% }else{ %>
											<%= m.getReleaseDate() %>
										<% } %>
									</td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>

				<!-- 페이징 처리 -->
				<ul class="pagination">
				<% if(pi != null){ %>
					<% if( pi.getStartPage() != 1 ){ %>
						<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= pi.getEndPage()-pi.getPageLimit()+1 %><%= query %>">&lt;</a></li>
					<% } %>
					
					<% for(int i = pi.getStartPage(); i<=pi.getEndPage();i++){ %>
						<% if(i == pi.getCurrentPage()){ %>
							<li class="page-item active"><a class="page-link"><%= i %></a></li>
						<% }else{ %>
							<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= i %><%= query %>"><%= i %></a></li>
						<% } %>
					<% } %>
					
					<% if(pi.getEndPage()!= pi.getMaxPage()){ %>
						<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= pi.getStartPage()+pi.getPageLimit() %><%= query %>">&gt;</a></li>
					<% } %>
				<% } %>
				</ul>
				<script>
					$(function(){
						//'전체' 체크하면 전체 불 들어오고 끄면 다 꺼지기. 하나씩 다 눌러서 다 채울때 불 들어오거나 하나라도 체크해제하면 불 꺼지는거 구현 안함
						$('#checkAll').on('change', function () {
							if ($(this).prop('checked'))
								$('.rows').prop('checked', true);
							else
								$('.rows').prop('checked', false);
						})
						
						//상세조회 tr 누를 시 상세조회 들어가기!! 단 체크박스 제외
						$('#notice-body tbody>tr>td').click(function(){
							var loc = $(this).parent().children('td').eq(1).text();
							if($(this).parent().children().eq(0).text()!=$(this).text())
								location.href='<%= contextPath %>/updateForm.mo?mno='+loc;
						})
						
						//체크가 될 경우 modal에 삭제 목록에 들어감. 해제될 경우 사라짐
						$('.rows').change('checked', function(){
							var deleteNo = $(this).parent().siblings().eq(0).text();
							var deleteTitle = $(this).parent().siblings().eq(1).text();
							if ($(this).prop('checked'))
								$('#deleteList').append('<li class='+deleteNo+'>'+deleteTitle+'</li>');
							else
								$('#deleteList').find('.'+deleteNo).remove();
						})
						
						//삭제 버튼 누르기
						$('#popModal').click(function(){
							if($('#notice-body input:checked').length > 0){
								$('.modal-body>span').html('삭제하시겠습니까?');
								$('#deleteSubmit').show();
							}else{
								$('.modal-body>span').html('삭제할 영화를 선택해주세요');
								$('#deleteSubmit').hide();
							}
						})
						//modal-삭제 누르면 delete.mo에 리스트로 전달
						$('#deleteSubmit').click(function(){
							var deleteList = [];
							var deleteLength = $('#deleteList>li').length;
							for(var i = 0; i < deleteLength; i++){
								deleteList.push($('#deleteList').children().eq(i).attr('class'));
							}
							location.href='<%= contextPath %>/delete.mo?list='+deleteList;
						})
					})
				</script>

				</div>
			</div>
		</div>
	</body>

	</html>
