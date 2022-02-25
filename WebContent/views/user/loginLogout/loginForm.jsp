<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시네마 헤븐(로그인폼)</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/01_loginform.css">
</head>
	
	<%@ include file="../common/header.jsp" %>

	<div id="container">
            <div id="content_1">
                <p id="login">로그인</p>
            </div>
            <div id="content_2">
                <div id="login_form">
                    <form action="<%= contextPath %>/login.log" method="post">
                        <div id="id_pwd">
                            <input type="text" placeholder="아이디" name="memberId" id="userId" required><br>
                            <input type="password" placeholder="비밀번호" name="memberPwd" id="userPwd" required>
                        </div>
                        
                        <div id="login_btn">
                            <button type="submit">로그인</button>
                        </div>
                        
                        <br clear="both">
                        
                        <div id="search_id_pwd">
                            <a href="<%= contextPath %>/sidForm.sch">아이디찾기</a>&emsp;|&emsp;
                            <a href="<%= contextPath%>/spwdForm.sch">비밀번호찾기</a>
                        </div>
                    </form>
                </div>
                <div id="ad">
                    <div id="ad_1">
                    	    광고/투표독려
                    </div>
                </div>
            </div>

            <div id="content_3">
                <hr>
                    <p>
                        &emsp;&emsp;&emsp;아직 시네마헤븐의 회원이 아니신가요? 회원가입하시고 다양한 혜택을 누려보세요.
                        <a href="">&emsp;&emsp;회원가입</a>
                    </p>
            </div>
        </div>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>