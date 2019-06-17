package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserServiceTest {

	//사용자 전체리스트를 조회 하는 메소드
	//1. 메소드 인자가 필요한가? : 별다른 인자는 불필요 X
	//2. 리턴 타입은 뭐가 될까? : List<UserVO>
	//3. 메소드 이름은 뭐가 적당하지? : userList
	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	IuserService userService;
	
	//@BeforeClass가 적용된 메소드가 최초 1회 실행
	
		//다음 구간은 @Test가 적용된 모든 메소드에 대해 반복 적용
		//@Before가 적용된 메소드 실행
		//@Test가 적용된 메소드 실행
		//@After가 적용된 메소드 실행
		
		//@AfterClass가 적용된 메소드가 1회 실행
		
		@BeforeClass
		public static void beforeClass() {
			logger.debug("beforeClass");
			
		}
		
		@Before
		public void setup() {
			userService = new UserService();
			logger.debug("setup");
		}
		
		@After
		public void teardown() {
			userService = new UserService();
			logger.debug("teardown");
		}
		
		@AfterClass
		public static void afterClass() {
			
			logger.debug("afterClass");
		}
		
	
	
	
	
	@Test
	public void userListTest() {
		/***Given***/
		userService = new UserService();
		
		/***When***/
		List<UserVO> userlist = userService.userList();

		/***Then***/
		assertEquals("brown", userlist.get(0).getUserId());
		assertEquals(105, userlist.size()); //메서드 실행하는것,(기대값,실제값)
		logger.debug("userList : {} " , userlist);
		
	}
	
	@Test
	public void getUserTest() {
		/***Given***/
		userService = new UserService();
		String userId="brown";
		
		/***When***/
		UserVO uservo = userService.getUser(userId);
				
		
		/***Then***/
		assertNotNull(uservo);
		assertEquals("브라운", uservo.getName());
		logger.debug("userVO : {} " , uservo);
		
		
	}
	
	@Test
	public void userPagingListTest() {
		
		/***Given***/
		PageVO pagevo = new PageVO(1, 10);
		
		
		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pagevo);
		List<UserVO> userlist= (List<UserVO>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		/***Then***/
		//pagingList assert
		assertNotNull(userlist);
		assertEquals(10, userlist.size());
		
		//usersCnt assert
		assertEquals(11, paginationSize);
		
	}
	
	@Test
	public void ceilTest() {
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		
		/***When***/
		double paginationSize =  Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}" , paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
		
		
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		//사용자 정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		UserVO uservo = new UserVO("감자", "userTest", "감자사랑", "test123", "서울", "뭐시기", "123", sdf.parse("2019-05-31"));
		/***When***/
		//userDao.insertUser()
		int cnt = userService.insertUser(uservo);
		
		/***Then***/
		//insertCnt(1)
		assertEquals(1,cnt);
		
		//data 삭제
		userService.deleteUser(uservo.getUserId());
		
	}
	
	/**
	 * 
	* Method : updateUserTest
	* 작성자 : PC09
	* 변경이력 :
	* @throws ParseException
	* Method 설명 : 사용자 수정
	 */
	@Test
	public void updateUserTest() throws ParseException {
		
		
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		UserVO uservo = new UserVO("감자11", "userTest", "감자사랑", "test123", "서울", "뭐시기", "123", sdf.parse("2019-05-31"));
		
		/***When***/
		int cnt = userService.updateUser(uservo);

		/***Then***/
		assertEquals(cnt, 1);
		
	}
	
}
