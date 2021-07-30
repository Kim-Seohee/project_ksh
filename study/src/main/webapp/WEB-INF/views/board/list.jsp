<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>일반 게시판</title>
</head>
<body>

<div class="container">
	<h2>게시판</h2>
	<p>^_____________^</p>            
	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.num}</td>
					<td>
						<a href="#">
							<c:if test="${board.groupOrd != 0}"> <i class="fas fa-reply-all"></i> </c:if>
							${board.title}
						</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.registeredDate}</td>
					<td>${board.views}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>