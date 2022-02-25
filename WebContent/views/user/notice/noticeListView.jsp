<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<% 
	String query ="";
	String mapping = "";
	if(request.getAttribute("type") == null){
		mapping = "list.no";
	}else{
		query = "&type="+request.getAttribute("type")+"&keyword="+(String)request.getAttribute("keyword");
		mapping = "search.no";
	}
%>

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>고객센터-공지사항-목록조회</title>
		<link rel="stylesheet" href="resource/css/user/notice/notice.css">
    </head>

    <body>
        <!--header-->
        <%@ include file="../common/header.jsp" %>
                <!-- 고객센터 메뉴바 넣을 자리-->
			<div id="wrap">
				<div id="menuBar">
					<%@ include file="../common/customerNavigation.jsp" %>
				</div>
                <div id="notice-body">
					<h3 class="headline">공지사항</h3>
					<div class="notice-search">
						<form action="search.no" method="get">
							<input type="hidden" name="currentPage" value="1">
							<select name="type">
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select>
							<input type="search" name="keyword">
							<input type="submit" class="btn btn-sm btn-secondary"value="검색">
						</form>
					</div>
					<br>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>구분</th>
                                <!-- 구분으로 선택해서 filter -->
                                <th>제목</th>	
                                <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% if(list.isEmpty()){ %>
                        	<tr><td>공지사항이 존재하지 않습니다.</td></tr>
                        <% }else{ %>
                            <% for(Notice n : list){ %>
	                            <% if(n.getNoticeCategory().equals("10")){ %>
	                            <tr class="important">
		                                <td><%= n.getNoticeNo() %></td>
		                                <td>중요</td>
		                        <% }else{ %>
		                        	<tr>
		                                <td><%= n.getNoticeNo() %></td>
		                                <td>일반</td>
	                            <% } %>
		                                <td><%= n.getNoticeTitle() %></td>
		                                <td><%= n.getNoticeDate() %></td>
		                            </tr>
                            <% } %>
                        <% } %>
                        </tbody>
                    </table>

                    <!-- 페이징 처리 -->
                    <ul class="pagination">
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
                    </ul>
					<br clear="both"><br>
					
                </div>
				
                <script>
                	$(function(){
                		//상세조회 tr 누를 시 상세조회 들어가기!!
                		$('#notice-body tbody>tr').click(function(){
                			var loc = $(this).children('td').eq(0).text();
                			location.href='<%= contextPath %>/detail.no?nno='+loc;
                		})
                	})
                </script>
            </div>
			<br clear="both">
            <!--footer-->
            <%@ include file="../common/footer.jsp" %>
    </body>

    </html>
