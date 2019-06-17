package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.paging.model.PageVO;

public class LprodService implements ILprodService {

	ILprodDao lprodDao = new LprodDao();
	
	
	@Override
	public Map<String, Object> lprodPagingList(PageVO pagevo) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", lprodDao.lprodPagingList(pagevo));
		
		int lprodCnt = lprodDao.lprodCnt();
		int paginationSize = (int)Math.ceil((double)lprodCnt/pagevo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}


	@Override
	public int lprodCnt() {
		int cnt = lprodDao.lprodCnt();
		return cnt;
	}

}
