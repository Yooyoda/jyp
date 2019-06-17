package kr.or.ddit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/*
	contextPath > js, css경로 설정
	${pageContext.request.contextPath}/js/jquery.js > 얘 안불편 하세여?
	
	이거를 application 속성에다가 cp라는 이름으로 contextPath값을 넣어주면은
	${cp}/js/jquery.js > 이렇게 쓸수 있어용.
 */
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("cp", sce.getServletContext().getContextPath());
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
