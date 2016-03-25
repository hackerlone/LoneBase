<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
	<head>
		<title>我的简历</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="renderer" content="webkit">
		<meta name="description"
			content="实习僧是国内领先的实习生招聘网站,500强名企实习,靠谱实习机会,优质实习信息,优秀实习生,找实习就上实习僧,实习生招聘首选实习僧。">
		<meta name="keywords" content="实习,实习生,找实习,实习生招聘,暑期实习,实习僧">
		<meta name="Robots" content="all">
		<meta property="qc:admins" content="2040752403463010135676375" />
		<meta name="baidu-site-verification" content="EP5drAzZgp" />
		<script language="javascript" type="text/javascript"
			src="My97DatePicker/WdatePicker.js"></script>
		<link rel="Shortcut Icon"
			href="${pageContext.request.contextPath}
		/images/favicon (1).ico">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}
		/css/resume_manage.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}
		/css/create_box.css" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}
		/css/lightbox.css" />
		<script src="${pageContext.request.contextPath}
/css/less.js"></script>
		<sx:head parseContent="true" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath}
		/js/jquery-1.4.1.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}
		/js/ajaxfileupload.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}
		/js/upload.js"></script>
		<script type="text/javascript">
	$(document).ready(function() {
		var face = $("#face").val();
 		$("option[name='"+face+"']").attr("selected",true);
 		var xl = $("#xl").val();
 		$("#xl > option[name='"+xl+"']").attr("selected",true);
	});
