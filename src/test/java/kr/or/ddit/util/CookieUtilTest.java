package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(CookieUtilTest.class);
	/**
	 * 
	* Method : getCookieTest
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : getCookie 테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "userId=brown; rememberme=true; test=testValue";
		CookieUtil.setCookieString(cookieString);
		
		
		/***When***/
//		String cookieValue = CookieUtil.getCookie("userId");
//		String cookieValue1 = CookieUtil.getCookie("rememberme");
		String cookieValue2 = CookieUtil.getCookie("userId1");
		
		
		/***Then***/
//		assertEquals("brown", cookieValue);
//		assertEquals("true", cookieValue1);
		assertEquals("", cookieValue2);
		
		
	}

}
