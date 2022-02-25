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
<title>비밀번호찾기_임시비밀번호발급</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/03_z04_search_pwd_imsy_pwd.css">
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
                <div class="ment">
                    <p id="ment_1">
                        임시비밀번호를 이메일로 발송해드립니다. <br>
                        임시비밀번호로 로그인 후, 비밀번호 재설정이 가능합니다.
                    </p>
                </div>
            </div>
            <div id="content_3">
                <div class="imsy_pwd">
                    <p>
                        임시비밀번호 발급
                        <hr>
                    </p>
                </div>
                <form action="<%= contextPath %>/spwdimsy.sch" method="post">
                    <div class="check_info">
                        <div id="info_keyword">
                            임시비밀번호를 받으실 이메일을 입력하세요.
                        </div>
                        <div id="info_input">
                        	<input type="hidden" name="memberId" value="<%= searchMem.getMemberId()%>">
                            <input type="email" name="email" placeholder="이메일 주소 전체를 입력해 주세요."> <br>
                        </div>
                    </div>
                    <div class="btn_div">
                        <button type="submit">다음단계</button>
                    </div>
                </form>
                
                
            </div>
        </div>
	
	
	
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>