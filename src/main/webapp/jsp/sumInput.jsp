<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start <input type="text" name="startParam" value="1"> <br>
		end   <input type="text" name="endParam" value="10"> <bR>
		<button>전송하기</button>
	</form>
	
	


</body>
</html>