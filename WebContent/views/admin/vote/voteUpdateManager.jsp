<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.vote.model.vo.*" %>
<%
	ArrayList<VoteList> list = (ArrayList<VoteList>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<%@ include file="../common/menubar.jsp" %>
	<div class="content">
	<br><br>
		<h2>투표관리</h2>
		<br><br>
			<%if(list.isEmpty()){ %>
				알아서
			<%} else{%>
			<form action="<%=contextPath %>/voteUpdate.vot" method="post" enctype="multipart/form-data">
					<input type="hidden" name="voteNo" value="<%=list.get(0).getVoteNo() %>">
				 <label>투표 명칭 : <input type="text" name="voteTitle" value="<%=list.get(0).getVoteTitle() %>"></label> <br><br>
				 <label>투표 시작일  : <input type="date" name="sDate" value="<%=list.get(0).getsDate()%>"></label> <br><br>
				 <label>투표 마감일  : <input type="date" name="eDate" value="<%=list.get(0).geteDate()%>"></label> <br><br>
	
			   <br><br>
			   
			<div style="width:800px">
				  
		        <table class="table table-bordered">
		            <thead>
		                <tr bgcolor="lightgray">
		                    <th>no.</th>
		                    <th width=120px;>제목</th>
		                    <th width=120px;>장르</th>
		                    <th width=120px;>파일등록</th>
		                    <th>시놉시스</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<%for(int i= 0; i<4; i++) {%>
		                <tr>
		                    <td><%=i+1 %><input type="hidden" name="vreNo<%=i+1 %>"  value="<%=list.get(i).getVreNo()%>"></td>
		                    <td><input type="text" name="vreTitle<%=i+1 %>" value="<%=list.get(i).getVreTitle()%>"></td>
		                    <td><input type="text" name="vreGenre<%=i+1 %>" value="<%=list.get(i).getVreGenre()%>"></td>
		                    <td>
		                    	<input type="file" name="file<%=i+1%>">
		                    	<input type="hidden" name="filePath<%=i+1 %>" value="<%=list.get(i).getVreFilePath()%>">
		                    </td>
		                    <td><textarea rows="4" cols=45; name="synopsis<%=i+1%>"><%=list.get(i).getVreSynopsis() %></textarea></td>
		                </tr>
		                <%} %>
		            </tbody>
		        </table>
					<p>
			            <input type="submit" value="수정" class="btn btn-sm btn-primary">
			            
			            <input type="button" value="수정취소" class="btn btn-sm btn-secondary">
			        </p>
		    </div>
	    </form> 
	    <%} %>
	</div>
	<br><br><br><br>

	
</body>
</html>