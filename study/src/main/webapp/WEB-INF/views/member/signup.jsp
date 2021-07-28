<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>


</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/member/signup" id="signup">
	<h1>회원가입</h1>
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" name="id">
	</div>
	<button id="dupCheck" type="button" class="col-12 btn btn-outline-success">아이디 중복 확인</button>
	<div class="form-group">
		<label>비밀번호</label>
		<input type="password" class="form-control" name="pw" id="pw"> <!-- id값을 써야 한다(정규표현식 플러그인 -->
	</div>
	<div class="form-group">
		<label>비밀번호 확인</label>
		<input type="password" class="form-control" name="pw2"> 
	</div>
	<div class="form-group">
		<label>이름</label>
		<input type="text" class="form-control" name="name">
	</div>
	<div class="form-group">
		<label>이메일</label>
		<input type="text" class="form-control" name="email">
	</div>
	<div class="form-group">
		<label>성별</label>
		<select class="form-control" name="gender">
			<option value="M">남성</option>
			<option value="F">여성</option>
		</select>
	</div>
	<button class="btn btn-outline-success col-12">회원가입</button>
</form>

</body>
</html>