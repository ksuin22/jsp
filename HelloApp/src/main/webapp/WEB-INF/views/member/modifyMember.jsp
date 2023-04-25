<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <form action="modifyMember.do" >
 <input type="text" name="id" value="${id }" readonly>
<input type="text" name="pw">
<input type="text" name="phone">
<input type="text" name="adr">
<button type="submit">수정</button>
 </form>