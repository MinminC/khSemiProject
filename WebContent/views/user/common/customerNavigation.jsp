<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/user/common/subNav.css">
</head>
<body>
	 <div class="sub-nav-area">
        <div class="sub-nav-head">
            <h2>고객센터</h2>
        </div>
        <div class="sub-nav-list">
           <a href="<%=request.getContextPath()%>/faq.no">FAQ</a> 
        </div>
        <div class="sub-nav-list qeustion-form">
            <a href="<%=request.getContextPath()%>/enroll-form.qu">1:1문의</a> 
        </div>
        <div class="sub-nav-list">
           <a href="<%=request.getContextPath()%>/list.no">공지사항</a> 
        </div>
        <div class="sub-nav-bottom" style="border: none;">
            <span>시네마 헤븐 고객센터</span>
            For Your Convinience
            <br><br>
            9:30 ~ 18:30
        </div>
    </div>
</body>
</html>