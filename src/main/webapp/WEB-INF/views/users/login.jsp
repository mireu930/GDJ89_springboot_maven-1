<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<form action="./login" method="post">
	<input type="hidden" value="${_csrf.token}" name="${_csrf.parameterName}">
		<input type="text" name="username" id="username">
		<input type="password" name="password" id="password">
		
		<button type="submit" class="btn btn-primary">login</button>
	</form>
</body>
</html>