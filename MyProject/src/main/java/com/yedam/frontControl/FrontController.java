package com.yedam.frontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.control.ProdListFormControl;
import com.yedam.prod.control.ProdMainControl;

//공지사항 컨트롤러
public class FrontController extends HttpServlet {

	private Map<String, Control> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>();	

	}

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		//------컨트롤 만들기------//
		
		//상품목록
		map.put("/prodListForm.do", new ProdListFormControl());
		
		//상품조회
		map.put("/prodMain.do", new ProdMainControl());
		
		
	}

	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//인코딩 방식 
		
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println("path: "+path);
		
		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println("viewPage: "+viewPage);
		
		if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return; //메소드 종료
		}
		
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
													//처음부터 시작해서 .json 빼고
			return; //메소드종료
		}
		
		//페이지 재지정.
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
				
	}

	
}



