<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML>

<html xmlns:wb="http://open.weibo.com/wb" lang="zh-CN">
	<head>
		<title>实习僧-实习生-最靠谱的实习生招聘网站</title>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="renderer" content="webkit">
		<meta name="description"
			content="实习僧是国内领先的实习生招聘网站,500强名企实习,靠谱实习机会,优质实习信息,优秀实习生,找实习就上实习僧,实习生招聘首选实习僧。">
		<meta name="keywords" content="实习,实习生,找实习,实习生招聘,暑期实习,实习僧">
		<meta name="Robots" content="all">
		<meta property="qc:admins" content="2040752403463010135676375" />
		<meta name="baidu-site-verification" content="EP5drAzZgp" />
		<link rel="stylesheet" href="css/icon1.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.4.1.js"></script>
		<link href="css/serch.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/serch.js"></script>
		<link rel="stylesheet" type="text/css"
			href="css/style.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/style.css?v=2.3.7" />
		<link rel="stylesheet" type="text/css"
			href="css/external.min.css-v=2.2.7.css"
			tppabs="http://www.shixiseng.com/css/external.min.css?v=2.2.7" />
		<link rel="stylesheet" type="text/css"
			href="css/popup.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/popup.css?v=2.3.7" />
		<link rel="stylesheet" type="text/css"
			href="css/lightbox.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/lightbox.css?v=2.3.7" />
		<link rel="stylesheet" type="text/css"
			href="css/bluedream.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/bluedream.css?v=2.3.7" />
		<link rel="stylesheet" type="text/css"
			href="css/introjs.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/introjs.css?v=2.3.7" />
		
		<link rel="stylesheet" type="text/css"
			href="css/uploadify.css-v=2.3.7.css"
			tppabs="http://www.shixiseng.com/css/uploadify.css?v=2.3.7" />
		<link rel="stylesheet" type="text/css"
			href="css/jquery.datetimepicker.css-v=2.2.7.css"
			tppabs="http://www.shixiseng.com/css/jquery.datetimepicker.css?v=2.2.7" />
		

		<script src="js/jquery.min.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/jquery.min.js?v=2.2.7"></script>
		<script type="text/javascript" src="js/libs/jquery.lib.min.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/libs/jquery.lib.min.js?v=2.2.7"></script>
		<script type="text/javascript" src="js/ajaxfileupload.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/ajaxfileupload.js?v=2.2.7"></script>
		<script type="text/javascript" src="js/additional-methods.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/additional-methods.js?v=2.2.7"></script>
		<script language="javascript" type="text/javascript"
			src="My97DatePicker/WdatePicker.js"></script>
		


		<style>
#ul1{
	height: auto;
	width: 550px;
}
#ul1 > li{
	height: auto;
	width: 550px;
	margin: 1px;
}
.forLastStep {
	font-weight: bold;
}
#ajaxregnameError {
    display: block;
    margin: 5px 0 10px 0;
    font-size: 14px;
    color: #ff6a6a;
    text-align: left;
    background: url("images/error.png"/*tpa=http://www.shixiseng.com/images/error.png*/) 0 3px no-repeat;
    padding-left: 20px;
    line-height: 22px;
}
.customDefault {
	font-weight: bold;
	color: gray;
}

.customDefault .introjs-skipbutton {
	border-radius: 10px;
	color: cornflowerblue;
}

.div_login {
	display: none;
}

