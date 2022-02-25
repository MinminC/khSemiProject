<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.theater.model.vo.Theater, com.kh.common.model.vo.PageInfo" %>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징 바 만들 때 필요한 변수 미리 세팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화관목록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/theater/04_z01_movietheater_list.css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<div id="container">
            <div id="content_1">
                <h1>극장 안내</h1>
            </div>
            <div id="content_2">
                <table class="table">
                    <thead>
                        <tr>
                            <th>극장명</th>
                            <th>주소</th>
                            <th>전화번호</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!-- 게시글 출력 -->
                    <% if(theaterList.isEmpty()) { %>
                    	<tr>
                    		<td colspan="3">조회된 게시글이 없습니다.</td>
                    	</tr>
                    <% } else { %>
                    	<!-- 반복 : list에 있는 값을 순차적으로 접근해서 뽑아오기 -->
                    	<% for(Theater t : theaterList){ %>
                        <tr>
                        	<td hidden><%= t.getTheaterNo() %></td>
                            <td><%= t.getTheaterName()%></td>
                            <td><%= t.getAddress()%></td>
                            <td><%= t.getPhone()%></td>
                        </tr>
                        <% } %>
                    <% } %>
                    </tbody>
                </table>
            </div>
            
            <br>
            
            <script>
            	$(function(){
					$(".table>tbody>tr").click(function(){
						
						location.href="<%= contextPath%>/tDetail.th?tno=" + $(this).children().eq(0).text();
					})
            	})
            </script>
            
            
            <div id="content_3" >
                <div id="paging_btn" class="paging-area">
                    <!-- 페이징 버튼 -->
			<% if(currentPage != 1) { %>
            	<button class="btn btn-outline-primary" onclick="location.href='<%= contextPath%>/tList.th?currentPage=<%= currentPage - 1 %>'">&lt;</button>
			<% } %>
	

			<%for(int i = startPage; i <= endPage; i++) { %>
				<% if( i != currentPage){ %>
            		<button class="btn btn-outline-primary" onclick="location.href='<%= contextPath%>/tList.th?currentPage=<%= i %>'"><%= i %></button>
				<% }else{ %>
	            	<button class="btn btn-outline-primary" disabled><%= i %></button>
            	<% } %>
            <% } %>
            
            <!-- 페이징바에서 > 를 담당 : 다음페이지 이동 -->
            <% if(currentPage != maxPage) { %>
            	<button class="btn btn-outline-primary" onclick="location.href='<%= contextPath%>/tList.th?currentPage=<%= currentPage + 1 %>'">&gt;</button>
			<% } %>
        	</div>
          </div>
        </div>
            
        </div>
	
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>