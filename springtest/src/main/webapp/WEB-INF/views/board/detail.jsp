<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script> <!-- js파일 연결 -->
	<style>
	 	.recommend-btn{
	 		font-size: 30px;	
	 	}
	 	.fa-thumbs-down{
	 		transform: rotateY(180deg);
	 	}
	</style>
</head>
<body>
<div class="container">
	<h1>게시글</h1>
	<div class="form-group">
	  <label>게시글 번호</label>
	  <input type="text" class="form-control" name="num" readonly value="${board.num}">
	</div>
	<div class="form-group">
	  <label>게시 날짜</label>
	  <input type="text" class="form-control" name="registerd" readonly value="${board.registeredDateTime}">
	</div>
	<div class="form-group">
	  <label>글쓴이</label>
	  <input type="text" class="form-control" name="writer" readonly value="${board.writer}">
	</div>
	<div class="form-group">
	  <label>조회수</label>
	  <input type="text" class="form-control" name="views" readonly value="${board.views}">
	</div>
	<div class="form-group">
		<a href="#" class="recommend-btn up">
			<i class="<c:choose><c:when test="${recommend != null && recommend.state==1}">fas</c:when><c:otherwise>far</c:otherwise></c:choose> fa-thumbs-up"></i>
		</a>
		<a href="#" class="recommend-btn down">
			<i class="<c:choose><c:when test="${recommend != null && recommend.state==-1}">fas</c:when><c:otherwise>far</c:otherwise></c:choose> fa-thumbs-down"></i>
		</a>
	</div>
	<div class="form-group">
	  <label>제목</label>
	  <input type="text" class="form-control" name="title" readonly value="<c:out value="${board.title}"/>">
	</div>
	<div class="form-group">
	  <label>내용</label>
	  <div id="summernote" class="form-control">${board.contents}</div>
	</div>
	<c:if test="${fileList.size() != 0 }">
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${fileList}" var="file">
				<a href="<%=request.getContextPath()%>/board/download?fileName=${file.name}" class="form-control mb-2">${file.ori_name}</a>
			</c:forEach>
		</div>
	</c:if>
	
	<div class="reply form-group">
		<label>댓글</label>
		<div class="contents">
			<div class="reply-list"></div>
			
			<ul class="pagination justify-content-center">
				
			</ul>
			
			
			<div class="reply-box form-group">
				<textarea class="reply-input form-control mb-2"></textarea>
				<button type="button" class="reply-btn btn btn-outline-dark">등록</button>
			</div>
		</div>
	</div>
	
	<div class="input-group">
		<a href="<%=request.getContextPath()%>/board/list" class="mr-2"><button class="btn btn-outline-danger">목록</button></a>
		<c:if test="${board != null && user.id eq board.writer}"> <!--게시글이 있을 때만, 또 글을 쓴 사용자일때만 수정,삭제 버튼을 보여줌-->
			<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}" class="mr-2"><button class="btn btn-outline-danger">수정</button></a>
			<form action="<%=request.getContextPath()%>/board/delete" method="post" class="mr-2">
				<input type="hidden" value="${board.num}" name="num">
				<button class="btn btn-outline-danger">삭제</button>
			</form>
		</c:if>
	</div>
</div>
<script>
	// 전역변수
	// 게시글 번호
	// 프로젝트명
	// 유저 정보
	var rp_bd_num = '${board.num}';
	var contextPath = '<%=request.getContextPath()%>';
	var user = '${user.id}';
	$(function(){
		var msg = '${msg}';
		printMsg(msg);
		history.replaceState({},null,null); // history를 비워줌
		$('.recommend-btn').click(function(e){
			e.preventDefault();
			// 추천 버튼이면 state를 1로, 비추천 버튼이면 state를 -1로
			var state = $(this).hasClass('up')? 1 : -1;
			var board = '<c:out value="${board.num}"/>';
			var obj = $(this);
			$.ajax({
				type: 'get',
				url: '<%=request.getContextPath()%>/board/recommend/' + state + '/' + board,
				dataType: "json",
				success: function(res, status, xhr){
					$('.recommend-btn i').removeClass('fas').addClass('far');
					var str = '';
					var str2 = '';
					if(state == 1){
						str2 = '추천';
					}else{
						str2 = '비추천';
					}
					
					if(res.result == 0){
						str = '이 취소되었습니다.';
					}else if(res.result == 1){
						str = '을 했습니다.';
						if(state == 1){
							$('.recommend-btn.up i').addClass('fas');
						}else if(state == -1){
							$('.recommend-btn.down i').addClass('fas');
						}
					}else{
						str = '추천/비추천은 회원만 가능합니다.';
					}
					
					if(res.result != -1){
						alert(str2 + str);
					}else{
						alert(str);
					}
					
					
					
				},
				error: function(xhr, status, error){
				}
			})
		})

		replyService.list(contextPath, rp_bd_num, 1, user);
		
		$(document).on('click', '.pagination .page-item', function(){
			var page = $(this).attr('data');
			replyService.list(contextPath, '${board.num}', page, user);
		})
		
		$(document).on('click', '.mod-btn', function(){
			var rp_num = $(this).attr('data');
			var content = $(this).parent().prev().children().last().text();
			console.log(rp_num);
			console.log(content);
			var str =
				'<div class="reply-mod-box form-group">' +
					'<textarea class="reply-input form-control mb-2">' + content + '</textarea>' +
					'<button type="button" class="reply-mod-btn btn btn-outline-dark" data="' + rp_num + '">등록</button>' +
				'</div>';
			$(this).parent().hide();
			$(this).parent().prev().children().last().hide();
			$(this).parent().prev().append(str);
		})
		$(document).on('click', '.reply-mod-btn', function(){
			var rp_content = $(this).prev().val();
			var rp_num = $(this).attr('data');
			replyService.modify(contextPath, rp_content, rp_num, rp_bd_num);
			
		})
		$('.reply-btn').click(function(){
			var rp_bd_num = '${board.num}'; // 문법에 맞게 하기 위해 앞뒤로 따옴표를 붙여주는 것
			var rp_me_id = '${user.id}';
			var rp_content = $('.reply-input').val();
			if(rp_me_id == ''){
				alert('댓글을 달려면 로그인하세요.');
				return;
			}
			var data = {
					'rp_bd_num': rp_bd_num, // 속성명: 변수
					'rp_me_id': rp_me_id,
					'rp_content': rp_content
			}
			
			replyService.insert(contextPath, data);
		})
	})
	function printMsg(msg){
		if(msg == '' || history.state){
			return
		}
		alert(msg);
	}
	
	$(function(){
	
		
	})
</script>
</body>
</html>