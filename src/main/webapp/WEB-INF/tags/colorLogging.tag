<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="color" type="java.lang.String" required="true" %>
<%@ attribute name="size" type="java.lang.String" required="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<font color="${color}" >
	<c:if test="${size==null }"> 
		<c:set var="size" value="5"/>
		
	</c:if>
	
	<c:forEach begin="1" end="${size }">=</c:forEach>
</font>