</script>
	</head>
	<body>
		<s:action name="jz_secvitaforjob" executeResult="false">
			<s:param name="jz.vita.JId">
				<s:property value="vita.JId" />
			</s:param>
			<s:param name="option">secjob</s:param>
		</s:action>
	
	 <s:hidden id="face" name="vita.JFace"></s:hidden>   
		<s:hidden id="xl" name="vita.JXl"></s:hidden>
		<div class="box">
			<div class="nav">
				<a href="stu_getStudentById.action?student.UId=<s:property value="vita.student.UId"/>&option=update">&lt; 个人中心</a>
				<span id="gdata" class="name" data-guuid="grp_qkuphbel9zcz"
					data-ruuid="res_bbecb3vwaekf" data-stype="online">默认简历</span>
				<span class="change_name"></span>
				<ul class="change_lag">

					<li>
						中文简历
					</li>
					
	
					
				</ul>
				<dl>
					<dd class="change_model">
						选择模版
					</dd>
					<dd>
						<a href="/trainee/resume/view/res_bbecb3vwaekf" data-att="1"
							class="no_pos" target="_blank">预览</a>
					</dd>
					<dd>
						<a href="/trainee/resume/down/res_bbecb3vwaekf" data-att="1"
							class="no_pos">下载到本地</a>
					</dd>
				</dl>
			</div>
			有职位 <s:property value="#request.jobss.size"/>份已投递<br />
   <s:iterator value="#request.jobss" var="jobss">		
	<a href="/MTCampus/job_getJobById.action?id=<s:property value="#jobss.job.ZId" />&option=update">查看编号为<s:property value="#jobss.job.ZId" />的职位</a><br />		  				    			     
	
	</s:iterator>
			
			<div class="section_box">
				<div class="section">
					<h1 class="res_header"></h1>
					<div class="section_item bas_must complete">
						<div class="bas_inf">
							<div>
								<img src="upload/<s:property value="vita.student.UTouxiang"/>"
									class="user_img" />
								<p class="bas_inf_inf">
									编号:
									<s:property value="vita.JId" />
									<br />
									<div >
									 姓名：<span class="stu_name"> <s:property
											value="vita.student.UName" /> </span>
											
									<input type="hidden" value="1985" class="s1" />
									<input type="hidden" value="01" class="s2" />
									<span> <span style="display: none;" class="v9">1</span>
										性别：<s:if test="vita.student.USex==0">男</s:if> <s:elseif
											test="vita.student.USex==1">女</s:elseif> | 生日：<span class="birthday"><s:property
											value="vita.student.UBirthday" /></span> |邮箱： <span class="email"><s:property
												value="vita.student.UEmail" /> </span> |毕业院校： <span class="byxx"><s:property
												value="vita.JByxx" /> </span> | 地址：<span class="dizhi"><s:property
												value="vita.JDizhi" /> </span> | 学历：<span class="xl"><s:property
												value="vita.JXl" /> </span> | 
												政治面貌：<span class="face"><s:property
												value="vita.JFace" /> </span>
												 </span>
												
									专业：<span class="zy"><s:property value="vita.JZy" /></span>
									工作经验：<span class="jl"><s:property value="vita.JGzjl" /> </span>
									简介：<span class="jianjie"><s:property value="vita.JJianjie" /> </span>
									</div>
								</p>
							</div>
						</div>
					</div>
					
					
					
					<div class="section_item item_expect complete">
						<div class="expect">
							<h2 class="ico">
								期望实习
							</h2>
							<div class="inf">

								<p>
									<span class="v2">成都</span> |
									<span class="v1">JAVA</span> |
									<span class="v3">120</span> 日薪 |
									<span class="d1">5</span> 天 | 实习:
									<span class="mons">2</span> 个月| 预计到岗日期:
									<input type="hidden" class="months"
										value="[&quot;&#39;11&#39;&quot;, &quot;&#39;12&#39;&quot;]" />
									<span class="v4"> 2015</span>-
									<span class="v5">12</span>-
									<span class="v6">11</span>
								</p>

							</div>
						</div>
					</div>
					<div class="section_item item_education complete">
						<div class="education">
							<h2 class="ico">
								教育背景
							</h2>
							<div class="inf">

								<p>
									<span class="time"> <span class="v3 item0">2013</span>-
										<span class="v4 item0">2016</span> </span>
									<span class="inf_content"> <span class="v1 item0"><s:property
												value="vita.JByxx" /> </span> | <span class="v2 item0">计算机信息管理</span>
										| <s:property value="vita.JXl" /> </span>
								</p>

								<input type="hidden" class="item_all" value="1" />
							</div>
						</div>
					</div>
					<div class="section_item item_school ">
						<div class="school">
							<h2 class="ico">
								大学经历
							</h2>
							<div class="inf">

								<input type="hidden" class="item_all" value="0" />
							</div>
						</div>
					</div>
					<div class="section_item item_practice ">
						<div class="practice">
							<h2 class="ico">
								实习经历
							</h2>
							<div class="inf">

								<input type="hidden" class="item_all" value="0" />
							</div>
						</div>
					</div>
					<div class="section_item item_project ">
						<div class="project">
							<h2 class="ico">
								项目经验
							</h2>
							<div class="inf">

								<input type="hidden" class="item_all" value="0" />
							</div>
						</div>
					</div>
					<div class="section_item item_skill ">
						<div class="skill">
							<h2 class="ico">
								技能简介
							</h2>
							<div class="inf">

								<input type="hidden" class="item_all" value="0" />
							</div>
						</div>
					</div>
					<div class="section_item item_self ">
						<div class="self">
							<h2 class="ico">
								自我评价
							</h2>
							<div class="inf">

							</div>
						</div>
					</div>
					<div class="section_item item_works ">
						<div class="works">
							<h2 class="ico">
								作品展示
							</h2>
							<div class="inf">

								<input type="hidden" class="item_all" value="0" />
							</div>
						</div>
					</div>
					<div class="item_works">
						<div class="attachment">

						</div>
					</div>

				</div>
				<!-------------------------简历模块------------------------------->
				<div class="aside">
					<p class="aside_header">
						简历模块
					</p>
					<dl>
						<dt class="aside_inf must">
							基本信息
							<span class="aside_inf_flg aside_inf_flg_ok"></span>
						</dt>
						<dd class="aside_inf must">
							期望实习
							<span class="aside_inf_flg aside_inf_flg_ok"></span>
							<dd class="aside_inf" data-flg="item_education">
								教育背景
								<span class="aside_inf_flg aside_inf_flg_ok"></span>
							</dd>
							<dd class="aside_inf" data-flg="item_school">
								大学经历
								<span class="aside_inf_flg "></span>
							</dd>
							<dd class="aside_inf" data-flg="item_practice">
								实习经历
								<span class="aside_inf_flg "></span>
							</dd>
							<dd class="aside_inf" data-flg="item_project">
								项目经验
								<span class="aside_inf_flg "></span>
							</dd>
							<dd class="aside_inf" data-flg="item_skill">
								技能简介
								<span class="aside_inf_flg "></span>
							</dd>
							<dd class="aside_inf" data-flg="item_self">
								自我评价
								<span class="aside_inf_flg "></span>
							</dd>
							<dd class="aside_inf" data-flg="item_works">
								作品展示
								<span class="aside_inf_flg "></span>
							</dd>
					</dl>
				</div>
			</div>
		</div>
		<div class="shade">
			<!-----------------------------修改的弹框------------------------------->
			<div class="change_res">
				<div class="bas_inf_change">
					<p class="change_header">
						基本信息
					</p>
					<input type="hidden" class="mod" value="base" />
					
					<div class="change_section_box">
						<div class="change_section">
							<div class="d_change_header">
								<input type="file" class="d_header_up"
									onchange="UploadFile('upload','.jpg,.png,.jpeg',onUploadFinish)"
									id="upload" data-uuid="" />
								<img id="img_upload"
									src="${pageContext.request.contextPath}
