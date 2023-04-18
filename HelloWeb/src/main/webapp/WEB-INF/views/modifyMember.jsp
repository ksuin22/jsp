<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "menu.jsp"></jsp:include>
<jsp:include page = "nav.jsp"></jsp:include>

<style>
input[type="button"]{
background-color: yellow;

}

</style>


</head>
<body>
<%
//사원번호 조회.=> Employee
	String empId = request.getParameter("emp_id");
	EmpDAO dao = new EmpDAO();
	Employee result = dao.getEmp(Integer.parseInt(empId));
%>

<form action="modifyMember.do" method="post">
<table class='table'>
	<tr>
		<th>사원번호</th>
		<td><input type="text" name="emp_id" value="<%=result.getEmployeeId()%>"></td>
	</tr>
	<tr>
		<th>FirstName</th>
		<td><input type="text" name="first_name" value="<%=result.getFirstName()%>"></td>
	</tr>
	<tr>
		<th>LastName</th>
		<td><input type="text" name="last_name" value="<%=result.getLastName()%>"></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email" value="<%=result.getEmail()%>"></td>
	</tr>	
	<tr>
		<td colspan="2">
		<input type="submit" value="수정">
		<input type="button" value="삭제">
		</td>
	</tr>
	
</table>
</form>

<script>

//document Object Model.
	let btn = document.querySelector('input[type="button"]');
	console.log(btn);
	btn.onclick = function(){
		//alert("클릭됨");
		let frm=document.querySelector('form');
		frm.action = "deleteMember.do";
		frm.submit(); //
		
	}
	
	

</script>

</body>

<jsp:include page = "footer.jsp"></jsp:include>

</html>