<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>수정페이지(noticeModify.jsp)</h3>

<form action="modifyNotice.do" method="post">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid" value="${noticeInfo.noticeId}"
				readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeTitle}" ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea type="text" name="subject">
				${noticeInfo.noticeSubject} </textarea> </td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter}" readonly></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><img width="200px" src="images/${noticeInfo.attachFile}">
				</td>

			<td colspan="2" align="center">
				<button type="submit">수정완료</button>
				<button type="button">삭제</button>
				
			</td>
		</tr>
		

	
	</table>
</form>