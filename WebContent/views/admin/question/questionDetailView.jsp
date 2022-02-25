<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.question.model.vo.Question, com.kh.question.model.vo.Q_Attachment" %>
<%
	Question q = (Question)request.getAttribute("Qdetail");	
	Q_Attachment at = (Q_Attachment)request.getAttribute("Qat");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 답변하기</title>
</head>
<body>
	<div id="admin-menu">
		<%@ include file="../common/menubar.jsp" %>
	</div>
	<div id="container" style="margin-left: 200px; padding: 30px;">
	<h1><b>1:1 문의 관리</b></h1>
    <br>
    <form action="comment.qu" method="post">
        <input type="text" name="qno" value="<%= q.getAskNo() %>" hidden>
        <table class="table" style="border-top: 2px solid black; border-bottom: 2px solid black; width: 1300px;">
            <tbody>
            <tr>
                <th scope="col" colspan="">제목</th>
                <td colspan="3"><%= q.getAskTitle() %></td>
            </tr>
            <tr>
                <th scope="row">등록일</th>
                <td><%= q.getAskDate() %></td>
                <th scope="row">문의 유형</th>
                <td><%= q.getAskTypeTxt() %></td>
            </tr>
            <tr>
                <th scope="row">내용</th>
                <td colspan="3"><%= q.getAskContent() %></td>
            </tr>
            <% if(at != null) { %>
                <tr>
                    <th scope="row">첨부 파일</th>
                    <td colspan="3" style="text-align: center;">
                        <img 
                            src="<%= request.getContextPath() + at.getFilePath() + at.getChangeName() %>" 
                            alt="<%= at.getOriginName() %>"
                            class="Qat"
                            style="width: 600px;">
                            
                    </td>
                </tr>
                <% } %>
            <tr>
                <th scope="row">답변</th>
                <td colspan="3"><textarea name="comment" id="comment" rows="10" style="width: 100%;">문의 주셔서 감사합니다. 시네마헤븐 고객센터 입니다.</textarea></td>
            </tr>
            </tbody>
        </table>
      <button type="submit" class="btn btn-primary">답변하기</button>
    </form>
	</div>
</body>
</html>