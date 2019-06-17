package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

	private IuserDao userDao;
	//junit 실행순서
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
		userDao = new UserDao();
		logger.debug("setup");
	}
	
	@After
	public void teardown() {
		userDao = new UserDao();
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass() {
		
		logger.debug("afterClass");
	}
	
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 */
	// 오른쪽버튼 - run as - junit실행하면 @Test가 있는 메서드 실행
	@Test
	public void userListTest() {
		/***Given***/
		
		/***When***/
		List<UserVO> userList =  userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size()); //메서드 실행하는것,(기대값,실제값)
		logger.debug("userList : {} " , userList);
		
	}
	
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVo = userDao.getUser(userId); 

		/***Then***/
		assertEquals("브라운", userVo.getName());
		
	}
	
	//사용자 페이징 리스트 조회
	//고려사항
	//몇 번째 페이지 조회인지?, 페이징 몇 건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	//정렬순서? : 로직 --> 파라미터화 시킬 수 있다
	//--> 우리는 사용자 아이디 순으로 정렬

	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest() {
		
		/***Given***/
		PageVO pagevo = new PageVO(1, 10);
		
		
		/***When***/
		List<UserVO> userlist= userDao.userPagingList(pagevo);
		

		/***Then***/
		assertNotNull(userlist);
		assertEquals(10, userlist.size());
		
	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC09
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	 */
	@Test
	public void usersCntTest() {
		/***Given***/
		
		
		/***When***/
		int cnt = userDao.usersCnt();
		
		/***Then***/
		assertEquals(105, cnt);
		
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
		int cnt = userDao.insertUser(uservo);
		
		/***Then***/
		//insertCnt(1)
		assertEquals(1,cnt);
		
		//data 삭제
		userDao.deleteUser(uservo.getUserId());
		
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
		UserVO uservo = new UserVO("감자1", "userTest", "감자사랑", "test123", "서울", "뭐시기", "123", sdf.parse("2019-05-31"));
		
		/***When***/
		int cnt = userDao.updateUser(uservo);

		/***Then***/
		assertEquals(cnt, 1);
		
	}
	
}
