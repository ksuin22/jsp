package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//로그아웃
		HttpSession session = req.getSession();
		//
		session.invalidate(); //세션객체 정보를 삭제하는 메소드
		
		
		try {
			resp.sendRedirect("loginForm.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
