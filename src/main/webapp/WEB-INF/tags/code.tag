<%@tag import="kr.or.ddit.prod.model.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.service.ProdService"%>
<%@tag import="kr.or.ddit.prod.service.IProdService"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ attribute name="code" type="java.lang.String" required="true" %>
code : ${code } <br>
<%
// 	String code = (String)jspContext.getAttribute("code");
// 	final String driver = "oracle.jdbc.driver.OracleDriver";
// 	final String url = "jdbc:oracle:thin:@localhost:1521:xe";
// 	final String users = "pc09";
// 	final String pass = "java";
			
// 	Connection conn = null;
// 	PreparedStatement pst =null;
// 	ResultSet rs = null;
	
// 	try{
// 		Class.forName(driver);
// 		conn = DriverManager.getConnection(url,users,pass);
// 		pst = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu= ?");
// 		pst.setString(1, code); //인덱스는 1부터 시작
		
// 		rs = pst.executeQuery();
		
// 		out.write("<select>");
// 		while(rs.next())
// 			out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
// 		out.write("</select>");
		
// 		conn.close();
		
// 	}catch(Exception e){
// 		e.printStackTrace();
// 	}

	String code = (String)jspContext.getAttribute("code");
	IProdService prodService = new ProdService();
	
	List<ProdVO> prodList = prodService.prodList(code);
	jspContext.setAttribute("prodList", prodList);

%>
	<select>
		<c:forEach items="${prodList }" var="prodList">
			<option id= "${prodList.prod_id }">${prodList.prod_name } </option>
		</c:forEach>
	</select>

