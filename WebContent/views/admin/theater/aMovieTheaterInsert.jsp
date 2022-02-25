<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String auditoriumNo = (String)request.getAttribute("auditoriumNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 영화관 등록</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/admin/theater/05_z03_admin_movietheater_insert.css">
</head>
<body>
		<div id="container">
			<div class="menutab">
       	 		<%@ include file="../common/menubar.jsp" %>
    		</div>
    		<div id="content_wrap">
    		<form action="<%= contextPath%>/atInsert.th" method="post">
            	<div id="content_1">
                	<div id="title">
                    	<h2>영화관 등록</h2>
            		</div>
            	</div>
            	<div id="content_2">
                	<div class="input_info">
                    	<div id="movietheater_info">
                        	<div id="input_ment">
                           	 	영화관명 <br>
                            	주소 <br>
                            	상영관수 <br>
                            	전화번호 <br>
                            	좌석수 <br>
                        	</div>
                        	<div id="input_tag">
                            	<input type="text" name="theaterName">
                            	<input type="text" name="address"><br>
                            	<input type="text" name="auditoriumNum"><br>
                            	<input type="text" name="phone"><br>
                            	<input type="text" name="seatNum"><br>
                            	<input type="hidden" name="auditoriumNo" value="<%= auditoriumNo%>">
                        	</div>
                    	</div>
                    	<br clear="both">
                    	<div id="movietheater_file">
                    		<p></p>
                        	<p>영화관 이미지 (1: CGV / 2: 롯데시네마 / 3: 메가박스)</p>
                        	<input type="text" name="theaterImg" placeholder="숫자(1,2,3)으로 입력해주세요." style="width:225px"> 
                    	</div>
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
                            <tr>
                                <td><input type="checkbox" value="1관" name="auditoriumName" checked>1관</td>
                                <td><input type="checkbox" value="100" name="auditoriumSeatNum" checked>100석</td>
                                <td><input type="checkbox" value="120" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" name="auditoriumSeatNum">160석</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" value="2관" name="auditoriumName">2관</td>
                                <td><input type="checkbox" value="100" name="auditoriumSeatNum">100석</td>
                                <td><input type="checkbox" value="120" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" name="auditoriumSeatNum">160석</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" value="3관" name="auditoriumName">3관</td>
                                <td><input type="checkbox" value="100" name="auditoriumSeatNum">100석</td>
                                <td><input type="checkbox" value="120" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" name="auditoriumSeatNum">160석</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <br clear="both">
            </div>
            <div id="content_3">
                <hr>
                <div id="ex_info">
                    위치안내 &emsp;<input type="text" placeholder="위도, 경도를 ','를 포함하여 작성해주세요. ex)36.12345, 127.123456" style="width:500px;" name="location"></input><br><br>
                    교통안내 &emsp;<textarea style="resize: none; height:150px;" name="traffic" placeholder="줄바꿈대신 '&'를 사용해주세요."></textarea><br><br>
                    주차안내 &emsp;<textarea style="resize: none; height:150px;" name="parking" placeholder="줄바꿈대신 '&'를 사용해주세요."></textarea><br><br>
                </div>
            </div>
            <div id="content_4">
            		<a href="<%= contextPath%>/atList.th?currentPage=1" class="btn btn-outline-primary">목록가기</a>
                    <button class="btn btn-outline-primary" type="reset">취소하기</button>
                    <button class="btn btn-outline-primary" type="submit">등록하기</button>
            </div>
            </form>
        </div>
    	</div>
	
	
	
	
</body>
</html>