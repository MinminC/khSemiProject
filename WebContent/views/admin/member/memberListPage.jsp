<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.member.model.vo.Member, com.kh.common.model.vo.PageInfo" %>

<% 
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); 
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int currentPage = (int)pi.getCurrentPage();
	
	int startPage = (int)pi.getStartPage();
	int endPage = (int)pi.getEndPage();
	int maxPage = (int)pi.getMaxPage();
	
	
	String msg = (String)request.getAttribute("msg");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<style type="text/css">
    #temporaryEmailBtn , .btn-area>input, #searchBtn{
        width: 160px;
        height: 40px;
        background: rgb(13, 71, 161);
        color: white;
    }
    .page-area a{
        width: 40px;
        height: 40px;
        background: rgb(13, 71, 161);
        color: white;
    }
    
    .updateBtn{
    	background: rgb(13, 71, 161);
    	color : white;
    }
    .deleteBtn, .removeBtn{
    	background: red;
    	color : white;
    	width: 
    }
    .page_btn, .page_btn_disabled{
    	width: 40px;
    	height: 40px;
    }
</style>


</head>
<body>
    <div class="outer">
        <div class="menubar">

            <%@ include file="../../admin/common/menubar.jsp" %>

        </div>
        <div class="content">
            <div class="container">
                <br>
                <h2>회원 관리</h2>
                <div class="search-area">
                    <input type="text" name="keyword" id="keyword">
                    <input id="searchBtn" type="button" value="검색">
                </div>         
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>회원아이디</th>
                            <th>회원이름</th>
                            <th>생년월일</th>
                            <th>성별</th>
                            <th>이메일</th>
                            <th>전화번호</th>
                            <th>상태</th>
                            <th>수정 / 삭제</th>
                        </tr>
                    </thead>
                    <%if(list.isEmpty()) {%>
					<tr>
						<td colspan="8">조회된 게시글이 없습니다.</td>
						</tr>
					<%} else {
						for(Member m : list){
					%>
					<tr>
						<td><input type="hidden" name="memberNo" value="<%=m.getMemberNo() %>" >
							<%=m.getMemberNo() %>
						</td>
						<td><%=m.getMemberId()%></td>
						<td><%=m.getMemberName() %></td>
						<td><%=m.getBirth() %></td>
						<td><%=m.getGender() %></td>
						<td><%=m.getEmail() %></td>
						<td><%=m.getPhone() %></td>
						<td>
							<%if(m.getMemberStatus().equals("Y")){ %>
							회원
							<%}else{ %>
							탈퇴
							<%} %>
						<td>
							<%if(m.getMemberStatus().equals("Y")){ %>
							<button class="updateBtn" value="<%=m.getMemberNo()%>">수정</button>
							<button class="deleteBtn" value="<%=m.getMemberNo()%>">삭제</button>
							<%}else{ %>
							<button class="removeBtn" value="<%=m.getMemberNo() %>">복구</button>
							<%} %>
                        </td>
					</tr>
					<%	}
					}%>
                </table>
                <%if(!list.isEmpty()) {%>
                <div class="page-area" align="center">
					
					<%if (currentPage != 1){ %>
						<button class="page_btn" onclick="location.href='<%=contextPath%>/memberList.me?currentPage=<%= currentPage - 1 %>'">&lt;</button>
					<%} %>
					<% for(int i = startPage; i <= endPage; i++) {%>
						<%if(i != currentPage) {%>
							<button class="page_btn" onclick="location.href='<%=contextPath%>/memberList.me?currentPage=<%= i %>'"><%= i %></button>
                     
						<%}else{%>
							<button class="page_btn_disabled" disabled><%= i %></button>
						<%} %>
					<%} %>
					<% if(currentPage != maxPage) { %>
						<button class="page_btn" onclick="location.href='<%=contextPath%>/memberList.me?currentPage=<%= currentPage + 1 %>'">&gt;</button>
					<%} %>
					
				</div>
				<%} %>
			</div>
        </div>
    </div>
</body>
<script type="text/javascript">
	$(function(){
		function getContextPath() {
			var hostIndex = location.href.indexOf( location.host ) + location.host.length;
			return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
		};
		
		$('#searchBtn').on('click', function(){
			location.href=getContextPath()+"/memberList.me?currentPage=1&keyword="+$('#keyword').val();
		})
		
		$(".updateBtn").on('click', function(){
			var memberNo = $(this).val();
			location.href= "<%=contextPath%>/adminDetail.me?memberNo=" + memberNo;
		})
		$('.deleteBtn').on('click', function(){
			var memberNo = $(this).val();
			location.href= "<%=contextPath%>/delete.me?memberNo=" + memberNo;
		})
		$('.removeBtn').on('click', function(){
			var memberNo = $(this).val();
			location.href= "<%=contextPath%>/remove.me?memberNo=" + memberNo;
		})
		
		var msg = '<%=msg%>';
		
		if(msg != 'null'){
			alert(msg);
		}
	})
</script>
</html>