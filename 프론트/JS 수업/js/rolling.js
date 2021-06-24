function rollingTop(list, listItem, marginTop, animateTime, intervalTime){
    var id = setInterval(function(){
        if(!$(list+ ' ' + listItem).first().is(':animated')){
            $(list+ ' ' + listItem).first().animate({'margin-top':marginTop+'px'},animateTime,function(){
                $(this).detach().appendTo(list).removeAttr('style');
            });
        }
    },intervalTime);
    return id
}
function rollingLeft(list, listItem, animateTime, intervalTime){
    var id = setInterval(function(){
        if(!$(list + ' ' + listItem).first().is(':animated')){
            var width = $(list + ' ' + listItem).first().width();
            $(list + ' ' + listItem).first().animate({'margin-left':'-'+width}, animateTime, function(){
                $(this).detach().appendTo(list).removeAttr('style');
            })
        }
    },intervalTime)
    return id;
}
function rollingRight(list, listItem, animateTime, intervalTime){
    var id = setInterval(function(){
        if(!$(list + ' ' + listItem).first().is(':animated')){
            var width = $(list + ' ' + listItem).last().width();
            console.log('-' + width +'px')
            $(list + ' ' + listItem).last().css('margin-left',-width + 'px').detach().prependTo('.box1')
            $(list + ' ' + listItem).first().animate({'margin-left':'0px'},animateTime)
        }
    },intervalTime)
    return id;
}  