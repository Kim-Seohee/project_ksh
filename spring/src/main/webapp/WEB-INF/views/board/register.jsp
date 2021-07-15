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
		<textarea class="form-control" rows="10" name="contents"></textarea>
	</div>
	 <!-- 파일 업로드창 추가 -->
    <div class="form-group files">
        <label>파일</label>
        <input type="file" class="form-control file" name="file" data=""/>
    </div>
	<button type="submit" class="btn btn-outline-success">등록</button>
</form>
<script type="text/javascript">
	$(function(){
		$(document).on('change', '.file', function(){
			var str = '<input type="file" class="form-control file" name="file" data=""/>';
			var val = $(this).val();
			var length = $('.file').length;
			var data = $(this).attr('data');
			console.log(val);
			// val이 빈 문자열이 아닐 때
			// input 태그를 추가해야 하는 경우
			if(val != ''){
				if(length < 3 && data == ''){
					$('.files').append(str);
				}
				$(this).attr('data',val);
			}
			// val이 빈 문자열일 때
			if(val == ''){
				$(this).remove();
				if(length == 3 && $('.file').last().val() != ''){
					$('.files').append(str);					
				}
			}
		});
	})
</script>
</body>
</html>