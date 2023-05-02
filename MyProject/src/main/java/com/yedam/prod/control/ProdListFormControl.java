package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class ProdListFormControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		// TODO Auto-generated method stub
		ProdService service = new ProdServiceImpl();
		req.setAttribute("prodList", service.ProdList());
		System.out.println(service.ProdList());
		
		return "prod/prodList.tiles";
	}

}
