<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, com.kh.theater.model.vo.Auditorium" %>
<%
	ArrayList<Auditorium> auditoriumList = (ArrayList<Auditorium>)request.getAttribute("auditoriumList");
%>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>관리자 - 영화 등록</title>
		<link rel="stylesheet" href="resource/css/admin/movie/movie.css">
	</head>

	<body>
		<div id="wrap">
			<div id="menuBar">
				<%@ include file="../common/menubar.jsp" %>
			</div>
			<div id="body-area">
				<br>
				<form action="<%= contextPath %>/insert.mo" method="post" enctype="multipart/form-data" >
					<h3>영화 추가</h3>
					<div id="inform-btn">
						<button class="btn btn-secondary" onclick="history.back();">뒤로가기</button>
						<button class="btn btn-secondary" type="submit" id="insertMovie" onclick="return submitMovie();">등록</button>
					</div>
					<table class="in-form table">
						<tr>
							<th colspan="8">영화 요약</th>
						</tr>
						<tr>
							<th>영화명</th>
							<td><input type="text" name="title" required></td>
							<th>상영시간</th>
							<td><input type="number" name="runtime" value="0" required></td>
							<th>감독</th>
							<td><input type="text" name="director"></td>
						</tr>
						<tr>
							<th>등급</th>
							<td>
								<select name="rate">
									<option>전체</option>
									<option>7</option>
									<option>12</option>
									<option>15</option>
									<option>19</option>
								</select>
							</td>
							<th>장르</th>
							<td id="btn-list" colspan="6">
								<button type="button" class="btn btn-sm btn-light">공포</button>
								<button type="button" class="btn btn-sm btn-light">드라마</button>
								<button type="button" class="btn btn-sm btn-light">미스터리</button>
								<button type="button" class="btn btn-sm btn-light">범죄</button>
								<button type="button" class="btn btn-sm btn-light">로맨스</button>
								<button type="button" class="btn btn-sm btn-light">사극</button>
								<button type="button" class="btn btn-sm btn-light">스릴러</button>
								<button type="button" class="btn btn-sm btn-light">액션</button>
								<button type="button" class="btn btn-sm btn-light">판타지</button>
								<button type="button" class="btn btn-sm btn-light">코미디</button>
								<button type="button" class="btn btn-sm btn-light">19세</button>
								<button type="button" class="btn btn-sm btn-light">SF</button>
								<input type="hidden" name="genre">
							</td>
						</tr>
						<tr>
							<th colspan="8">시놉시스</th>
						</tr>
						<tr style="height:200px">
							<td colspan="8"><textarea name="synopsis" maxlength="2000"></textarea></td>
						</tr>
						<tr>
							<th colspan="8">사진 등록(4MB 크기 제한)</th>
						</tr>
						<tr>
							<th rowspan="2">
								포스터(필수)
							</th>
							<td rowspan="2"><img id="pic0"></img></td>
							<th>스틸컷 1(필수)</th>
							<td><img id="pic1"></td>
							<th>스틸컷 2</th>
							<td><img id="pic2"></td>
						</tr>
						<tr>
							<th>스틸컷 3</th>
							<td><img id="pic3"></td>
							<th>스틸컷 4</th>
							<td><img id="pic4"></td>
						</tr>
						<tr>
							<th colspan="2">출연진 등록</th>
							<th colspan="6">상영일정 등록</th>
						</tr>
						<tr>
							<th colspan="2">
								<ul>
									<li><input type="text" id="role" size="5"> 역</li>
									<li><input type="text" id="actor" size="5"></li>
									<li><button type="button" class="btn btn-secondary" id="addActor">추가</button></li>
								</ul>
							</th>
							<th colspan="4">
								<select id="theater">
									<% for(Auditorium au : auditoriumList){ %>
										<option class='auditorium' value="<%= au.getAuditoriumNo() %>"><%= au.getAuditoriumName() + " " +  au.getTheaterNo() %>관</option>
									<% } %>
								</select>
								<input type="datetime-local" id="schedule">
								<button type="button" class="btn btn-secondary" id="addSchedule">추가</button>
							</th>
						</tr>
						<tr>	
							<td colspan="2" id="actorTable">
								<table class="table" id="actors">
									<thead>
										<tr>
											<th>역</th>
											<th>배우</th>
											<th>조작</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</td>
							<td colspan="6">
								<table class="table" id="schedules">
									<thead>
										<tr>
											<th>극장 명</th>
											<th>상영관 번호</th>
											<th>상영시각</th>
											<th>삭제</th>
										</tr>
									</thead>
									<tbody><%-- script로 추가 --%></tbody>
								</table>
							</td>
						</tr>
					</table>
					<div id="file-form">
						<input type="file" onchange="changeImg(this, 0)" name="pic0">
						<input type="file" onchange="changeImg(this, 1)" name="pic1">
						<input type="file" onchange="changeImg(this, 2)" name="pic2">
						<input type="file" onchange="changeImg(this, 3)" name="pic3">
						<input type="file" onchange="changeImg(this, 4)" name="pic4">
					</div>
					<input type="hidden" name="actors">
					<input type="hidden" name="schedules">
				</form>
			</div>
		</div>
		<script>
			$(function(){
				//버튼을 누르면 해당 장르에 불이 안들어올 경우 불을 켜고, 들어왔을 경우 불을 끔
				$('#btn-list>button').click(function(){
					if($(this).hasClass('btn-primary')){
						$(this).removeClass('btn-primary');
						$(this).addClass('btn-light');
					}else{
							$(this).removeClass('btn-light');
							$(this).addClass('btn-primary');
					}
				})

				//배우 리스트 추가
				$('#addActor').click(function(){
					if($('#role').val() == '' || $('#actor').val() == ''){
						alert('배우와 역할을 모두 채워주세요');
					}else{
						$('#actors tbody').append('<tr><td>'+$('#role').val()+'</td><td>'+$('#actor').val()
								+'</td><td><button type="button" class="up btn btn-sm btn-light">▲</button><button type="button" class="down btn btn-sm btn-light">▼</button><button type="button" class="remove btn btn-sm btn-light">X</button></td></tr>');
						$('#role').val('');
						$('#actor').val('');
					}
				})
				
				//배우 리스트 순서 조작, 삭제
				$('tbody').on('click', '.up', function(){
					var $actorTarget = $(this).parent().parent();
					var prev = $actorTarget.prev().html();

					$actorTarget.prev().html($actorTarget.html());
					$actorTarget.html(prev);
				})
				$('tbody').on('click', '.down', function(){
					var $actorTarget = $(this).parent().parent();
					var next = $actorTarget.next().html();

					$actorTarget.next().html($actorTarget.html());
					$actorTarget.html(next);
				})
				$('tbody').on('click', '.remove', function(){
					$(this).parent().parent().remove();
				})
				$('tbody').on('click', '.removeSch', function(){
					$(this).parent().parent().remove();
					schAll.splice(schAll.indexOf($(this).parent().parent()),1);
				})
				
				//상영관, 상영시각 리스트 추가
				var schAll = [];//객체배열 활용
				$('#addSchedule').click(function(){
					if($('#schedule').val() == ''){
						alert('상영시각을 채워주세요');
					}else{
						var schOne = {'auditoriumNo': $('#theater').val(), 'auditoriumName': $('.auditorium:selected').text().substring(0,$('.auditorium:selected').text().length-3), 'schedule': $('#schedule').val()};
						schAll.push(schOne);
						
						//schedule 속성의 오름차순으로 정렬
						schAll.sort(function(a, b) {
							var c = new Date(a.schedule);
							var d = new Date(b.schedule);
							return c-d;
						});
						var result='';
						for(var i in schAll){
							result+='<tr><td>'+schAll[i].auditoriumName+'</td><td>'+schAll[i].auditoriumNo+'</td><td>'+schAll[i].schedule+'</td>'
							+'<td><button type="button" class="removeSch btn btn-sm btn-light">X</button></td></tr>';
						}
						$('#schedules tbody').html(result);
						$('#schedule').val('');
					}
				})

				$('#removeSchedule').click(function(){
					$(this).parent().remove();
				})

				$('#file-form').hide();
				<% for(int i = 0; i < 5 ; i++){ %>
					$('#pic<%=i%>').click(function(){
						$('input[name=pic<%=i%>]').click();
					})
				<% } %>
			})
			//schAll 객체배열을 정렬
			//테이블에 저장한 값 input:hidden의 value에 넣어 전달
			function submitMovie(){
				//장르
				var genres =[];
				for(var i in $('#btn-list').children()){
					var $btnTarget = $('#btn-list').children().eq(i);

					if($btnTarget.hasClass('btn-primary'))
						genres.push($btnTarget.text());
				}
				$('input[name=genre]').val(genres.join(','));

				//배우
				var actorRows = $('#actors>tbody').children().length;
				var $actorRows = $('#actors>tbody').children()
				var bundle = $actorRows.eq(0).children().eq(0).text()+'/'+$actorRows.eq(0).children().eq(1).text();
				for(var i = 1; i < actorRows ; i++){
					bundle += ','+$actorRows.eq(i).children().eq(0).text()+'/'+$actorRows.eq(i).children().eq(1).text();
				}
				$('input[name=actors]').val(bundle);
				
				//상영시각
				var scheduleRows = $('#schedules>tbody').children().length;
				var $scheduleRows = $('#schedules>tbody').children()
				var bundle = $scheduleRows.eq(0).children().eq(1).text()+'/'+$scheduleRows.eq(0).children().eq(2).text();
				for(var i = 1; i < scheduleRows ; i++){
					bundle += ','+$scheduleRows.eq(i).children().eq(1).text()+'/'+$scheduleRows.eq(i).children().eq(2).text();
				}
				$('input[name=schedules]').val(bundle);//관/시각, 관/시각 나눠서 보내기
				
				if($('input[name=genre]').val() == ''){//장르 선택을 안한 경우
					alert('장르를 선택해주세요');
					return false;
				}
				if($('input[name=pic0]').val() == ''){//포스터를 등록 안한 경우
					alert('포스터를 선택해주세요');
					return false;
				}
				if($('input[name=pic1]').val() == ''){//스틸컷 1을 등록 안한 경우
					alert('스틸컷1을 선택해주세요');
					return false;
				}
				return true;
			}
			//사진을 등록하면 이미지 교체
			function changeImg(picture, num){
				if(picture.files.length == 1){//새로운 파일이 업로도 된 경우
					var reader = new FileReader();//파일리더 생성
					reader.readAsDataURL(picture.files[0]);//업로드하면 임시저장되는 파일만의 고유 url을 읽어들임
					reader.onload = function(e){//파일이 전부 로딩되면 실행하는 함수. e.target.result에 각 파일의 url을 담음
						switch(num){
							case 0: $('#pic0').attr('src', e.target.result); break;
							case 1: $('#pic1').attr('src', e.target.result); break;
							case 2: $('#pic2').attr('src', e.target.result); break;
							case 3: $('#pic3').attr('src', e.target.result); break;
							case 4: $('#pic4').attr('src', e.target.result); break;
						}
					}
				}else{//파일 등록하는 과정에서 취소하는 경우->미리보기 사라지기
						switch(num){
							case 0: $('#pic0').attr('src', null); break;
							case 1: $('#pic1').attr('src', null); break;
							case 2: $('#pic2').attr('src', null); break;
							case 3: $('#pic3').attr('src', null); break;
							case 4: $('#pic4').attr('src', null); break;
						}
					
				}
			}
		</script>
	</body>

	</html>