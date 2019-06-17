<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>     
<script>
	$(document).ready(function(){
		$('#localeSelect').on('change',function(){
			console.log("localeSelect");
			
			$("#frm").submit();
			
			
		});
		
		
	});
	
	

</script> 
</head>
<body>

<h2>select locale</h2>
<%-- <form action="${pageContext.request.contextPath }/selectLocale" id="frm"> --%>
<form action="${pageContext.request.contextPath }/selectLocale" id="frm" method="post">
	<select id="localeSelect" name="locale">
		<option value="ko" <c:if test="${locale == 'ko' }">selected</c:if>>한국어</option>
		<option value="en" <c:if test="${locale == 'en' }">selected</c:if>>english</option>
		<option value="ja" <c:if test="${locale == 'ja' }">selected</c:if>>日本言</option>
	
	</select>
</form>
<fmt:setLocale value="${locale }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/><br>
	</fmt:message>
</fmt:bundle>








</body>
</html>