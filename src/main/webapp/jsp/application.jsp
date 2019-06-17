<%@page import="java.io.IOException"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
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
	out.write("application.getContextPath() : " +  application.getContextPath() + "<br>");
	out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
	out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
	out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
	out.write("application.getInitParameter(\"ADMIN\") : " + application.getInitParameter("ADMIN") + "<br>");
	
	out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt"));
	
	String fileName = "190522.txt";
	
	BufferedReader br=null;
	try{
		String text = "";
		FileReader fr = new FileReader(application.getRealPath("/res/190522.txt")); 
		br = new BufferedReader(fr);
		
		while(true){
			text = br.readLine();
			if(text == null)
				break;
			out.write(text + "<br>");
		}
	}catch(IOException e){
		out.write("파일을 읽을 수 없음");
	}finally{
		try{
			br.close();
		}catch(Exception e){
			
		}
		
	}
	
	
	
	
%>
</body>
</html>