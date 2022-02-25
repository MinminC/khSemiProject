<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.kh.notice.model.vo.Notice" %>
<%
	Notice n = (Notice)request.getAttribute("n");
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>고객센터-공지사항-게시글조회</title>
		<link rel="stylesheet" href="resource/css/user/notice/notice.css">
	</head>

	<body>
		<!--header-->
		<%@ include file="../common/header.jsp" %>
		<div id="wrap">
			<div id="menuBar">
				 <%@ include file="../common/customerNavigation.jsp" %>
			</div>
			<!-- 고객센터 메뉴바 넣을 자리-->

			<!-- 게시글 1개 조회 -->
			<div id="notice-body">
				<h3 class="headline">공지사항</h3>
				<table class="table">
					<thead>
						<tr>
							<th><%= n.getNoticeTitle() %></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<ul>
									<li><span>구분</span> | <span><%= n.getNoticeCategory() %></span></li>
									<li><span>등록일</span> | <span><%= n.getNoticeDate() %></span></li>
									<li><span>조회수</span> | <span><%= n.getNoticeViews() %></span></li>
								</ul>
							</td>
						</tr>
						<tr>
							<td>
								<%= n.getNoticeContent() %>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<!-- 다음 글이 존재할 경우 -->
						<% if(n.getNextNoticeNo() != 0){ %>
							<tr>
								<td><a href="<%= contextPath %>/detail.no?nno=<%= n.getNextNoticeNo() %>">다음글 : <%= n.getNextNoticeTitle() %></a></td>
							</tr>
						<% } %>
						<!-- 이전 글이 존재할 경우 -->
						<% if(n.getPrevNoticeNo() != 0){ %>
							<tr>
								<td><a href="<%= contextPath %>/detail.no?nno=<%= n.getPrevNoticeNo() %>">이전글 : <%= n.getPrevNoticeTitle() %></a></td>
							</tr>
						<% } %>
					</tfoot>
				</table>
				<!-- 목록으로 이동 -->
				<a href="<%= contextPath %>/list.no?currentPage=1" class="btn btn-secondary" id="goToList">목록 이동</a>
				<br>
			</div>

		</div>
		<!--footer-->
		<%@ include file="../common/footer.jsp" %>
	</body>

	</html>
