<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.vote.model.vo.*" %>

<%
	ArrayList<VoteList> list = (ArrayList<VoteList>)request.getAttribute("list");
	int vreNo = (int)request.getAttribute("vreNo");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 페이지</title>
<link rel="stylesheet" href="../../../resource/css/user/common/00_stylesheet.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/user/vote/votePage.css"/>
    


</head>
<body>

	<%@ include file="../common/header.jsp" %>
	
	<div id="container">
            <div id="container_4">
                <div class="service_area3">2월 투표</div>
                <br><br><br>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	포스터 클릭시 영화정보 있어요!</p>
                <main class="main-container">
                	<%if(list.isEmpty()){ %>
                		현재 투표 없습니다.
                	<%}else{ %>
                	<input type="hidden" name="voteNo" id="voteNo" value="<%=list.get(1).getVoteNo()%>">
                	<%for(VoteList vl : list) {%>
                    <ul class="thumbnail-list">
                        <li class="thumbnail-item">
                            <img src="<%=contextPath %><%=vl.getVreFilePath() %>" alt="투표1" class="thumbnail-image" class="btn btn-primary" data-toggle="modal" data-target="#mo<%=vl.getVreNo()%>">
                            <div class="modal" id="mo<%=vl.getVreNo()%>">
                                <div class="modal-dialog">
                                  <div class="modal-content">
                                    <!-- Modal Header -->
                                    <div class="modal-header">
	                                    <h4 class="modal-title"><%=vl.getVreTitle() %></h4>
	                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>
                                    <!-- Modal body -->
                                    <div class="modal-body">
										제목 :<%=vl.getVreTitle() %>	<br>
										장르 :<%=vl.getVreGenre() %><br>
										시놉시스 :<%=vl.getVreSynopsis() %>
                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                      	<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            <span class="thumbnail-title"><%=vl.getVreTitle() %> <br><br>
                            <div class="checkbox">
                            	<%if(vreNo == vl.getVreNo()){ %>
                            	<input type="radio" name="vreNo" id="vreNo" checked value="<%=vl.getVreNo() %>" class="checkbox">
                            	<%}else{ %>
                            	<input type="radio" name="vreNo" id="vreNo" value="<%=vl.getVreNo() %>" class="checkbox">
                            	<%} %>
                           </div>
                           </span>
                           </li>
                    </ul>
                    	<%} %>
                    <%} %>
                    
                </main>
            </div>
            <br><br><br><br><br>    

            <div align="center"><button id="voting_btn" class="btn btn-sm btn-primary">투표하기</button></div>
        </div>
        <br><br><br><br><br><br>    
		<script type="text/javascript">
		$(function(){
			$("#voting_btn").click(function(){
				if(<%=vreNo%> == 0){
					if($('input:radio[name=vreNo]').is(':checked')){
						var vreNo = $('input[name=vreNo]:checked').val();
						location.href= "<%=contextPath%>/voteCount.vot?vreNo="+vreNo;
					}else{
						alert('선택 하시고 투표 하세요.');
					}
				}else{
					alert("이미 투표 하셨습니다.");
				}
			})
		})
			
		
		</script>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>