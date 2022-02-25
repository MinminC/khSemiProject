<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.common.model.vo.PageInfo, com.kh.movie.model.vo.Report" %>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
%>
<% 
	String query ="";
	String mapping = "";
	if(request.getAttribute("pageType") == null){
		query = "";
		mapping = "reportList.re";
	}else{
		String pageType = (String)request.getAttribute("pageType");
		String keyword = (String)request.getAttribute("keyword");
		query = "&pageType="+pageType+"&keyword="+keyword;
		mapping = "reportSearch.re";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 신고</title>
<link rel="stylesheet" href="resource/css/admin/movie/movie.css">
</head>
<body>
	<div id="wrap">
		<div id="menuBar">
			<%@ include file="../common/menubar.jsp" %>
		</div>
		<div id="body-area">
			<br>
			<h3>리뷰 신고 목록</h3>
		<div id="notice-menu">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#holdForm">
					보류(신고불량)
				</button>
				<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">
					삭제
				</button>
				
				<!-- Modal : 보류 Form -->
				<div class="modal hold-form" id="holdForm">
				<div class="modal-dialog">
					<div class="modal-content">
				
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">보류 - 신고불량</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<!-- Modal body -->
					<div class="modal-body">
						<ul id="holdList"></ul>
							보류하시겠습니까? 
					</div>
				
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
						<button id="holdSubmit" type="submit" class="btn btn-danger" data-dismiss="modal">보류</button>
					</div>
					</div>
				</div>
				</div>  
				
				
				<!-- Modal : DeleteForm -->
				<div class="modal delete-form" id="deleteForm">
				<div class="modal-dialog">
					<div class="modal-content">
				
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">삭제 - 불량 리뷰</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<!-- Modal body -->
					<div class="modal-body">
						<ul id="deleteList"></ul>
								삭제하시겠습니까? 
					</div>
				
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
						<button id="deleteSubmit" type="submit" class="btn btn-danger" data-dismiss="modal">삭제</button>
					</div>
					</div>
				</div>
				</div>
				
				
			</div>

			<!-- 목록 테이블 영역 -->
			<div id="notice-body">
				<table class="table">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkAll"></th>
							<th>No.</th>
							<th>리뷰내용</th>
							<th>신고일</th>
							<th>신고사유</th>
							<th>처리여부</th>
						</tr>
					</thead>
					<tbody>
						<% if(list == null || list.isEmpty()){ %>
							<tr><td>
								리뷰 신고가 존재하지 않습니다.
							</td></tr>
						<% }else{ %>
							<% for(Report rp : list){ %>
								<% if(rp.getStatus().equals("Y")){ %>
									<tr style="background:lightgray; color:gray;">
										<td>
											<input type="checkbox" disabled class="rows" value="<%= rp.getReportNo() %>">
								<% }else{ %>
									<tr>
										<td>
											<input type="checkbox" class="rows" value="<%= rp.getReportNo() %>">
								<% } %>
										<input type="hidden" value="<%= rp.getReviewNo() %>">
									</td>
									<td><%= rp.getReportNo() %></td>
									<td><%= rp.getReviewContent() %></td>
									<td><%= rp.getReportDate() %></td>
									<td><%= rp.getReason() %></td>
									<td><%= rp.getStatus() %></td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
			</div>
			<!-- 페이징 처리 -->
			<ul class="pagination">
			<% if(pi != null){ %>
				<% if( pi.getStartPage() != 1 ){ %>
					<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= pi.getEndPage()-pi.getPageLimit()+1 %><%= query %>">&lt;</a></li>
				<% } %>
				
				<% for(int i = pi.getStartPage(); i<=pi.getEndPage();i++){ %>
					<% if(i == pi.getCurrentPage()){ %>
						<li class="page-item active"><a class="page-link"><%= i %></a></li>
					<% }else{ %>
						<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= i %><%= query %>"><%= i %></a></li>
					<% } %>
				<% } %>
				
				<% if(pi.getEndPage()!= pi.getMaxPage()){ %>
					<li class="page-item"><a class="page-link" href="<%= contextPath %>/<%= mapping %>?currentPage=<%= pi.getStartPage()+pi.getPageLimit() %><%= query %>">&gt;</a></li>
				<% } %>
			<% } %>
			</ul>
		</div>
	</div>
	<script>
		$(function(){
			//'전체' 체크하면 전체 불 들어오고 끄면 다 꺼지기. 하나씩 다 눌러서 다 채울때 불 들어오거나 하나라도 체크해제하면 불 꺼지는거 구현 안함
			$('#checkAll').on('change', function () {
                if ($(this).prop('checked'))
                    $('.rows').prop('checked', true);
                else
                    $('.rows').prop('checked', false);
            })
            
       		//행에 마우스 가져다 대면 해당 리뷰의 전문이 나옴
       		$('#notice-body tbody>tr>td').hover(function(){
       		})
       		
       		//체크가 될 경우 modal에 보류 목록에 들어감. 해제될 경우 사라짐
       		$('.rows').change('checked', function(){
       			var holdTitle = $(this).parent().siblings().eq(0).text();
       			if ($(this).prop('checked'))
       				$('#holdList').append('<li class='+holdTitle+'>'+holdTitle+'</li>');
       			else
       				$('#holdList').find('.'+holdTitle).remove();
       		})
       		
       		//체크가 될 경우 modal에 삭제 목록에 들어감. 해제될 경우 사라짐
       		$('.rows').change('checked', function(){
       			var deleteReportNo = $(this).parent().siblings().eq(0).text();
       			var deleteReviewNo = $(this).siblings('input:hidden').val();
       			var deleteReviewContent = $(this).parent().siblings().eq(1).text();
       			if ($(this).prop('checked'))
       				$('#deleteList').append('<li class='+deleteReportNo+'><input type="hidden" class="reportNo" value="'+deleteReportNo
       											+'"><span>'+deleteReviewContent+'</span><input type="hidden" class="reviewNo" value="'+deleteReviewNo+'"></li>');
       			else
       				$('#deleteList').find('.'+deleteReportNo).remove();
       		})
       		
       		//보류modal-보류 누르면 holdByReport.re에 리스트로 전달
       		$('#holdSubmit').click(function(){
       			var holdList = [];
       			var holdLength = $('#holdList>li').length;
       			for(var i = 0; i < holdLength; i++){
       				holdList.push($('#holdList').children().eq(i).text());
       			}
       			location.href='<%= contextPath %>/holdByReport.re?list='+holdList;
       		})
       		
       		//삭제modal-삭제 누르면 deleteByReport.re에 리스트로 전달
       		$('#deleteSubmit').click(function(){
       			var deleteReview = [];//review 'N'으로 숨김
       			var updateReport = [];//report 'Y'으로 처리완료 
       			var deleteLength = $('#deleteList>li').length;
       			
       			for(var i = 0; i < deleteLength; i++){
       				deleteReview.push($('#deleteList').children().eq(i).children('.reportNo').val());
       				updateReport.push($('#deleteList').children().eq(i).children('.reviewNo').val());
       			}
       			
       			var deleteReviewString = deleteReview.join(',');
       			var updateReviewString = updateReport.join(',');
       			location.href='<%= contextPath %>/deleteByReport.re?deleteReview='+deleteReviewString+'&updateReport='+updateReviewString;
       		})
       		
		})	
	</script>
</body>
</html>
