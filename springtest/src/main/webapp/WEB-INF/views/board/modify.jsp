<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>게시글 상세</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<form class="container" method="post" action="<%=request.getContextPath()%>/board/modify">
	<h1>게시글</h1>
	<div class="form-group">
	  <label>게시글 번호</label>
	  <input type="text" class="form-control" name="num" readonly value="${board.num}">
	</div>
	<div class="form-group">
	  <label>게시 날짜</label>
	  <input type="text" class="form-control" name="registerd" readonly value="${board.registeredDateTime}">
	</div>
	<div class="form-group">
	  <label>글쓴이</label>
	  <input type="text" class="form-control" name="writer" readonly value="${board.writer}">
	</div>
	<div class="form-group">
	  <label>조회수</label>
	  <input type="text" class="form-control" name="views" readonly value="${board.views}">
	</div>
	<div class="form-group">
	  <label>제목</label>
	  <input type="text" class="form-control" name="title" value="${board.title}">
	</div>
	<div class="form-group">
	  <label>내용</label>
	  <textarea name="contents" class="form-control" rows="10">${board.contents}</textarea>
	</div>
	<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-primary">목록</button></a>
	<a href="<%=request.getContextPath()%>/board/modify"><button class="btn btn-outline-danger">수정</button></a>
</form>
</body>
</html>