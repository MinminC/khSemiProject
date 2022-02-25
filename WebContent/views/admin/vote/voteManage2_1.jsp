<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표관리 2_1</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

		<%@ include file="../common/menubar.jsp" %>

	    <div class="content">
        <h2>투표관리</h2> <br>
        
        <label>투표 명칭 : <input type="text" name="voteTitle"></label> <br><br>
		<label>투표 시작일  : <input type="date" name="sDate"></label> <br><br>
		<label>투표 마감일  : <input type="date" name="eDate"></label> <br><br>
        <div style="width:1200px">
        <p align="right">
        <a href="<%=contextPath %>/enroll.vot" class="btn btn-sm btn-primary">수정</a>
        <!--  &nbsp;&nbsp;<button class="btn btn-sm btn-danger">삭제</button></p> -->
        <table class="table table-bordered">
            <thead>
            	<!--  <tr bgcolor="lightgray">
                    <th width=100px;>투표명칭</th>
                    <th width=110px;>투표 시작일</th>
                    <th width=110px;>투표 종료일</th>
                </tr>  -->
                <tr bgcolor="lightgray">
                    <th width=80px;>no.</th>
                    <th width=160px;>제목</th>
                    <th width=130px;>장르</th>
                    <th width=130px;>파일등록</th>
                    <th>시놉시스</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>영화1</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>영화2</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>영화3</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>영화4</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
        </div>
    </div>

</body>
</html>