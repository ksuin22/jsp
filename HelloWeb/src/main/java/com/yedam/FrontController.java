package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	//key&value 저장할 수 있는 컬렉션. Map
	//Map<String, String> map;
	//Map<String, Object> map;
	Map<String, Control> map;
	
		
	public FrontController() {
		System.out.println("FrontController() call");
		map= new HashMap<>();
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() call.");
		//map.put("/first.do", new AddMemberServlet()); //key, value
		//map.put("/second.do", new EmpListServlet());
		map.put("/main.do", new Maincontrol());
		map.put("/first.do", new FristControl()); 
		map.put("/second.do", new SecondControl()); 
		
		//사원정보 상세페이지(getMember.jsp)
		map.put("/getMember.do", new GetMemberControl());
		
		//사원정보 수정 페이지(modifyMember.jsp)
		map.put("/modifyMember.do", new modifyMemberControl());
		
		//사원 등록페이지(
		map.put("/addMemberForm.do", new AddMemberFormControl());
		map.put("/addMember.do",new AddMemberControl());
		
		//사원정보 삭제
		map.put("/deleteMember.do", new DeleteMemberControl());
		
		//로그인(아이디, 이메일 입력화면)
		map.put("/loginForm.do", new LoginForm());
		
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보에 한글이 있을시 utf-8
		resp.setContentType("text/html;charset=utf-8"); 
		
		System.out.println("service() call");
		//URL: http://localhost:8081/HelloWeb/first.do
		//URI: URL에서 호스트와 포트정보를 뺀거 -> /HelloWeb/first.do
		String uri = req.getRequestURI(); //HelloWeb/first.do
		String context = req.getContextPath(); //context:프로젝트의 최상위를 말한다. /HelloWeb
		String page = uri.substring(context.length()); 
		
		System.out.println(page);
		System.out.println(map.get(page));
		
		//Object Control = map.get(page);
		Control control = map.get(page);
		control.exec(req, resp);
	}
		
//		if(page.equals("/first.do"))
//			((InitServlet) Object).service(req, resp);
//		else if(page.equals("/second.do"))
//			(EmpListServlet) Object).service(req, resp);
		
	
	
	@Override
	public void destroy() {
		System.out.println("destroy() call");
	}
	
	
	
	

}
