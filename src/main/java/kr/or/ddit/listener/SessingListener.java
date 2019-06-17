package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessingListener implements HttpSessionListener{

	private static final Logger logger = LoggerFactory.getLogger(SessingListener.class);
	
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().getServletContext().setAttribute("sessionMap", sessionMap);
		logger.debug("session created : {}", se.getSession().getId());
		sessionMap.put(se.getSession().getId(), se.getSession());
		
//		logger.debug("session created USER_INFO: {}", se.getSession().getAttribute("USER_INFO"));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.debug("session Destroyed : {}", se.getSession().getId());
		sessionMap.remove(se.getSession().getId());
	}

}
