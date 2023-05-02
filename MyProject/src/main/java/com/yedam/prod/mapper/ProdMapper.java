package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProdVO;

public interface ProdMapper {
	
	
	//상품목록
	public List<ProdVO> prodList();
	
	
	//상품조회
	public ProdVO prodMain(int prodNo);
	
	

}
