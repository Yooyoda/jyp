<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{
		border : 2px solid black;
		padding : 10px;
	}

</style>
</head>
<body>

<!-- localhost/jsp/jsp/timesTable.jsp -->
<!-- 9*9단 출력 (2~9단) -->
<table>
	<% 
	String param1 = request.getParameter("param1");
	String param2 = request.getParameter("param2");
	
	for(int i=2;i<=Integer.parseInt(param2); i++){
	%>
	<tr>
		<%	
			for(int j=1;j<=Integer.parseInt(param1);j++){
		%>
				<td>
					<%=i%> * <%=j%> = <%= i*j %>
				</td>
		<%			
				}
		%>
	
	</tr>
	<%
		}	
	%>

</table>





</body>
</html>