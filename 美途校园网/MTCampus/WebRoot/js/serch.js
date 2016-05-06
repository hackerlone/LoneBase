var xz = "";
var yx = "";
var gm = "";
var xl = "";
var txt = "";
$(document)
		.ready(
				function() {
					
					

					secJob(txt);
					$("#search1")
							.click(
									function() {
										if ($("#search1").attr("class")
												.toString() == "refineNavOn") {
											$("#search1").removeClass(
													"refineNavOn");
											$("#search1").addClass(
													"refineNavOff");
											$("#xz").hide();
										} else if ($("#search1").attr("class")
												.toString() == "refineNavOff") {
											$("#search1").removeClass(
													"refineNavOff");
											$("#search1").addClass(
													"refineNavOn");
											$("#xz").show();
										}
									});
					$("#search2")
							.click(
									function() {
										if ($("#search2").attr("class")
												.toString() == "refineNavOn") {
											$("#search2").removeClass(
													"refineNavOn");
											$("#search2").addClass(
													"refineNavOff");
											$("#yx").hide();
										} else {
											$("#search2").removeClass(
													"refineNavOff");
											$("#search2").addClass(
													"refineNavOn");
											$("#yx").show()
										}
									});
					$("#search3")
							.click(
									function() {
										if ($("#search3").attr("class")
												.toString() == "refineNavOn") {
											$("#search3").removeClass(
													"refineNavOn");
											$("#search3").addClass(
													"refineNavOff");
											$("#gm").hide();
										} else {
											$("#search3").removeClass(
													"refineNavOff");
											$("#search3").addClass(
													"refineNavOn");
											$("#gm").show();
										}
									});
					$("#search4")
							.click(
									function() {
										if ($("#search4").attr("class")
												.toString() == "refineNavOn") {
											$("#search4").removeClass(
													"refineNavOn");
											$("#search4").addClass(
													"refineNavOff");
											$("#xl").hide();
										} else {
											$("#search4").removeClass(
													"refineNavOff");
											$("#search4").addClass(
													"refineNavOn");
											$("#xl").show();
										}
									});
					$("#search5")
							.click(
									function() {
										if ($("#search5").attr("class")
												.toString() == "refineNavOn") {
											$("#search5").removeClass(
													"refineNavOn");
											$("#search5").addClass(
													"refineNavOff");
											$("#rq").hide();
										} else {
											$("#search5").removeClass(
													"refineNavOff");
											$("#search5").addClass(
													"refineNavOn");
											$("#rq").show()
										}
									});

					$("#xz > ul > li >a").click(function() {
						$("#secjob > tr").remove();
						$("#serchjob > li").remove();
						xz = $(this).text().toString();
						$("#xz > ul > li >a").css("background", "#666");
						$(this).css("background", "red");

						secJob(txt);
					});
					$("#yx > ul > li >a").click(function() {
						$("#secjob > tr").remove();
						$("#serchjob > li").remove();
						yx = $(this).text().toString();
						$("#yx > ul > li >a").css("background", "#666");
						$(this).css("background", "red");
						secJob(txt);
					});
					$("#gm > ul > li >a").click(function() {
						$("#secjob > tr").remove();
						$("#serchjob > li").remove();
						gm = $(this).text().toString();
						$("#gm > ul > li >a").css("background", "#666");
						$(this).css("background", "red");
						secJob(txt);
					});
					$("#xl > ul > li >a").click(function() {
						$("#secjob > tr").remove();
						$("#serchjob > li").remove();
						xl = $(this).text().toString();
						$("#xl > ul > li >a").css("background", "#666");
						$(this).css("background", "red");
						secJob(txt);
					});
					$("#search_input").keyup(function() {
						window.setTimeout(function() {
							txt = $("#search_input").val();
							$("#searchtxt").empty();
							secJname(txt);
						}, 800);
					});
					function secJname(txt) {
						var txtstr = "<ul id='ul1'>";
						$.ajax( {
							url : 'utils_selcJname',
							type : 'post',
							data : {
								"xz" : xz,
								"yx" : yx,
								"gm" : gm,
								"xl" : xl,
								"txt" : txt
							},
							dataType : 'json',
							success : function(data) {
								$(data).each(
										function(i, obj) {
											txtstr += "<li class='txtli'>"
													+ obj.name + "</li>";
										})
								txtstr += "</ul>";
								$("#searchtxt").append(txtstr);
								$(".txtli").css("background-color", "#FFFFFF");
								$(".txtli").css("list-style", "none");
								$(".txtli").css("margin-left", "18px");
								$(".txtli").css("font-size", 18);
								$(".txtli").hover(function() {
									$(this).css("background", "#E0E0E0");
								}, function() {
									$(this).css("background", "#FFFFFF");
								});

								$(".txtli").click(function() {
									$("#search_input").val($(this).text());
									$("#searchtxt").html("");
								});
							}
						});
					}
					$("#search_button").click(function() {
						txt = $("#search_input").val();
						secJob(txt);
					});
					function secJob(txt) {
						$("#serchjob").empty();
						$.ajax( {
									url : 'utils_selcAllJob',
									type : 'post',
									data : {
										"xz" : xz,
										"yx" : yx,
										"gm" : gm,
										"xl" : xl,
										"txt" : txt
									},
									dataType : 'json',
									success : function(data) {
										$(data).each(function(i, obj) {				
											$("#secjob").append("<tr>"
												+ "<td>"
												+ obj.id
												+ "</td><td>"
												+ obj.qid
												+ "</td><td>"
												+ obj.name
												+ "</td><td>"
												+ obj.data
												+ "</td><td>"
												+ obj.area
												+ "</td><td>"
												+ obj.renshu
												+ "</td><td>"
												+ obj.zhineng
												+ "</td><td>"
												+ obj.miaoshu
												+ "</td><td>"
												+ obj.xinzi
												+ "</td><td>"
												+ obj.xl
												+ "</td><td><a href='/MTCampus/job_getJobById.action?id="
												+ obj.id
												+ "&option=sec'>secAll</a></td>"
												+ "</tr>");
															$("#serchjob")
																	.append(
																			"<li id='pagy' class='old clearfix' style='border-bottom: 1px solid #eee;' >"
																					+ "<div id='div_intern_info' class='block'><a title='查看职位信息' href='/MTCampus/job_getJobById.action?id="
																					+ obj.id
																					+ "&option=sec' target='_blank' >"
																					+ "<span class='f18 current_color nowrap'>"
																					+ obj.name
																					+ "</span>"
																					+ "</a><br/><a  class='nowrap' title='查看企业信息' href='qy_getEnterpriseById.action?enterprise.QId="
																					+ obj.qid
																					+ "&option=updata'  target='_blank'>"
																					+ obj.qid
																					+ "</a></div>"
																					+ "<div id='div_location' class='block'  title='公司地址'>"
																					+ "<span class='icon location' title='公司地址'></span><span class='c9'>"
																					+ obj.area
																					+ "</span><br/></div>"
																					+ "<div id='div_money' class='block'>"
																					+ "<span class='icon clock'  title='招聘人数'></span>"
																					+ "<span class='color' title='招聘人数'>"
																					+ obj.renshu
																					+ "</span><br/>"
																					+ "<span class='icon money' title='薪资待遇'></span>"
																					+ "<span class='c_gengxin' title='薪资待遇'>"
																					+ obj.xinzi
																					+ "</span></div>"
																					+ "<div id='div_other' class='block'>"
																					+ "<span class='icon-date' title='发布时间'></span>"
																					+ "<span class='color' title='发布时间'>"
																					+ obj.data
																					+ "</span><br/></div></li>");

											
											
										}

										);
										var show_per_page = 8; 
										var number_of_items = $('#serchjob').children().size();
										var number_of_pages = Math.ceil(number_of_items/show_per_page);
										$('#current_page').val(0);
										$('#show_per_page').val(show_per_page);
										var navigation_html = '<a class="previous_link" href="javascript:previous();">Prev</a>';
										var current_link = 0;
										while(number_of_pages > current_link){
											navigation_html += '<a class="page_link" href="javascript:go_to_page(' + current_link +')" longdesc="' + current_link +'">'+ (current_link + 1) +'</a>';
											current_link++;
										}
										navigation_html += '<a class="next_link" href="javascript:next();">Next</a>';
										$('#page_navigation').html(navigation_html);
										$('#page_navigation .page_link:first').addClass('active_page');
										$('#serchjob').children().css('display', 'none');
										$('#serchjob').children().slice(0, show_per_page).css('display', 'block');
									}
								});

					}
				});
function previous(){
	new_page = parseInt($('#current_page').val()) - 1;
	if($('.active_page').prev('.page_link').length==true){
		go_to_page(new_page);
	}
}
function next(){
	new_page = parseInt($('#current_page').val()) + 1;
	//if there is an item after the current active link run the function
	if($('.active_page').next('.page_link').length==true){
		go_to_page(new_page);
	}
}
function go_to_page(page_num){
	var show_per_page = parseInt($('#show_per_page').val());
	start_from = page_num * show_per_page;
	end_on = start_from + show_per_page;
	$('#serchjob').children().css('display', 'none').slice(start_from, end_on).css('display', 'block');
	$('.page_link[longdesc=' + page_num +']').addClass('active_page').siblings('.active_page').removeClass('active_page');
	$('#current_page').val(page_num);
}


