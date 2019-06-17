<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Content-Disposition","attachment; filename=line.xls" );
%>    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<th>영문명</th>
		</tr>
		<tr>
			<td>룰루</td>
			<td>랄라</td>
		</tr>	
		<tr>
			<td>리릴</td>
			<td>로롤</td>
		</tr>	
		<tr>
			<td>캬캬</td>
			<td>뀨우</td>
		</tr>	


	</table>
</body>
</html>