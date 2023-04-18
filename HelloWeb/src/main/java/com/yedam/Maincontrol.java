package com.yedam;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class Maincontrol implements Control {

	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			//페이지를 재지정하겠다
			//resp.sendRedirect(); ->내부,외부사이트 가능
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/empList.jsp"); //forward(req,resp); 
			rd.forward(req, resp);
			
		} catch (Exception e) {
			
		}

	}

}
