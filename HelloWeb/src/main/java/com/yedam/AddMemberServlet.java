package com.yedam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

//등록: 사용자의 입력 (addform.html)
//처리: 서블릿(insert기능: addMemberServlet)
//결과: 목록페이지 출력





@WebServlet("/addMemberServlet")
public class AddMemberServlet extends HttpServlet{
	//생성자, init, service 

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String fname = req.getParameter("fname"); //input name="fname"
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String job = req.getParameter("job");
		String hdate = req.getParameter("hdate");
		System.out.println("fname: " +fname +"lname: " +lname );
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setJobId(job);
		emp.setHireDate(hdate);
		
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);
		
		if(result) {
			resp.sendRedirect("empList");
		}else {
			resp.sendRedirect("employee/addForm.html");
		}
	
	
	//jdbc 연결 접속 조회
//	try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//	} catch (ClassNotFoundException e) { 
//		e.printStackTrace();
//	}
//	
//	try {
//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
//		//쿼리 조회 -> 처리결과: preparedStatement
//		String sql = "insert into employees (employee_id,first_name,last_name,email, hire_date,job_id)\r\n"
//				+ "values(EMPLOYEES_SEQ.nextval, ?,?,?,?,?)";
//		PreparedStatement psmt = conn.prepareStatement(sql);
//		psmt.setString(1, fname);
//		psmt.setString(2, lname);
//		psmt.setString(3, email);
//		psmt.setString(4, hdate);
//		psmt.setString(5, job);
//		
//		int r = psmt.executeUpdate();
//		System.out.println("처리된 건수: "+ r);
//		
//		resp.sendRedirect("empList"); //form -> addMemberServlet -> empList
//		
//		
//	} catch (SQLException e) {
//	}
//	
	
	
	
	
	}

}
