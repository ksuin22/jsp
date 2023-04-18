package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/empList")
public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		//jdbc 연결 접속 조회
		
//				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");
//				} catch (ClassNotFoundException e) { 
//					e.printStackTrace();
//				}
//				
//				try {
//					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
//					//쿼리 조회 -> 처리결과: preparedStatement
//					String sql = "select employee_id, first_name, last_name, email, phone_number\r\n"
//							+ "from employees";
//					PreparedStatement psmt = conn.prepareStatement(sql);
//					ResultSet rs = psmt.executeQuery();
//					
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list =dao.getEmpList();
		
		
					out.print("<table border='1'>");
					out.print("<thead><tr>"
							+ "<th>사원번호</th><th>FirstName</th><th>LastName</th><th>email</th><th>JobId</th>"
							+ "</tr></thead>");
					out.print("<tbody>");

					//					while(rs.next()) {
						
					for(Employee emp : list) {
//						System.out.println("eid: " +emp.getInt("employee_id") + ",Fname: " +rs.getString("first_name") );
						//사원번호, 
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
//					conn.close();
//					psmt.close();
//					rs.close();
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
				
	}
	
//	public static void main(String[] args) {
//		
//		
//	}

}
