package com.yedam.prod.domain;

import java.util.List;

import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class Sample {
	public static void main(String[] args) {

		ProdService service = new ProdServiceImpl();
		List<ProdVO> list = service.ProdList();
		
		for(ProdVO vo : list) {
			System.out.println(vo);
		}
		
				



	}

}
