<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@taglib prefix="page" uri="/WEB-INF/paging.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="http://open.weibo.com/wb" lang="zh-CN">
	<head>

		<title>实习僧-实习生-最靠谱的实习生招聘网站</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="description"
			content="实习僧是国内领先的实习生招聘网站,500强名企实习,靠谱实习机会,优质实习信息,优秀实习生,找实习就上实习僧,实习生招聘首选实习僧。">
		<meta name="keywords" content="实习,实习生,找实习,实习生招聘,暑期实习,实习僧">
		<meta name="Robots" content="all">
		<meta property="qc:admins" content="2040752403463010135676375" />
		<meta name="baidu-site-verification" content="EP5drAzZgp" />
		<link rel="icon"
			href="${pageContext.request.contextPath}/images/favicon.ico"
			type="image/x-icon" />
		<link rel="Shortcut Icon"
			href="${pageContext.request.contextPath}/images/favicon.ico"
			type="image/x-icon">
		<link rel="stylesheet"
			href='${pageContext.request.contextPath}/css/style.css' />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/spinner.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/register_index.css" />

		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/css/trainee_center.css" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/upload.js"></script>
			 <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	$("document").ready(function (){
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
     </script>
		<script language="javascript" type="text/javascript"
			src="My97DatePicker/WdatePicker.js"></script>
		<script>
	var _hmt = _hmt || [];
	(function() {
		var hm = document.createElement("script");
		hm.src = "//hm.baidu.com/hm.js?aedd3972ca50f4fd67b4d7e025fa000c";
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(hm, s);
	})();
</script>
	</head>
	<body>

		<s:action name="qy_getEnterpriseById" executeResult="false">
			<s:param name="enterprise.QId">${session.enterprise.QId}</s:param>
			<s:param name="option">updata</s:param>
		</s:action>
		<s:action name="job_getAllJob" executeResult="false" />
		<div id="header_box">
			<div id="header">
				<div id="header_content">
					<a href="index.jsp" class="home_logo">
						<h1>
							实习僧
						</h1> </a>
					<ul id="item_box">

						<li>
							<a href="index.jsp" class="header_href">首页</a>
						</li>
						<li class="active">
							<a href="qy_getEnterpriseById.action?enterprise.QId=<s:property value="enterprise.QId"/>&option=updata"  class="header_href">个人中心</a>
						</li>
						<li>
							<a href="/topic" target="_blank" class="header_href">活动</a>
						</li>
						<li>
							<a href="" target="_blank"
								class="header_href">加油站</a>
						</li>

					</ul>
					<!--未登录-->

					<!--已经登录 企业用户-->
					<dl id="log_user">
						<dt id="user_name">
						<s:property value="#request.enterprise.QName"/>
							<span class="redstar"></span>
						</dt>


						<dd class="user_nav">
							<a href="qy_getEnterpriseById.action?enterprise.QId=<s:property value="enterprise.QId"/>&option=updata">个人中心<span class="redstar"></span>
							</a>
						</dd>
						<dd class="user_nav">
							<a href=""   id="freesession"  class="exit">退出</a>
						</dd>
					</dl>

				</div>
			</div>
		</div>
		<div id="container">

			<!--<div id="shade"></div>-->
			<div class="box">
				<div class="resume_box">
					<div class="base_inf">

						<!--  
 头像：<img id="headimg" src="upload/<s:property value="student.UTouxiang"/>"/>
   <s:form id="uploadForm" action="upload_exec" method="post" enctype="multipart/form-data">
    <input id= "file" type="file" name="myFile">
	<input id="uploadBtn" type="button" value="修改头像" />
   </s:form>  
   -->
						<center>
							<s:form action="qy_update">
    编号:<s:property value="enterprise.QId" />
								<br />
								<strong><s:textfield name="enterprise.QName" label="名称" />
								</strong>
								<s:textfield name="enterprise.QPwd" label="密码" />
								<s:textfield name="enterprise.QXingzhi" label="薪资" />
								<s:textfield name="enterprise.QGuimo" label="规模" />
								<s:textfield name="enterprise.QArea" label="地区" />
								<s:textfield name="enterprise.QYoubian" label="邮编" />
								<s:textfield name="enterprise.QEmail" label="邮箱" />
								<s:textfield name="enterprise.QMiaoshu" label="描述" />
注册日期：<input name="enterprise.QDate"
									value="<s:property value="enterprise.QDate"/>" type="text"
									class="Wdate" readonly id="Regemail" tabindex="1"
									onClick=
	WdatePicker();
>

								<s:if test="#session.enterprise.QName==null">
									<s:submit value="修改"></s:submit>
								</s:if>
						</center>
						</s:form>




					</div>
					<div class="res_load_box">
						<div class="load_con">

							<div class="resume">


							</div>

						</div>
					</div>


				</div>
			</div>
			<!----------------------添加简历 add by whitney------------------------->
			<div id="addResume" class="popup">
				<div class="popup_head">
					请选择简历类型
				</div>
				<div class="popup_close">
					×
				</div>
				<div class="popup_main">
					<div class="btn_box">
						<a class="resume_resume_btn fl">在线简历</a>
						<a class="resume_resume_btn fr">附件简历</a>
					</div>
					<p class="tips">
						你最多只能拥有 2 个简历哦
					</p>
				</div>
			</div>
			<!---------------------添加简历 结束---------------------------------->
			<!-------------------------是否参加面试------------------------------->
			<div class="join_interview">
				<div class="title">
					<p>
						是否参加面试
					</p>
					<img class="close_interview"
						src="/static/img/close.png?v=43ca279e203e75e1d574a03a9acb5e42"
						alt="" />
				</div>
				<input type="hidden" class="guid_join" value="" />
				<div class="option">
					<form>
						<input type="radio" name="interview" id="punctual" value="normal" />
						<label for="punctual">
							准时参加
						</label>
						<input type="radio" name="interview" id="delay" value="delay" />
						<label for="delay">
							延时参加
						</label>
						<input type="radio" name="interview" id="abandon" value="reject" />
						<label for="abandon">
							放弃面试
						</label>
					</form>
				</div>
				<div class="supplement">
					<p>
						补充内容：
					</p>
					<textarea class="add_content" name="content"></textarea>
				</div>
				<div class="btn">
					<span class="join_int_go">确定</span>
					<span class="join_int_no">取消</span>
				</div>
			</div>
			<!------------------------------对话HR-------------------------------->
			<div class="dialogue_hr"></div>
			<!-----------------------------面试体验-------------------------------->
			<!--面试体验弹窗开始-->
			<div id="noticeRecord" class="popup">
				<div class="popup_head">
					面试体验
				</div>
				<div class="popup_close">
					×
				</div>
				<div class="popup_main">
					<form action="" id="noticeRecordForm">
						<ul class="interview_result">
							<li>
								<input name="stype" id="cope_off" type="radio" value="1" />
								<label for="cope_off">
									已收到offer
								</label>
							</li>
							<li>
								<input name="stype" id="not_off" type="radio" value="0" />
								<label for="not_off">
									未收到offer
								</label>
							</li>
						</ul>
						<table class="recort_content">
							<tr>
								<td width="80">
									面试评分：
								</td>
								<td>
									<input type="hidden" name="score" value="0" />
									<ul class="star_list">
										<li data-v="1"></li>
										<li data-v="2"></li>
										<li data-v="3"></li>
										<li data-v="4"></li>
										<li data-v="5"></li>
									</ul>
								</td>
							</tr>
							<tr>
								<td width="80">
									面试短评：
								</td>
								<td class="short_box">
									<input id="shortevalu" type="text" name="short_evaluate"
										class="borderbox shortdesc" maxlength="15"
										placeholder="15字以内对面试的简单描述哦">
									<ul class="short_down">
										<li>
											面试官很nice
										</li>
										<li>
											公司环境不错
										</li>
										<li>
											公司妹子很多
										</li>
										<li>
											公司比较垃圾
										</li>
										<li>
											面试官不认真
										</li>
										<li>
											面试流程有问题
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<td width="80" class="eva_con">
									面试经历：
								</td>
								<td>
									<textarea id="evaluate_content" class="borderbox content_box"
										name="cont" placeholder="记录下自己的面试经历"></textarea>
								</td>
							</tr>
							<input type="hidden" name="deliver_id" class="uuid_text">
						</table>
					</form>
					<a href="javascript:;" class="popup_cancel popup_btn">取消</a>
					<a href="javascript:;" class="popup_btn send_popup">发送</a>
				</div>
			</div>
			<!--面试评价弹窗结束-->
			<div class="load_res_de"></div>

			<!--登陆-->
			<div class="reg_log_box login_box_X">
				<div class="log_box">
					<a href="/" class="go_home"></a>
					<span id="close_login" class="close_login">×</span>
					<div class="log_content">
						<div id="login_inf">
							<form>
								<input type="text" id="log_name" class="log_input" tabindex="1"
									placeholder="请输入手机号/邮箱" />
								<span class="error">此用户不存在</span>
								<input type="password" id="log_password" class="log_input"
									tabindex="2" placeholder="请输入密码">
								<span class="error">密码不正确</span>
								<input type="button" id="login_btn" value="登 录">
								<div class="login_jump">
									<p class="not_user">
										没有账号,直接
										<span class="to_login f_col"
											onclick="jumpto('/user/register')">注册</span>
									</p>
									<a href="/user/findpass" class="f_col look_pas">找回密码</a>
								</div>
							</form>
						</div>
						<div class="other_login">
							<p>
								使用以下帐号直接登录:
							</p>
							<div class="other_link">
								<a href="/user/sso/weibo/auth" class="icon_wb"
									title="使用新浪微博帐号登录"></a>
								<a href="/user/sso/qq/auth" class="icon_qq" title="使用腾讯QQ帐号登录"></a>
								<a href="/user/sso/wechat/auth" class="icon_weixin"
									title="使用微信帐号登录"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div id="footer_content">
				<div class="information">
					<p>
						中国领先的实习生招聘网站 &nbsp;&nbsp;&copy;2015 Shixiseng
					</p>
					<a href="http://www.miitbeian.gov.cn/" target="_blank">ICP备13010980号</a>
					<a href="Mailto:me@shixiseng.com" target="_blank">&nbsp;联系我们:me@shixiseng.com</a>
				</div>
				<a href="http://weibo.com/345952499" target="_blank"> <img
						src='../images/sina-icon.png' alt="实习僧微博" /> </a>
				<a id="weixin" href="javascript:;"> <img
						src="../images/weixin.png" alt="实习僧微信" /> </a>
				<img src="../images/weixin_qr.png" width="264" height="264" />
			</div>
		</div>
		<!--反馈，回头部等-->
		<a id="back_top"></a>
		<div id="feedback">
			<div id="feedback_icon" title="我要反馈"></div>
			<span id="i_want_f">我要反馈</span>
		</div>
		<div id="feedback-con">
			<div id="fb-header">
				<div id="fb-ico"></div>
				<p id="fb-close">
					&#xe60a;
				</p>
			</div>
			<form id="fb_present">
				<textarea id="fed_msg" name="fb_msg"
					placeholder="一起来吐槽，把你遇到的问题，或是想要的功能告诉我吧（300字以内）" maxlength="300"></textarea>
				<input type="text" id="fb-email" name="fb_user"
					placeholder="留下邮箱方便我们沟通（必填）">
				<span id="fb_presend">确定</span>
			</form>
		</div>
		<script
			src="${pageContext.request.contextPath}/css/jquery-1.9.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/css/jquery-creatBox.js"></script>
		<script src="${pageContext.request.contextPath}/js/utils.js"></script>
		<script src="${pageContext.request.contextPath}/js/layer.js"></script>
		<script src="${pageContext.request.contextPath}/js/main_base.js"></script>

		<script>
	var item = 'feedback', maxLength = '2';
</script>
		<script src="${pageContext.request.contextPath}/css/upload.js"></script>
		<script
			src='${pageContext.request.contextPath}/css/jquery-creatBox.js'></script>
		<script src="${pageContext.request.contextPath}/js/trainee_center.js"></script>

	</body>
</html>