#search_input {
	height: auto;
}
#secjob {
	background-color:#999;
	height: 600px;
}
#page_navigation{
margin:0 auto 0 auto;
}
#page_navigation a{
	padding:3px;
	border:1px solid gray;
	margin:2px;
	color:black;
	text-decoration:none
	margin: 0 auto;
}
.active_page{
	background:darkblue;
	color:white !important;
}
</style>
		<!--    登录注册-->
		<script src="js/md5.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/md5.js?v=2.2.7"></script>
		<sx:head parseContent="true" />

	</head>
	<body>
	<input type='hidden' id='current_page' />
	<input type='hidden' id='show_per_page' />
	
		<div id="ad" style="display: none;">
			<a href="summerstorm/index.html"
				tppabs="http://www.shixiseng.com/summerstorm/index.html"> <img
					src="images/ad_summerstorm.png"
					tppabs="http://www.shixiseng.com/images/ad_summerstorm.png"
					style="width: 100%; position: absolute; top: 0; left: 0; z-index: 1;" />
			</a>
			<img id="close_btn" src="images/ad_close.png"
				tppabs="http://www.shixiseng.com/images/ad_close.png"
				style="position: absolute; right: 10px; top: 3px; z-index: 2"
				width="20" />
		</div>
		<div id="content_wrapper">
			<div id="header">
				<div class="wrapper">
					<ul class="reset" id="navheader">
						<li class="logo_header">
							<a href="index.jsp" tppabs="http://www.shixiseng.com/index.html">
								<img src="images/new_logo_2.png"
									tppabs="http://www.shixiseng.com/images/new_logo_2.png"
									width="140" height="52" alt="实习僧,专注实习生招聘，最靠谱的实习生招聘网站" /> </a>
						</li>
						<li class="current">
							<a href="index.jsp" tppabs="index.jsp">首页</a>
						</li>
						<li>
							<a href="index.jsp" rel="nofollow" class="validate">找实习</a>
						</li>
						<!-- <li  class="current" ><a href="" >公司</a></li>-->
						<s:if test="#session.students.UName!=null">
						<li>
							<a href="stu_getStudentById.action?student.UId=${session.students.UId}&option=update" rel="nofollow" class="validate">我的简历</a>
						</li>
						</s:if>
						<s:else>
						<li>
							<a href="qy_getEnterpriseById.action?enterprise.QId=${session.enterprise.QId}&option=updata" rel="nofollow" class="validate">我的职位</a>
						</li>
						</s:else>
						<li>
							<a href="http://localhost:8088/MTCampus/job/add.jsp" rel="nofollow" class="validate">发布职位</a>
						</li>
						<li>
							<a href="javascript:if(confirm('" target="_blank">加油站</a>
						</li>
					</ul>
					<ul class="loginTop">

						<li style="border-right: 1px dashed #fff;">
						
							
					 <s:if test="#session.students.UName!=null">
					 	<a href="stu_getStudentById.action?student.UId=${session.students.UId}&option=update" class="login" rel="nofollow">
							${session.students.UName}					
						</a>
					</s:if>
					 <s:elseif  test="#session.enterprise.QName!=null">
					 	<a href="qy_getEnterpriseById.action?enterprise.QId=${session.enterprise.QId}&option=updata" class="login" rel="nofollow">
							${session.enterprise.QName}					
						</a>
					</s:elseif >
 						<s:else>
 						<a class="login" rel="nofollow">
							登录				
						</a></s:else>
