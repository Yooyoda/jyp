package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4511911406957314687L;

	Logger logger = LoggerFactory.getLogger(mulCalculation.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int param1 = Integer.parseInt(req.getParameter("param1"));
		int param2 = Integer.parseInt(req.getParameter("param2"));
		
		int result = param1 * param2;
		
		req.getSession().setAttribute("mulResult", result);
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);;
		
		
		
	}
	
	
	
	
	
	
	
}
