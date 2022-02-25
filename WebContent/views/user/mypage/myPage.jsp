<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>

<%
	Member m = (Member) request.getAttribute("m");
	String tier = "";
	String tierCss = "";
	int point = m.getPoint();
	int basic = 10000;
	int silver = 20000;
	int gold = 30000;
	int vip = 40000;
	int nextPoint = 0;
	double progress = 0;
	if(point < basic){
		tier = "일반";
		tierCss = "green";
		nextPoint = basic - point;
		progress = (double)point / (double)basic * (double)100;
	}else if(point < silver){
		tier = "실버";
		tierCss = "silver";
		nextPoint = silver - point;
		progress = (double)point / (double)silver * (double)100;
		System.out.print(progress);
	}else if(point < gold){
		tier = "골드";
		tierCss = "gold";
		nextPoint = gold - point;
		progress = (double)point / (double)gold * (double)100;
	}else if(point < vip){
		tier = "vip";
		tierCss = "rgb(13, 71, 161)";
		nextPoint = vip - point;
		progress = (double)point / (double)vip * (double)100;
	}else{
		tier = "vvip";
		tierCss = "black";
	}
%>


<!DOCTYPE html>
<html>
<head>

<style type="text/css">
.membershipTier{
   width: 130px;
   height: 200px;
   border: 1px solid rgb(13, 71, 161);
   border-radius: 10px / 10px;
}
   
.membership_div{
    margin:auto;
    text-align: center;
}

.membership_div>ul>li {
   margin: auto;
   padding: 30px 10px 30px 10px;
   border : 0;
   float: left;
   list-style : none;
   text-decoration: none;
}
.membership_div>h4 {
   margin-left: 50px;
}

.myPage_area{
    width: 900px;
   background-color: rgb(240, 240, 240);
    border-radius: 5px;
    margin:auto;
    height:200px;
}

.person_img{
    width: 70px;
    height: 70px;
    margin-top:30px;
    margin-left:20px;
}

.person{
    margin:auto;
    margin-left: 20px;
    margin-top:70px;
    width: 240px;
}

.bar{
    float:right;
    margin-right: 690px;
    margin-top: 30px;
}

.point{
    float:left;
    margin-left: 30px;
    margin-top: 30px;
}

.point_num{
    float:left;
    margin-left: 300px;
    margin-top: -20px;
}

.next_point{
    float:left;
    margin-left: 30px;
    margin-top:10px;
}
.next_point_num{
    float:right;
    margin-right:80px;
    margin-top: 10px;
}

.content{
    background-color: rgb(212, 211, 211);
    float:right;
    width:430px;
    margin-right:30px;
    margin-top:-125px;
    border-radius: 5px;
    height:120px;
}
</style>

<meta charset="UTF-8">
<title>멤버쉽</title>
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
		<h2 class="title">멤버쉽</h2>
		<div class="myPage_area">
        <!--맴버 영역-->
			<div class="memberInfo">
				<table>
					<tr>
						<td rowspan="2">
							<%if(m.getGender().equals("남")) {%>
							<img class="person_img" src="<%=request.getContextPath()%>/resource/image/user/member/myPage_men.png">
							<%} else {%>
							<img class="person_img" src="<%=request.getContextPath()%>/resource/image/user/member/myPage_women.png">
							<%} %>
						</td>
						<td>
							<p class = "person"><%=m.getMemberName() %>님 안녕하세요<br>고객님의 회원등급은 <span style="color : <%=tierCss%>;"><%=tier %></span>입니다.</p>
							<br>
							<div class="progress">
								<div class="progress-bar" style="width:<%=(int)progress%>%"><%=(int)progress %></div>
							</div>
						</td>
                    </tr>
				</table>
				<div class="content">
					<table>
						<tr>
							<th class = "point">포인트 점수</th>
							<td class = "point_num"><%=point %>P</td>
						</tr>
						<tr>
							<th class = "next_point">다음 등급 남은 점수</th>
							<%if(tier.equals("vvip")){ %>
								<td class = "next_point_num">최고등급</td>
							<%}else{ %>
								<td class = "next_point_num"><%=nextPoint %>P</td>
							<%} %>
						</tr>
					</table>
				</div>
				<div class="content2">
				</div>
			</div>
         
		</div>
		<div class="membership_div">
			<br>
			<h4>멤버십 등급 안내</h4>
			<ul>
				<li>
					<div class="membershipTier">
						<br>
						<table align="center">
							<tr>
								<td>
									<img src="">VVIP
								</td>
							</tr>
							<tr>
								<td><br>40000P ~<br> </td>							
							</tr>
							<tr>
								<td><br>10% 할인</td>
							</tr>
						</table>
					</div>
				</li>
				<li>
					<div class="membershipTier">
						<br>
						<table align="center">
							<tr>
								<td>
									<img src="">VIP
								</td>
							</tr>
							<tr>
								<td><br>20000P ~<br>30000P </td>							
							</tr>
							<tr>
								<td><br>6% 할인</td>
							</tr>
						</table>
					</div>
				</li>
				<li>
					<div class="membershipTier">
						<br>
						<table align="center">
							<tr>
								<td>
									<img src="">GOLD
								</td>
							</tr>
							<tr>
								<td><br>20000P ~<br>30000P </td>							
							</tr>
							<tr>
								<td><br>4% 할인</td>
							</tr>
						</table>
					</div>
				</li>
				<li>
					<div class="membershipTier">
						<br>
						<table align="center">
							<tr>
								<td>
									<img src="">SILVER
								</td>
							</tr>
							<tr>
								<td><br>10000P ~<br>20000P </td>							
							</tr>
							<tr>
								<td><br>2% 할인</td>
							</tr>
						</table>
					</div>
				</li>
				<li>
					<div class="membershipTier">
						<br>
						<table align="center">
							<tr>
								<td>
									<img src="">일반
								</td>
							</tr>
							<tr>
								<td><br>0P ~<br>10000P </td>							
							</tr>
							<tr>
								<td><br>할인 없음</td>
							</tr>
						</table>
					</div>
				</li>
			</ul>
      	</div>
   </div>
<script type="text/javascript">
	$(function(){
		$('.progress-bar').css('background-color', '<%=tierCss%>');
	})
</script>
</body>
</html>