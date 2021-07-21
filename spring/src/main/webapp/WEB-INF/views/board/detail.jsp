<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/reply.js"></script>
</head>
<body>
<c:if test="${board != null}">
<div class="container">
	<h2>게시판</h2>
	<div class="form-group">
		<label>제목</label>
		<input type="text" class="form-control" value="${board.title}" readonly>
	</div>
	<div class="form-group">
		<label>작성자</label>
		<input type="text" class="form-control" value="${board.writer}" readonly>
	</div>
	<div class="form-group">
		<label>작성일</label>
		<input type="text" class="form-control" value="${board.registeredDate}" readonly>
		<!-- ${board.getRegisteredDate()} -->
	</div>
	<div class="form-group">
		<label>조회수</label>
		<input type="text" class="form-control" value="${board.views}" readonly>
	</div>
	
	<div class="form-group">
		<button type="button" class="re-btn up btn btn<c:if test="${rvo.state != 1}">-outline</c:if>-success">추천</button>
		<button type="button" class="re-btn down btn btn<c:if test="${rvo.state != -1}">-outline</c:if>-success">비추천</button>
	</div>
	
	<div class="form-group">
		<label>내용</label>
		<div class="form-control" style="height:auto;">${board.contents}</div>
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
			<div class="reply-list">	
			</div>
			<!-- 페이지네이션 추가 -->
			<ul class="pagination justify-content-center">
				
			</ul>
			
			<div class="reply-box form-group">
				<textarea class="reply-input form-control mb-2"></textarea>
				<button type="button" class="reply-btn btn btn-outline-primary">등록</button>
			</div>
		</div>
	</div>
	
	<c:if test="${user != null && user.id == board.writer}">
		<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button class="btn btn-outline-success">수정</button></a>
		<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button class="btn btn-outline-success">삭제</button></a>
	</c:if>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
</div>
</c:if>
<c:if test="${board ==null}">
<div class="container">
	<h1>삭제되거나 존재하지 않은 게시글입니다.</h1>
	<a href="<%=request.getContextPath()%>/board/list"><button class="btn btn-outline-success">목록</button></a>
</div>
</c:if>
<script type="text/javascript">
	$(function(){
		$('.re-btn').click(function(){
			// 추천 버튼이면 state를 1로, 비추천 버튼이면 state를 -1로
			var state = $(this).hasClass('up')? 1 : -1;
			var num = '<c:out value="${board.num}"/>';
			var obj = $(this);
			$.ajax({
				type: 'get',
				url: '<%=request.getContextPath()%>/board/recommend/' + state + '/' + num,
				dataType: "json",
				success: function(res, status, xhr){
					var str = '';
					var str2 = '';
					if(state == 1){
						str2 = '추천'
					}else{
						str2 = '비추천'
					}
					
					if(res.result == 0){
						str = '이 취소되었습니다.';
					}else if(res.result == 1){
						str = '을 했습니다.';
					}else{
						str = '추천/비추천은 회원만 가능합니다.';
					}
					
					if(res.result != -1){
						alert(str2 + str);
					}else{
						alert(str);
					}
					
					if(res.result == 1){
						$('.re-btn').removeClass('btn-success').addClass('btn-outline-success');
						obj.removeClass('btn-outline-success').addClass('btn-success');	
					}else if(res.result == 0){
						obj.removeClass('btn-success').addClass('btn-outline-success');
					}
					
					
				},
				error: function(xhr, status, error){
					
				}
			})
		})
	})
	$(function(){
		$('.reply-btn').click(function(){
			var rp_bd_num = '${board.num}'; // c:out으로 안 해도 됨(특수문자가 안 들어가니까)
			var rp_me_id = '${user.id}';
			var rp_content = $('.reply-input').val();
			
			if(rp_me_id == ''){
				alert('댓글을 달려면 로그인하세요.');
				return;
			}
			
			var data = {
					'rp_bd_num': rp_bd_num,
					'rp_me_id': rp_me_id,
					'rp_content': rp_content}
			
			$.ajax({
				type: 'post',
				url: '<%=request.getContextPath()%>/reply/ins',
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				success: function(result, status, xhr){
					if(result == 'ok'){
						alert('댓글 등록이 완료되었습니다.')
						readReply('${board.num}', 1);
						$('.reply-input').val('');
					}
				},
				error: function(xhr, status, e){
					
				}
			})
		})
		readReply('${board.num}', 1);
		$(document).on('click', '.pagination .page-item', function(){
			var page = $(this).attr('data');
			readReply('${board.num}', page);
		})
		$(document).on('click', '.del-btn', function(){
			var rp_num = $(this).attr('data');
			$.ajax({
				type: 'post',
				url: '<%=request.getContextPath()%>/reply/del',
				data: JSON.stringify({'rp_num': rp_num}),
				contentType: "application/json; charset=utf-8",
				success: function(result, status, xhr){
					console.log(result);
					readReply('${board.num}', 1);
				},
				error: function(xhr, status, e){
					
				}
			})
		})
	})
	function readReply(rp_bd_num, page){
		$.ajax({
			type: 'get',
			url: '<%=request.getContextPath()%>/reply/list/' + rp_bd_num + '/' + page,
			dataType: "json",
			success: function(result, status, xhr){
				var list = result['list'];
				var str = '';
				for(i = 0; i < list.length; i++){
					str += 
						'<div class="form-group">' +
							'<label>' + list[i].rp_me_id + '</label>' +
							'<div class="form-control">' + list[i].rp_content + '</div>' +
						'</div>';
					if('${user.id}' == list[i].rp_me_id){
						str += '<button class="btn btn-outline-danger del-btn" data="' + list[i].rp_num + '">삭제</button>';						
					}
					
				}
				$('.reply-list').html(str); // 기존에 있는 정보를 덮어쓰기한다(append가 아님)
				var pm = result['pm'];
				var pmStr = '';
				if(pm['prev']){
					pmStr += '<li class="page-item" data="' + (pm['startPage'] - 1) + '"><a class="page-link" href="javascript:void(0);">이전</a></li>';					
				}
				for(i = pm['startPage']; i <= pm['endPage']; i++){
					var active = '';
					if(i == pm['criteria']['page']){
						active = 'active';
					}
					pmStr += '<li class="page-item ' + active + '" data="' + i + '"><a class="page-link" href="javascript:void(0);">' + i + '</a></li>';
				}				
				if(pm['next']){
					pmStr += '<li class="page-item" data="' + (pm['endPage'] + 1) + '"><a class="page-link" href="javascript:void(0);">다음</a></li>';					
				}
				$('.pagination').html(pmStr);
			},
			error: function(xhr, status, e){
				
			}
		})
	}
</script>
</body>
</html>