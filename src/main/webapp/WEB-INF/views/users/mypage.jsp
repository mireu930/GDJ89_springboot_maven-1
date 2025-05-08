<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>mypage</h1>
	<input type="text" name="username" value="<sec:authentication property="principal.username"/>" readonly >
	<input type="text" name="username" value="<sec:authentication property="principal.name"/>" readonly >
	<input type="text" name="username" value="<sec:authentication property="principal.birth"/>" readonly >
</body>
</html>