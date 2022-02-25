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
<title>비밀번호찾기_본인인증</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/user/loginLogout/03_z02_search_pwd_try_certify.css">
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
                        	개인정보보호를 위해 이메일의 일부는 *로 표시됩니다. <br>
                        	본인인증 후에 비밀번호 재설정이 가능합니다.
                    </p>
                </div>
            </div>
            <div id="content_3">
                <div class="simple_search">
                    <p>
                       	 본인인증
                        <hr>
                    </p>
                </div>
                <form action="<%=contextPath %>/spwdcerti.sch" method="post">
                    <div class="check_info">
                        <div id="info_keyword">
                            	내 정보에 등록된 이메일 인증 (ex.XXXX@XXX.COM)<br>
                        </div>
                        <div id="info_input">
                        	<input type="hidden" name="memberId" value="<%= searchMem.getMemberId()%>">
                            <input type="email" name="email"> <br>
                        </div>
                    </div>
                    <div class="btn_div">
                        <button type="submit">인증하기</button>
                    </div>
                </form>
                
                
            </div>
        </div>
	
	
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>