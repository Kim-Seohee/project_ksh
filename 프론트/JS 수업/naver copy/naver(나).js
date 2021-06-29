var id1;
$(function(){
    // 오른쪽 두번째 컨텐츠 롤링 기능
    id1 = rollingLeft('.right2 .contents-box','li',1200,1500);
    $('.right2').hover(function(){
        clearInterval(id1);
    },function(){
        id1 = rollingLeft('.right2 .contents-box','li',1200,1500);
    });
    // 오른쪽 두번째 컨텐츠 다음 버튼
    $('.right2 .next-btn').click(function(){
        var width = $('.right2 .contents-box li').first().width();
        if(!$('.right2 .contents-box li').first().is(':animated')){
            $('.right2 .contents-box li').first().animate({'margin-left': -width + 'px'}, 1200, function(){
                $(this).detach().appendTo('.right2 .contents-box').removeAttr('style');
            });
        }
    });
    // 오른쪽 두번째 컨텐츠 이전 버튼
    $('.right2 .prev-btn').click(function(){
        var width = $('.right2 .contents-box li').first().width();
        if(!$('.right2 .contents-box li').first().is(':animated')){
            $('.right2 .contents-box li').last().detach().prependTo('.right2 .contents-box').css('margin-left', -width + 'px').animate({'margin-left': 0}, 1200);
        }
    });
});
// 기본 메뉴
var oriMenu = ['사전', '뉴스', '증권', '부동산', '지도', 'VIBE', '책', '웹툰'];
// 저장으로 최종 확정된 메뉴
var selMenu = [];
// 메뉴설정에서 선택한 메뉴
var tmpMenu = [];

var oriHref = ['https://weather.naver.com/'];
var selHref = ['https://weather.naver.com/'];
var tmpHref = [];
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
        //접기/더보기 버튼 
        $(this).hide();
        $('.menu .more-btn').show();

        //메뉴 박스
        $('.box3 .menu-box').hide();
        $('.box3 .menu-box .menu-box1').show();//메뉴 링크된 메뉴를 보여주고
        $('.box3 .menu-box .menu-box2').addClass('display-none');//메뉴 체크박스로 된 메뉴를 가림

        //메뉴 버튼 박스
        $('.box3 .menu .menu-btn-box').hide();
        $('.box3 .menu .menu-btn-box .btn-box1').show();//서비스 전체보기, 메뉴설정 버튼을 보여주고
        $('.box3 .menu .menu-btn-box .btn-box2').hide();//초기화, 저장 버튼은 감춤

        //검은 메뉴 출력
        setMenuBox(selMenu, oriMenu, selHref, oriHref);
        tmpMenu = [];
        tmpHref = [];
        initCheckbox(selMenu);
        // $('.menu-list input[type=checkbox]').each(function(i){
        // 	$('.menu-list input[type=checkbox]').eq(i).prop('checked',false);
        // });
        // if(selMenu.length > 0){
        // 	for(var index = 0; index < selMenu.length; index++){
        // 		$('.menu-list input[type=checkbox]').each(function(i){
        // 			if($('.menu-list input[type=checkbox]').eq(i).val() == selMenu[index])
        // 				$('.menu-list input[type=checkbox]').eq(i).prop('checked',true);
        // 		});
        // 	}
        // }
    })
    //메뉴 설정 버튼 클릭
    $('.box3 .set-btn').click(function(){
        $('.box3 .menu-box1').hide();
        $('.box3 .menu-box2').removeClass('display-none');
        $('.box3 .btn-box2').show();
        $('.box3 .btn-box1').hide();
        initMenuBox(selMenu);
        tmpMenu = selMenu.slice(0);
        tmpHref = selHref.slice(0);
    })
    // 메뉴 설정에서 체크박스 클릭
    $('.menu-list input[type=checkbox]').click(function(){
        var value = $(this).val();
        var state = $(this).prop('checked');
        var href = $(this).attr('data-target');
        if(state){
            //배열에 추가
            if(tmpMenu.length == 4){
                $(this).prop('checked',!state);
                alert('최대 4개');
                return;
            }
            tmpMenu.push(value);
            tmpHref.push(href);
        }else{
            //배열에서 제거
            var index = tmpMenu.indexOf(value);
            tmpMenu.splice(index,1);
            tmpHref.splice(index,1);
        }
        initMenuBox(tmpMenu);
    });
    // 메뉴 설정에서 저장 버튼 클릭
    $('.btn-box2 .save-btn').click(function(){
        selMenu = tmpMenu.slice(0);
        selHref = tmpHref.slice(0);
        $('.menu .fold-btn').click();
    });
    // 메뉴 설정에서 초기화 버튼 클릭
    $('.btn-box2 .init-btn').click(function(){
        alert('초기 설정으로 돌아갑니다');
        selMenu = [];
        selHref = [];
        $('.menu .fold-btn').click();
    });
})
/*
- 메뉴 설정을 눌렀을 때 검은 메뉴 창에 메뉴를 선택할 수 있는 박스를 보여주도록 화면을 구성하는 함수로
  선택된 메뉴가 있으면 글자가, 아니면 박스가 보여지고, 최대 네개 보여진다. 
*/
function initMenuBox(arr){
    $('.black-menu-list .list-item').each(function(index){
        $(this).removeClass('input-box selected display-none');
        $(this).find('a').attr('href','#');
        //5번째 검은색 메뉴를 안보이게 함
        if(index >= 4){
            $(this).addClass('display-none');
        }
        //선택된 메뉴를 화면에 미리 출력
        else if(arr.length > index){
            $(this).find('a').text(arr[index]);
        }
        //남은 부분을 검은 색 빈 박스로 변경
        else{
            $(this).find('a').text('');
            $(this).addClass('input-box');
            if(index == arr.length){
                $(this).addClass('selected');
            }
        }
    })
}
/*
- 선택된 메뉴에 따라 검은색 메뉴를 보여주는 부분, 선택된 메뉴가 없으면 기본 메뉴를 화면에 보여줌
*/
function setMenuBox(selArr, oriArr, selHref, oriHref){
    //선택된 메뉴가 있으면 선택된 메뉴를 화면에 출력하고, 선택된 메뉴가 없으면 미리 지정된 메뉴를 출력
    //하기 위해 arr를 상황에 따라 선정
    var arr = selArr.length == 0 ? oriArr: selArr;
    var hrefArr = selHref.length == 0 ? oriHref : selHref;

    $('.black-menu-list .list-item').each(function(index){
        $(this).removeClass('display-none');
        //메뉴를 보여줘야 하기 때문에 메뉴 선택할 때 사용된 박스를 제거
        $(this).removeClass('selected input-box');
        if(index < arr.length){
            $(this).find('a').text(arr[index]);
            $(this).find('a').attr('href', hrefArr[index]);
        }else{
            $(this).addClass('display-none');
        }
    })
}
/*
- 메뉴 설정에서 선택된 메뉴에 따라 체크 박스 체크 여부가 결정되게 하는 함수
*/
function initCheckbox(arr){
    $('.menu-list input[type=checkbox]').each(function(){
        var value = $(this).val();
        // 선택된 메뉴에 값이 있으면
        if(arr.indexOf(value) >= 0){
            $(this).prop('checked',true);
        }
        // 없으면
        else{
            $(this).prop('checked',false);
        }
    })
}

