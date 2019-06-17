package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public class UserDao implements IuserDao{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	public static void main(String[] args) {
		
		/***Given***/
		IuserDao userDao = new UserDao();
		
		/***When***/
		List<UserVO> userList =  userDao.userList();
		UserVO getUser = userDao.getUser("brown");
		
		/***Then***/
		logger.debug("userList : {}", userList);
		logger.debug("getUser : {}", getUser);
		
	}

	/**
	 * 
	* Method : userList
	* 작성자 : PC09
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList =  sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC09
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO user = sqlSession.selectOne("user.getUser",userId);
		sqlSession.close();
		return user;
	}

	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC09
	* 변경이력 :
	* @param pagevo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVO> userPagingList(PageVO pagevo) {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userPagingList", pagevo);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int usersCnt() {
		SqlSession sqlSession =  MyBatisUtil.getSqlSession();
		int cnt = (Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return cnt;
	}

	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC09
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVO userVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int cnt = sqlSession.insert("user.insertUser", userVo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC09
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int cnt = sqlSession.delete("user.deleteUser",userId);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}

	/**
	 * 
	 * Method : updateUser
	 * 작성자 : PC09
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 수정
	 */
	@Override
	public int updateUser(UserVO uservo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int cnt = sqlSession.update("user.updateUser",uservo);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
		
	}

	/**
	 * 
	* Method : userListForPassEncrypt
	* 작성자 : PC09
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userListForPassEncrypt(SqlSession sqlSession) {
		
		return sqlSession.selectList("user.userListForPassEncrypt");
	}

	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVO uservo) {
	
		return sqlSession.update("user.updateUserEncryptPass",uservo);
	}
	
	

}	
