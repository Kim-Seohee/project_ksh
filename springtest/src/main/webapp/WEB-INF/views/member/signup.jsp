<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>

</head>
<body>

<form class="container" method="post" action="<%=request.getContextPath()%>/member/signup">
	<h1>회원가입</h1>
	<div class="form-group">
		<label>아이디</label>
		<input type="text" class="form-control" name="id">
		<button id="dupCheck" type="button" class="col-12 btn btn-outline-success">아이디 중복 확인</button>
	</div>
	<div class="form-group">
		<label>비밀번호</label>
		<input type="password" class="form-control" name="pw">
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
	<button class="btn btn-outline-dark col-12">회원가입</button>
</form>
<script type="text/javascript">
	$(function(){
		$('form').submit(function(){
			var id = $('[name=id]').val();
			var pw = $('[name=pw]').val();
			var pw2 = $('[name=pw2]').val();
			var name = $('[name=name]').val();
			var email = $('[name=email]').val();
			if(id.trim() == ''){ // trim: 문자열 앞뒤의 모든 공백을 지움
				alert('아이디를 입력하세요');
				return false;
			}
			if(pw.trim() == ''){
				alert('비밀번호를 입력하세요');
				return false;
			}
			if(pw != pw2){
				alert('비밀번호가 일치하지 않습니다.');
				return false;
			}
			if(name.trim() == ''){
				alert('이름을 입력하세요.');
				return false;
			}
			if(email.trim() == ''){
				alert('이메일을 입력하세요.');
				return false;
			}
		})
		
	})
	$(function(){
		$('#dupCheck').click(function(){
			var id = $('[name=id]').val();
			if(id == ''){
				alert('아이디를 입력하세요');
				return;
			}
			$.ajax({
				type: 'get',
				url: '<%=request.getContextPath()%>/member/idcheck/' + id,
				success: function(result, status, xhr){
					if(result == "POSSIBLE")
						alert('사용 가능한 아이디입니다.');
					else
						alert('사용 불가능한 아이디입니다.');
				},
				error: function(xhr, status, error){
					
				}
			})
		})
	})
</script>
</body>
</html>