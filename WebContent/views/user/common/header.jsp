<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member, java.util.ArrayList, com.kh.theater.model.vo.Theater" %>
<% 
	String contextPath = request.getContextPath();	

	Member loginUser = (Member)session.getAttribute("loginUser");
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	
	ArrayList<Theater> theaterList = (ArrayList<Theater>)session.getAttribute("theaterList");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>header</title>

<!-- 스타일시트 -->
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="resource/css/user/common/00_stylesheet.css">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">



<style>

body{
  margin: 0;
  padding: 0;
  background-color: #fff;
}
.search-box{
  padding: 10px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  height: 50px;
  background-color: #fff;
  border: 1px solid #0588ed;
  border-radius: 30px;
  transition: 0.4s;
  width:30px;
}
.search-box:hover{
  box-shadow: 0px 0px .5px 1px #0588ed;
  width: 282px;
}
.search-btn{
  text-decoration: none;
  float: right;
  width: 30px;
  height: 30px;
  background-color: #fff;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #0588ed;
}
.search-box:hover > .search-btn{
  background-color: #fff;
}
.search-txt{
  display: flex;
  padding: 0;
  width: 0px;
  border:none;
  background: none;
  outline: none;
  float: left;
  font-size: 1rem;
  line-height: 30px;
  transition: .4s;
}
.search-box:hover > .search-txt{
  width: 240px;
  padding: 0 6px;
}
.submenu {
	
	position: absolute;
}
.submenu li{
	display: inline-block; 
}



</style>

<script>
	$(function(){
		$('.search-btn').on('click', function(){
			var search = $('#search').val();
			location.href="<%=contextPath %>/search.all?search="+search;
		})
	})
</script>

</head>
<body>	
	<script>
			var msg = "<%= alertMsg%>"
			if(msg != "null"){ // 성공, 경고 메세지 문구가 담겨있을 경우
				alert(msg);
			
			<% session.removeAttribute("alertMsg"); %>
			// 해당 페이지가 로딩 될 때마다 뜨는 alert제거			
			}
		</script>
	

<div id="header">
	<div class="logo_area">
		<div class="logo_bg">

			<a href="<%=contextPath %>/index.do"><img
				src="<%=contextPath %>/resource/image/user/member/cinema_logo900.jpg" alt="시네마헤븐"></a>
		</div>
		<div class="service_area">
			<!-- <a href="" class="link search">검색</a>  -->
			<!-- 검색 지우고 돋보기 이미지 넣기 -->
			<% if(loginUser == null) { %>
			<a href = "<%=contextPath%>/loginForm.log" class="link login">로그인</a> <a href="<%=contextPath %>/terme.me" class="link signIn">회원가입</a> <br><br><br><br>
			<% } else { %>
			<a href = "<%= contextPath %>/logout.log" class="link login">로그아웃</a> <a href="<%=contextPath %>/myPage.me" class="link signIn">마이페이지</a> <br><br><br><br>
			<% } %>
			    <div class="search-box">
      				<input type="text" id="search" name="search" class="search-txt">
      				<a class="search-btn">
        			<i class="fas fa-search"></i>
      				</a>
    			</div>
		</div>
	</div>
	<div id="navi_area">
		<div class="group_nav">
			<ul class="list_navi">
				<li class="nav_item"><a href="<%=contextPath%>/list.mo" class="link nav">영화</a></li>
				<li class="nav_item"><a href="<%=contextPath%>/tList.th?currentPage=1" class="link nav">영화관</a></li>
				<li class="nav_item"><a href="<%=contextPath%>/MoView.ti" class="link nav">예매</a></li>

				<li class="nav_item"><a href="<%=contextPath %>/list.vot" class="link nav">투표하기</a>
					<ul>
						<div class="submenu">
							<li><a href="<%=contextPath %>/vote.re" class="link nav">투표결과</a></li>
							<li><a href="<%=contextPath %>/vote.pa?currentPage=1" class="link nav">이전 투표목록</a></li>
						</div>
					</ul>
				</li>
				<li class="nav_item"><a href="<%=contextPath%>/faq.no" class="link nav">고객센터</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>