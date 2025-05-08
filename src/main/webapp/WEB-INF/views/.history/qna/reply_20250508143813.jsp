<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>qna reply</h1>
		
	<form action="" method="post" enctype="multipart/form-data">
		<input type="hidden" name="userName" id="memoReceiver" value='<sec:authentication property="principal.username"/>'>
		<div>
			<label>제목</label>
			<input type="text" name="boardTitle">	
		</div>
		<div>
			<label>내용</label>
			<textarea rows="" cols="" name="boardContents" id="memoContents"></textarea>
		</div>
		
		<button id="memoSend">작성</button>
	</form>
</body>
<script>
	//웹소켓관련코드
	const websocket = new WebSocket("/ws/chat")
	const memoSend = document.getElementById("memoSend");
	const memoContents = document.getElementById("memoContents")
	const memoReceiver = document.getElementById("memoReceiver")
	
	memoSend.addEventListener("click",()=>{
		let m = new Message();
	
		m.body=memoContents.value;
		m.receiver=memoReceiver.value;
		m.status=3;
		m.date=new Date();
		
		websocket.send(JSON.stringfy(m))
	})
	
	class Message {
		sender="";
		body="";
		receiver="";
		date="";
		status="0"
	}
</script>
</html>