$(function(){
    $('.left3 .menu-btn-box .next-btn').click(function(){
        var selected = $('.left3 .selected');
        // 메뉴4, 8, 12
        if(selected.next().length == 0){
            // 마지막 메뉴인 경우(메뉴 12)
            if(selected.parent().next().length == 0){
                return;
            }
            // 애니메이션
            var ml = $('.left3 .menu-wrap-box').css('margin-left');
            ml = parseFloat(ml);
            var width = $('.left3 .menu').first().width();
            ml = ml - width;
            $('.left3 .menu-wrap-box').animate({'margin-left': ml + 'px'},500);
            // 이동 후 다음 큰 메뉴에서 첫번째 메뉴에 selected 클래스 추가
            selected.parent().next().children('.menu-item').first().addClass('selected');
            selected.removeClass('selected');

        }else{
            // 큰 메뉴 내에서 다음으로 이동
            selected.removeClass('selected').next().addClass('selected');
        }
        $('.selected').click();
    });
    $('.left3 .menu-btn-box .prev-btn').click(function(){
        var selected = $('.left3 .selected');
        // 메뉴1, 5, 9
        if(selected.prev().length == 0){
            // 첫번째 메뉴인 경우(메뉴 12)
            if(selected.parent().prev().length == 0){
                return;
            }
            // 애니메이션
            var ml = $('.left3 .menu-wrap-box').css('margin-left');
            ml = parseFloat(ml);
            var width = $('.menu').first().width();
            ml = ml + width;
            $('.left3 .menu-wrap-box').animate({'margin-left': ml + 'px'},500);
            // 이동 후 다음 큰 메뉴에서 첫번째 메뉴에 selected 클래스 추가
            selected.parent().prev().children('.menu-item').last().addClass('selected');
            selected.removeClass('selected');

        }else{
            // 큰 메뉴 내에서 다음으로 이동
            selected.removeClass('selected').prev().addClass('selected');
        }
        $('.selected').click();
    });
    $('.left3 .menu-item').click(function(){
        $('.left3 .menu-item').removeClass('selected');
        $(this).addClass('selected');
        var target = $(this).attr('data-target');
        $('.left3 .contents-box div').hide();
        $(target).show();
        // 첫번째 메뉴를 선택하면 prev 버튼 안보이게
        if(target == '.menu-box1'){
            $('.left3 .menu-btn-box .prev-btn').hide();
        }else{
            $('.left3 .menu-btn-box .prev-btn').show();
        }
        // 마지막 메뉴를 선택하면 next 버튼 안보이게
        if(target == '.menu-box27'){
            $('.left3 .menu-btn-box .next-btn').hide();
        }else{
            $('.left3 .menu-btn-box .next-btn').show();
        }
    });
    $('.left3 .menu-item').eq(0).click();
});