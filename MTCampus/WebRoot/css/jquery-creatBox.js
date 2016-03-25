// JavaScript Document
/**
 * Created by dcg on 15/10/8.
 */
;(function($){
    $.fn.creatBox = function(options,isThis){
        //var option = $.extend({},options);
        if(options == 'close'){
            var $shade = $("#shade");
            $shade.fadeOut(400,function(){
                $shade.remove();
            });
            if(isThis){
                 $(this).fadeOut(600);
            }else{
                $(this).parent().fadeOut(600);
            }
            return;
        }
        return $(this).each(function(){
            var $shade = $("<div id='shade'></div>"),
                $this = $(this),
                width = $this.width();
            $this.css({
                position:'fixed',
                top:'15%',
                left:'50%',
                zIndex:'1003',
                margin:'0 0 0 ' + -width/2 + 'px'
            });
            $shade.css({
                width:'100%',
                height:'100%',
                background:'#000',
                opacity:'0',
                position:'fixed',
                top:'0',
                left:'0',
                zIndex:'1002',
                cursor:'pointer'
            });
            $("body").append($shade);
            $shade.animate({opacity:.8},400).on("click",function(){
                $this.fadeOut(400);
                $shade.fadeOut(600,function(){
                    $shade.remove();
                });
            });
            $this.fadeIn(800);
        })
    }
})(jQuery);

//寮圭獥鍙栨秷
$('.popup_cancel').on('click',function(){
    $('.popup_close').click();
});

//寮圭獥鍏抽棴
$('.popup_close').on('click',function(){
    $(this).creatBox('close');
});