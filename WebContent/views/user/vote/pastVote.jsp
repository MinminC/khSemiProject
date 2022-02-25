<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.vote.model.vo.VoteList, com.kh.common.model.vo.*" %>   
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int currentPage = (int)pi.getCurrentPage();
	int startPage = (int)pi.getStartPage();
	int endPage = (int)pi.getEndPage();
	int maxPage = (int)pi.getMaxPage();
	
	ArrayList<VoteList> list = (ArrayList<VoteList>)request.getAttribute("list"); 
	
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이전 투표 목록</title>
<link rel="stylesheet" href="../../../resource/css/00_stylesheet.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/user/vote/pastVote.css">


</head>
<body>
	
	<%@ include file="../common/header.jsp" %>

		<div id="container">
				<div class="container_5">
					<br><br><br><br>
	                <p style="font-size:30px;">이전투표목록</p> <br><br>
	                <!--  <hr size="4"  color="gray"> -->
				</div>
				<%if(list.isEmpty()){ %>
					<div class="container_5">
						투표 목록이 없습니다.
					</div>
				<%} else{%>
					<%for(VoteList vl : list) {%>
	                <div class="container_5">
	                	<hr size="4"  color="gray">
	                    <table>
	                    	<tr>
			                    <img src="<%=contextPath %><%=vl.getVreFilePath() %>" alt="포스터1" class="poster1" style="vertical-align:middle;">
			                    <span style="margin-top:20px;margin-left:160px;font-size:18px;"><%=vl.getVoteTitle() %></span>
			                    <input type="hidden" name="voteNo" id="voteno" value="<%=vl.getVoteNo() %>">
	                    	</tr>
						</table>
	                </div>
                	<%} %>
                <%} %>
                <br><br>
 
 		<%-- <script>
	        $(function(){
	        	$(".list-area>tbody>tr").click(function(){
	        	
	        				
	        		location.href = "<%=contextPath%>/?=" + $(this).children().eq(0).text();
	       
	        	})
	        })

        </script> --%>
 
 			<%if(!list.isEmpty()){ %>
 				<div id="paging">
                <div id="paging_btn" class="paging-area">
                    <!-- 페이징 버튼 -->
					<% if(currentPage != 1) { %>
		            	<button class="btn btn-sm btn-outline-primary" onclick="location.href='<%= contextPath%>/vote.pa?currentPage=<%= currentPage - 1 %>'">&lt;</button>
					<% } %>
			
		
					<%for(int i = startPage; i <= endPage; i++) { %>
						<% if( i != currentPage){ %>
		            		<button class="btn btn-sm btn-outline-primary" onclick="location.href='<%= contextPath%>/vote.pa?currentPage=<%= i %>'"><%= i %></button>
						<% }else{ %>
			            	<button class="btn btn-outline-primary" disabled><%= i %></button>
		            	<% } %>
		            <% } %>
		            
		            <!-- 페이징바에서 > 를 담당 : 다음페이지 이동 -->
		            <% if(currentPage != maxPage) { %>
		            	<button class="btn btn-sm btn-outline-primary" onclick="location.href='<%= contextPath%>/vote.pa?currentPage=<%= currentPage + 1 %>'">&gt;</button>
					<% } %>
        		</div>
          	</div>
          <%} %>
 	
 			
 
    </div>

	<br><br><br><br><br><br><br><br><br><br><br><br>
	<%@ include file="../common/footer.jsp" %>
	
	
</body>
</html>