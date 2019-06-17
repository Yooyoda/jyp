<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="dt" value="<%=new Date() %>"></c:set>
dt : <fmt:formatDate value="${dt }" type="both"/><br>

<fmt:setTimeZone value="Poland" var="pol"/>
dt : <fmt:formatDate value="${dt }" timeZone="${pol }" type="both"/> <br>

<fmt:timeZone value="Poland">
	dt : <fmt:formatDate value="${dt }" type="both"/> <br>
</fmt:timeZone>

<%-- <c:forEach items="<%= TimeZone.getAvailableIDs() %>" var="timeZone"> --%>
<%-- 	${timeZone} <br> --%>
<%-- </c:forEach> --%>



</body>
</html>