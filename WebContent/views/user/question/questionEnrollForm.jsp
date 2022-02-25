<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의 작성</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/user/question/question.css">
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	<div class="sub_nav" style="float:left;">
		<%@ include file="../common/customerNavigation.jsp"%>
	</div>
	<!-- 로그인 안돼있으면 못들어옴 -->
	<% if (loginUser == null) { %>
		<%@ include file="../common/loginCheck.jsp"%>
	<% } %>
	<div class="outer">
		<br>
		<h1 class="title">문의 작성하기</h1>
		<br> <br> <br>

		<form id="enroll-form" action="<%= contextPath %>/insert.qu" method="post" enctype="multipart/form-data">
		<% if(loginUser != null) { %>
			<!-- 로그인한 회원 정보 넘기기 -->
			<input type="text" name="memberNo" value="<%= loginUser.getMemberNo() %>" hidden>
		<% } %>
		
		<table class="list-area Qform">
			<tr>
				<th>제목</th>
				<td><input type="text" name="Qtitle" style="width: 100%"></td>
				<th>문의 유형</th>
				<td>
					<select name="Qtype" style="width: 100%">
						<option value="1">일반문의</option>
						<option value="2">칭찬</option>
						<option value="3">불만</option>
						<option value="4">제안</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>사진 첨부</th>
				<td colspan="3" class="Qanswer">
					<p class="pic-disc">
						* JPEG, PNG형식의 5M 이하의 파일만 첨부 가능합니다. <br> 
						* 개인정보가 포함된 이미지 등록은 자제하여 주시기 바랍니다. <br>
					</p> <input type="file" name="Qpic">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" class="Qcontent">
					<textarea name="Qcontent" style="width: 700px; resize: none;" rows="15"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="4"><button type="submit" class="btn btn-primary" style="text-align: right;">등록하기 </button></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>