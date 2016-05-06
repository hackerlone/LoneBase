//引用
$(function(){
    $("h4.backs").bind("click",function(){
	    var $content = $(this).next("div.track");
	    if($content.is(":visible")){
			$content.hide("200");
		}else{
			$content.show("200");
		}
	})
})
//提示
 var sweetTitles = {
 x : 10, // @Number: x pixel value of current cursor position
 y : 20, // @Number: y pixel value of current cursor position
 tipElements : ".conbox_image a,.def5img a,.cmslisttit a", // @Array: Allowable elements that can have the toolTip,split with ","
 noTitle : true, //if this value is false,when the elements has no title,it will not be show
 init : function() {
 var noTitle = this.noTitle;
 $(this.tipElements).each(function(){
 $(this).mouseover(function(e){
 if(noTitle){
 isTitle = true;
 }else{
 isTitle = $.trim(this.title) != '';
 }
 if(isTitle){
 this.myTitle = this.title;
 this.title = "";
 var tooltip = "<div id='tooltip'><p>"+this.myTitle+"</p></div>";
 $('body').append(tooltip);
 $('#tooltip')
 .css({
 "top" :( e.pageY+20)+"px",
 "left" :( e.pageX+10)+"px"
 }).show('fast');
 }
 }).mouseout(function(){
 if(this.myTitle != null){
 this.title = this.myTitle;
 $('#tooltip').remove();
 }
 }).mousemove(function(e){
 $('#tooltip')
 .css({
 "top" :( e.pageY+20)+"px",
 "left" :( e.pageX+10)+"px"
 });
 });
 });
 }
 };
 $(function(){
 sweetTitles.init();
 });

//留言回复
$(document).ready(function(){
	var s=document.location;
	$("#divNavBar a").each(function(){
		if(this.href==s.toString().split("#")[0]){$(this).addClass("on");return false;}
	});
});
function ReComment_CallBack(){for(var i=0;i<=ReComment_CallBack.list.length-1;i++){ReComment_CallBack.list[i]()}}
ReComment_CallBack.list=[];
ReComment_CallBack.add=function(s){ReComment_CallBack.list.push(s)};

// 链接复制
function copy_code(text) {
  if (window.clipboardData) {
    window.clipboardData.setData("Text", text)
	alert("已经成功将原文链接复制到剪贴板！");
  } else {
	var x=prompt('你的浏览器可能不能正常复制\n请您手动进行：',text);
  }
}

//Comments
$(document).ready(function(){
// 当鼠标聚焦
if($('#txaArticle').val()==""){
$('#txaArticle').val('留言是种美德，写点什么...').css({color:"#666"});}
$('#txaArticle').focus(
function() {
if($(this).val() == '留言是种美德，写点什么...') {
$(this).val('').css({color:"#222"});
}
}
// 当鼠标失去焦点
).blur(
function(){
if($(this).val() == '') {
$(this).val('留言是种美德，写点什么...').css({color:"#666"});
}
}
);
});

//搜索提示
$(document).ready(function(){
// 当鼠标聚焦
if($('#s').val()==""){
$('#s').val('搜索，回车有效...').css({color:"#666"});}
$('#s').focus(
function() {
if($(this).val() == '搜索，回车有效...') {
$(this).val('').css({color:"#222"});
}
}
// 当鼠标失去焦点
).blur(
function(){
if($(this).val() == '') {
$(this).val('搜索，回车有效...').css({color:"#666"});
}
}
);
});

// 头像
$(document).ready(function(){
$('#divCommentPost').hover(
	function() {
		$(this).find('.set_avatar').stop(true,true).fadeIn();
	},
	function() {
		$(this).find('.set_avatar').stop(true,true).fadeOut();
	}
);
});

// context 翻篇
$(document).ready(function(){
$('.left760 ').hover(
	function() {
		$(this).find('.context_t').stop(true,true).fadeIn();
	},
	function() {
		$(this).find('.context_t').stop(true,true).fadeOut();
	}
);
});
// 滑动特效
$(function() {
	$("#featured .item").hover(function(){
		$(this).find(".boxCaption").stop().animate({
			top:0
		}, 150);
		}, function(){
		$(this).find(".boxCaption").stop().animate({
			top:160
		}, 600);
	});
});

//设置样式表
function SetActiveStyleSheet(title){

	var a;

	if (title) {

		{
			SetCookie("sk",title,365);
		}
		a = document.getElementsByTagName("link")[0];

		a.href=bloghost+"style/"+title+".css";

	}

}

//*********************************************************
// 目的：    设置Cookie
// 输入：    sName, sValue,iExpireDays
// 返回：    无
//*********************************************************
function SetCookie(sName, sValue,iExpireDays) {
	var path=(typeof(cookiespath)=="undefined") ? "/":cookiespath;
	if (iExpireDays){
		var dExpire = new Date();
		dExpire.setTime(dExpire.getTime()+parseInt(iExpireDays*24*60*60*1000));
		document.cookie = sName + "=" + escape(sValue) + "; expires=" + dExpire.toGMTString()+ "; path="+path;
	}
	else{
		document.cookie = sName + "=" + escape(sValue)+ "; path="+path;
	}
}
//*********************************************************




