<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProcess</title>
</head>
<body>
	loginProcess.jsp <Br>  
	<%--post방식 한글 파라미터 --%>
	<% request.setCharacterEncoding("utf-8"); %>
	
	
	<h2>request객체의 getParameter, getParameterValues</h2>
	request.getParameter("userId") : <%=request.getParameter("userId") %> <br>
	request.getParameterValues("userId") : 
				<% 
				String[] userIds = request.getParameterValues("userId"); 
				for(String userId : userIds){ %>
					<%= userId %> <br>
					<%} %>			
	
	request.getParameter("password") : <%=request.getParameter("password") %> <br>

	<h2>request객체의 getParameterMap</h2>
	request.getParameterMap() : <%=request.getParameterMap() %> <br>
	<% Map<String, String[]> parameterMap = request.getParameterMap(); 
		//paramter : userId, password
		String[] userIdsFromMap = parameterMap.get("userId");
		String[] passwords = parameterMap.get("password");
		
		for(String userId : userIdsFromMap){ %>
			userIdsFromMap : <%=userId %> <br>
		<% }%>
	
		<%for(String password : userIdsFromMap){ %>
			userIdsFromMap : <%=password %> <br>
		<% }%>
	
	<h2>request객체의 getParameterNames()</h2>
	<% Enumeration<String> parameterNames = request.getParameterNames(); 
		while(parameterNames.hasMoreElements()){ %>
			parameterNames : <%=parameterNames.nextElement() %> <br>
		
	<%
		}
	%>






</body>
</html>