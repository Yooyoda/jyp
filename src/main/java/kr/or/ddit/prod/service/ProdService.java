package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVO;

public class ProdService implements IProdService{

	private IProdDao dao = new ProdDao();
	
	@Override
	public List<ProdVO> prodList(String prod_lgu) {
		List<ProdVO> list = dao.prodList(prod_lgu);
		return list;
	}

}
