<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				${noticeInfo.noticeSubject} </textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"
				value="${noticeInfo.noticeWriter}" readonly></td>
		</tr>
		<tr>
			<th>첨부파일 : ${fileType }</th>
			<td><c:if test="${noticeInfo.attachFile !=null }">
					<c:choose>
						<c:when test="${fileType=='image' }">
							<img width="200px" src="images/${noticeInfo.attachFile}">
						</c:when>
						<c:otherwise>
							<a href="images/${noticeInfo.attachFile}">${noticeInfo.attachFile}</a>
						</c:otherwise>
					</c:choose>
				</c:if></td>

			<td colspan="2" align="center"><c:if
					test="${id == noticeInfo.noticeWriter || id=='admin@email.com'}">
					<button type="submit">수정</button>
				</c:if>
				<button type="button"
					onclick="location.href='noticeList.do?page=${pageNum}'">목록</button>
			</td>
		</tr>
	</table>
</form>
<!-- 댓글등록 -->

<div id="content">
<input type="text" id="reply">
<span>${id}</span>
<button type="button" id="addBtn"> 등록</button>
</div>



<!-- 댓글정보 -->
<table class="table">
	<thead>
	<tr>
		<th>댓글번호</th>
		<th>글내용</th>
		<th>작성자</th>
		<th>삭제</th>
	</tr>
	</thead>
	<tbody id="tlist">
		<tr>
			<td><c:out value="${no=no+1 }"></c:out></td>
			<td>222</td>
			<td></td>
		</tr>
	
	</tbody>
</table>

<script>
	let showFields=['replyId','reply', 'replyWriter']
	let xhtp = new XMLHttpRequest(); //Ajax 호출.
	xhtp.open('get', 'replyList.do?nid=${noticeInfo.noticeId}');
	xhtp.send(); 
	xhtp.onload = function(){
		
		console.log(xhtp.response);
		let tlist = document.querySelector('#tlist');
		
		//목록생성
		let data =JSON.parse(xhtp.response);
		for(let reply of data){
			console.log(reply);
			
			let tr= makeTrFunc(reply);
			tlist.append(tr);
		}
	}
		
	
	//tr 생성해주는 함수만들기
	function makeTrFunc(reply ={}){ //변수의 타입은 obj타입
		let tr= document.createElement('tr');
		for(let prop of showFields){
			let td =document.createElement('td');
			td.innerText =reply[prop];
			tr.append(td);
		}
		
		//삭제 버튼 
		let btn = document.createElement('button');
		btn.addEventListener('click',function (e){
			let 삭제글번호 = btn.parentElement.parentElement.children[0].innerText;
			//db에서 삭제후 .. 화면에서 삭제
			 
			let xhtp = new XMLHttpRequest();
			xhtp.open('post', 'removeReply.do');
			xhtp.setRequestHeader('Contect-Type','application/x-www-form-urlencoded');
			xhtp.send('rid='+삭제글번호);
			
			xhtp.onload = function(){
				let result = xhtp.response;
				if(result.retCode == 'Success'){
					//화면에서 지우기
				}else if(result.retCode == 'Fail'){
					alert('처리중 에러발생');
				}else{
					alert('알수없음');					
				}
			}
			
		})
		btn.innerText = '삭제'
		let td =document.createElement('td');
		td.append(btn);
		tr.append(td);
		
		return tr; //생성한 tr을 반환.		
	}
	
	
	//등록이벤트
	document.querySelector("#addBtn").addEventListener('click',addReplyFnc);
	
	function addReplyFnc(e){
		//로그인 여부를 체크해서 로그인 정보가 없으면 로그인화면으로 이동하기.
		let id= document.querySelector('#content span').innerText;
		if(id==null || id ==''){
			alert("로그인 후에 처리하세요.");
			location.href = 'loginForm.do';
			return;
		}
		
		console.log('click', e.target);
		console.log('reply',document.querySelector("#reply").value)
		console.log('id',"${id}");
		let reply=document.querySelector("#reply").value ="";
		
		//Ajax 호출
		let xhtp = new XMLHttpRequest();
		xhtp.open('post','addReply.do');
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhtp.send('id=${id}&reply='+reply +'&notice_id=${noticeInfo.noticeId}');
		xhtp.onload = function() {
			console.log(xhtp.response);		
			let result = JSON.parse(xhtp.response);
			if(result.retCode == 'Success'){
				//값을 활용해서 tr생성
				let tr = makeTrFunc(result.data);
				tlist.append(tr);
				
				//입력값 초기화하기
				document.getElementById("reply").value='';
				document.getElementById("reply").focus();
				
			}else if(result.retCode == 'Fail'){
				alert ('처리중 에러.')
				
			}
		}	
	}
	
</script>



