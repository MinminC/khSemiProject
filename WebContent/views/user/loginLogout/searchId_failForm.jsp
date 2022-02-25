<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기_실패</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/02_z01search_id_fail.css">
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
                        <a href="<%= contextPath%>/spwdForm.sch">비밀번호 찾기</a>
                    </div>
                </div>
            </div>
            <div id="content_3">
                <div class="ment">
                    <p id="ment_1">
                        <b>입력하신 아이디에 일치하는 회원정보가 없습니다. <br>
                        다시 입력하거나 회원가입을 해주세요.</b>
                    </p>
                </div>
                <div class="btn_div">
                        <button id="again"><a href="<%= contextPath%>/sidForm.sch">다시입력</a></button>
                        <button id="enrollment"><a href="">회원가입</a></button>
                </div>
            </div>
        </div>
	
	
	

	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>