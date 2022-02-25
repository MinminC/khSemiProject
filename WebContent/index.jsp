<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.movie.model.vo.*, com.kh.notice.model.vo.Notice" %>    
  
<%
	
	Notice mainList = (Notice)request.getAttribute("mainList");
	ArrayList<Movie> currentList = (ArrayList<Movie>)request.getAttribute("currentList");
	ArrayList<Picture> picList = (ArrayList<Picture>)request.getAttribute("picList");
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>시네마헤븐</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/user/main/main.css"/>
<link rel="stylesheet" href="resource/css/user/movie/movieList.css">



</head>
<body>
	<%@ include file="views/user/common/header.jsp" %>


  
		<script language="javascript">
		
        window.open("08_2_popup.html", "a", "width=430, height=350, left=100, top=50");
         function moveClose() {
        	 opener.location.href="<%=contextPath %>/list.vot";
        	  self.close(); 
        	}   
        </script>

<!--  
		<script type="text/javascript">
			function popUp(){
				window.open("08_2_popup.html","","width=500, height=400, left=100, top=50");
			}
		</script>
-->	

            <div id="container">
                <div id="container_1">
                    <!--  <img src="<%=contextPath %>/resource/image/52ef372732ec3bbee5fb9159477006ad.jpg" alt="영화0" class="thumbnail-image0">  -->
					<br><br>   
					
					<script language="JavaScript">
						var list = new Array()
						list[list.length]='<%=contextPath %>/resource/image/52ef372732ec3bbee5fb9159477006ad.jpg';
						list[list.length]='<%=contextPath %>/resource/image/88.jpg';
						list[list.length]='<%=contextPath %>/resource/image/99.jpg';
						list[list.length]='<%=contextPath %>/resource/image/10.jpg';
						j=parseInt(Math.random()*list.length);
						j=(isNaN(j))?0:j;
						function showimg(){
							document.write("<img src='"+list[j]+"' width='800' height='450'>");
						}
					
					</script>
					<script language="JavaScript">showimg();</script>
                </div>
                <div id="container_2">
                    <!-- <div class="service_area2">현재 상영 영화</div> -->
                    <br><br><br>
                    <div style="font-size: x-large;"><b>현재 상영 영화</b></div>
                    
                    
                    <div class="movie-list">
                <% if(currentList == null){ %>
                    	영화가 존재하지 않습니다.
                <% }else{ %>
	                <% for(int i = 0; i < currentList.size();i++){ %>
	                    <div class="movie-one">
	                        <img src="<%=contextPath %><%= picList.get(i).getFilePath()+picList.get(i).getChangeName() %>" alt="" class="movie-poster">
	                        <!-- 바로 전 요소에 마우스 오버하면 나오는 영역 -->
	                        <div class="poster-button">
								<br>
	                            <a href="<%=contextPath %>/MoView.ti?mName=<%= currentList.get(i).getMovieName() %>" class="btn btn-light">예매하기</a><br><br>
	                            <a href="<%=contextPath %>/detail.mo?mno=<%= currentList.get(i).getMovieNo() %>" class="btn btn-light">상세정보</a>
	                        </div>
	                        <ul>
	                            <li>
	                                <span><%= currentList.get(i).getMovieName() %></span>
	                            </li>
	                            <li>
	                                <span>예매율</span>
	                                <em><%= currentList.get(i).getAdvanceRate() %></em>
	                            </li>
	                        </ul>
	                    </div>
	                <% } %> 
	               <%} %>   
                   </div> 
                    
                    
                
                <br><br><br><br>
                
                <div id="container_3">
                    <hr size="1" noshade>
                    <p>공지사항  &nbsp;&nbsp;&nbsp; <a href="<%=contextPath %>/list.no">[공지사항] 
                    		<% if(mainList==null){ %>
					            		게시글이 없습니다.
				            	<% } else {%>
						                <%=mainList.getNoticeTitle() %>
					                
				                <% } %></a>
                    	<input type="button" onclick="location.href='<%=contextPath%>/list.no'" class="btn btn-sm btn-primary" value="더보기" style="float:right;">
                    </p>
                    <hr size="1" noshade>
                    <p>고객센터 &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="location.href='<%=contextPath%>/faq.no'" class="btn btn-sm btn-primary">FAQ</button>
                          	 &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="location.href='<%=contextPath%>/enroll-form.qu'" class="btn btn-sm btn-primary">1:1문의</button>
                          	 <span style="float:right;">1544-0000</span></p> 
                    <hr size="1" noshade>

                </div>
            </div>
	
	<br><br><br>
	<%@ include file="views/user/common/footer.jsp" %>

</body>
</html>