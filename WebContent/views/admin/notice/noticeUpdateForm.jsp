<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Category, com.kh.notice.model.vo.Notice" %>
<% 
	String tableType = (String)request.getAttribute("tableType");
	ArrayList<Category> category = (ArrayList<Category>)request.getAttribute("category");
	Notice n = (Notice)request.getAttribute("n");
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>관리자 - 공지/FAQ 수정</title>
		<link rel="stylesheet" href="resource/css/admin/movie/movie.css">
	</head>

	<body>
		<div id="wrap">
			<div id="menuBar">
				<%@ include file="../common/menubar.jsp" %>
			</div>
			<div id="body-area">
				<br>
				<h3>고객센터 수정</h3>
				
				<form action="<%= contextPath %>/update.no" method="post">
					<table class="table in-form">
						<tr>
							<th>구분</th>
							<td>
								<input type="hidden" name="tableType" value="<%= tableType %>">
								<input type="hidden" name="nno" value="<%= n.getNoticeNo() %>">
								<select name="category">
									<% for(Category c : category){ %>
										<% if(n.getNoticeCategory().equals(c.getCategoryContent())){ %>
											<option selected value="<%= c.getCategoryNo() %>"><%= c.getCategoryContent() %></option>
										<% }else{ %>
											<option value="<%= c.getCategoryNo() %>"><%= c.getCategoryContent() %></option>
										<% } %>
									<% } %>
								</select>
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" size="120" required value="<%= n.getNoticeTitle() %>"></td>
						</tr>
						<tr>
							<td colspan="4">
								<script type="text/javascript" src="<%= contextPath %>/resource/js/service/HuskyEZCreator.js" charset="utf-8"></script>
								<textarea name="ir1" id="ir1" rows="25" cols="147" required><%= n.getNoticeContent() %></textarea>
								<script type="text/javascript">
									var oEditors = [];
									nhn.husky.EZCreator.createInIFrame({
									oAppRef: oEditors,
									elPlaceHolder: "ir1",
									sSkinURI: "<%= contextPath %>/resource/SmartEditor2Skin.html",
									fCreator: "createSEditor2"
									});
									
									function submitContents(elClickedObj) {
										oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
										if(document.getElementById("ir1").value.length>4000){
											alert('4000 Byte 까지만 작성 가능합니다. 확인해주세요.');
											return false;
										}
										return true;
									}
									
									$(function(){
										var $tableType = $('#tableType').children();
										if('<%= tableType %>' == 'notice'){
											$tableType.eq(0).addClass('btn-primary');
											$tableType.eq(1).addClass('btn-secondary');
										}else{
											$tableType.eq(1).addClass('btn-primary');
											$tableType.eq(0).addClass('btn-secondary');
										}
									})
								</script>
							</td>
						</tr>
					</table>
					<div id="btns-center">
						<button type="submit" class="btn btn-secondary" onclick="return submitContents();">수정하기</button>
						<button type="button" class="btn btn-secondary" onclick="history.back();">목록이동</button>
					</div>
				</form>
			</div>
		</div>
	</body>

	</html>