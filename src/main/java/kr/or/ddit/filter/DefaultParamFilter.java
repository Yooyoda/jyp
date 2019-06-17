package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class DefaultParamFilter
 */
@WebFilter("/*")
public class DefaultParamFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//무슨말인지 모르겠지만 그냥 주석은 달았어.
		DefaultParamWrapper requestWrapper = new DefaultParamWrapper((HttpServletRequest)request);
		requestWrapper.setParameter("UNT_CD", new String[]{"LINE"});
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
