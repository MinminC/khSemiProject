<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/02_search_id.css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	<div id="container">
            <div id="content_1">
                <p id="mainText">
                    	아이디 / 비밀번호 찾기
                </p>
            </div>
            <div id="content_2">
                <div id="choose">
                    <div>
                        <a href="<%= contextPath %>/sidForm.sch" id="search_id_text">아이디 찾기</a>
                    </div>
                    <div>
                        <a href="<%= contextPath%>/spwdForm.sch">비밀번호 찾기</a>
                    </div>
                </div>
                <div id="ment">
                    <p id="ment_1">
                       	 아이디를 잊으셨나요? <br>
                       	 등록된 회원정보로 아이디를 찾으실 수 있습니다.
                    </p>
                </div>
            </div>
            <div id="content_3">
                <div id="simple_search">
                    <p>
                       	간편찾기
                        <hr>
                    </p>
                </div>
                <form action="<%=contextPath %>/sid.sch" method="post">
                    <div id="check_info">
                        <div id="info_keyword">
                            	이름 <br>
                           	 생년월일 <br>
                           	 휴대폰번호 <br>
                          	  이메일 <br>
                        </div>
                        <div id="info_input">
                            <input type="text" name="memberName"> <br>
                            <input type="text" name="birth"> <br>
                            <input type="text" name="phone"> <br>
                            <input type="email" name="email"> <br>
                        </div>
                    </div>
                    <div id="btn">
                        <button type="submit">아이디 찾기</button>
                    </div>
                </form>
            </div>
        </div>
        <br clear="both">
	
		<%@ include file="../common/footer.jsp" %>
</body>
</html>