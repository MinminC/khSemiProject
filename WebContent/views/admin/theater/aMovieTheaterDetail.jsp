<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.theater.model.vo.TheaterAuditorium, java.util.ArrayList" %>
<%
	ArrayList<TheaterAuditorium> taList = (ArrayList<TheaterAuditorium>)request.getAttribute("taList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 영화관 상세</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/admin/theater/05_z02_admin_movietheater_detail.css">
</head>
<body>

		<div id="container">
			<div class="menutab">
       	 		<%@ include file="../common/menubar.jsp" %>
    		</div>
    		<div id="content_wrap">
            	<div id="content_1">
                	<div id="title">
                    	<h2>영화관 상세</h2>
            		</div>
            	</div>
            	<div id="content_2">
                	<div class="input_info">
                    	<div id="movietheater_info">
                        	<div id="input_ment">
                           	 영화관명 : <br>
                            	주소 : <br>
                            	상영관수 : <br>
                            	전화번호 : <br>
                            	좌석수 : <br>
                            	영화관 로고 : <br>
                        	</div>
                            	
                        	<div id="input_tag">
                            	<%= taList.get(0).getTheaterName() %><br>
                            	<%= taList.get(0).getAddress() %><br>
                            	<%= taList.get(0).getAuditoriumNum() %><br>
                            	<%= taList.get(0).getPhone() %><br>
                            	<%= taList.get(0).getSeatNum() %><br>
                            	<%= taList.get(0).getTheaterImg() %> (1: CGV / 2: 롯데시네마 / 3: 메가박스)<br>
                            	
                        	</div>
                    	</div>
                    	<br clear="both">
                	</div>
                	<div>
                    <table class=table>
                        <thead>
                            <tr>
                                <th>상영관명</th>
                                <th>좌석수</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for(TheaterAuditorium ta : taList) { %>
                            <tr>
                                <td><%= ta.getAuditoriumName() %></td>
                                <td><%= ta.getAuditoriumSeatNum() %>석</td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                
                <br clear="both">
            </div>
            <div id="content_3">
                <hr>
                <div id="ex_info">
                    위치안내 :  &emsp;<%= taList.get(0).getLocation() %><br><br>
                    교통안내 :  &emsp;<pre><%= taList.get(0).getTraffic()%></pre>
                    주차안내 :  &emsp;<pre><%= taList.get(0).getParking()%></pre>
                </div>
            </div>
            <div id="content_4">
                <div>
                	<a href="<%= contextPath%>/atList.th?currentPage=1" class="btn btn-outline-primary">목록가기</a>
                	<form action="<%= contextPath%>/atUpdateForm.th">
                		<input type="hidden" name="tno" value=<%= taList.get(0).getTheaterNo() %>>
	                    <button class="btn btn-outline-primary" type="submit">수정하기</button>
                	</form>
                	<form action="<%= contextPath%>/atDelete.th">
                		<input type="hidden" name="list" value=<%= taList.get(0).getTheaterNo() %>>
	                    <button class="btn btn-outline-primary" type="submit">삭제하기</button>
                	</form>
                </div>
            </div>
        </div>
    	</div>
	
	
	
	
</body>
</html>