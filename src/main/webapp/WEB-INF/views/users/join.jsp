<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<form:form modelAttribute="userVO" action="./join" method="post" enctype="multipart/form-data">
		<form:input path="username" id="username" placeholder="id"/>
		<form:password path="password" id="password" placeholder="password"/>
		<form:input path="name" id="name" placeholder="name"/>
		<form:input path="phone" id="phone" placeholder="phone"/>
		<form:input path="email" id="email" placeholder="email"/>
		<input type="date" name="birth" id="birth" placeholder="birth">
		<input type="file" id="profile" name="profile">
		
		<button type="submit" class="btn btn-primary">join</button>	
	</form:form>

</body>
</html>