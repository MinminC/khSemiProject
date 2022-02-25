<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기_성공</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/03_z05_search_pwd_success.css">
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
                        <a href="<%= contextPath %>/sidForm.sch" id="search_id_text">아이디 찾기</a>
                    </div>
                    <div>
                        <a href="<%= contextPath%>/spwdForm.sch" id="search_pwd_text">비밀번호 찾기</a>
                    </div>
                </div>
            </div>
            <div id="content_3">
                <div class="ment">
                    <p id="ment_1">
                        <b>발급받으신 임시비밀번호로 로그인하세요.<br>
                        로그인 후 새로운 비밀번호로 변경하시기를 권장드립니다.</b>
                    </p>
                </div>
                <div class="btn_div">
                    <button id="login_btn"><a href="<%= contextPath %>/loginForm.log">로그인</a></button>    
                </div>
            </div>
        </div>
	
	
	
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>