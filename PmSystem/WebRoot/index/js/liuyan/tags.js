$(document).ready(function(){
$('.Tblogpublished span').click(function() {
    $(this).addClass("selected").siblings().removeClass();
	$(".tblogconent").slideUp('1500').eq($(this).index()).slideDown('1500');
});     
$('#Tblogpublished span').click(function() {
    $(this).addClass("selected").siblings().removeClass();
    $(".tblogconent").slideUp('1500').eq($(this).index()).slideDown('1500');
}); 
    })