</p>	
						
						</li>
						<li style="border-right: 1px dashed #fff;">
							<a class="register" rel="nofollow">注册</a>
						</li>
						<li>
							<a id="freesession" class="" rel="nofollow">退出</a>
						</li>
					</ul>
				</div>
			</div>
			<div id="content_box">
				<div class="slide" id="hero">
					<div class="prev">
						<div>
							<a class="slide-prev" href="javascript:;"><i></i>
							</a>
						</div>
					</div>
					<div class="next">
						<div>
							<a class="slide-next" href="javascript:;"><i></i>
							</a>
						</div>
					</div>
					<div class="slide-btn-box">
						<span class="slide-btn on" num="1"></span>
						<span class="slide-btn " num="2"></span>
						<span class="slide-btn " num="3"></span>
						<span class="slide-btn " num="4"></span>
						<span class="slide-btn " num="5"></span>
						<span class="slide-btn " num="6"></span>
						<span class="slide-btn " num="7"></span>

					</div>
					<div class="slide-content" data-timer="5000">

						<div class="slide-item  visible" data-id="41">
							<div class="slide-image" data-location="1">
								 <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/Fr_PELKAJUOCNmhAm6qacCnXINNn.png); background-size: cover;"
									class="sl-img current first"></b> </a>
							</div>
						</div>
						<div class="slide-item  " data-id="40">
							<div class="slide-image" data-location="2">
								<a href=""
									target="_blank"> <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/FjL5NuwBWrMesnp4cK1XoMoGh_gG.png); background-size: cover;"
									class="sl-img current first"></b>
									 </a>
							</div>
						</div>
						<div class="slide-item  " data-id="39">
							<div class="slide-image" data-location="3">
								 <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/Fs8uXmIpcs8Hc27hvUPZPb3rNMy2.png); background-size: cover;"
									class="sl-img current first"></b> 
							</div>
						</div>
						<div class="slide-item  " data-id="35">
							<div class="slide-image" data-location="4">
								 <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/FtYLIHm1ll3KQQ0OiMsQBsBJPnsp.png); background-size: cover;"
									class="sl-img current first"></b> 
							</div>
						</div>
						<div class="slide-item  " data-id="3">
							<div class="slide-image" data-location="5">
								 <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-08/Fk-gtTEppUAlC4IcsdxhhzAmya3j.png); background-size: cover;"
									class="sl-img current first"></b> 
							</div>
						</div>
						<div class="slide-item  " data-id="37">
							<div class="slide-image" data-location="6">
								 <b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/FgwyRZweTegkJktfy234qNJQF007.jpg); background-size: cover;"
									class="sl-img current first"></b> 
							</div>
						</div>
						<div class="slide-item  " data-id="38">
							<div class="slide-image" data-location="7">
								<b
									style="background-image: url(http://7xkvp5.com2.z0.glb.qiniucdn.com/2015-10/FhzLNIP9PVEwxeJUfkabwfv0yv2l.png); background-size: cover;"
									class="sl-img current first"></b> 
							</div>
						</div>

					</div>
					<div id="first_search_box" class="my_search_box">

						<div id="search_box">
							<form id="searchForm1" name="searchForm" action="">
								<input type="text" id="search_input" tabindex="1" value=""
									placeholder="请输入期望的 实习岗位 或 公司名 或 城市" />

								<input type="button" id="search_button" value="搜 索 实 习" />
								<div id="searchtxt"></div>
							</form>
						</div>

					</div>
				</div>
				<!--    热门实习、最新实习生信息-->
				<div id="content_box">
					<div id="container">
						<div class="bline_search">
							<div id="search1" class="refineNavOn">
								公司性质
							</div>
							<div id="xz" class="refineMenu">
								<ul>
									<li>
										<a>外资</a>
									</li>
									<li>
										<a>合资</a>
									</li>
									<li>
										<a>国企</a>
									</li>
									<li>
										<a>民营公司</a>
									</li>
									<li>
										<a>上市公司</a>
									</li>
									<li>
										<a>创业公司</a>
									</li>
									<li>
										<a>政府机关</a>
									</li>
									<li>
										<a>事业单位</a>
									</li>
									<li>
										<a>非营利机构</a>
									</li>
								</ul>
							</div>
							<div id="search2" class="refineNavOn">
								月薪范围
							</div>
							<div id="yx" class="refineMenu">
								<ul>
									<li>
										<a>0-1500</a>
									</li>
									<li>
										<a>1500-1999</a>
									</li>
									<li>
										<a>2000-2999</a>
									</li>
									<li>
										<a>3000-4499</a>
									</li>
									<li>
										<a>4500-5999</a>
									</li>
									<li>
										<a>6000-7999</a>
									</li>
									<li>
										<a>8000-9999</a>
									</li>
									<li>
										<a>10000-9999999</a>
									</li>
								</ul>
							</div>
							<div id="search3" class="refineNavOn">
								公司人数
							</div>
							<div id="gm" class="refineMenu">
								<ul>
									<li>
										<a>0-50</a>
									</li>
									<li>
										<a>50-150</a>
									</li>
									<li>
										<a>150-500</a>
									</li>
									<li>
										<a>500-1000</a>
									</li>
									<li>
										<a>1000-5000</a>
									</li>
									<li>
										<a>5000-10000</a>
									</li>
									<li>
										<a>10000-999999</a>
									</li>
								</ul>
							</div>
							<div id="search4" class="refineNavOn">
								学历要求
							</div>
							<div id="xl" class="refineMenu">
								<ul name="">
									<li>
										<a>初中及以下</a>
									</li>
									<li>
										<a>高中</a>
									</li>
									<li>
										<a>中专</a>
									</li>
									<li>
										<a>大专</a>
									</li>
									<li>
										<a>本科</a>
									</li>
									<li>
										<a>硕士</a>
									</li>
									<li>
										<a>博士</a>
									</li>
								</ul>
							</div>
						</div>
						<div class="content">

							<div class="tab">

								<ul id="serchjob" class="hot_pos reset">
								
								</ul>
								<div id='page_navigation' align="center"></div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<link rel="stylesheet" type="text/css" href="css/icon1.css"
			tppabs="http://www.shixiseng.com/css/icon1.css" />
		<script type="text/javascript" src="js/assets/Chart.min.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/assets/Chart.min.js?v=2.2.7"></script>
		<script type="text/javascript" src="js/home.min.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/home.min.js?v=2.2.7"></script>
		<script type="text/javascript" src="js/jquery.mousewheel.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/jquery.mousewheel.js?v=2.2.7"></script>
		<script>
    //快速滑动大图
    var isAnimate = false;
    $("html,body").bind("mousewheel",function(e){
        var container_scrollTop = $("#main_content").offset().top-95;
        var current_scrollTop = $(document).scrollTop();
        e.preventDefault();
        if(!isAnimate)
        {
            var body = $("html,body");
            if(e.deltaY > 0)
            {//向上滚 在顶部
                if(current_scrollTop < container_scrollTop){
                    isAnimate = true;
                    body.animate({scrollTop: 0}, 500,"swing",callbackbody);
                    $("#second_search_box").fadeOut(800);
                    $("#second_search_box").removeClass("current");
                    $("#first_search_box").addClass("current");
                }
                else
                {
                    body.scrollTop(current_scrollTop-50);
                }
            }else if(e.deltaY < 0){//向下滚 在顶部
                if(current_scrollTop < (container_scrollTop-2)){
                    isAnimate = true;
                    body.animate({scrollTop:container_scrollTop}, 500,"swing",callbackbody);
                    $("#first_search_box").fadeOut(800);
                    $("#first_search_box").removeClass("current");
                    $("#second_search_box").addClass("current");
                }
                else{
                    body.scrollTop(current_scrollTop+50);
                }
            }
        }
    });
    function callbackbody()
    {
        isAnimate = false;
        $(".my_search_box.current").fadeIn(800);
    }
