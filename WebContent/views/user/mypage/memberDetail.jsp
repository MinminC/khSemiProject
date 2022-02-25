<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>

<%
	Member m = (Member) request.getAttribute("m");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/user/mypage/reserveList.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/user/member/memberForm.css">
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	<div class="sub_nav" style="float: left;">
		<%@ include file="../common/subNavigation.jsp"%>
	</div>

	<div class="outer">
		<br>
		<h2 class="title">회원정보</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>아이디</th>
					<td><%=m.getMemberId()%> 
						<input type="hidden" id="memberNo" name="memberNo" value="<%=m.getMemberNo()%>">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><%=m.getMemberName()%></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><%=m.getBirth()%></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><%=m.getGender()%></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><%=m.getEmail()%> 
						<input type="hidden" name="before_email" id="before_email" value="<%=m.getEmail()%>"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><%=m.getPhone()%></td>
				</tr>
				<tr>
					<th rowspan="4">관심장르</th>
					<td>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="action">액션
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox"name="interest" id="interest" class="form-check-input" value="animation">애니메이션
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="drama">드마라
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="thriller">스릴러
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="romance">로맨스멜로
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="comedy">코미디
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox"	name="interest" id="interest" class="form-check-input" value="crime">범죄
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox"	name="interest" id="interest" class="form-check-input" value="fear">공포
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest"  id="interest" class="form-check-input" value="mystery">미스터리
							</label>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="adult">성인물
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="history">사극
							</label>
						</div>
						<div class="form-check-inline interest_div">
							<label class="form-check-label"> 
								<input type="checkbox" name="interest" id="interest" class="form-check-input" value="SF">SF
							</label>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btn-area" align="center">
			<input type="button" id="update_btn" value="수정">
		</div>
	</div>
<script type="text/javascript">

	$(function(){
		var interest = "<%=m.getInterest()%>";
		$("input[type=checkbox]").each(function(){
			if(interest.search($(this).val()) != -1){
				$(this).attr("checked", true);
			}
		})
					
		$('#update_btn').on('click', function(){
			var memberNo = $('#memberNo').val();
			location.href="<%=request.getContextPath()%>/updateForm.me?memberNo=" + memberNo;
		})
					
	})
</script>
</body>
</html>