$(function(){
    //获取焦点时追加边框class
    $('.pfb-txt textarea').focus(function(){
        $('.pfb-txt').addClass('tags');
    });
    //失去焦点时去除边框class
    $('.pfb-txt textarea').blur(function(){
        $('.pfb-txt').removeClass('tags');
    });
    //点击反馈反馈框显示
    $('#feedback').click(function(){
        $('#product-fb textarea').val('');
        $('#product-fb input').val('');
        $('.error').hide();
        $('.error span').text('你还没填任何反馈呢');
        $('#feedback-con').fadeIn();
    });
    //点击小叉反馈框消失
    $('.pfb-pho-close').click(function(){
        $('#product-fb textarea').val('');
        $('#product-fb input').val('');
        $('#feedback-con').fadeOut();
    })
    //点击确定时ajax提交数据
    $('.ensure').click(function(){
        var msg = $('.pfb-txt textarea').val();
        var email = $('.pfb-email .e-box').val();
        if (!msg) {
            $('.tip').show();
            setTimeout(function(){
                $('.tip').hide();
            }, 2000);
        } else {
            if (!email) {
                $('.tip').show();$('.tip span').text('请留下您的邮箱');
                setTimeout(function(){
                    $('.tip').hide();
                }, 2000);
            } else {
                var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/i;
                if (!pattern.test(email)) {
                    $('.tip').show();$('.tip span').text('请填写正确的邮箱');
                    setTimeout(function(){
                        $('.tip').hide();
                    }, 2000);
                } else {
                    $.post(baseurl+'Index/feedback.html', {'msg': msg, 'email': email}, function(data){
                        if (data == 1) {
                            if (data) {
                                //提交成功后反馈框消失
                                $('#feedback-con').fadeOut();
                                var a = setTimeout(function(){
                                }, 2000);
                                $('.tip').show();$('.tip span').text('提交成功');
                                var b = setTimeout(function(){
                                    $('.tip').hide();
                                }, 2000);
                            }
                        } else {
                            $('.tip').show();
                            $('.tip span').text('数据提交失败');
                            setTimeout(function(){
                                $('.tip').hide();
                            }, 2000);
                        }
                    });
                    return false;
                }
            }
        }
    });
});