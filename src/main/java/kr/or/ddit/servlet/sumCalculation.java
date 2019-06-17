package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* sumCalculation.java
*
* @author PC09
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC09 최초 생성
*
* </pre>
*/
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1713673133022723470L;
	private Logger logger = LoggerFactory.getLogger(sumCalculation.class);
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("start값 : " + req.getParameter("startParam"), req.getParameter("startParam"));
		logger.debug("end값 : " + req.getParameter("endParam"), req.getParameter("endParam"));
		
		//파라미터
		int start = Integer.parseInt(req.getParameter("startParam"));
		int end = Integer.parseInt(req.getParameter("endParam"));
		
		int result=0;
		
		for(int i=start;i<=end;i++) {
			result += i;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("sumResult", result);
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
