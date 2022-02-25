<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="select-seat-wrapper" style="text-align: center;">
	
    <% for(int j=1; j<11; j++) { %>
    	<% String str = null; %>
            <% switch(j) {
            case 1: str = "A열";
            break;
            case 2: str = "B열";
            break;
            case 3: str = "C열";
            break;
            case 4: str = "D열";
            break;
            case 5: str = "E열";
            break;
            case 6: str = "F열";
            break;
            case 7: str = "G열";
            break;
            case 8: str = "H열";
            break;
            case 9: str = "I열";
            break;
            case 10: str = "J열";
            break;
            } %>
            <div class="<%= str %>">
            <span><%= str %>&nbsp;</span>
		<% for(int i=1; i<11; i++) { %>
			<button type="button" class="btn btn-outline-secondary btn-lg" style="margin-bottom: 5px; padding: 0.375rem 0.75rem;"><%= i %></button>
			<% if(i == 2) { %>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<% } else if(i == 8) { %>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<% } %>
		<% } %>
        </div>
    <% } %>
    </div>
    <br><br>
</body>
</html>