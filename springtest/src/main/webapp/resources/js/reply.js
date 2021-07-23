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
					list(contextPath, data['rp_bd_num'], 1, user);
					alert('댓글 등록이 완료되었습니다.');
					$('.reply-input').val('');
				}
			}
		})
	}
	function list(contextPath, rp_bd_num, page, user){
		$.ajax({
			type: 'get',
			url: contextPath + '/reply/list/' + rp_bd_num + '/' + page,
			dataType: 'json',
			success: function(result){
				var list = result['replyList'];
				var str = '<hr style="background: red"/>';
				for(i = 0; i < list.length; i++){
					str +=
						'<div class="form-group">' +
							'<label>' + list[i].rp_me_id + '</label>' +
							'<div class="form-control">' + list[i].rp_content + '</div>' +
						'</div>';
					if(user == list[i].rp_me_id){
						str += '<div>';
						str += '<button class="btn btn-outline-danger del-btn" data="' + list[i].rp_num + '">삭제</button>';
						str += '<button class="btn btn-outline-danger mod-btn" data="' + list[i].rp_num + '">수정</button>';
						str += '</div>'
					}
				}
				str += '<hr style="background: red"/>';
				$('.reply-list').html(str);
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
			}
		})
	}
	return {
		name: '서비스',
		insert: insert,
		list: list
	}
})();