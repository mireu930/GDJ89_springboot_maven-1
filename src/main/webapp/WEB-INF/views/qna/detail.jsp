<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>qna detail</h1>
	<table class="table table-striped table-hover" style="width: 100%; font-size: 1.2em;">
					<thead>
						<tr>
						<th>제목</th>
						<th>날짜</th>
						<th>작성자</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${vo.boardTitle}</td>
							<td>${vo.boardDate}</td>
							<td>${vo.userName}</td>
						</tr>
			</tbody>
		</table>
		<div class="form-group" style="width: 100%">
			<div style="width: 100%; font-size: 1.1em; min-height: 300px; overflow-y: auto; white-space: pre-line; background-color: white">
				${vo.boardContents}
			</div>					
		</div>
		
		<a href="./reply?boardNum=${vo.boardNum}">답글작성</a>
		
		<c:import url="/WEB-INF/views/template/websocket.jsp"></c:import>
</body>
</html>