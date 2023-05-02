package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.mapper.ProdMapper;

public class ProdServiceImpl implements ProdService {

	SqlSession session = DataSource.getInstance().openSession(true); // true가 들어가면 자동커밋
	ProdMapper mapper = session.getMapper(ProdMapper.class);

	@Override
	public List<ProdVO> ProdList() {
		// TODO Auto-generated method stub
		return mapper.prodList();
	}

	
	@Override
	public ProdVO ProdMain(int prodNo) {
		
		return mapper.prodMain(prodNo);
	}
}
