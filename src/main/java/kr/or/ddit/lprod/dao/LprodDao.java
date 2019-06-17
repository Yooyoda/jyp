package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDao implements ILprodDao {

	
	@Override
	public List<LprodVO> lprodPagingList(PageVO pagevo) {
		SqlSession sqlsession = MyBatisUtil.getSqlSession();
		List<LprodVO> list = sqlsession.selectList("lprod.lprodPagingList",pagevo);
		sqlsession.close();
		return list;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlsession = MyBatisUtil.getSqlSession();
		int cnt = (Integer)sqlsession.selectOne("lprod.lprodCnt");
		sqlsession.close();
		
		return cnt;
	}

}
