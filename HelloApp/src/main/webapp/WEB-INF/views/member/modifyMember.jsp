<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="modifyMember.do">
	<table class="table">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${name }" readonly></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" value="${id }" readonly></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" value="${pw }" required></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="phone" value="${phone}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="adr" value="${adr }"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">수정</button>
				<button>취소</button>
			</td>
		</tr>
	</table>
</form>