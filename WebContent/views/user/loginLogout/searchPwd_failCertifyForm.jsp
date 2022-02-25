<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기_이메일인증실패</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/03_z03_search_pwd_fail_certify.css">
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
                        <a href="<%= contextPath%>/spwdForm.sch"" id="search_pwd_text">비밀번호 찾기</a>
                    </div>
                </div>
            </div>
            <div id="content_3">
                <div class="ment">
                    <p id="ment_1">
                        <b>본인인증에 실패하였습니다.<br>
                        이메일을 다시 입력하거나 회원가입을 해주세요.</b>
                    </p>
                </div>
                <div class="btn_div">
                    <button id="again" onclick="history.back();">다시입력</button>
                    <button id="enrollment"><a href="" id="enrollment_1">회원가입</a></button>
                </div>
                
            </div>
        </div>
        
	
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>