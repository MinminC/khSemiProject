<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.theater.model.vo.TheaterAuditorium, com.kh.theater.model.vo.Auditorium, java.util.ArrayList" %>
<%
	ArrayList<TheaterAuditorium> taList = (ArrayList<TheaterAuditorium>)request.getAttribute("taList");
	ArrayList<Auditorium> auList = (ArrayList<Auditorium>)request.getAttribute("auList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 영화관 수정</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/admin/theater/05_z04_admin_movietheater_update.css">
</head>
<body>

		<div id="container">
			<div class="menutab">
       	 		<%@ include file="../common/menubar.jsp" %>
    		</div>
    		<div id="content_wrap">
    		<form action="<%= contextPath%>/atUpdate.th" method="post">
            	<div id="content_1">
                	<div id="title">
                    	<h2>영화관 수정</h2>
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
                            	영화관 로고 <br>
                        	</div>
                        	<div id="input_tag">
                        		<input type="hidden" name="theaterNo" value="<%= taList.get(0).getTheaterNo()%>">
                        		<input type="hidden" name="auditoriumNo" value="<%= taList.get(0).getAuditoriumNo()%>">
                            	<input type="text" name="theaterName" value="<%= taList.get(0).getTheaterName()%>"><br>
                            	<input type="text" name="address" value="<%= taList.get(0).getAddress() %>"><br>
                            	<input type="text" name="auditoriumNum" value="<%= taList.get(0).getAuditoriumNum()%>"><br>
                            	<input type="text" name="phone" value="<%= taList.get(0).getPhone()%>"><br>
                            	<input type="text" name="seatNum" value="<%= taList.get(0).getSeatNum()%>"><br>
                            	<input type="text" name="theaterImg" value="<%= taList.get(0).getTheaterImg()%>"><br>
                            	(1: CGV / 2: 롯데시네마 / 3: 메가박스)
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
							<tr>
                                <td><input type="checkbox" value="1관" class="auditoriumA" name="auditoriumName">1관</td>
                                <td><input type="checkbox" value="100" class="seatA" name="auditoriumSeatNum">100석</td>
                                <td><input type="checkbox" value="120" class="seatA" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" class="seatA" name="auditoriumSeatNum">160석</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" value="2관" name="auditoriumName">2관</td>
                                <td><input type="checkbox" value="100" id="" name="auditoriumSeatNum">100석</td>
                                <td><input type="checkbox" value="120" id="" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" id="" name="auditoriumSeatNum">160석</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" value="3관" name="auditoriumName">3관</td>
                                <td><input type="checkbox" value="100" id="" name="auditoriumSeatNum">100석</td>
                                <td><input type="checkbox" value="120" id="" name="auditoriumSeatNum">120석</td>
                                <td><input type="checkbox" value="160" id="" name="auditoriumSeatNum">160석</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <script>
                	$(function(){ // DB에 저장된 상영관명, 좌석수의 해당하는 체크박스에 체크
                <%
                	String auditoriumNameA = ""; // 1관
                	String auditoriumSeatNumA = "";
                	String auditoriumNameB = ""; // 2관
                	String auditoriumSeatNumB = "";
                	String auditoriumNameC = ""; // 3관
                	String auditoriumSeatNumC = "";
                	
                		if(auList.size() == 1){ // 저장된 상영관의 수가 1개일 때 
							auditoriumNameA = (auList.get(0).getAuditoriumName() == null)? "" : auList.get(0).getAuditoriumName();		
							auditoriumSeatNumA = (auList.get(0).getSeatNum() == null)? "" : auList.get(0).getSeatNum();
                		} else if(auList.size() == 2){ // 저장된 상영관의 수가 2개일 때 
							auditoriumNameA = (auList.get(0).getAuditoriumName() == null)? "" : auList.get(0).getAuditoriumName();		
							auditoriumSeatNumA = (auList.get(0).getSeatNum() == null)? "" : auList.get(0).getSeatNum();
							auditoriumNameB = (auList.get(1).getAuditoriumName() == null)? "" : auList.get(1).getAuditoriumName();		
							auditoriumSeatNumB = (auList.get(1).getSeatNum() == null)? "" : auList.get(1).getSeatNum();	
                		} else if(auList.size() == 3){ // 저장된 상영관의 수가 3개일 때 
							auditoriumNameA = (auList.get(0).getAuditoriumName() == null)? "" : auList.get(0).getAuditoriumName();		
							auditoriumSeatNumA = (auList.get(0).getSeatNum() == null)? "" : auList.get(0).getSeatNum();
							auditoriumNameB = (auList.get(1).getAuditoriumName() == null)? "" : auList.get(1).getAuditoriumName();		
							auditoriumSeatNumB = (auList.get(1).getSeatNum() == null)? "" : auList.get(1).getSeatNum();	
							auditoriumNameC = (auList.get(2).getAuditoriumName() == null)? "" : auList.get(2).getAuditoriumName();		
							auditoriumSeatNumC = (auList.get(2).getSeatNum() == null)? "" : auList.get(2).getSeatNum();	
                		}
				%>
						// 상영관명, 좌석수 jQuery변수
                		var auditoriumNameA = "<%= auditoriumNameA %>";
                		var auditoriumSeatNumA = "<%= auditoriumSeatNumA %>";
                		
                		var auditoriumNameB = "<%= auditoriumNameB %>";
                		var auditoriumSeatNumB = "<%= auditoriumSeatNumB %>";
                		
                		var auditoriumNameC = "<%= auditoriumNameC %>";
                		var auditoriumSeatNumC = "<%= auditoriumSeatNumC %>";
                		
                		// 상영관명에 해당하는 좌석수 체크박스에 체크
                		$("tbody").children().eq(0).find(':checkbox').each(function(){
                			
                			if(auditoriumNameA.search($(this).val()) != -1){
                        		$(this).attr("checked", true);
                        	}
                			if(auditoriumSeatNumA.search($(this).val()) != -1){
                				$(this).attr("checked", true);
                			}
                			
                		})
                		$("tbody").children().eq(1).find(':checkbox').each(function(){
                			
                			if(auditoriumNameB.search($(this).val()) != -1){
                        		$(this).attr("checked", true);
                        	}
                			if(auditoriumSeatNumB.search($(this).val()) != -1){
                				$(this).attr("checked", true);
                			}
                			
                		})
                		$("tbody").children().eq(2).find(':checkbox').each(function(){
                			
                			if(auditoriumNameC.search($(this).val()) != -1){
                        		$(this).attr("checked", true);
                        	}
                			if(auditoriumSeatNumC.search($(this).val()) != -1){
                				$(this).attr("checked", true);
                			}
                			
                		})
				
                	})
                </script>
                
                <br clear="both">
            </div>
            <div id="content_3">
                <hr>
                <div id="ex_info">
                    위치안내 &emsp;<input type="text" name="location" value="<%= taList.get(0).getLocation() %>" placeholder="위도, 경도를 ','를 포함하여 작성해주세요. ex) 36.12345, 127.123456" style="width:500px;"></input><br><br>
                    교통안내 &emsp;<textarea name="traffic" style="resize: none; height:300px;" placeholder="줄바꿈대신 '&'를 사용해주세요."><%= taList.get(0).getTraffic() %></textarea><br><br>
                    주차안내 &emsp;<textarea name="parking" style="resize: none; height:200px;" placeholder="줄바꿈대신 '&'를 사용해주세요."><%= taList.get(0).getParking() %></textarea><br><br>
                </div>
            </div>
            <div id="content_4">
                	<a href="<%= contextPath%>/atList.th?currentPage=1" class="btn btn-outline-primary">목록가기</a>
                    <button class="btn btn-outline-primary" type="reset">취소하기</button>
                    <button class="btn btn-outline-primary" type="submit">수정하기</button>
            </div>
            </form>
        </div>
    	</div>
	
	
	
	
</body>
</html>