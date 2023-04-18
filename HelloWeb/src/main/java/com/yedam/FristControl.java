package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class FristControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("firstControl 실행");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try {
			out = resp.getWriter();
		} catch (Exception e) {

		}
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list =dao.getEmpList();
		
		
					out.print("<table border='1'>");
					out.print("<thead><tr>"
							+ "<th>사원번호</th><th>FirstName</th><th>LastName</th><th>email</th><th>JobId</th>"
							+ "</tr></thead>");
					out.print("<tbody>");

						
					for(Employee emp : list) {
						out.print("<tr>"
								+ "<td><a href='searchMember?empId="+emp.getEmployeeId()+"'>"+emp.getEmployeeId()+"</a></td>"
								+"<td>"+emp.getFirstName()+"</td>"
								+"<td>"+emp.getLastName()+"</td>"
								+"<td>"+emp.getEmail()+"</td>"
								+"<td>"+emp.getJobId()+"</td>"
												+ "</tr>");
					}
					
					out.print("</tbody>");
					out.print("</table>");

	}
	
	
	

}
