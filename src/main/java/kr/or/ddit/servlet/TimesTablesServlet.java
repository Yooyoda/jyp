package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





public class TimesTablesServlet extends HttpServlet{

	//kr.or.ddit.servlet.TimesServlet
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		resp.setContentType("text/html; charset=utf-8");
		
		// localhost/jsp/timesTables?param=6
		// http://localhost/jsp/timesTablesServlet?param=0&param2=0
		String param = req.getParameter("param");
		int param1 = Integer.parseInt(param);
		logger.debug("param : {}, {}" , param,"test");
		
		String param2 = req.getParameter("param2");
		int param22 = Integer.parseInt(param2);
		logger.debug("param2 : " + param2);
		
		
		pw.write("<html>");
		pw.write("	<style>");
		pw.write("	td{");
		pw.write("		border : 2px solid violet;"
				+ 		"padding : 5px;");
		
		pw.write("	}");
		
		pw.write("	</style>");
		pw.write(" 	<body>");
		pw.write("   <table>");
		
		for(int i=2;i<=param1;i++) {
			pw.write("    <tr>");
			for(int j=2;j<=param22;j++) {
				pw.write("     <td>");
				pw.write(j + " * " + i + " = " + j*i);
				pw.write("     </td>");
			}
			pw.write("    </tr>");
		}
		
		pw.write("   </table>");
		pw.write(" 	</body>");
		pw.write("</html>");
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
