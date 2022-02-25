<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.Movie, com.kh.theater.model.vo.Theater" %>
<%
	ArrayList<Movie> mlist = (ArrayList<Movie>)request.getAttribute("mlist");
	ArrayList<Theater> tlist = (ArrayList<Theater>)request.getAttribute("tlist");
%>
<!DOCTYPE html>
<html>
<head>
<title>시네마헤븐</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resource/css/user/ticketing/reserve.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.css" integrity="sha512-3pIirOrwegjM6erE5gPSwkUzO+3cTjpnV9lexlNZqvupR64iZBnOOTiiLPb9M36zpMScbmUNIcHUqKD47M719g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="resource/js/ticket/reserve.js"></script>
</head>
<body>
<!-- 비로그인시 로그인페이지로 보내기 -->
	<div id="wrap">
		<%@ include file="../common/header.jsp"%>
		
	<!-- 로그인 안돼있으면 못들어옴 -->
	<%// if (loginUser == null) { %>
		<% //@ include file="../common/loginCheck.jsp"%>
	<%// } %>

		<div id="container">
			<div class="reserve-container">
				<div class="movie-part">
					<div class="reserve-title">영화</div>
					<div class="movie-list-wrapper">
					<% for(Movie m : mlist) { %>
						<div class="movie-list" style="width: 100%">
							<div class="movie-list-age"><%= m.getRate() %></div>
							<div class="movie-list-title"><%= m.getMovieName() %></div>
						</div>
					<% } %>
					</div>
				</div>
				<div class="theater-part">
					<div class="reserve-title">극장</div>
					<div class="theater-container">
						<div class="theater-wrapper">
							<div class="theater-location-wrapper">
							<% for(Theater t : tlist) { %>
								<button class="theater-location" disabled><%= t.getAddress() %>(<%= t.getTheaterNum() %>)</button>
							<% } %>
							</div>
							<div class="theater-place-wrapper">
								<!-- <button class="theater-place">천호</button> -->
							</div>
						</div>
					</div>
				</div>
				<div class="day-part">
					<div class="reserve-title">날짜</div>
					<div class="reserve-date">

					</div>
				</div>
				<div class="time-part">
					<div class="reserve-title">시간</div>
					<div class="reserve-time">
						<!-- 
						<div class="reserve-where">4관(Laser) 6층(총 240석)</div>
						<div class="reserve-time-wrapper">
							<button class="reserve-time-button">
								<span class="reserve-time-want">12:20</span> 
								<span class="reserve-time-remain">240석</span>
							</button>
						</div>
						 -->
					</div>
					<div>
						<form class="moveSeatForm" action="selectSeat.ti" method="get">
							<input type="hidden" name="memberId" value="test11<%//= loginUser.getMemberId() %>">
							
							<input type="hidden" class="mName" name="mName"> 
							<input type="hidden" class="movieAge" name="movieAge"> 
							
							<input type="hidden" class="selectedTheater" name="selectedTheater"> 
							<!-- X관(총 XXX석) -->
							<input type="hidden" class="AuditoriumSeat" name="AuditoriumSeat">
							<input type="hidden" class="remainSeat" name="remainSeat">
							
							<input type="hidden" class="reserveDate" name="movieDate">
							<input type="hidden" class="runNo" name="runNo">
							<input type="hidden" class="runningTime" name="runningTime">
						</form>
					</div>
					
				</div>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>