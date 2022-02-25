<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.question.model.vo.Question" %>
<% 
	ArrayList<Question> list = (ArrayList<Question>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 목록</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/user/question/question.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script>
	$(function(){
		$(".Qlist-data").click(function(){
			// 글번호 가져가기
			var qno = $(this).children().eq(0).text();
			location.href = "<%=request.getContextPath()%>/detail.qu?qno=" + qno;
		})
	})
</script>
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	<div class="sub_nav" style="float: left;">
		<%@ include file="../common/subNavigation.jsp"%>
	</div>
	<!-- 로그인 안돼있으면 못들어옴 -->
	<% if (loginUser == null) { %>
		<%@ include file="../common/loginCheck.jsp"%>
	<% } %>

	<div class="outer">
		<br>
		<h1 class="title">문의 내역 확인</h1>
		<p class="discription">고객센터를 통해 남기신 1:1문의내역을 확인하실 수 있습니다.</p>
		<br>

		<div class="Qform-btn">
			<a href="<%=contextPath%>/enroll-form.qu"
				class="btn btn-sm btn-primary">1:1 문의하기</a> <br> <br>
		</div>
		<table class="list-area">
			<thead>
				<tr>
					<th>번호</th>
					<th width="100">유형</th>
					<th width="400">제목</th>
					<th>답변 상태</th>
					<th width="100">등록일</th>
				</tr>
			</thead>
			<tbody class="Qlist">
				<!-- 문의 내역이 존재하지 않는 경우 -->
				<% if (list.isEmpty()) { %>
					<tr>
						<td colspan="5">문의 내역이 존재하지 않습니다.</td>
					</tr>
				<% } else { %>
					<!-- 문의 내역이 있을 경우 -->
					<% for(Question q : list) { %>
					<%
						
						// 답변이 없을 경우 X, 답변이 있을 경우 O
						String comment = q.getCommentDate();
						char OX = 'X';
						if(comment != null){
							OX = 'O';
						}
					%>
					<tr class="Qlist-data">
						<td hidden><%= q.getAskNo() %></td>
						<td>1</td>
						<td class="Qtype"><%= q.getAskTypeTxt() %></td>
						<td><%= q.getAskTitle() %></td>
						<td><%= OX %></td>
						<td><%= q.getAskDate() %></td>
					</tr>
					<% } %>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>