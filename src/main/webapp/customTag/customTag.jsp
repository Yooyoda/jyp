<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 고정문자열 : =======================================================<br>
2. loop : <ct:loopLogging/><br>
3. customTag : <ct:logging/> <br>
4. loopCustomTag : <ct:loopLogging></ct:loopLogging> <bR>
5-1. colorLoggingTag : <ct:colorLogging color="blue" size="10"></ct:colorLogging><br>
5-2. colorLoggingTag : <ct:colorLogging color="blue"></ct:colorLogging><br>
6. rangersTag : 
<!-- <select> -->
<!-- 	<option>brown</option> -->
<!-- 	<option>cony</option> -->
<!-- 	<option>james</option> -->
<!-- 	<option>sally</option> -->
<!-- 	<option>moon</option> -->
	
<!-- </select> -->
<select>
	<ct:rangers rangers="brown,cony,james,sally,moon"></ct:rangers>
</select>

<ct:code code="P101"></ct:code>


</body>
</html>