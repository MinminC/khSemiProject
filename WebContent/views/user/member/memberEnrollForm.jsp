<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%=contextPath %>/resource/css/user/member/memberForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resource/js/member/member.js"></script>
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
            <legend>회원가입</legend>
            <form action="<%=contextPath %>/insert.me" method="post">
                <ul>
                    <li>
                    	<div class="id-area">
                    		<div align="left" style="width: 280px">
                        		<label for="memberId">아이디</label>
                    		</div>
                    		<div align="right" style="width: 120px">
	                    		<input type="button" class="member_btn id_check_btn" id="idCheck" value="중복체크">
                    		</div>
	                    </div>
                    </li>
                    <li>
                        <input type="text" class="member_input" name="memberId" id="memberId" maxlength="20" required placeholder="영문 대.소문자, 숫자 _,-만 입력 가능하고 5에서 20자리">
                    </li>
                     <li class="id_text error_text">
                    </li>
                    <li>
                        <label for="memberPwd">비밀번호</label>
                    </li>
                    <li>
                        <input type="password" class="member_input" name="memberPwd" id="memberPwd" maxlength="16" required placeholder="영문 대문자와 소문자, 숫자, 특수문자를 하나 이상 포함하여 8~16">
                    </li>
                    <li class="pwd_text error_text">
                    </li>
                    <li>
                        <label for="pwdCheck">비밀번호 확인</label>
                    </li>
                    <li>
                        <input type="password" class="member_input" id="pwdCheck" required placeholder="비밀번호 한번 더 입력해 주세요.">
                    </li>
                    <li class="pwdCheck_text error_text">
                    </li>
                    <li>
                        <label for="memberName">이름</label>
                    </li>
                    <li>
                        <input type="text" class="member_input" name="memberName" id="memberName" required placeholder="2~6자 한글만">
                    </li>
                    <li class="name_text error_text">
                    </li>
                    <li>
                        <label for="yyyy">생년월일</label>
                    </li>
                    <li>
                        <input type="text" name="yyyy" id="yyyy" class="birth_input" maxlength="4" placeholder="년" required>
                        <select name="mm" id="mm" class="birth_input">
                            <option value="0">월</option>
                            <option value="01">01</option>
                            <option value="02">02</option>
                            <option value="03">03</option>
                            <option value="04">04</option>
                            <option value="05">05</option>
                            <option value="06">06</option>
                            <option value="07">07</option>
                            <option value="08">08</option>
                            <option value="09">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>
                        <input type="text" name="dd" id="dd" class="birth_input" maxlength="2" placeholder="일" required>
                    </li>
                    <li>
                        <label for="gender">성별</label>
                    </li>
                    <li>
                        <select name="gender" id="gender" class="member_input">
                            <option value="0">성별</option>
                            <option value="남">남</option>
                            <option value="여">여</option>
                        </select>
                    </li>
                    <li>
                        <label for="email">이메일</label>
                    </li>
                    <li>
                        <input type="text" id="email" name="email" class="member_input" required placeholder="@ 포함으로 입력 해주세요.">
                    </li>
                     <li class="email_text error_text">
                    </li>
                    <li>
                        <input type="button" id="emailCheck" class="member_input member_btn" value="이메일 인증" >
                    </li>
                    <li>
                        <input type="text" id="email_check" class="member_input">
                    </li>
                    <li>
                        <input type="button" id="CheckBtn" class="member_input member_btn" value="인증번호 확인">
                    </li>
                     <li class="email_certification_text error_text">
                    </li>
                    <li>
                        <label for="phone">휴대전화</label>
                    </li>
                    <li>
                        <input type="text" name="phone" id="phone" class="member_input" required placeholder="-포함 숫자만 입력해주세요.">
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
								<input type="checkbox" name="interest" class="form-check-input" value="매이메이션">애니메이션
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
                    <input class="member_input member_btn insert_btn" type="submit" value="가입">
                </div>
            </form>
            </fieldset>
		</div>
	</div>
	<br>
	
	<script type="text/javascript">
		$(function(){
			
			$('.search-btn').on('click', function(){
				var search = $('#search').val();
				loaction.href("<%=contextPath%>/search.all?search="+search);
			})
			
		})
	</script>
</body>
</html>