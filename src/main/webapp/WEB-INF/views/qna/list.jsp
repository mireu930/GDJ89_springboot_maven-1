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
	<h1>qna</h1>
	<table>
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>user</th>
				<th>date</th>
				<th>hit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
			<tr>
				<td><a href="./detail?boardNum=${vo.boardNum}">${vo.boardNum}</a></td>
				<td>
					<c:forEach begin="1" end="${vo.boardDepth}" varStatus="d">
						-
						<c:if test="${d.last}">
							>
						</c:if>
					</c:forEach>
						${vo.boardTitle}				
				</td>
				<td>${vo.userName}</td>
				<td>${vo.boardDate}</td>
				<td>${vo.boardHit}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<sec:authorize access="isAuthenticated()">
		<a href="./add">글작성</a>
	</sec:authorize>
</body>
</html>