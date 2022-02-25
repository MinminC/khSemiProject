<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<% 
	PageInfo pi=(PageInfo) request.getAttribute("pi"); 
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>
<% String query="&category=" + request.getAttribute("category"); %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>고객센터-FAQ</title>
	<link rel="stylesheet" href="resource/css/user/notice/notice.css">
</head>

<body>
	<!--header-->
	<%@ include file="../common/header.jsp" %>
	<div id="wrap">
		<div id="menuBar">
			<%@ include file="../common/customerNavigation.jsp" %>
		</div>
		<!-- FAQ  -->
		<div id="notice-body">
			<h3 class="headline">FAQ</h3>
			<div class="toolbar">
				<p>더 궁금한 점이 있거나, 이미 문의한 내용과 답변을 확인하려면?</p>
				<a href="<%= contextPath %>/enroll-form.qu" style="text-decoration: underline;">1:1문의 바로가기</a>
			</div>
			<div class="FAQ-class">
				<ul>
					<li><a href="<%=contextPath%>/faq.no?category=100&currentPage=1">
						<i class='fas fa-ticket-alt' style='font-size:36px'></i> <br>
						예매
						</a></li>
					<li><a href="<%=contextPath%>/faq.no?category=200&currentPage=1">
						<i class='fa fa-film' style='font-size:36px'></i><br>
							영화관</a></li>
					<li><a href="<%=contextPath%>/faq.no?category=300&currentPage=1">
						<i class='fas fa-user-alt' style='font-size:36px'></i><br>
						회원</a>
					</li>
					<li><a href="<%=contextPath%>/faq.no?category=400&currentPage=1"> 
						<i class="fa fa-home" style="font-size:36px"></i><br>
						 홈페이지
						</a></li>
					<li><a href="<%=contextPath%>/faq.no?category=500&currentPage=1">
						<i class='far fa-address-card' style='font-size:36px'></i><br>
						 멤버십
						</a></li>
					<li><a href="<%=contextPath%>/faq.no?category=600&currentPage=1"> 
						<i class='fas fa-vote-yea' style='font-size:36px'></i><br>
						투표
						</a></li>
					<li><a href="<%=contextPath%>/faq.no?category=700&currentPage=1"> 
						<i class='fas fa-align-justify' style='font-size:36px'></i><br>
						 기타
						</a></li>
				</ul>
			</div>
			<br>
			<div class="FAQ-body">
				<% if(list.isEmpty()){ %>
					<div class="nothing">FAQ가 존재하지 않습니다.</div>
				<% }else{ %>
					<% for(Notice n : list){ %>
						<div class="FAQ-one" id="<%= n.getNoticeNo() %>">
							<h4><a href="#<%= n.getNoticeNo() %>"><%= n.getNoticeTitle() %></a></h4>
							<p><%= n.getNoticeContent() %></p>
							<hr>
						</div>
					<% } %>
				<% } %>
			</div>
			<br>
			<!-- 페이징 처리 -->
			<ul class="pagination">
				<% if (pi.getStartPage() !=1) { %>
					<li class="page-item"><a class="page-link"
							href="<%=contextPath%>/faq.no?currentPage=<%=pi.getEndPage() - pi.getPageLimit() + 1%><%=query%>">&lt;</a>
					</li>
				<% } %>

				<% for (int i=pi.getStartPage(); i <=pi.getEndPage(); i++) { %>
					<% if (i==pi.getCurrentPage()) { %>
						<li class="page-item active">
							<a class="page-link"><%=i%></a>
						</li>
					<% } else { %>
						<li class="page-item">
							<a class="page-link" href="<%=contextPath%>/faq.no?currentPage=<%=i%><%=query%>">
								<%=i%>
							</a>
						</li>
					<% } %>
				<% } %>

				<% if (pi.getEndPage() !=pi.getMaxPage()) { %>
					<li class="page-item">
						<a class="page-link" href="<%=contextPath%>/faq.no?currentPage=<%=pi.getStartPage() + pi.getPageLimit()%><%=query%>">&gt;</a>
					</li>
				<% } %>
			</ul>
		</div>
	</div>
	<script>
		$(function(){
			var category = '100';
			<% if(request.getAttribute("category") != null){ %>
				category = '<%= request.getAttribute("category") %>';
			<% } %>
				console.log(category);
				console.log($('.FAQ-class>ul>li'));
			switch(category){
				case '700': $('.FAQ-class>ul>li').eq(6).addClass('ac'); break;
				case '600': $('.FAQ-class>ul>li').eq(5).addClass('ac'); break;
				case '500': $('.FAQ-class>ul>li').eq(4).addClass('ac'); break;
				case '400': $('.FAQ-class>ul>li').eq(3).addClass('ac'); break;
				case '300': $('.FAQ-class>ul>li').eq(2).addClass('ac'); break;
				case '200': $('.FAQ-class>ul>li').eq(1).addClass('ac'); break;
				case '100': $('.FAQ-class>ul>li').eq(0).addClass('ac'); break;
			}
		})
	</script>
	<br><br><br><br><br><br><br>
	<!--footer-->
	<%@ include file="../common/footer.jsp" %>
</body>

</html>