</script>
		<!--    大图滑动-->
		<script type="text/javascript">
$(function() {
        //"slide": next buttom click
        $(".slide-next").click(function(){
            var target = $(".slide-content");
            var now = target.children(".visible");
            var next = now.next();
            var nowBtn = target.prev().children(".on");
            var nextBtn = nowBtn.next();
            if (next.length === 0) {
                next = now.siblings().first();
            }
            if(nextBtn.length === 0){
                nextBtn = nowBtn.siblings().first();
            }
            myswitch(now,next,nowBtn,nextBtn);
        });

        //"slide": prev buttom click
        $(".slide-prev").click(function(){
            var target = $(".slide-content");
            var now = target.children(".visible");
            var prev = now.prev();
            var nowBtn = target.prev().children(".on");
            var prevBtn = nowBtn.prev();
            if (prev.length === 0) {
                prev = now.siblings().last();
            }
            if(prevBtn.length === 0){
                prevBtn = nowBtn.siblings().last();
            }
            myswitch(now,prev,nowBtn,prevBtn);
        });
        var move;
        $(".slide-content").each(function(){
            var len = $(this).data("timer");
            var target = $(this);
            //"slide": auto-switch
            move = setInterval(function(){
                var now = target.children(".visible");
                var next = now.next();
                var nowBtn = target.prev().children(".on");
                var nextBtn = nowBtn.next();
                if (next.length === 0) {
                    next = now.siblings().first();
                }
                if(nextBtn.length === 0){
                    nextBtn = nowBtn.siblings().first();
                }
                myswitch(now,next,nowBtn,nextBtn);
            }, len);
        });
    //鼠标移入时停止更换图片
        $("#hero").on("mouseover",function(){
            clearInterval(move);
        });
    $("#hero").on("mouseout",function(){
        var
            target = $(".slide-content"),
            len = target.data("timer");
        //"slide": auto-switch
        move = setInterval(function(){
            var now = target.children(".visible");
            var next = now.next();
            var nowBtn = target.prev().children(".on");
            var nextBtn = nowBtn.next();
            if (next.length === 0) {
                next = now.siblings().first();
            }
            if(nextBtn.length === 0){
                nextBtn = nowBtn.siblings().first();
            }
            myswitch(now,next,nowBtn,nextBtn);
        }, len);
    });
    });
    function myswitch(now,next,nowBtn,nextBtn){
        now.stop(true,true).fadeOut(500);
        now.removeClass("visible");
        nowBtn.removeClass("on");
        next.stop(true,true).fadeIn(500);
        next.addClass("visible");
        nextBtn.addClass("on");
    }
    //点击按钮滑动大图
    $(".slide-btn").on("mouseover",function(){
        var nowNum = $(this).attr("num") - 1;

        var now = $(".slide-content").children(".visible");

        var next = $(".slide-content").children().eq(nowNum);

        var nowBtn = $(this).parent().children(".on");

        var nextBtn = $(this);


        myswitch(now,next,nowBtn,nextBtn);
    });

    //统计banner图点击量
    $(".slide-item").on('click',function(){
        var id = $(this).attr('data-id');
        $.get('http://www.shixiseng.com/index/countslider.html',{id:id});
    });