/images/default_headpic.png"
									width="100" height="100" />
								<div id="coverlayer"
									style="position: absolute; display: none; z-index: 1001; top: 0; left: 0; right: 0; bottom: 0; width: 100%; height: 100%; background: rgba(15, 15, 15, 0.3) none repeat scroll 0% 0%;">
									<div class="spinner" style="top: 40%; left: 40%">
										<div class="spinner-container container1">
											<div class="circle1"></div>
											<div class="circle2"></div>
											<div class="circle3"></div>
											<div class="circle4"></div>
										</div>
										<div class="spinner-container container2">
											<div class="circle1"></div>
											<div class="circle2"></div>
											<div class="circle3"></div>
											<div class="circle4"></div>
										</div>
										<div class="spinner-container container3">
											<div class="circle1"></div>
											<div class="circle2"></div>
											<div class="circle3"></div>
											<div class="circle4"></div>
										</div>
									</div>
								</div>

							</div>
							
							<form action="vit_update" method="post">
								<input id="headpic" name="headpic" value="" type="hidden" />
								<p class="change_sec_item">
								<span class="change_sec_head">姓名</span>
									<input type="text" name="vita.student.UName" maxlength="15"
										placeholder="您的姓名"
										data-v="stu_name" class="v_itm change_sec_inf" />

								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">性别</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<s:set name="sexlist" value="#{'0':'男','1':'女'}"
										scope="request" />
									<s:select name="vita.student.USex" list="#request.sexlist"
										listKey="key" listValue="value" data-v="v9"
										class="v_itm change_sec_inf sec_1" />

								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">现在城市</span>
									<input type="text" name="vita.JDizhi" maxlength="20"
										placeholder="现在城市"
										data-v="dizhi" class="v_itm change_sec_inf" />

								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">生日</span>
									<input type="text" class="v_itm change_sec_inf" readonly
										id="Regemail" tabindex="1"
										placeholder="生日" data-v="birthday"
										onClick= WdatePicker();
										class="v_itm change_sec_inf">

								</p>
								<script type="text/javascript">
								
								</script>
								
								<div class="change_sec_item1">
								
									<span class="change_sec_head">学历</span>
									
									
									<select id="xl"  name="vita.JXL" class="change_sec_inf "
										>
										<option name="初中及以下">初中及以下</option>
										<option name="高中">高中</option>
										<option name="中专">中专</option>
										<option name="大专">大专</option>
										<option name="本科">本科</option>
									</select>
								</div>
								<p class="change_sec_item">
									<span class="change_sec_head">毕业院校</span>
									<input type="text" name="vita.JByxx" maxlength="20"
										placeholder="毕业院校" data-v="byxx"
										class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">专业</span>
									<input type="text" name="vita.JZy" maxlength="20"
										placeholder="专业" data-v="zy"
										class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">政治面貌</span>
									<select name="vita.JFace" class="change_sec_inf" >
								<option name="群众">群众</option>
								<option name="共青团员">共青团员</option>
								<option name="预备党员">预备党员</option>
								<option name="党员">党员</option>
									</select>
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">常用邮箱</span>
									<input type="text" name="vita.student.UEmail"
										placeholder="邮箱"
										maxlength="25" data-v="email" class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">工作经验</span>
									<input type="text" name="vita.JGzjl"
										placeholder="工作经验" maxlength="25"
										data-v="jl" class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">简介</span>
									<input type="text" name="vita.JJianjie"
										
										data-v="jianjie" maxlength="25" class="v_itm change_sec_inf" />
								</p>	
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<s:if test="#session.students.UName!=null">
						<input type="submit" class="btn" data-flg="1" value="保存"/>
						</s:if>						
					</div>
					
					</form>	
						</div>
					</div>
									
				</div>
				
				
				
				
				<div class="expect_change">
					<p class="change_header">
						期望实习
					</p>
					<input type="hidden" class="mod" value="expc" />
					<div class="change_section">
						<form>
							<p class="change_sec_item">
								<span class="change_sec_head">期望职位</span>
								<input type="text" name="job" maxlength="18"
									placeholder="互联网产品经理" data-v="v1" class="v_itm change_sec_inf" />
							</p>
							<p class="change_sec_item">
								<span class="change_sec_head">期望地点</span>
								<input type="text" name="cty" maxlength="15" placeholder="成都"
									data-v="v2" class="v_itm change_sec_inf" />
							</p>
							<p class="change_sec_item">
								<span class="change_sec_head">天数/周</span>
								<input type="hidden" name="day" class="v_itm special days"
									value="2" />
								<span class="change_sec_inf change_day_6 expect_days"> <span
									class="active" data-day="2">2天</span> <span data-day="3">3天</span>
									<span data-day="4">4天</span> <span data-day="5">5天</span> <span
									data-day="6">6天</span> </span>
							</p>
							<p class="change_sec_item">
								<span class="change_sec_head">实习月份</span>
								<input type="hidden" name="months" class="mon v_itm special"
									value="" />
								<span class="change_sec_inf change_day_12"> <span
									class="super_mon" data-mon="01">1月</span> <span
									class="super_mon" data-mon="02">2月</span> <span
									class="super_mon" data-mon="03">3月</span> <span
									class="super_mon" data-mon="04">4月</span> <span
									class="super_mon" data-mon="05">5月</span> <span
									class="super_mon" data-mon="06">6月</span> <span
									class="super_mon mar_t_5" data-mon="07">7月</span> <span
									class="super_mon mar_t_5" data-mon="08">8月</span> <span
									class="super_mon mar_t_5" data-mon="09">9月</span> <span
									class="super_mon mar_t_5" data-mon="10">10月</span> <span
									class="super_mon mar_t_5" data-mon="11">11月</span> <span
									class="super_mon mar_t_5" data-mon="12">12月</span> </span>
							</p>
							<p class="change_sec_item">
								<span class="change_sec_head">期望日薪</span>
								<input type="text" name="sly" maxlength="5" placeholder="100"
									data-v="v3" class="change_day v_itm" />
							</p>
							<p class="change_sec_item">
								<span class="change_sec_head_bot">到岗日期</span>
								<select name="repy" data-v="v4"
									class="v_itm mar_l_20 change_sec_inf sec_item3 sec_1 judg_year">
									<option value="2015">
										2015
									</option>
									<option value="2016">
										2016
									</option>
									<option value="2017">
										2017
									</option>
									<option value="2018">
										2018
									</option>
								</select>
								<select name="repm" data-v="v5"
									class="v_itm change_sec_inf sec_item3 judg_mon">
									<option value="01">
										1
									</option>
									<option value="02">
										2
									</option>
									<option value="03">
										3
									</option>
									<option value="04">
										4
									</option>
									<option value="05">
										5
									</option>
									<option value="06">
										6
									</option>
									<option value="07">
										7
									</option>
									<option value="08">
										8
									</option>
									<option value="09">
										9
									</option>
									<option value="10">
										10
									</option>
									<option value="11">
										11
									</option>
									<option value="12">
										12
									</option>
								</select>
								<select name="repd" data-v="v6"
									class="v_itm change_sec_inf sec_item3 judg_day">
									<option value="01">
										1
									</option>
									<option value="02">
										2
									</option>
									<option value="03">
										3
									</option>
									<option value="04">
										4
									</option>
									<option value="05">
										5
									</option>
									<option value="06">
										6
									</option>
									<option value="07">
										7
									</option>
									<option value="08">
										8
									</option>
									<option value="09">
										9
									</option>
									<option value="10">
										10
									</option>
									<option value="11">
										11
									</option>
									<option value="12">
										12
									</option>
									<option value="13">
										13
									</option>
									<option value="14">
										14
									</option>
									<option value="15">
										15
									</option>
									<option value="16">
										16
									</option>
									<option value="17">
										17
									</option>
									<option value="18">
										18
									</option>
									<option value="19">
										19
									</option>
									<option value="20">
										20
									</option>
									<option value="21">
										21
									</option>
									<option value="22">
										22
									</option>
									<option value="23">
										23
									</option>
									<option value="24">
										24
									</option>
									<option value="25">
										25
									</option>
									<option value="26">
										26
									</option>
									<option value="26">
										27
									</option>
									<option value="28">
										28
									</option>
								</select>
							</p>
						</form>
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				
				<div class="education_change">
					<p class="change_header">
						
					</p>
					
					
					<input type="hidden" class="mod" value="educ" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">学校</span>
									<input type="text" name="school" maxlength="15"
										placeholder="四川大学" data-v="v1" class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">专业</span>
									<input type="text" name="major" maxlength="15"
										placeholder="软件工程" data-v="v2" class="v_itm change_sec_inf" />
								</p>
								<div class="change_sec_item">
									<span class="change_sec_head">学历</span>
									<select name="degree" class="change_sec_inf s v_itm"
										data-s="s1">
										<option>
											大专
										</option>
										<option>
											本科
										</option>
										<option>
											硕士
										</option>
										<option>
											博士
										</option>
										<option>
											其他
										</option>
									</select>
								</div>
								
								<p class="change_sec_item">
									<span class="change_sec_head">在校时间</span>
									<select name="begin_year"
										class="sec_item2 sec_1 v_itm change_sec_inf" data-v="v3">
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
										<option value="2009">
											2009
										</option>
										<option value="2008">
											2008
										</option>
										<option value="2007">
											2007
										</option>
										<option value="2006">
											2006
										</option>
									</select>
									<span class="change_sec_head_bot"> － </span>
									<select name="end_year" class="sec_item2 v_itm change_sec_inf"
										data-v="v4">
										<option value="2021">
											2021
										</option>
										<option value="2020">
											2020
										</option>
										<option value="2019">
											2019
										</option>
										<option value="2018">
											2018
										</option>
										<option value="2017">
											2017
										</option>
										<option value="2016">
											2016
										</option>
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
									</select>
								</p>
							</form>
						</div>
					</div>
					<div class="add_item">
						<h2>
							＋
						</h2>
						添加教育背景
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
					
				</div>
				
				<div class="school_change">
					<p class="change_header">
						大学经历
					</p>
					<input type="hidden" class="mod" value="expe" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">经历</span>
									<select name="exp_type" class="change_sec_inf v_itm s"
										data-s="s1">
										<option>
											获得证书
										</option>
										<option>
											校内职务
										</option>
										<option>
											社会实践
										</option>
										<option>
											获奖经历
										</option>
										<option>
											其他
										</option>
									</select>
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">说明</span>
									<textarea name="exp_info" class="change_sec_inf v_itm"
										maxlength="350" data-v="v1" placeholder="请列出如：英语四级证书"></textarea>
								</p>
							</form>
						</div>
					</div>
					<div class="add_item">
						<h2>
							＋
						</h2>
						添加大学经历
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				<div class="practice_change">
					<p class="change_header">
						实习经历
					</p>
					<input type="hidden" class="mod" value="prac" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">公司名称</span>
									<input type="text" name="name" maxlength="20"
										placeholder="成都萌想科技有限责任公司" data-v="v1"
										class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">职位名称</span>
									<input type="text" name="play_role" maxlength="15"
										placeholder="运营推广" data-v="v2" class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">实习时间</span>
									<select name="begin_year" data-v="v3"
										class="v_itm sec_item4 change_sec_inf sec_1">
										<option value="2016">
											2016
										</option>
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
										<option value="2009">
											2009
										</option>
										<option value="2008">
											2008
										</option>
										<option value="2007">
											2007
										</option>
										<option value="2006">
											2006
										</option>
									</select>
									<select name="begin_month" data-v="v4"
										class="v_itm sec_item4 change_sec_inf">
										<option value="01">
											1
										</option>
										<option value="02">
											2
										</option>
										<option value="03">
											3
										</option>
										<option value="04">
											4
										</option>
										<option value="05">
											5
										</option>
										<option value="06">
											6
										</option>
										<option value="07">
											7
										</option>
										<option value="08">
											8
										</option>
										<option value="09">
											9
										</option>
										<option value="10">
											10
										</option>
										<option value="11">
											11
										</option>
										<option value="12">
											12
										</option>
									</select>
									<span class="change_sec_head_bot"> － </span>
									<select name="end_year" data-v="v5"
										class="v_itm sec_item4 change_sec_inf until_now">
										<option value="0">
											至今
										</option>
										<option value="2016">
											2016
										</option>
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
										<option value="2009">
											2009
										</option>
										<option value="2008">
											2008
										</option>
										<option value="2007">
											2007
										</option>
										<option value="2006">
											2006
										</option>
									</select>
									<select name="end_month" data-v="v6"
										class="v_itm sec_item4 change_sec_inf until_nowm">
										<option value="0">
											至今
										</option>
										<option value="01">
											1
										</option>
										<option value="02">
											2
										</option>
										<option value="03">
											3
										</option>
										<option value="04">
											4
										</option>
										<option value="05">
											5
										</option>
										<option value="06">
											6
										</option>
										<option value="07">
											7
										</option>
										<option value="08">
											8
										</option>
										<option value="09">
											9
										</option>
										<option value="10">
											10
										</option>
										<option value="11">
											11
										</option>
										<option value="12">
											12
										</option>
									</select>
								</p>
								<div class="change_sec_item">
									<span class="change_sec_head">实习描述</span>
									<textarea name="description" placeholder="实习描述" maxlength="350"
										class="change_sec_inf v_itm" data-v="v7"></textarea>
								</div>
							</form>
						</div>
					</div>
					<div class="add_item">
						<h2>
							＋
						</h2>
						添加新实习
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				<div class="project_change">
					<p class="change_header">
						项目经验
					</p>
					<input type="hidden" class="mod" value="proj" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">项目名称</span>
									<input type="text" name="name" maxlength="15"
										placeholder="'XX文化网" class="v_itm change_sec_inf" data-v="v1" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">担任职务</span>
									<input type="text" name="play_role" maxlength="15"
										placeholder="主要负责人" class="v_itm change_sec_inf" data-v="v2" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">项目时间</span>
									<select name="begin_year"
										class="v_itm sec_item4 change_sec_inf sec_1" data-v="v3">
										<option value="2016">
											2016
										</option>
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
										<option value="2009">
											2009
										</option>
										<option value="2008">
											2008
										</option>
										<option value="2007">
											2007
										</option>
										<option value="2006">
											2006
										</option>
									</select>
									<select name="begin_month"
										class="v_itm sec_item4 change_sec_inf" data-v="v4">
										<option value="01">
											1
										</option>
										<option value="02">
											2
										</option>
										<option value="03">
											3
										</option>
										<option value="04">
											4
										</option>
										<option value="05">
											5
										</option>
										<option value="06">
											6
										</option>
										<option value="07">
											7
										</option>
										<option value="08">
											8
										</option>
										<option value="09">
											9
										</option>
										<option value="10">
											10
										</option>
										<option value="11">
											11
										</option>
										<option value="12">
											12
										</option>
									</select>
									<span class="change_sec_head_bot"> － </span>
									<select name="end_year"
										class="v_itm sec_item4 change_sec_inf until_now" data-v="v5">
										<option value="0">
											至今
										</option>
										<option value="2016">
											2016
										</option>
										<option value="2015">
											2015
										</option>
										<option value="2014">
											2014
										</option>
										<option value="2013">
											2013
										</option>
										<option value="2012">
											2012
										</option>
										<option value="2011">
											2011
										</option>
										<option value="2010">
											2010
										</option>
										<option value="2009">
											2009
										</option>
										<option value="2008">
											2008
										</option>
										<option value="2007">
											2007
										</option>
										<option value="2006">
											2006
										</option>
									</select>
									<select name="end_month"
										class="v_itm sec_item4 change_sec_inf until_nowm" data-v="v6">
										<option value="0">
											至今
										</option>
										<option value="01">
											1
										</option>
										<option value="02">
											2
										</option>
										<option value="03">
											3
										</option>
										<option value="04">
											4
										</option>
										<option value="05">
											5
										</option>
										<option value="06">
											6
										</option>
										<option value="07">
											7
										</option>
										<option value="08">
											8
										</option>
										<option value="09">
											9
										</option>
										<option value="10">
											10
										</option>
										<option value="11">
											11
										</option>
										<option value="12">
											12
										</option>
									</select>
								</p>
								<div class="change_sec_item">
									<span class="change_sec_head">项目描述</span>
									<textarea name="description"
										placeholder="个人博客是采用PHP作为服务器脚本语言进行开发的，项目框架
