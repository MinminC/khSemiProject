<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.vote.model.vo.*, java.util.*, java.text.*" %>
<%
	ArrayList<VoteList> list = (ArrayList<VoteList>)request.getAttribute("list");

	int number = list.size(); 
	
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표관리1</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>

	<div class="content">
        <h2>투표 관리</h2> <br>
        <div style="width:800px">
        <p align="right"><a href="<%=contextPath %>/enroll.vot" class="btn btn-sm btn-primary">등록</a>
        <!--  &nbsp;&nbsp;<button class="btn btn-sm btn-primary">수정</button> 
        &nbsp;&nbsp;<button class="btn btn-sm btn-danger">삭제</button> --></p> 
        <table class="table table-bordered">
            <thead>
                <tr bgcolor="lightgray">
                    <th>no.</th>
                    <th>월</th>
                    <th>처리상태</th>
                </tr>
            </thead>
            <tbody>
            	<%if(list.isEmpty()){ %>
            		알아서
            	<%} else{%>
	            	<% for(int i=0; i<list.size(); i++){ %>
	                <tr>
	                    <td><%=number %></td>
	                    <td><%=list.get(i).getVoteTitle() %></td>
	                    <td align="center">
	                    
	                    <%
	                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	                	Date day1 = null;
	                	Date day2 = null;
	                	
	                	Calendar calender = Calendar.getInstance();
	                	Calendar calender1 = Calendar.getInstance();
	                	calender.add(calender.MONTH, -1);
	                	calender1.add(calender.MONTH, +1);
	                	String previousMonth = format.format(calender.getTime());
	                	String nextMonth = format.format(calender1.getTime());
	                	String sDate = format.format(list.get(i).getsDate());
	                	String eDate = format.format(list.get(i).geteDate());
	                	try {

	                		day1 = format.parse(previousMonth);

	                		day2 = format.parse(sDate);

	                	} catch (ParseException e) {
	                	
	                	}
	                	int compare1 = day1.compareTo(day2);
	                	try {
	                		day1 = format.parse(nextMonth);

	                		day2 = format.parse(eDate);
	                	}catch (ParseException e) {

	                	}
	                	int compare2 = day1.compareTo(day2);
	                    if(compare1 > -1 && compare2 > -1 ){
	                    %>
	                    <button class="" value="<%=list.get(i).getVoteNo()%>">완료</button>
	                    <%} else{%>
	                    	<button class="btn btn-sm btn-primary detail" value="<%=list.get(i).getVoteNo()%>">진행중</a></td>
	                    <%} %>
	                </tr>
	                <%number --;%>
	                <%}%>
                <%} %>
            </tbody>
        </table>
        </div>
    </div>
<script type="text/javascript">
	
	$(function(){
		$(".detail").on('click', function(){
			var voteNo = $(this).val();
			location.href= "<%=contextPath%>/voteUpdateForm.vot?voteNo=" + voteNo;
		})
	})
	
</script>
</body>
</html>
	            