</script>
		<a id="backtop" title="回到顶部" rel="nofollow" class="dn"></a>
		<!--反馈留言-->
		<div id="feedback">
			<div class="feedback-icon" title="我要反馈"></div>
			<span style="font-size: 12px; margin: 0px">我要反馈</span>
		</div>
		<div id="feedback-con">
			<div class="pfb-pho-close">
				<div class="pfb-pho"></div>
				<div class="pfb-close"></div>
			</div>
			<form id="product-fb">
				<div class="pfb-txt">
					<textarea placeholder="一起来吐槽，把你遇到的问题，或是想要的功能告诉我吧（300字以内）"
						maxlength="300"></textarea>
				</div>
				<div class="pfb-email" style="height: 60px;">
					<input type="text" class="e-box" placeholder="留下邮箱方便我们沟通（必填）"
						class="" />
					<span class="ensure">确定</span>
				</div>
			</form>
		</div>
		<em class="tip"><span>你还没填任何反馈呢</span><i class="txt"></i>
		</em>
		<!--反馈留言结束-->
		<div class="clear" ></div>
		</div>
		<script type="text/javascript" src="js/index/intern_feedback.js"
			tppabs="http://www.shixiseng.com/js/index/intern_feedback.js"></script>
		</div>
		<div id="footer">
			<div style="padding-top: 80px; width: 1024px; margin: 0 auto;">
				<div style="">
					<p>
						领先的实习生招聘网站 &copy;Copyright 2015 实习僧
						<a href="Mailto:me@shixiseng.com">联系我们:me@shixiseng.com</a>
					</p>
				</div>
				<div class="social" style="float: none;">
					<a
						href="javascript:if(confirm('http://weibo.com/345952499  \n\n���ļ�δ�� Teleport Pro ���أ���Ϊ ��λ����ʼ��ַ�����õı߽���������·���С�  \n\n����Ҫ�ӷ�����������?'))window.location='http://weibo.com/345952499'"
						tppabs="http://weibo.com/345952499" target="_blank" class="left"><img
							src="images/weibo.png"
							tppabs="http://www.shixiseng.com/images/weibo.png" alt="实习僧微博">
					</a>
					<a href="javascript:;" class="right"> <img
							src="images/weixin.png"
							tppabs="http://www.shixiseng.com/images/weixin.png" alt="实习僧微信">
						<i></i> </a>
				</div>
			</div>
		</div>
		<div id="cboxOverlay" style="display: none;"></div>
		<!--                    登录注册-->

		<!--登录-->
		<div class="div_login login_boxX">
			<div id="login_header">
				<a href="
