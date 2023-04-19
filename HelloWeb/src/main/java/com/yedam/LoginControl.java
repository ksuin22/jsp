package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//사원번호(100), 이메일(SKING)
		
		String empId = req.getParameter("uname");
		String email = req.getParameter("psw");
		
		//emp객체에 담아서 넘기기
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setEmail(email);
		System.out.println("1 emp : "+emp);

		//
		EmpDAO dao = new EmpDAO();
		emp = dao.loginCheck(emp);
		System.out.println("2 emp : "+emp);
		
		
				

		try {
			
			if(emp ==null) { //id,pw 넣었으나 없을때
				resp.sendRedirect("loginForm.do"); //로그인폼으로 간다.
			}else {
				//request 객체/ session객체
				req.setAttribute("reqInfo", emp);
				HttpSession session = req.getSession();
				session.setAttribute("sesInfo", emp.getLastName());
				
				
				resp.sendRedirect("main.do");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
	}

}
