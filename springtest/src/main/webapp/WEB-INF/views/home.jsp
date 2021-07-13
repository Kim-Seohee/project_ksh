<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>홈</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">Seohee</a>
	
	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item">
 			<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
		</li>		
		<!-- Dropdown -->
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
				회원
			</a>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="<%=request.getContextPath()%>/member/signin">로그인</a>
				<a class="dropdown-item" href="<%=request.getContextPath()%>/member/signup">회원가입</a>
			</div>
		</li>
	</ul>
</nav>
${user}
</body>
</html>
