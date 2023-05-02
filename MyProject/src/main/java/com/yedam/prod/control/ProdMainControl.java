package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class ProdMainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		
		String no= req.getParameter("no"); //"no"는 prodList.jsp에서 클릭할때 넘겨오는값. 
		
		ProdService service = new ProdServiceImpl();
		ProdVO vo = service.ProdMain(Integer.parseInt(no));
		
		req.setAttribute("prod",vo);
		
		
		
		return "prod/prodMain.tiles";
	}

}