选择了YII，项目实现了个人博文的发表，博文的分类显示，评价和留言以及对博客的管理。"
										maxlength="350" class="change_sec_inf v_itm" data-v="v7"></textarea>
								</div>
							</form>
						</div>
					</div>
					<div class="add_item">
						<h2>
							＋
						</h2>
						添加新项目
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				<div class="skill_change">
					<p class="change_header">
						技能简介
					</p>
					<input type="hidden" class="mod" value="skil" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">技能名称</span>
									<input type="text" name="name" maxlength="15"
										placeholder="Word，Excel，PPT" data-v="v1"
										class="v_itm change_sec_inf" />
								</p>
								<div class="change_sec_item">
									<span class="change_sec_head skill_tex">掌握程度</span>
									<input type="hidden" name="level"
										class="skill_lev special v_itm" value="2" />
									<ul class="skill_sel">
										<li class="skill_op skill_r_ok skill_text_ok" data-rank="0"
											data-lev="2">
											初学
										</li>
										<li class="skill_op" data-rank="1" data-lev="3">
											了解
										</li>
										<li class="skill_op" data-rank="2" data-lev="4">
											掌握
										</li>
										<li class="skill_op" data-rank="3" data-lev="0">
											熟练
										</li>
										<li class="skill_op" data-rank="4" data-lev="1">
											精通
										</li>
									</ul>
								</div>
							</form>
						</div>
					</div>
					<div class="add_item skill_btn">
						<h2>
							＋
						</h2>
						添加新项目
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				<div class="self_change">
					<p class="change_header">
						自我评价
					</p>
					<input type="hidden" class="mod" value="desc" />
					<div class="change_section">
						<form>
							<textarea name="judge" class="change_sec_inf v_itm" data-v="v1"
								placeholder="年轻与活力是我的成本，兴趣是我的动力，
