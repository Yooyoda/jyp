<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	
	
	<table>
		<c:forEach begin="1" end="${param.row == null ? 9 : param.row }" var="i">
		<tr>
			<c:forEach begin="2" end="${param.col == null ? 9 : param.col }" var="j">
				<td>
					${j } * ${i } = ${j*i } 
				</td>
			</c:forEach>
			
		</tr>
		</c:forEach>
	</table>
	

<%-- 	<c:if test="${row == null && col == null }"> --%>
<%-- 		<c:set var="row1" value="9"></c:set> --%>
<%-- 		<c:set var="col1" value="9"></c:set> --%>
<%-- 	</c:if> --%>
	
<%-- 	<c:if test="${row != null && col != null }"> --%>
<%-- 		<c:set var="row1" value="${row }"></c:set> --%>
<%-- 		<c:set var="col1" value="${col }"></c:set> --%>
		
<%-- 	</c:if> --%>
	
<!-- 	<table> -->
<%-- 		<c:forEach begin="1" end="${row1 }" var="i"> --%>
<!-- 		<tr> -->
<%-- 			<c:forEach begin="2" end="${col1 }" var="j"> --%>
<!-- 				<td> -->
<%-- 					${j } * ${i } = ${j*i }  --%>
<!-- 				</td> -->
<%-- 			</c:forEach> --%>
			
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${row == null && col ==null }"> --%>
<!-- 			<table> -->
<%-- 				<c:forEach begin="1" end="9" var="i"> --%>
<!-- 				<tr> -->
<%-- 					<c:forEach begin="2" end="9" var="j"> --%>
<!-- 						<td> -->
<%-- 							${j } * ${i } = ${j*i }  --%>
<!-- 						</td> -->
<%-- 					</c:forEach> --%>
					
<!-- 				</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->
<%-- 		</c:when> --%>
		
<%-- 		<c:otherwise> --%>
<!-- 			<table> -->
<%-- 				<c:forEach begin="1" end="${row }" var="i"> --%>
<!-- 				<tr> -->
<%-- 					<c:forEach begin="2" end="${col }" var="j"> --%>
<!-- 						<td> -->
<%-- 							${j } * ${i } = ${j*i }  --%>
<!-- 						</td> -->
<%-- 					</c:forEach> --%>
					
<!-- 				</tr> -->
<%-- 				</c:forEach> --%>
<!-- 			</table> -->
		
		
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>


</body>
</html>