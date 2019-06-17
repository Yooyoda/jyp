package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVO;

public class ProdDao implements IProdDao{

	@Override
	public List<ProdVO> prodList(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVO> list = sqlSession.selectList("prod.prodList",prod_lgu);
		sqlSession.close();
		return list;
	}

}
