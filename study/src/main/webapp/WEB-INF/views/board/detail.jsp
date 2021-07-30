<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>
</head>
<body>

<div class="container">
	<h2>게시판</h2>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" value="${board.title}" readonly>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" value="${board.writer}" readonly>
	</div>
	<div class="form-group">
		<label>작성일</label>
		<input type="text" class="form-control" value="${board.registeredDate}" readonly>
		<!-- ${board.getRegisteredDate()} -->
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" value="${board.views}" readonly>
	</div>
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="height:auto;">${board.contents}</div>
	</div>

	
	<div class="reply form-group">
		<label>댓글</label>
		<div class="contents">
			<div class="reply-list">	
			</div>
			<!-- 페이지네이션 추가 -->
			<ul class="pagination justify-content-center">
				
			</ul>
			
			<div class="reply-box form-group">
				<textarea class="reply-input form-control mb-2"></textarea>
				<button type="button" class="reply-btn btn btn-outline-dark">등록</button>
			</div>
		</div>
	</div>
	<c:if test="${board.groupOrd == 0 && (user != null && user.authority != 'USER')}">
		<a href="<%=request.getContextPath()%>/board/reply/register?oriNo=${board.num}">
			<button class="btn btn-outline-secondary">답변</button>
		</a>
	</c:if>
</div>


</body>
</html>