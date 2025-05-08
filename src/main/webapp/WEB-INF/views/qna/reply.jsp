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
		<input type="hidden" id="memoReceiver" value="${vo.userName}">
		<input type="hidden" name="userName" value='<sec:authentication property="principal.username"/>'>
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
	<c:import url="/WEB-INF/views/template/websocket.jsp"></c:import>
</body>
</html>

