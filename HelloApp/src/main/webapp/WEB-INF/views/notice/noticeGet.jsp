<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>상세페이지 : ${noticeInfo.noticeId}번 글 (noticeGet.jsp)</h3>

<form action="modifyNotice.do" method="get">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" name="nid" value="${noticeInfo.noticeId}"
				readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"
				value="${noticeInfo.noticeTitle}" readonly></td>
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
			<th>첨부파일 : ${fileType }</th>
			<td>
			<c:if test="${noticeInfo.attachFile !=null }">
			<c:choose>
			<c:when test="${fileType=='image' }">
			<img width="200px" src="images/${noticeInfo.attachFile}">
			</c:when>
			<c:otherwise>
			<a href="images/${noticeInfo.attachFile}">${noticeInfo.attachFile}</a> 
			</c:otherwise>
			 </c:choose>
			 </c:if>
				</td>

			<td colspan="2" align="center">
				<button type="submit">수정</button>
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</td>
		</tr>
		

	
	</table>
</form>