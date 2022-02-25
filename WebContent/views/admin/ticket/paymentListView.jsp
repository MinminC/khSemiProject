<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.ticket.model.vo.Ticket, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<Ticket> tlist = (ArrayList<Ticket>)request.getAttribute("tlist");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역 관리</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/admin/ticket/ticket.css">
</head>
<body>
	<div id="admin-menu">
		<%@ include file="../common/menubar.jsp" %>
	</div>
	<div id="container">
        <h1><b>결제 내역 관리</b></h1>
        <br>
            
            <table class="table table-hover table-dark">
                <thead>
                  <tr>
                    <th scope="col" width="5%">#</th>
                    <th scope="col" width="12%">예매 번호</th>
                    <th scope="col" width="45%">제목</th>
                    <th scope="col" width="15%">회원ID</th>
                    <th scope="col" width="13%">티켓 매수</th>
                    <th scope="col" width="10%">결제 금액</th>
                  </tr>
                </thead>
                <tbody>
                <% if(tlist.isEmpty()){ %>
	            	<tr>
	            		<td colspan="6">조회된 게시글이 없습니다.</td>
	            	</tr>
            	<% } else {%>
            		<!-- 반복 : list에 있는 값을 순차적으로 접근해서 뽑아오기 -->
            		<% for(Ticket t : tlist) {%>
	                  <tr>
	                    <th scope="row">1</th>
	                    <td><%= t.getPayNo() %></td>
	                    <td><%= t.getmName() %></td>
	                    <td><%= t.getMemberId() %></td>
	                    <td><%= t.getTypeCount() %></td>
	                    <td><%= t.getPayment() %></td>
	                  </tr>
	               	<% } %>
                <% } %> 
                </tbody>
              </table>
	</div>
</body>
</html>