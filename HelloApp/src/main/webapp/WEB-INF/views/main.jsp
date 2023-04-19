<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main.jsp</title>
</head>
<body>
	<p>Main Page</p>
	<p>Expression Language</p>
	${3>2} <!--간단한 연산식 처리가능 -->
	${"hi"}
	${10-1}
	${myName} <!-- setAttribute 에서 불러온-->
	${myName != null } <!-- true -->
	${myName != null ? '<p>있음</p>': '<p>없음</p>' }
</body>
</html>