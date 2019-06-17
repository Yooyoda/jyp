package kr.or.ddit.prod;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdService;

import org.junit.Test;

public class ProdServiceTest {

	private IProdService service = new ProdService();
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void prodList(){
		/***Given***/
		String prod_lgu = "P101";
		/***When***/
		List<ProdVO> prodList =  service.prodList(prod_lgu);
		
		/***Then***/
		assertEquals(6,prodList.size());
		
		
	}

}
