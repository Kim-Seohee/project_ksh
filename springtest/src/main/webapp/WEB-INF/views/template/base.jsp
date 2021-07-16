<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!doctype html>
<html>
<head>
<title>스프링</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
<style>
	.body{
		min-height: calc(100vh - 240px);
	}
</style>
</head>
<body>
    <tiles:insertAttribute name="nav" />    
    <div class="body">
    <tiles:insertAttribute name="body" />                                               
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>