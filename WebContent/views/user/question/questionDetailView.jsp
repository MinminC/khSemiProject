<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "com.kh.question.model.vo.Question, com.kh.question.model.vo.Q_Attachment" %>
<%
	Question q = (Question)request.getAttribute("Qdetail");	
	Q_Attachment at = (Q_Attachment)request.getAttribute("Qat");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변 상세 확인</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/user/question/question.css">
</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<div class="sub_nav" style="float: left;">
		<%@ include file="../common/subNavigation.jsp"%>
	</div>
	<div class="outer">
		<br>
		<h1 class="title">문의 답변 확인</h1>
		<br>

		<div class="Qform-btn">
			<a href="<%=contextPath%>/enroll-form.qu %>"
				class="btn btn-sm btn-primary">1:1 문의하기</a> <br> <br>
		</div>

		<table class="list-area Qform">
			<tr>
				<th>제목</th>
				<td colspan="5"><%= q.getAskTitle() %></td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><%= q.getAskDate() %></td>
				<th>문의 유형</th>
				<td><%= q.getAskTypeTxt() %></td>
				<th>답변 상태</th>
				<td><%= q.getStatus() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5" class="Qcontent"><%= q.getAskContent() %></td>
			</tr>
			<% if(at != null) { %>
			<tr>
				<th>첨부 파일</th>
				<td colspan="5" style="text-align: center;">
					<img 
						src="<%= request.getContextPath() + at.getFilePath() + at.getChangeName() %>" 
						alt="<%= at.getOriginName() %>"
						class="Qat"
						style="width: 600px;">
						
				</td>
			</tr>
			<% } %>
			<tr>
				<th></th>
				<td colspan="5" class="Qanswer"><%= q.getComment() %></td>
			</tr>
		</table>
	</div>
	<script>
		$(function(){
			var $img = $('.Qat');
			$img.click(function(){
				window.open(this.src)
			})
		})
	</script>
</body>
</html>