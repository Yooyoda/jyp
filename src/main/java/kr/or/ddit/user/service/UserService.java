package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IuserService {

	IuserDao userDao = new UserDao();

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	/**
	 * 
	 * Method : userList 작성자 : PC09 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		// db에서 데이터를 조회했다고 가정
		List<UserVO> userList = new ArrayList<UserVO>();

		userList = userDao.userList();

		return userList;
	}

	@Override
	public UserVO getUser(String userId) {
		UserVO user;
		user = userDao.getUser(userId);

		return user;
	}

	@Override
	public Map<String, Object> userPagingList(PageVO pagevo) {
		//1. List<UserVO> , userCnt를 필드로 하는 vo
		//2. List<Object> resultlist - bew ArratList<Object>();
		//	 resultlist.add(userList)
		//	 resultlist.add(userCnt)
		//3. Map<String,Object> resultMap = new HaspMap<String,Object>();
		//	 resultMap.put("userList",userList)
		//	 resultMap.put("userCnt",userCnt)
		
//		List<UserVO> userList;
//		userList = userDao.userPagingList(pagevo);
		Map<String, Object> resultMap = new HashMap<String, Object>();

		//userList라는 아이디로 map에 저장해서 페이지 정보 넘김
		resultMap.put("userList",userDao.userPagingList(pagevo));
		
		//usersCnt --> paginationSize 변경
//		resultMap.put("usersCnt",userDao.usersCnt());
		int usersCnt = userDao.usersCnt();
		//pageSize --> pageVO.getPageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt/pagevo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}

	@Override
	public int usersCnt() {
		int cnt = userDao.usersCnt();
		return cnt;
	}

	@Override
	public int insertUser(UserVO userVo) {
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVO uservo) {
		return userDao.updateUser(uservo);
	}

	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	* 				재적용 하지 말것
	 */
	@Override
	public int encryptPassAllUser() {
		//상ㅇ하지 마세요 이미 암호화 적용 되었습니다
		if(1==1) {
			return 0;
		}
		
		//0.sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//1.모든 사용자 정보를 조회(단, 기존 암호화 적용 사용자 제외, brown, userTest)
		List<UserVO> userList = userDao.userListForPassEncrypt(sqlSession);
		
		//2.조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트 
		int updateCntSum=0;
		
		for(UserVO uservo : userList) {
			String encryptPass = KISA_SHA256.encrypt(uservo.getPass());
			uservo.setPass(encryptPass);
			
			int updateCnt = userDao.updateUserEncryptPass(sqlSession,uservo);
			updateCntSum += updateCnt;
			
			//비정상
			if(updateCnt != 1) {
				sqlSession.rollback();
				break;
			}
		}
		
		//3.sqlSession 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		
		return updateCntSum;
	}

	public static void main(String[] args) {
		IuserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {}",updateCnt);
		
	}
	
	
	
	
	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVO uservo) {
		
		return 0;
	}

	

}
