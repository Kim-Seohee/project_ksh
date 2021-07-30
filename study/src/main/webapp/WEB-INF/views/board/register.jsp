<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<form class="container" method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
	<h2>게시글 등록</h2>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" name="title">
	</div>
	<div class="form-group">
		<label>내용</label>
		<textarea rows="10" class="form-control" name="contents"></textarea>
	</div>
	<div class="form-group">
		<input type="file" name="fileList" class="form-control">
		<input type="file" name="fileList" class="form-control">
		<input type="file" name="fileList" class="form-control">
	</div>
	<button type="submit" class="btn btn-outline-success">등록</button>
</form>
<script type="text/javascript">

</script>
</body>
</html>