//*********************************************************
// 目的：    返回Cookie
// 输入：    Name
// 返回：    Cookie值
//*********************************************************
function GetCookie(sName) {

	var arr = document.cookie.match(new RegExp("(^| )"+sName+"=([^;]*)(;|$)"));
	if(arr !=null){return unescape(arr[2])};
	return null;

}
//*********************************************************




//*********************************************************
// 目的：    验证信息
// 输入：    无
// 返回：    无
//*********************************************************

function VerifyMessage() {

	var strFormAction=$("#inpId").parent("form").attr("action");
	var strName=$("#inpName").val();
	var strEmail=$("#inpEmail").val();
	var strHomePage=$("#inpHomePage").val();
	var strVerify=$("#inpVerify").val();
	var strArticle=$("#txaArticle").val();
	var intReplyID=$("#inpRevID").val();
	var intPostID=$("#inpId").val();
	var intMaxLen=1000;

	if(strName==""){
		alert(str01);
		return false;
	}
	else{
		re = new RegExp("^[\.\_A-Za-z0-9\u4e00-\u9fa5]+$");
		if (!re.test(strName)){
			alert(str02);
			return false;
		}
	}

	if(strEmail==""){
		//alert(str01);
		//return false;
	}
	else{
		re = new RegExp("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
		if (!re.test(strEmail)){
			alert(str02);
			return false;
		}
	}

	if(typeof(strArticle)=="undefined"){
		alert(str03);
		return false;
	}

	if(typeof(strArticle)=="string"){
		if(strArticle==""){
			alert(str03);
			return false;
		}
		if(strArticle.length>intMaxLen)
		{
			alert(str03);
			return false;
		}
	}

	//ajax comment begin
	var strSubmit=$("#inpId").parent("form").find(":submit").val();
	$("#inpId").parent("form").find(":submit").val("Waiting...").attr("disabled","disabled").addClass("loading");

	$.post(strFormAction,
		{
		"isajax":true,
		"postid":intPostID,
		"verify":strVerify,
		"name":strName,		
		"email":strEmail,
		"content":strArticle,
		"homepage":strHomePage,
		"replyid":intReplyID
		},
		function(data){
		
			$("#inpId").parent("form").find(":submit").removeClass("loading");
			$("#inpId").parent("form").find(":submit").removeAttr("disabled");
			$("#inpId").parent("form").find(":submit").val(strSubmit);
		
			var s =data;
			if((s.search("faultCode")>0)&&(s.search("faultString")>0))
			{
				alert(s.match("<string>.+?</string>")[0].replace("<string>","").replace("</string>",""))
			}
			else{
				var s =data;
				var cmt=s.match(/cmt\d+/);
				if(intReplyID==0){
					$(s).insertAfter("#AjaxCommentBegin");
				}else{
					$(s).insertAfter("#AjaxComment"+intReplyID);
				}
				window.location="#"+cmt;
				$("#txaArticle").val("");
				
				SaveRememberInfo();
				CommentComplete();
			}

		}
	);

	return false;
	//ajax comment end

}
//*********************************************************




//*********************************************************
// 目的：    加载信息
// 输入：    无
// 返回：    无
//*********************************************************
function LoadRememberInfo() {

	var strName=GetCookie("name");
	var strEmail=GetCookie("email");
	var strHomePage=GetCookie("homepage");


	if(strName){$("#inpName").val(strName);}
	if(strEmail){$("#inpEmail").val(strEmail);}
	if(strHomePage){$("#inpHomePage").val(strHomePage);}

}
//*********************************************************




//*********************************************************
// 目的：    保存信息
// 输入：    无
// 返回：    无
//*********************************************************
function SaveRememberInfo() {

	var strName=$("#inpName").val();
	var strEmail=$("#inpEmail").val();
	var strHomePage=$("#inpHomePage").val();

	SetCookie("name",strName,365);
	SetCookie("email",strEmail,365);
	SetCookie("homepage",strHomePage,365);

}
//*********************************************************




//*********************************************************
// 目的：    回复留言
// 输入：    无
// 返回：    无
//*********************************************************
function RevertComment(i) {

	$("#inpRevID").val(i);
	
	$("#cancel-reply").show().bind("click", function(){ $("#inpRevID").val(0);$(this).hide();window.location.hash="#comment";return false; });

	window.location.hash="#comment";
}
//*********************************************************




//*********************************************************
// 目的：    
//*********************************************************
function GetComments(postid,page){
	$.get(bloghost+"zb_system/cmd.php?act=getcmt&postid="+postid+"&page="+page, function(data){
	  $('#AjaxCommentBegin').nextUntil('#AjaxCommentEnd').remove();
	  $('#AjaxCommentBegin').after(data);
	});

}
//*********************************************************




//*********************************************************
// 目的：  预留空函数,留给主题或插件用  
//*********************************************************
function CommentComplete(){
}
//*********************************************************