<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>회원정보</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${member!=null}">
<form class="container" method="post" action="<%=request.getContextPath()%>/mypage">
	<h1>회원정보</h1>
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" value="${member.id}" readonly>
	</div>
	<div class="form-group">
		<label>비밀번호</label>
		<input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
		<label>비밀번호확인</label>
		<input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
		<label>이름</label>
		<input type="text" class="form-control" value="${member.name}" readonly>
	</div>
	<div class="form-group">
		<label>이메일</label>
		<input type="text" class="form-control" value="${member.email}">
	</div>
	<div class="form-group">
		<label>성별</label>
		<select class="form-control" name="gender">
			<option value="M"<c:if test="${member.gender == 'M'}">selected</c:if>>남성</option>
			<option value="F"<c:if test="${member.gender == 'F'}">selected</c:if>>여성</option>
		</select>
	</div>
	<button class="btn btn-outline-success col-12">수정</button>
</form>
</c:if>
<c:if test="${member==null}">
<h1>존재하지 않는 회원입니다.</h1>
</c:if>
</body>
</html>