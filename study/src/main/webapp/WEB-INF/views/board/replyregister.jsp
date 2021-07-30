<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
<form class="container" method="post" action="<%=request.getContextPath()%>/board/reply/register">
	<h2>게시글 등록</h2>
	<div class="form-group">
		<label>내용</label>
		<textarea rows="10" class="form-control" name="contents"></textarea>
	</div>
	<input type="hidden" name="oriNo" value="${oriNo}">
	<button type="submit" class="btn btn-outline-success">등록</button>
</form>
<script type="text/javascript">

</script>
</body>
</html>