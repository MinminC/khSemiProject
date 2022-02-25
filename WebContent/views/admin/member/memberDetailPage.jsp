<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>

<% 
	Member m = (Member)request.getAttribute("m");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>

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
</style>


</head>
<body>
    <div class="outer">
        <div class="menubar">
           <%@ include file="../common/menubar.jsp" %>
        </div>
        <div class="content">
            <div class="container">
                <br>
                <h2>회원 수정</h2>
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th>아이디</th>
                            </tr>
                            <tr>
                                <td>
                                	<%=m.getMemberId() %>
                                	<input type="hidden" id="memberId" name="memberId" value="<%=m.getMemberId()%>">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button id="temporaryEmailBtn">임시 비밀번호 발급</button>
                                </td>
                            </tr>
                            <tr>
                                <th>이름</th>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" name="memberName" id="memberName" value="<%=m.getMemberName()%>" required>
                                </td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" name="email" id="email" value="<%=m.getEmail()%>" required>
                                    <input type="hidden" name="before_email" id="before_email" value="<%=m.getEmail() %>">
                                </td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" name="phone" id="phone" value="<%=m.getPhone()%>" required>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="btn-area">
                        <input type="button" id="cancle" value="취소">
                        <input type="button" id="update_btn" value="수정">
                    </div>
            </div>
        </div>
    </div>
<script type="text/javascript">
	
	$(function(){
		function getContextPath() {
			var hostIndex = location.href.indexOf( location.host ) + location.host.length;
			return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
		};
		
		$('#cancle').on('click',function(){
			history.back();
		})
		
		$('#temporaryEmailBtn').on('click', function(){
			
			$.ajax({
				url : getContextPath()+"/tempMail.me",
				data : { 
					email : $('#email').val(),
					memberId : $('#memberId').val()
					},
				type : "post",
				success : function(result){
					if(result != 1){
						alert('사용 할 수 없는 이메일 입니다.');
					}else{
						alert('이메일 인증번호가 해당 이메일로 전송 되었습니다.');
					}
				},
				error : function(){
					console.log('비밀번호 발송 실패');
				}
			})
			
			
		})
		
		$('#update_btn').on('click', function(){
			$.ajax({
				url : getContextPath()+"/adminUpdate.me",
				data : { 
					email : $('#email').val(),
					memberId : $('#memberId').val(),
					memberName : $('#memberName').val(),
					phone : $('#phone').val(),
					beforeEmail : $('#before_email').val()
				},
				type : "post",
				success : function(result){
					if(result == 1){
						alert('회원 수정 완료.');
					}else if(result == 2){
						alert('이메일이 중복 입니다.');
					}else{
						alert('수정 실패');
					}
				},
				error : function(){
					console.log('비밀번호 발송 실패');
				}
			})
			
			
		})
		
		
		
	})
	
	


</script>
</body>
</html>