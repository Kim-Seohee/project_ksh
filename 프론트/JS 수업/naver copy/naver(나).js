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