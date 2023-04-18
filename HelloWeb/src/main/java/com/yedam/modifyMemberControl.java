package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class modifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//view에서 요청한 method를 구분해주는 메소드. get/post인지 선택
		if(req.getMethod().equals("GET")) {
			
		//get- 화면열기. post = 업데이트
			
		
		// 파라미터 : emp_id
		// MVC 패턴. 컨트롤러에서 DB의 처리. view 화면으로 정보를 전송.
		// emp 변수에 조회결과를 담아서 empInfo의 속성으로 modifyMember.jsp 재지정.
		
		//매개값으로 사원번호를 가져온다.
			
		String empId= req.getParameter("emp_id");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		req.setAttribute("empInfo", emp);
		
		//페이지를 재지정. control => getMember.jsp
		try {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp");
			rd.forward(req, resp);
					
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		}else if(req.getMethod().equals("POST")) {
			//DB업데이트 처리. 목록으로 이동.
			String empId = req.getParameter("emp_id");
			String fname = req.getParameter("first_name");
			String lname = req.getParameter("last_name");
			String email = req.getParameter("email");
			
			Employee emp = new Employee();
			emp.setEmployeeId(Integer.parseInt(empId));
			emp.setFirstName(fname);
			emp.setLastName(lname);
			emp.setEmail(email);
			
			EmpDAO dao = new EmpDAO();
			boolean result = dao.updateMember(emp);
			
				try {
					if(result) {
					resp.sendRedirect("main.do");
					}else {
						resp.sendRedirect("modifyMember.do");
					}
				} catch (IOException e) {
					e.printStackTrace();
				
				
			}
			
			
			
		}
		
	}

}
