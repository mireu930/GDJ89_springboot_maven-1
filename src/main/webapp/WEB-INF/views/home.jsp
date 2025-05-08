<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	<sec:authorize access="!isAuthenticated()">
		<a href="/users/login">로그인</a>
		<a href="/users/join">회원가입</a>	
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="/users/logout">로그아웃</a>
		<a href="/users/mypage">마이페이지</a>	
	</sec:authorize>
	
	<a href="/qna/list">qna</a>
</body>
	<sec:authorize access="isAuthenticated()">
		<c:forEach items="${memoList}" var="m">
			<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" style="border: 1px solid black">
			  <div class="toast-header">
			    <strong class="mr-auto">답글이 달렸습니다</strong>
			    <small>${m.date}</small>
			    <button type="button" class="ml-2 mb-1 close readMessage" data-dismiss="toast" aria-label="Close" data-chatNum="${m.chatNum}">
			      <span aria-hidden="true">&times;</span>
			    </button>
			  </div>
			  <div class="toast-body">
			    	${m.body}
			    	${m.sender}
			  </div>
			</div>
		</c:forEach>
	</sec:authorize>
	
	<c:import url="/WEB-INF/views/template/websocket.jsp"></c:import>
</html>