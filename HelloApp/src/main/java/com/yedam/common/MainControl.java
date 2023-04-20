package com.yedam.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
		 
		req.setAttribute("myName", "홍길동");
		
		//return "WEB-INF/views/main.jsp";

		//main.jsp를 찾겠습니다 라는 뜻, tiles.xml에서 wildcard:*해놨기 때문에 tiles로
		//return "main.tiles"; 
		
		//
		return "product/productList.tiles";
	}

}