我酷爱建站，喜欢学习和接触web开发的新技术，愿意在web开发行业长期发展。
具有强烈的上进心和求知欲与超强的自学能力，
开发经历也让我具备了较强的团队协作能力，以及对工作的责任心。"
								maxlength="650"></textarea>
							<br />
						</form>
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
				<div class="works_change">
					<p class="change_header">
						作品展示
					</p>
					<input type="hidden" class="mod" value="prod" />
					<div class="change_section_box">
						<div class="change_section must_arr">
							<form>
								<p class="change_sec_item">
									<span class="change_sec_head">作品链接</span>
									<input type="text" name="url" maxlength="25"
										placeholder="www.shixiseng.com" data-v="v1"
										class="v_itm change_sec_inf" />
								</p>
								<p class="change_sec_item">
									<span class="change_sec_head">文字说明</span>
									<textarea name="info" class="v_itm change_sec_inf" data-v="v2"
										maxlength="350"
										placeholder="实习僧是国内领先的实习生招聘网站,500强名企实习,靠谱实习机会,优质实习信息,优秀实习生,找实习就上实习僧,实习生招聘首选实习僧。"></textarea>
								</p>
							</form>
						</div>
					</div>
					<div class="add_item">
						<h2>
							＋
						</h2>
						添加新作品
					</div>
					<div class="change_footer">
						<button class="btn" data-flg="0">
							取消
						</button>
						<button class="btn" data-flg="1">
							保存
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-------------------------------选择简历模板弹窗------------------------>
		<div id="change_tpl" class="popup">
			<div class="popup_head">
				选择简历模板
			</div>
			<div class="popup_close">
				×
			</div>
			<div class="popup_main">
				<div id="element_id" class="cxscroll">
					<!-- 控制按钮内部会自动创建，可省略 -->
					<a class="prev">prev</a>
					<a class="next">next</a>
					<div class="box">
						<ul class="list" id="tpl_list">

							<li>
								<img
									src="/static/img/template/default.png?v=18d52b1dcb9df0a0b721f9077bc0d39f"
									alt="default" width="148" height="195"
									data-val="tpl_w2yeuilmz9fg" class="active">
							</li>

							<li>
								<img
									src="/static/img/template/DarkSeaGreen.png?v=3247a92a13bd1419553b43fd6abc51e1"
									alt="DarkSeaGreen" width="148" height="195"
									data-val="tpl_dfhmunpjfgk5">
							</li>

							<li>
								<img
									src="/static/img/template/Peru.png?v=fdf18f0b4711479572047b5044b323d9"
									alt="Peru" width="148" height="195" data-val="tpl_ap6eyzuw2mnx">
							</li>

							<li>
								<img
									src="/static/img/template/LabelResume.png?v=2a7bcbf93f93f72d54bf486556e4408e"
									alt="LabelResume" width="148" height="195"
									data-val="tpl_nspvsmzf5ojf">
							</li>

							<li>
								<img
									src="/static/img/template/Blue.png?v=9aac0b7b7b3904e0988a90dfbcff771e"
									alt="Blue" width="148" height="195" data-val="tpl_vedfidipleof">
							</li>

							<li>
								<img
									src="/static/img/template/DeepSkyBlue.png?v=81c9545b27542ae7c26920a53ed0d367"
									alt="DeepSkyBlue" width="148" height="195"
									data-val="tpl_y6eljooy0ufz">
							</li>

							<li>
								<img
									src="/static/img/template/Salmon.png?v=243a5ac4898f27fbb60fdc2a53998e4f"
									alt="Salmon" width="148" height="195"
									data-val="tpl_iuuv2m5estmi">
							</li>

							<li>
								<img
									src="/static/img/template/GrayBreath.png?v=2a9db86fcd22df607a95780c1f60c6a4"
									alt="GrayBreath" width="148" height="195"
									data-val="tpl_g9xbwku0cb3v">
							</li>

							<li>
								<img
									src="/static/img/template/DimGray.png?v=90e53669068ab01143f03e083e8345c8"
									alt="DimGray" width="148" height="195"
									data-val="tpl_j1evawz1b4v6">
							</li>

						</ul>
					</div>
				</div>
				
				<a class="popup_cancel popup_btn">取消</a>
				<a class="popup_btn" id="tpl_submit">确定</a>
			</div>
			
			
		</div>
		<script
			src="${pageContext.request.contextPath}
/css/jquery-1.9.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}
/css/resume_manage.js"></script>
		<script
			src="${pageContext.request.contextPath}
/css/jquery-1.9.1.min.js"></script>
		<script
			src="${pageContext.request.contextPath}
/css/jquery.cxscroll.js"></script>
		<script src="${pageContext.request.contextPath}
/css/lightbox.min.js"></script>
		<script src="${pageContext.request.contextPath}
/css/upload.js"></script>
		<script>
	function onUploadFinish(success, fileuuid, fileurl) {
		if (success) {
			$('#headpic').val(fileuuid);
			$('#img_upload').attr('src', fileurl);
		} else {
			layer.alert('上传失败！');
		}
	}
</script>

	</body>
</html>