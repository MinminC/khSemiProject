<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>
<% String contextPath = request.getContextPath(); 
	Member m = (Member) request.getAttribute("m");
	
	String yyyy = m.getBirth().substring(0,4);
	int mm = Integer.parseInt(m.getBirth().substring(5,7));
	String dd = m.getBirth().substring(8);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<link rel="stylesheet" href="<%=contextPath %>/resource/css/user/member/memberForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resource/js/member/member.js"></script>
<style type="text/css">

.button_hidden{
	display: none;
}
</style>
<body>
</head>

	<div class="header">
		<div class="logo_bg">
			<img src="<%=contextPath %>/resource/image/user/member/cinema_logo900.jpg" alt="시네마헤븐">
		</div>
	</div>
	<div class="outer">
		<div class="member-area" align="center">
            <fieldset>
            <legend>회원수정</legend>
            <form action="<%=contextPath %>/update.me" method="post">
                <ul>
                    <li>
                    	<div class="id-area">
                    		<div align="left" style="width: 280px">
                        		<label for="memberId">아이디</label>
                    		</div>
	                    </div>
                    </li>
                    <li>
                    	<%=m.getMemberId() %> 
                        <input type="hidden" class="member_input" name="memberNo" id="memberNo" maxlength="20" value="<%=m.getMemberNo() %>" required placeholder="영문 대.소문자, 숫자 _,-만 입력 가능하고 5에서 20자리">
                    </li>
                     <li class="id_text error_text">
                    </li>
                    <li>
                        <label for="memberPwd">비밀번호 <span style="color:red; font-size: 9px" class="span_red">변경시만 입력</span></label>
                    </li>
                    <li class="pwd_hidden">
                        <input type="password" class="member_input" name="memberPwd2" id="memberPwd2" maxlength="16" placeholder="영문 대문자와 소문자, 숫자, 특수문자를 하나 이상 포함하여 8~16">
                    </li>
                    <li class="pwd_text error_text">
                    </li>
                    <li>
                        <label for="pwdCheck">비밀번호 확인</label>
                    </li>
                    <li>
                        <input type="password" class="member_input" id="pwdCheck2" placeholder="비밀번호 한번 더 입력해 주세요.">
                    </li>
                    <li class="pwdCheck_text error_text">
                    </li>
                    <li>
                        <label for="memberName">이름</label>
                    </li>
                    <li>
                        <input type="text" class="member_input" name="memberName" id="memberName" value="<%=m.getMemberName() %>" required placeholder="2~6자 한글만">
                    </li>
                    <li class="name_text error_text">
                    </li>
                    <li>
                        <label for="yyyy">생년월일</label>
                    </li>
                    <li>
                        <input type="text" name="yyyy" id="yyyy" value="<%=yyyy %>" class="birth_input" maxlength="4" placeholder="년" required>
                        <select name="mm" id="mm" class="birth_input">
                            <option value="0">월</option>
                        	<%for(int i =1; i<=12; i++) {%>
                        		<%if(mm == i){ %>
									<%if(i<10) {%>                        	
	                            		<option value="0<%=i%>" selected>0<%=i %></option>
	                            	<%} else{%>
	                            		<option value="<%=i%>" selected><%=i %></option>
	                            	<%}%>
	                            <%}else{ %>
	                            	<%if(i<10) {%>                        	
	                            		<option value="0<%=i%>">0<%=i %></option>
	                            	<%} else{%>
	                            		<option value="<%=i%>"><%=i %></option>
	                            	<%}%>
	                            <%} %>
							<%} %>
                        </select>
                        <input type="text" name="dd" id="dd" value="<%=dd %>" class="birth_input" maxlength="2" placeholder="일" required>
                    </li>
                    <li>
                        <label for="gender">성별</label>
                    </li>
                    <li>
                        <select name="gender" id="gender" class="member_input">
                            <option value="0">성별</option>
                        	<%if(m.getGender().equals("남")){ %>
                            <option value="남" selected>남</option>
                            <option value="여">여</option>
                            <%} else {%>
                            <option value="남" >남</option>
                            <option value="여" selected>여</option>
                            <%} %>
                        </select>
                    </li>
                    <li>
                        <label for="email">이메일  <span style="color:red; font-size: 9px" class="span_red">변경시 이메일 재 인증</span></label>
                    </li>
                    <li>
                        <input type="text" id="email" name="email" value="<%=m.getEmail() %>" class="member_input" required placeholder="@ 포함으로 입력 해주세요.">
                        <input type="hidden" id="beforeEmail" name="beforeEmail" value="<%=m.getEmail()%>">
                    </li>
                     <li class="email_text error_text">
                    </li>
                    <li class="remove">
                        <input type="button" id="emailChange" class="member_input member_btn" value="이메일 변경" >
                    </li>
                    <li>
                        <input type="button" id="emailReCheck" class="member_input member_btn button_hidden" value="이메일 인증" >
                    </li>
                    <li class="button_hidden">
                        <input type="text" id="email_check" class="member_input">
                    </li>
                    <li class="button_hidden">
                        <input type="button" id="CheckBtn" class="member_input member_btn" value="인증번호 확인">
                    </li>
                     <li class="email_certification_text error_text">
                    </li>
                    <li>
                        <label for="phone">휴대전화</label>
                    </li>
                    <li>
                        <input type="text" name="phone" id="phone" value="<%=m.getPhone() %>" class="member_input" required placeholder="-포함 숫자만 입력해주세요.">
                    </li>
                    <li class="phone_text error_text">
                    </li>
                    <li>
						관심장르(중복 가능)
                    </li>
                    <li> 
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="액션">액션
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="애니메이션">애니메이션
						  </label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="드마라">드마라
							</label>
						</div>
                    </li>
                    <li> 
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="스릴러">스릴러
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="로맨스">로맨스
						  </label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="코미디">코미디
							</label>
						</div>
                    </li>
                    <li> 
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="범죄">범죄
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="공포">공포
						  </label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="미스터리">미스터리
							</label>
						</div>
                    </li>
                    <li> 
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="성인물">성인물
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="사극">사극
						  </label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label">
								<input type="checkbox" name="interest" class="form-check-input" value="SF">SF
							</label>
						</div>
                    </li>
                </ul>
                <div>
                    <input class="member_input member_btn update_btn" type="submit" value="수정">
                </div>
            </form>
            	<br>
            	<div class="container">
					<button type="button" class="delete_btn" data-toggle="modal" data-target="#myModal">삭제	</button>
					<!-- The Modal -->
					<div class="modal" id="myModal">
						<div class="modal-dialog">
							<div class="modal-content">
			      
								<!-- Modal Header -->
								<div class="modal-header">
									<h4 class="modal-title">비밀번호 입력</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
			        
								<!-- Modal body -->
								<form action="<%=contextPath%>/memberDelete.me" method="post">
								<div class="modal-body">
									<input class="pwssword_input" type="password" id="deletePwd" name="deletePwd">
								</div>
			        
								<!-- Modal footer -->
								<div class="modal-footer" align="center">
									<input type="hidden" value="<%=m.getMemberNo() %>" name="deleteNo">
									<input type="submit" class="delete"  value="삭제">
								</div>
			        			</form>
							</div>
						</div>
					</div>
				</div>
            </fieldset>
		</div>
	</div>
	<br>
	
	<script type="text/javascript">
		$(function(){
			var interest = "<%=m.getInterest()%>";
			$("input[type=checkbox]").each(function(){
				if(interest.search($(this).val()) != -1){
					$(this).attr("checked", true);
				}
			})
			$('.search-btn').on('click', function(){
				var search = $('#search').val();
				loaction.href("<%=contextPath%>/search.all?search="+search);
			})
		})
	</script>
</body>
</html>