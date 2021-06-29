var id;
$(function(){
	// 오른쪽 두번째 컨텐츠 롤링 기능
	id = rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1500);
	$('.right2').hover(function(){
		clearInterval(id);
	},function(){
		id = rollingLeft('.right2 .view-box .contents-box', 'li', 800, 1500);
	})
	// 오른쪽 두번째 컨텐츠 다음 버튼
	$('.right2 .btn-box .next-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();
			$('.right2 .contents-box li').first()
				.animate({'margin-left': -width+'px'},800,function(){
					$(this).detach().appendTo('.right2  .contents-box').removeAttr('style');
				})
		}
	})
	// 오른쪽 두번째 컨텐츠 이전 버튼
	$('.right2 .btn-box .prev-btn').click(function(){
		if(!$('.right2 .contents-box li').first().is(':animated')){
			var width = $('.right2 .contents-box li').first().width();
			$('.right2 .contents-box li').last().detach().prependTo('.right2  .contents-box')
				.css('margin-left',-width+'px').animate({'margin-left':0}, 800);
		}
	})
})
var selMenu = [];
var tmpMenu = [];
var empty = [];

$(function(){
	//메뉴 더보기 버튼 클릭
	$('.menu .more-btn').click(function(){
		$('.box3 .menu-box').show();
		$('.box3 .menu .menu-btn-box').show();
		$(this).hide();
		$('.menu .fold-btn').show();
	})
	//접기 버튼 클릭
	$('.menu .fold-btn').click(function(){
		// 접기/더보기 버튼
		$(this).hide();
		$('.menu .more-btn').show();
		// 메뉴 박스
		$('.box3 .menu-box').hide();
		$('.box3 .menu-box .menu-box1').show(); // 메뉴 링크를 보여주고
		$('.box3 .menu-box .menu-box2').addClass('display-none'); // 메뉴 체크박스를 가림


		// 메뉴 버튼 박스
		$('.box3 .menu .menu-btn-box').hide();
		$('.box3 .menu .menu-btn-box .btn-box1').show(); // 서비스 전체보기, 메뉴설정 버튼을 보여주고
		$('.box3 .menu .menu-btn-box .btn-box2').hide(); // 초기화, 저장 버튼은 감춤

		if(selMenu.length == 0){
			selMenu = [];
			$('.selected-menu-list .list-item').each(function(index){
				$('.selected-menu-list .list-item').eq(index).removeClass('selected').find('a').text('');
				$('.selected-menu-list .list-item').eq(index).addClass('unselected').find('a').text('');
			});
			$('.menu-list li input[type=checkbox]').each(function(i){
				$('.menu-list li input[type=checkbox]').eq(i).prop('checked',false);
			});
			$('.selected-menu-list .list-item').eq(0).addClass('selected').find('a').text('');
			// 검은색 메뉴 보이게 만들기
			$('.menu .black-menu-list').show();
			// 선택한 메뉴 없어지게 만들기(임시)
			$('.menu .selected-menu-list').hide();
			// setMenuBox(selMenu);
		}else{
			$('.menu .fold-btn').hide();
			$('.menu .more-btn').show();
			// 메뉴 박스
			$('.box3 .menu-box').hide();
			$('.box3 .menu-box .menu-box1').show(); // 메뉴 링크를 보여주고
			$('.box3 .menu-box .menu-box2').addClass('display-none'); // 메뉴 체크박스를 가림


			// 메뉴 버튼 박스
			$('.box3 .menu .menu-btn-box').hide();
			$('.box3 .menu .menu-btn-box .btn-box1').show(); // 서비스 전체보기, 메뉴설정 버튼을 보여주고
			$('.box3 .menu .menu-btn-box .btn-box2').hide(); // 초기화, 저장 버튼은 감춤

			$('.menu .black-menu-list').hide();
			initMenuBox(selMenu);
			for(var i = selMenu.length; i <= 3; i++){
				$('.selected-menu-list .list-item').eq(i).removeClass('selected unselected');
			}
			tmpMenu = [];
			$('.menu-list input[type=checkbox]').each(function(i){
				$('.menu-list input[type=checkbox]').eq(i).prop('checked',false);
			});
			if(selMenu.length > 0){
				for(var index = 0; index < selMenu.length; index++){
					$('.menu-list input[type=checkbox]').each(function(i){
						if($('.menu-list input[type=checkbox]').eq(i).val() == selMenu[index])
							$('.menu-list input[type=checkbox]').eq(i).prop('checked',true);
					});
				}
			}
			}
	})
	// 메뉴 설정 버튼 클릭
	$('.box3 .set-btn').click(function(){
		tmpMenu = selMenu.slice(0);
		$('.box3 .menu-box1').hide();
		$('.box3 .menu-box2').removeClass('display-none');
		$('.box3 .btn-box2').show();
		$('.box3 .btn-box1').hide();

		// 검은색 메뉴 없어지게 만들기
		$('.menu .black-menu-list').hide();
		// 선택한 메뉴 보이게 만들기
		$('.menu .selected-menu-list').show();
		$('.selected-menu-list .list-item').addClass('unselected');
		initMenuBox(selMenu);
	})
	// 저장 버튼 클릭
	$('.menu-btn-box .save-btn').click(function(){
		selMenu = tmpMenu.slice(0); // 값을 복사
		if(selMenu.length > 0){
			$('.menu .fold-btn').hide();
			$('.menu .more-btn').show();
			// 메뉴 박스
			$('.box3 .menu-box').hide();
			$('.box3 .menu-box .menu-box1').show(); // 메뉴 링크를 보여주고
			$('.box3 .menu-box .menu-box2').addClass('display-none'); // 메뉴 체크박스를 가림


			// 메뉴 버튼 박스
			$('.box3 .menu .menu-btn-box').hide();
			$('.box3 .menu .menu-btn-box .btn-box1').show(); // 서비스 전체보기, 메뉴설정 버튼을 보여주고
			$('.box3 .menu .menu-btn-box .btn-box2').hide(); // 초기화, 저장 버튼은 감춤

			$('.menu .black-menu-list').hide();
			for(var i = selMenu.length; i <= 3; i++){
				$('.selected-menu-list .list-item').eq(i).removeClass('selected unselected');
			}
			$('.menu .selected-menu-list').show();
		}else{
			alert('선택된 메뉴가 없습니다. 초기 설정으로 돌아갑니다.')
			$('.menu .fold-btn').click();
		}
	});
	// 초기화 버튼 클릭
	$('.menu-btn-box .init-btn').click(function(){
		selMenu = [];
		tmpMenu = [];
		$('.selected-menu-list .list-item').each(function(index){
			$('.selected-menu-list .list-item').eq(index).removeClass('selected').find('a').text('');
			$('.selected-menu-list .list-item').eq(index).addClass('unselected').find('a').text('');
		});
		$('.menu-list li input[type=checkbox]').each(function(i){
			$('.menu-list li input[type=checkbox]').eq(i).prop('checked',false);
		});
		$('.selected-menu-list .list-item').eq(0).addClass('selected').find('a').text('');
		alert('초기 메뉴로 돌아갑니다');
		$('.menu .fold-btn').click();
	});
	// 체크박스 클릭
	$('.menu-list li input[type=checkbox]').click(function(){
		var value = $(this).val();
		var index = tmpMenu.indexOf(value);
		if(index >= 0){
			tmpMenu.splice(index,1);
			spliceMenu(tmpMenu);
		}else{
			if(tmpMenu.length == 4){
				alert('4개까지 선택할 수 있습니다.')
				$(this).prop('checked',false);
			}else{
				tmpMenu.push(value);
			}
			initMenuBox(tmpMenu);
		}
	});
	// left5 메뉴 선택
	// 클릭시
	$('.left5 .menuitem').click(function(){
		$('.left5 .menuitem').removeClass('selected');
		$(this).addClass('selected');
		var target = $(this).attr('data-target');
		$('.left5 .contents-box div').hide();
		$(target).show();
		//맨 마지막이나 맨 끝이면 버튼 없애기
		var selected = $('.left5 .selected');
		if(selected.parent().next().length == 0){
			if(selected.next().length == 0){
				$('.left5 .next-btn').hide();
			}else{
				$('.left5 .next-btn').show();	
			}
		}else{
			$('.left5 .next-btn').show();
		}
		if(selected.parent().prev().length == 0){
			if(selected.prev().length == 0){
				$('.left5 .prev-btn').hide();
			}else{
				$('.left5 .prev-btn').show();	
			}
		}else{
			$('.left5 .prev-btn').show();
		}

	});
	$('.menuitem').eq(0).click();

	$('.left5 .next-btn').click(function(){
		var selected = $('.left5 .selected');
		if(selected.next().length == 0){
			if(selected.parent().next().length == 0){
				return;
			}
			var ml = $('.left5 .inner-box').css('margin-left');
			ml = parseFloat(ml);
			var width = $('.left5 .menu').first().width();
			ml = ml - width;
			$('.left5 .inner-box').animate({'margin-left': ml + 'px'},500);
			selected.parent().next().children('.left5 .menuitem').first().addClass('selected');
			selected.removeClass('selected');

		}else{
			selected.removeClass('selected').next().addClass('selected');
		}
		$('.selected').click();
	});
	$('.left5 .prev-btn').click(function(){
		$(this).css('display','block')
		var selected = $('.left5 .selected');
		if(selected.prev().length == 0){
			if(selected.parent().prev().length == 0){
				return;
			}
			var ml = $('.left5 .inner-box').css('margin-left');
			ml = parseFloat(ml);
			var width = $('.left5 .menu').first().width();
			ml = ml + width;
			$('.left5 .inner-box').animate({'margin-left': ml + 'px'},500);
			selected.parent().prev().children('.left5 .menuitem').last().addClass('selected');
			selected.removeClass('selected');
		}else{
			selected.removeClass('selected').prev().addClass('selected');
		}
		$('.selected').click();
	});
})
function initMenuBox(arr){
	$('.selected-menu-list .list-item').each(function(index){
		// 선택된 메뉴를 화면에 미리 출력하고 unselected로 바꿈
		if(arr.length > index){
			$(this).find('a').text(arr[index]);
			$(this).removeClass('unselected')
		}
		// 남은 부분을 빈 공간으로 만들고 selected 적용
		else{
			$(this).find('a').text('');
			if(index == arr.length){
				$(this).addClass('selected');
			}
		}
	});
}
function setMenuBox(selMenu){
	if(selMenu.length > 0){
		$('.menu .black-menu-list').hide();
		initMenuBox(selMenu);
		$('.menu .selected-menu-list').show();
	}else{
	$('.menu .black-menu-list').show();
	$('.menu .selected-menu-list').hide();
	}
}
function spliceMenu(selMenu){
	$('.selected-menu-list .list-item').each(function(index){
		if(index == selMenu.length){
			$(this).find('a').text('');
			$(this).addClass('selected')
			$(this).addClass('unselected')
		}else if(index > selMenu.length){
			$(this).find('a').text('');
			$(this).removeClass('selected')
			$(this).addClass('unselected')
		}
	});
}