"> <img
						src="images/default/logo_findpassword.png" width="144" height="44"
						style="border: none;"> </a>
				<span class="close_login">×</span>
			</div>
			<!-- content begin lym-->
			<div class="login_wrapper">
				<div class="login_box" style="cursor: default;">
					<form id="headerLoginForm">
						<input type="text" id="email" name="email" tabindex="1"
							placeholder="邮箱/用户名">
						<span class="error" style="display: none;" id="beError"></span>
						<input type="password" id="password" name="password" tabindex="2"
							placeholder="密码">
						<label class="fl" for="remember" style="cursor: pointer;">
							<input type="checkbox" id="remember" name="remember" value="1"
								checked="checked" class="checkbox valid">
							记住我 &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="javascript:if(confirm(''))window.location=''"
								style="color: #777;">忘记密码？</a>
						</label>
						<div class="clear"></div>
						<input type="submit" id="submitLogin" value="登 录">
						<div style="float: left; line-height: 30px; padding-left: 5px;">
							<select id="usertype">
								<option value="identity">
									选择您的身份
								</option>
								<option value="stu">
									实习生
								</option>
								<option value="enp">
									企业用户
								</option>
							</select>
							<a class="to_login">快速注册</a>
						</div>
						<div class="clear"></div>
						<span id="ajaxError" style="display: none;"></span>
						<div class="clear"></div>
						<div id="social_login_div">
							<div style="padding-left: 80px;">
								使用以下帐号直接登录
							</div>
							<div style="padding-left: 20px; width: 400px;">
								<a
									href="javascript:if(confirm(''))window.location='https://api.weibo.com/oauth2/authorize?client_id=976310381&redirect_uri=http%3A%2F%2Fwww.shixiseng.com%2Fuser%2Fweibologinact.html&response_type=code'"
									tppabs="https://api.weibo.com/oauth2/authorize?client_id=976310381&redirect_uri=http%3A%2F%2Fwww.shixiseng.com%2Fuser%2Fweibologinact.html&response_type=code"
									class="icon_wb" title="使用新浪微博帐号登录"></a>
								<a href="javascript:if(confirm(''" class="icon_qq"
									title="使用腾讯QQ帐号登录"></a>
								<a href="javascript:if(confirm(''))window.location=''"
									class="icon_weixin" title="使用微信帐号登录"></a>
								<div class="clear"></div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--注册-->
	<form id="registerForm"  action="1.jsp" method="post">
		<div class="div_login reg_boxX">
			<div id="login_header">				
				<span class="close_login close_reg">×</span>
			</div>
			<div class="register_wrapper">
				<div class="login_box">
						<div class="div_left">
							<div class="register_radio">
								<div id="student_type" class="user_type_li blur" title="找实习"></div>
								<div class="user_type_tips_li"
									onclick="$('.register_radio #student_type').click();">
									找实习
								</div>
							</div>
							<div class="register_radio">
								<div id="corporation_type" class="user_type_li blur" title="招实习"></div>
								<div class="user_type_tips_li"
									onclick="$('.register_radio #corporation_type').click();">
									招实习
								</div>
							</div>
							<input type="hidden" value="" name="type">
						</div>
						
						<div class="div_right">
							<input type="text" id="Regemail" class="email1" name="email" tabindex="1"
								placeholder="请输入常用邮箱地址">
							<span class="error dn" id="beError"></span>
							<input type="text" id="Regemail" class="name1" name="name" tabindex="1"
								placeholder="姓名">
								<span id="ajaxregnameError"></span>
							<input type="password" class="checkpwd" id="Regpassword" name="password"
								tabindex="2" placeholder="请输入密码">
							<input type="password"  id="Regpassword" name="password1"
								tabindex="2" placeholder="请确认密码">
							<input type="text" id="Regemail" name="phone" tabindex="1"
							  class="phone1"	placeholder="请输入电话号码">
							<input type="text" class="Wdate" readonly id="Regemail"
								tabindex="1" placeholder="出生日期" onClick="WdatePicker()">

							<span class="error dn" id="beError"></span>

							<input type="submit" id="submitReg"  value="快速注册">
							
							<div class="has_account">
								已有帐号？
								<a class="to_login">登录</a>
							</div>
							<div class="clear"></div>
							<span id="ajaxregError"></span>
							<div id="social_login_div">
								<div style="padding-left: 55px;">
									使用以下帐号直接登录:
								</div>
								<a
									href="javascript:if(confirm('https://api.weibo.com/oauth2/authorize?client_id=976310381&redirect_uri=http%3A%2F%2Fwww.shixiseng.com%2Fuser%2Fweibologinact.html&response_type=code  \n\n���ļ�δ�� Teleport Pro ���أ���Ϊ ��һ��ʹ��δ֧��Э��ĵ�ַ(����: gopher)��  \n\n����Ҫ�ӷ�����������?'))window.location='https://api.weibo.com/oauth2/authorize?client_id=976310381&redirect_uri=http%3A%2F%2Fwww.shixiseng.com%2Fuser%2Fweibologinact.html&response_type=code'"
									tppabs="https://api.weibo.com/oauth2/authorize?client_id=976310381&redirect_uri=http%3A%2F%2Fwww.shixiseng.com%2Fuser%2Fweibologinact.html&response_type=code"
									class="icon_wb" title="使用新浪微博帐号登录"></a>
								<a
									href="javascript:if(confirm('http://www.shixiseng.com/user/qqlogin.html  \n\n���ļ�δ�� Teleport Pro ���أ���Ϊ ���ļ������û������ѱ���ֹ����ù����ѱ�ֹͣ��  \n\n����Ҫ�ӷ�����������?'))window.location='http://www.shixiseng.com/user/qqlogin.html'"
									tppabs="http://www.shixiseng.com/user/qqlogin.html"
									class="icon_qq" title="使用腾讯QQ帐号登录"></a>
								<a
									href="javascript:if(confirm('http://www.shixiseng.com/user/weixinlogin.html  \n\n���ļ�δ�� Teleport Pro ���أ���Ϊ ���ļ������û������ѱ���ֹ����ù����ѱ�ֹͣ��  \n\n����Ҫ�ӷ�����������?'))window.location='http://www.shixiseng.com/user/weixinlogin.html'"
									tppabs="http://www.shixiseng.com/user/weixinlogin.html"
									class="icon_weixin" title="使用微信帐号登录"></a>
							</div>
						</div>
					</form>
					</div>
				</div>
			
		
