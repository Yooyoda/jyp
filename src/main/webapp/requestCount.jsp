<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- application(getServletContext()) : requestMap --%>
	<table>
		<tr>
			<th>uri</th>
			<th>요청횟수</th>
		</tr>
		<tr>
			<c:forEach items="${requestMap }" var="map">
				<td>${map.key }</td>
				<td>${map.value }</td>
			</c:forEach>
		</tr>
	
	
	
	</table>
	
	
	
	
	
	
	
</body>
</html>