<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%
	Member searchMem = (Member)request.getAttribute("searchMem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기_성공</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/02_z02search_id_success.css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<div id="container">
            <div id="content_1">
                <p class="mainText">
                   	 아이디 / 비밀번호 찾기
                </p>
            </div>
            <div id="content_2">
                <div class="choose">
                    <div>
                        <a href="<%= contextPath %>/login.log" id="search_id_text">아이디 찾기</a>
                    </div>
                    <div>
                        <a href="<%= contextPath%>/spwdForm.sch">비밀번호 찾기</a>
                    </div>
                </div>
                <div class="ment">
                    <p id="ment_1">
                        	개인정보보호를 위해 아이디의 일부는 *로 표시됩니다.
                    </p>
                </div>
            </div>
            <div id="content_3">
                <div class="result_text">
                    <div class="result">
                       	 결과
                        <hr>
                    </div>
                </div>
                <div class="show_result">
                    <table class="result_table">
                        <thead>
                            <tr>
                                <th></th>
                                <th class="memInfo">아이디</th>
                                <th class="memInfo">가입일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="align">
                                <td><input type="radio" checked></td>
                                <td><%= searchMem.getMemberId() %></td>
                                <td><%= searchMem.getCreateDate() %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <button id="login_btn"><a href="<%=contextPath%>/loginForm.log">로그인</a></button>                
            </div>
        </div>
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>