</div>

		<script type="text/javascript">
		var option="login";
        $(function(){
            //验证表单
            $("#headerLoginForm").validate({
                onkeyup: false,
                rules: {
                    email: {
                        required: true
                    },
                    password: {
                        required: true,
                        rangelength: [5,18]
                    }
                   
                },
                messages: {
                    email: {
                        required: "请输入登录邮箱/用户名"
                    },
                    password: {
                        required: "请输入密码",
                        rangelength: "请输入5-16位密码"
                    }
                   
                },
                errorPlacement:function(label, element){
                    label.insertAfter(element);
                },
                submitHandler:function(form){
                    if($('#remember').prop("checked")){
                        $('#remember').val(1);
                    }else{
                        $('#remember').val(0);
                    }
                    var email =$('#headerLoginForm #email').val();;
                    var password = $('#headerLoginForm #password').val();
                    var usertype = $('#usertype').val();
                    var remember = $('input[name=remember]').val();
                    var referurl = $('input[name=referurl]').val();
                   	if(usertype=='identity'){
                       	alert("请选择您的身份");
                       	}else if(usertype=='stu'){
                    $.ajax({
                        type:'POST',
                        data: {'email':email,'password':password,'option':option},
                        url:'stu_stuLogin',
                        dataType:'text'
                    }).done(function(result) {
                        if(result==0){
                            location.reload();
                        }else{
                            $("#ajaxError").empty().text("帐号或密码错误").show();
                        }
                        $("#submitLogin").attr("disabled", false).attr("value", "登 录");
                    });
                       	}else if(usertype=='enp'){                 
                        	$.ajax({
                                type:'POST',
                                data: {'email':email,'password':password,'option':option},
                                url:'qy_enpLogin',
                                dataType:'text'
                            }).done(function(result) {
                            	 if(result==0){
                                     location.reload();
                                 }else{
                                     $("#ajaxError").empty().text("帐号或密码错误").show();
                                 }
                                 $("#submitLogin").attr("disabled", false).attr("value", "登 录");
                            });
                            }
                }
            });
            $("#freesession").click(function(){
				option="freesession";
				$.ajax({
					type:'POST',
                    data: {'email':null,'password':null,'option':option},
                    url:'stu_stuLogin',
                    dataType:'text',
                    success: function (data){
                    	location.reload();
                    	} 
					});
                });
            
        });
        //设置登录注册的显示隐藏等
        $(".div_login").css("z-index","105");
        $("#password,#email,#validcode,#Regemail,#Regpassword").css("border","1px solid #ccc").on("focus",function(){
            $(this).css("border","1px solid #00A9E0");
        }).on("blur",function(){
            $(this).css("border","1px solid #ccc");
        });
        //右上角关闭按钮
        $(".close_login").css({
            display:"inline-block",
            fontSize:"35px",
            color:"#fff",
            paddingTop:"5px",
            cursor:"pointer",
            float:"right"
        }).on("click",function(e){
            $(".div_login").hide();
            $(".shade").remove();
        });
