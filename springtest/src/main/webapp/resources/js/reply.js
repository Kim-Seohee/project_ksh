/**
 * 
 */
var replyService = (function(){
	
	function insert(contextPath, data){
		$.ajax({
			type: 'post',
			url: contextPath + '/reply/ins',
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			success: function(res){
				if(res == 'OK'){
					alert('댓글 등록이 완료되었습니다.');
					$('.reply-input').val('');
				}
			}
		})
	}
	
	return {
		name: '서비스',
		insert: insert
	}
})();