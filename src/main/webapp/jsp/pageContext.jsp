<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.write("pageContext.getOut().equals(out)" + pageContext.getOut().equals(out));
	
		out.write("pageContext.getPage().equals(page)" + pageContext.getPage().equals(page)) ;
		
		out.write("pageContext.getRequest().equals(request)" + pageContext.getRequest().equals(request));
		
		out.write("pageContext.getSession().equals(session)" + pageContext.getSession().equals(session));
		
		out.write("pageContext.getServletContext().equals(application)" + pageContext.getServletContext().equals(application));
		
		out.write("pageContext.getResponse().equals(response)" + pageContext.getResponse().equals(response));
		
	
	
	
	%>



</body>
</html>