//        弹出登录注册和遮罩
        $(".login_boxX").css({
            "left":"50%",
            "marginLeft":"-200px"
        });
        $(".close_reg").css("margin-right","-170px");
        $(".login").on("click",function(){
            $(".login_boxX").after("<div class=\"shade\" style=\"width: 100%;height: 100%;position: fixed;top:0;left:0;z-index:104;background: #000;opacity: .7\"></div>");
            $(".login_boxX").show();
        });
        $(".register").on("click",function(){
            $(".reg_boxX").after("<div class=\"shade\" style=\"width: 100%;height: 100%;position: fixed;top:0;left:0;z-index:104;background: #000;opacity: .7\"></div>");
            $(".reg_boxX").show();
        });
        //登录注册之间的跳转
        $(".to_login").on("click",function(){
             $(".reg_boxX").toggle();
            $(".login_boxX").toggle();
        });
    </script>
		<script type="text/javascript">
        $(function(){
            $('.register_radio #student_type').click(function(){
       		 $("#regid").remove();         
       		 $("#USex1").remove(); 
       		$(".add").remove();        
                $('.register_radio #corporation_type').removeClass("current").addClass("blur");
                $('.register_radio #student_type').removeClass("blur").addClass("current");              
                $("input[name='type']").val("0");
                $.ajax({
				url:'stu_getStudentMaxId',
				type:'post',
				dataType:'text',
				success: function (data){
				  
				$(".div_right").append(
					"<input type='hidden' id='regid' name='UId' value="+data+"/>"
				);
				$(".name1").after(
					"&nbsp;&nbsp;&nbsp;<input type='radio' id='USex1' name='USex' value='0'>男</input>"+
					"<input type='radio' id='USex1' name='USex' value='1'>女</input>"
				);
				
			}
            });
                $("#registerForm").attr("action","stu_addStu");                
				$(".email1").attr("name","UEmail");
				$(".name1").attr("name","UName");
				$(".name1").attr("placeholder","姓名");
				$(".phone1").attr("name","UPhone");
				$(".Wdate").attr("name","UBirthday");
				$(".Wdate").attr("placeholder","出生日期");
				$(".checkpwd").attr("name","UPwd");
			
				
                
            });
            $('.register_radio #corporation_type').click(function(){
               $("#regid").remove();
               $("#USex1").remove(); 
               $(".add").remove(); 
                $('.register_radio #student_type').removeClass("current").addClass("blur");
                $('.register_radio #corporation_type').removeClass("blur").addClass("current");
                $("input[name='type']").val("1");
                  $.ajax({
				url:'qy_getEnterpriseMaxId',
				type:'post',
				dataType:'text',
				success: function (data){
				$(".div_right").append(
					"<input type='hidden' id='regid' name='QId' value="+data+"/>"
				);
			$(".add").css("border","solid 1px");
				
			}
            });
                  $("#registerForm").attr("action","qy_addEnterprise");                
    				$(".email1").attr("name","QEmail");
    				$(".name1").attr("name","QName");
    				$(".name1").attr("placeholder","公司名称");
    				$(".phone1").attr("name","QPhone");
    				$(".Wdate").attr("name","QDate");
    				$(".Wdate").attr("placeholder","注册时间");
    				$(".checkpwd").attr("name","QPwd");
            });
           
            //验证表单
            $("#registerForm").validate({
                "onkeyup":false,
                rules: {
                    type:{
                        required: true
                    },
                    email: {
                        required: true,
                 
                    },
                    name: {
                        required: true,
                 
                    },
                    password: {
                        required: true,
                        rangelength: [5,18]
                    },
                    password1: {
                         required: true,
                        rangelength: [5,18],
                        equalTo:".checkpwd"                     
                    }
                },
                messages: {
                    type:{
                        required:"找还是招呢?"
                    },
                    email: {
                        required: "请输入常用邮箱地址",
             
                    },
                    name: {
                        required: "用户名不能为空",
             
                    },
                    password: {
                        required: "请输入密码",
                        rangelength: "请输入6-16位密码，字母区分大小写"
                    },
                    password1: {
                        required: "请确认密码",
                        rangelength: "请再次输入密码",
                      	  equalTo:"两次密码不一致"
                    }
                   
                },
                errorPlacement:function(label, element){
                    if(element.attr("type") == "hidden"){
                        label.insertBefore(element);
                    }else if(element.attr("type") == "checkbox"){
                        label.insertAfter($(element).parent()).css('clear','left');
                    }else{
                        label.insertAfter(element);
                    }
                },
                focusInvalid:true,  
                submitHandler:function(form){
                	form.submit();
                }
            });
        });
      
     
        $(".email1,.name1").blur(function(){
        	var name=$("input[name='name']").val();
        	var email=$(".email1").val();
        	$.ajax({
                type:'post',
                url:'stu_stuReg',
                data:{'name':name,'email':email},
                dataType:'text',
                success:function(data){                  
					if(data==1){
                    $(".name1").val("");
                	$("#ajaxregnameError").text("用户名或邮箱已存在");
                    $("#ajaxregnameError").show();
					}
                    }
          	});
        	
            });
    </script>
		<!-- content end lym-->
		<script type="text/javascript" src="js/core.min.js-v=2.2.7"
			tppabs="http://www.shixiseng.com/js/core.min.js?v=2.2.7"></script>


		<script type="text/javascript">
        var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
        document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Faedd3972ca50f4fd67b4d7e025fa000c' type='text/javascript'%3E%3C/script%3E"));
    </script>


	</body>
	<script type="text/javascript" src="js/core.js-v=2.2.7"
		tppabs="http://www.shixiseng.com/js/core.js?v=2.2.7"></script>
	<script type="text/javascript" src="js/popup.min.js-v=2.2.7"
		tppabs="http://www.shixiseng.com/js/popup.min.js?v=2.2.7"></script>
	<script>
	//首页导航广告
	//add by whitney(2015.7.10)
	//    if($.cookie('is_close')){
	//        $('#ad').hide();
	//        $('#header').css({
	//            position:"fixed",
	//            boxShadow:"0 0 0 0",
	//            top:0
	//        });
	//    }
	window.onscroll = function() {
		var t = document.documentElement.scrollTop || document.body.scrollTop;
		if (t > 60) {
			$('#header').css( {
				borderBottom : "1px solid #ccc",
				boxShadow : "0 0 6px 0 #ccc"
			});
		} else {
			$('#header').css( {
				boxShadow : "0 0 0 0",
				borderBottom : "0"
			});
		}
	};

	//登录验证
	$(".validate")
			.on(
					'click',
					function() {
						var is_guest = 1;
						if (is_guest == 0) {
							var text = $(this).text();
							if (text == '我的简历')
								window.location.href = "http://www.shixiseng.com/internuser/resumemanage.html";
							else if (text == '投递反馈')
								window.location.href = "http://www.shixiseng.com/internuser/delivery.html";
							else if (text == '发布实习')
								window.location.href = "http://www.shixiseng.com/company/createjob.html";
							else if (text == '简历管理')
								window.location.href = "http://www.shixiseng.com/company/pendresume.html";
							else if (text == 'HR中心')
								window.location.href = "http://www.shixiseng.com/company/center.html";
						} else {
							$(".login_boxX")
									.after(
											"<div class=\"shade\" style=\"width: 100%;height: 100%;position: fixed;top:0;left:0;z-index:104;background: #000;opacity: .7\">__tag_1035$162_");
							$(".login_boxX").show();
						}
</script>
</html>