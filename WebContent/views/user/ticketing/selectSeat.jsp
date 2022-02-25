<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.ticket.model.vo.Ticket" %>
<%
	Ticket t = (Ticket)request.getAttribute("selected");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>좌석 선택</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/user/ticketing/seat.css">
    <script src="resource/js/ticket/seat.js"></script>
    
</head>
<body>
	<div id="wrap">
		<%@ include file="../common/header.jsp" %>
		<div id="container">
			<div class="select-container">
				<div class="select-wrapper">
					<div class="select-title">인원/좌석</div>
					<div class="select-seat-container">
						<div class="select-seat-number-container">
							<div class="select-seat-number-wrapper">
								<div class="select-seat">
									<div class="select-seat-age">일반</div>
									<div class="select-seat-number">
										<ul class="select-seat-ul select-seat-ul-normal">
											<li class="select-number-normal">0</li>
											<li class="select-number-normal">1</li>
											<li class="select-number-normal">2</li>
											<li class="select-number-normal">3</li>
											<li class="select-number-normal">4</li>
											<li class="select-number-normal">5</li>
											<li class="select-number-normal">6</li>
											<li class="select-number-normal">7</li>
											<li class="select-number-normal">8</li>
										</ul>
									</div>
								</div>
								<div class="select-seat">
									<div class="select-seat-age">청소년</div>
									<div class="select-seat-number">
										<ul class="select-seat-ul select-seat-ul-teen">
											<li class="select-number-teen">0</li>
											<li class="select-number-teen">1</li>
											<li class="select-number-teen">2</li>
											<li class="select-number-teen">3</li>
											<li class="select-number-teen">4</li>
											<li class="select-number-teen">5</li>
											<li class="select-number-teen">6</li>
											<li class="select-number-teen">7</li>
											<li class="select-number-teen">8</li>
										</ul>
									</div>
								</div>
								<div class="select-seat">
									<div class="select-seat-age">우대</div>
									<div class="select-seat-number">
										<ul class="select-seat-ul  select-seat-ul-old">
											<li class="select-number-old">0</li>
											<li class="select-number-old">1</li>
											<li class="select-number-old">2</li>
											<li class="select-number-old">3</li>
											<li class="select-number-old">4</li>
											<li class="select-number-old">5</li>
											<li class="select-number-old">6</li>
											<li class="select-number-old">7</li>
											<li class="select-number-old">8</li>
										</ul>
									</div>
								</div>

							</div>
							<div class="reserve-number-wrapper">
								<div class="reserve-number-title">선택된 좌석 수</div>
								<div class="reserve-number">0</div>
							</div>
						</div>
						<div class="select-seat-information">
							<div class="selected-movie"><%= t.getmName() %></div>
							<div class="select-seat-information-wrapper">
								<div class="select-theater-place selected-theater-place-info"><%= t.getTheaterName() %></div>
								<div class="select-theater-place selected-theater-place-info"><%= t.getAuditoriumName() %></div>
								<div class="select-theater-place">
									<span>남은좌석</span><span class="remain-seats"><%= t.getRemain() %></span>
								</div>

							</div>
							<div class="select-theater-date">
								<div class="theater-date">2022.02.01(화)</div>
								<div class="theater-time"><%= t.getRunSch() %></div>
							</div>
							<div class="selected-seats-wrapper">
								<span class="selected-seats-title">좌석번호</span> 
                                <span class="selected-seats">선택한 좌석이 없습니다.</span>
							</div>
							<div class="ticket-price-wrapper">
								<div class="ticket-price-title">가격</div>
								<div class="ticket-price">0원</div>
							</div>
								<input type="hidden" class="memberNo" name="memberNo" value="<%= loginUser.getMemberNo() %>">
								<input type="hidden" class="runNo" name="runNo" value="<%= t.getRunNo() %>">
 								<!-- 영화 정보 -->
								<input type="hidden" class="title" name="title" value="<%= t.getmName() %>"> 
								<input type="hidden" class="selectedTheater" name="selectedTheater" value="<%= t.getTheaterName() %>">
								<input type="hidden" class="reserveDate" name="reserveDate" value="2022/02/01">
								<input type="hidden" class="runningTime" name="runningTime" value="<%= t.getRunSch() %>">
								<input type="hidden" class="movieAge" name="movieAge" value="<%= t.getRate() %>">
								<!-- 티켓의수(선택한 좌석) -->
								<input type="hidden" class="ticketNumber" name="ticketNumber">
								<input type="hidden" class="ticketType" name="ticketType">
								<input type="hidden" class="selectedSeat" name="selectedSeat">
								<!-- 결제 정보 -->
								<input type="hidden" class="payMoney" name="payMoney">
								<button type="button" class="reserve-button" onclick="kakaopay();"><img src="<%= contextPath %>/resource/image/user/pay.jpg" alt="결제하기" width="70px"></button>
						</div>

					</div>
					<div class="seat-container">
						<div class="seat-state">
							<div class="state">
								<div class="seat-type btn btn-primary"></div>
								<div class="seat-disc">선택 좌석</div>
							</div>
							<div class="state">
								<div class="seat-type type2"></div>
								<div class="seat-disc">예매 완료</div>
							</div>
							<div class="state">
								<div class="seat-type type3"></div>
								<div class="seat-disc">선택 불가</div>
							</div>
						</div>
						<div class="seat-wrapper">
							<div class="screen-view-wrapper">
								<div class="screen-view">SCREEN</div>
								
								<% 
									String seat = t.getAuditoriumName();
									seat = seat.substring(5, seat.length()-2);
								%>
								<% if(Integer.parseInt(seat) == 160) { %>
									<%@ include file="seat160.jsp" %>
								<% } else if(Integer.parseInt(seat) == 120) { %>
									<%@ include file="seat120.jsp" %>
								<% } else { %>
									<%@ include file="seat100.jsp" %>
								<% } %>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br><br><br>
		</div>
        <%@ include file="../common/footer.jsp" %>
    </div>
</body>
</html>