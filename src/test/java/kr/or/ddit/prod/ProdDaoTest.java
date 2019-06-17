package kr.or.ddit.prod;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.Test;

public class ProdDaoTest {

	IProdDao dao = new ProdDao();
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void prodList(){
		/***Given***/
		String prod_lgu = "P101";
		/***When***/
		List<ProdVO> prodList =  dao.prodList(prod_lgu);
		
		/***Then***/
		assertEquals(6,prodList.size());
		
		
	}

}
