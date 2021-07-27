<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="id">
		</div>
		<button type="button" id="findPwBtn" class="btn btn-outline-success">비밀번호 찾기</button>
	</div>
	<div class="wait-box"></div>
	<script type="text/javascript">
		$(function(){
			$('#findPwBtn').click(function(){
				var id = $('[name=id]').val();
				$('.wait-box').text('전송중입니다. 알림창이 나타날때까지 기다려주세요.')
				$.ajax({
					type : 'get',
					url : '<%=request.getContextPath()%>/find/pw/' + id,
					success : function(res){
						$('.wait-box').text('')
						console.log(res);
						alert('새 비밀번호를 등록된 이메일로 전송했습니다.');
					}
				})
			})
		})
	</script>
</body>
</html>