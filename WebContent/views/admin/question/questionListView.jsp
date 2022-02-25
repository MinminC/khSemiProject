<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.question.model.vo.Question, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<Question> qlist = (ArrayList<Question>)request.getAttribute("qlist");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들 때 필요한 변수 미리 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의 답변</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/admin/question/question.css">
</head>
<body>
	
	<div id="admin-menu">
		<%@ include file="../common/menubar.jsp" %>
	</div>
	<div id="container">
	<h1><b>1:1 문의 관리</b></h1>
	
    <br>
    <table class="table question-list-wrap">
        <thead>
          <tr>
            <th scope="col" style="width: 50px;">#</th>
            <th scope="col" style="width: 800px;">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">등록일</th>
            <th scope="col">상태</th>
          </tr>
        </thead>
        <tbody>
       		<% for(Question q : qlist) { %>
	          <tr class="qlist">
	            <th scope="row"><%= q.getAskNo() %></th>
	            <td><%= q.getAskTitle() %></td>
	            <td><%= q.getMemberId() %></td>
	            <td><%= q.getAskDate() %></td>
	            <td><span class="badge badge-pill"><%= q.getStatus() %></span></td>
	          </tr>
        	<% } %>
        </tbody>
      </table>
      <script>
      	$(function(){
      		var $qlist = $('.qlist')
      		for(var i=0; i<$qlist.length; i++) {
      			var $stat = $qlist.eq(i).children().eq(4);
      			
      			if($stat.text() == '답변 대기'){
    				$stat.children().addClass('badge-secondary');
    			} else {
    				$stat.children().addClass('badge-success');
    			}
      		}
      		
      		$qlist.click(function(){
      			var qno = $(this).children().eq(0).text();
      			location.href="<%=contextPath%>/adminDetail.qu?qno=" + qno;
      		})
			
      	})
      </script>
      <br><br>
      <!-- 페이징바 -->
      <div class="paging-area" align="center">

        <!-- 페이징 버튼 -->
        <!-- 페이징바에서 < 를 담당 : 이전페이지 이동 -->
        <% if(currentPage != 1) { %>
           	<button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%= contextPath %>/adminList.qu?currentPage=<%= currentPage - 1 %>'">&lt;</button>
        <% } %>
            
            
        <% for(int i = startPage; i <= endPage; i++) {%>
            <% if(i != currentPage){ %>
          	    <!-- /jsp/list.bo?currentPage=XX -->
                <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%= contextPath %>/adminList.qu?currentPage=<%= i %>'"><%= i %></button>
            <%} else{ %>
                <button class="btn btn-sm btn-info disabled"><%= i %></button>
            <% } %>
        <% } %>
            
        <!-- 페이징바에서 > 를 담당 : 다음페이지 이동 -->
        <% if(currentPage != maxPage){ %>
            <button class="btn btn-sm btn-outline-secondary" onclick="location.href='<%= contextPath %>/adminList.qu?currentPage=<%= currentPage + 1 %>'">&gt;</button>
		<%} %>
        </div>
	</div>
</body>
</html>