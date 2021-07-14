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
<form class="container" method="post" action="<%=request.getContextPath()%>/member/mypage">
	<h1>회원정보</h1>
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" value="${user.id}" readonly name="id"> <!-- ${user.xxx}: 세션에 있는 유저 정보 -->
	</div>
	<div class="form-group">
		<label>새 비밀번호</label>
		<input type="password" class="form-control" name="pw">
	</div>
	<div class="form-group">
		<label>새 비밀번호확인</label>
		<input type="password" class="form-control" name="pw2">
	</div>
	<div class="form-group">
		<label>이름</label>
		<input type="text" class="form-control" value="${user.name}" readonly name="name">
	</div>
	<div class="form-group">
		<label>이메일</label>
		<input type="text" class="form-control" value="${user.email}" name="email">
	</div>
	<div class="form-group">
		<label>성별</label>
		<select class="form-control" name="gender">
			<option value="M"<c:if test="${user.gender == 'M'}">selected</c:if>>남성</option>
			<option value="F"<c:if test="${user.gender == 'F'}">selected</c:if>>여성</option>
		</select>
	</div>
	<button class="btn btn-outline-success col-12">수정</button>
</form>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var pw = $('[name=pw]').val();
			var pw2 = $('[name=pw2]').val();
			if(pw == pw2){
				return true;
			}
			else{
				alert('비밀번호와 비밀번호 확인이 다릅니다')
				return false;
			}
		})
	})
</script>
</body>
</html>