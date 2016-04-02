<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="sys/Css/style.css" />
    <link href="sys/Css/serch.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="sys/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="sys/Js/bootstrap.js"></script>
    <script type="text/javascript" src="sys/Js/ckform.js"></script>
    <script type="text/javascript" src="sys/Js/common.js"></script>
     <script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
	#uhead{
		width: 40px;
		height: 30px;
	}
	.sel{
		width: 90px;
		height: 30px;
	}
 .page a{  
  text-decoration:none;  
}  
  .page a span{  
  padding:4px 16px 4px 16px;  
  border:1px solid #AAAAEE;  
  color: #1155BB;  
  font-size:12px;  
  font-weight:bold;  
  font-family: 'helvetica neue', arial, sans-serif;  
}  
  
.page a span:hover,.click_page{  
  background:#2266BB;  
  color:#ffffff;  
 } 
    </style>
    <script type="text/javascript">
    $(function() {					 	 
    	$("#create").click(function(){
    		$(".page").remove();
 			$("#usertab > tr").remove();
 			var y_id = ${sessionScope.user.UId};
 			$.ajax({
 				url : 'YuServlet',
 				type : 'post',
 				data : {"option" : "getYUId","y_id":y_id},
 				dataType:'json',
 				async:false,
 				success : function(data) {
 					$(data).each(function(i, obj1) {
 						var name = getUname(y_id);
 						var u_id = ${sessionScope.user.UId};
 						var arr = name.split(/[&]+/);
 						var tr = ".user"+i;
 						$("#usertab").append("<tr class='user"+i+"'>");	
 						$(tr).append("<td><a href='UserServlet?option=findById1&id="+obj1.YId+"'>"+arr[0]+"</a></td>");
 						$(tr).append("<td>"+obj1.yuData+"</td>");
 						$(tr).append("<td>"+obj1.yuEnddata+"</td>");
 						$("#usertab").append("</tr>");	
 						getYUId(obj1.YUId,i,obj1.YId);
 					});
 				TablePage("#tab",4);
 				}
 			});	
   });
    	
    	
    	$("#joining").click(function(){
    		$(".page").remove();
 			$("#usertab > tr").remove();
 			var y_id = ${sessionScope.user.UId};
 			$.ajax({
 				url : 'YuServlet',
 				type : 'post',
 				data : {"option" : "getYUId1","y_id":y_id},
 				dataType:'json',
 				async:false,
 				success : function(data) {
 					$(data).each(function(i, obj1) {
 						var name = getUname(obj1.YId);
 						var u_id = ${sessionScope.user.UId};
 						var arr = name.split(/[&]+/);
 						var tr = ".user"+i;
 						$("#usertab").append("<tr class='user"+i+"'>");	
 						$(tr).append("<td><a href='UserServlet?option=findById1&id="+obj1.YId+"'>"+arr[0]+"</a></td>");
 						$(tr).append("<td>"+obj1.yuData+"</td>");
 						$(tr).append("<td>"+obj1.yuEnddata+"</td>");
 						$("#usertab").append("</tr>");	
 						getYUId(obj1.YUId,i,obj1.YId);
 					});
 				TablePage("#tab",4);
 				}
 			});	
   });
    
    });
  
    </script>


</head>
<body>

<form class="form-inline definewidth m20" action="" method="get">    
    &nbsp;&nbsp; <span id="create"><button type="button" class="btn btn-success" id="">我创建的约会</button></span>
    &nbsp;&nbsp; <span id="joining"><button type="button" class="btn btn-success" id="">我参加的约会</button></span>
</form>
<table id="tab" class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>创建人</th>
        <th>创建时间</th>
        <th>结束时间</th>
        <th>约会名</th>
        <th>描述</th>
        <th>约会方式</th>
        <th>约会时间</th>
        <th>约会地点</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="usertab" class="hot_pos reset">
	    
    </tbody>	
</table>
    <div id='page_navigation' align="center"></div>
</body>
</html>
<script type="text/javascript">
function getYUId(yuid,claa,thisid){
	 $.ajax({
			url : 'AgreementServlet',
			type : 'post',
			data : {"option" : "findByCreate","y_id":yuid},
			dataType:'json',
			async:false,
			success : function(data) {
				$(data).each(function(i, obj) {
					var sex = obj.YFs;
					var fs = "";
	    			if(sex=="1"){
	    				fs="AA制";
	    			}else if(sex=="2"){
	    				fs="组团行";
	    			}else if(sex=="3"){
	    				fs="自由行";
	    			}
	    			var cla = ".user"+claa;
	    			
	    			$(cla).append("<td>"+obj.YName+"</td>");
	    			$(cla).append("<td>"+obj.YMs+"</td>");
	    			$(cla).append("<td>"+fs+"</td>");
	    			$(cla).append("<td>"+obj.YYhsj+"</td>");
	    			$(cla).append("<td>"+obj.YArea+"</td>");
	    			$(cla).append("<td>"+obj.YBz+"</td>");
	    			var uuname = ${sessionScope.user.UId};		
	    			if(thisid==uuname){
	    				$(cla).append("<td><a href='AgreementServlet?option=findById&yid="+obj.YId+"'>修改信息</a></td>");
	    				}else{
	    					$(cla).append("<td></td>");
	    				}
			});
				//var number_of_items = $("#usertab").children().size()
		}
});    
}


function getUname(yid){
	var name="";
	$.ajax({
		url : 'UserServlet',
		type : 'post',
		data : {"option" : "findById","id":yid},
		dataType:'json',
		async:false,
		success : function(data) {
			$(data).each(function(i, obj2) {	
				name = obj2.UName+"&"+obj2.UId;
			});
		}
	});
	return name;
}
//分页
function TablePage(id,size){  
	   var $table = $(id);  
	    var currentPage = 0;  //当前页  
	    var pageSize = size;  //每页行数（不包括表头）  
	    $table.bind("repaginate", function()  
	    {  
	       //console.log($table.find("tbody tr").eq(0));  
	      $table.find("tbody tr").hide().slice(currentPage * pageSize, (currentPage + 1) * pageSize).show();  
	     // $table.find("tbody tr").eq(0).show();  
	    });  
	    var numRows = $table.find("tbody tr").length;  //记录宗条数  
	    var numPages = Math.ceil(numRows/pageSize);    //总页数  
	    //console.log(numPages);  
	    var $pager = $("<div class='page'><a href='javascript:void(0)'><span id='Prev' style='margin-right:4px;'>« 上一页</span></a></div>");  //分页div  
	    for( var page = 0; page < numPages; page++ )  
	    {  
	  
	      //为分页标签加上链接  
	      //if(page==0){$("<a href='javascript:void(0)'><span id='1' class="click_page"></span></a>")}  
	     if(page<3||page>(numPages-4)){
	      $("<a href='javascript:void(0)'><span id='"+(page+1)+"'>"+ (page+1) +"</span></a>")  
	           .bind("click", { "newPage": page }, function(event){  
	                currentPage = event.data["newPage"];  
	                //console.log($(this).children("span"));  
	                $(this).children("span").attr("class","click_page");  
	                $(this).children("span").css({"color":"#FFFFFF"});  
	                $(".page a span").not($(this).children("span")).attr("class","");  
	                $(".page a span").not($(this).children("span")).css({"color":"#1155BB"});  
	                $table.trigger("repaginate");  
	            })  
	            .appendTo($pager);  }else{
	            	$("<span id='"+(page+1)+"'>.</span>").appendTo($pager);
	            }
	  
	        $pager.append("  ");  
	    }  
	    //$table.trigger("repaginate");  
	    var next=$("<a href='javascript:void(0)'><span id='Next'>下一页 »</span></a>");  
	    $pager.append(next);  
	    $pager.insertAfter($table);//分页div插入table  
	    $("#1").attr("class","click_page");  
	    $("#1").css({"color":"#FFFFFF"});  
	    $table.trigger("repaginate");  
	    //console.log($("#1"));  
	    //$("#1").attr("class","click_page");  
	    //$("#1").css({"background":"#FFFFFF"});  
	    $("#Prev").bind("click",function(){  
	       var prev=Number($(".click_page").text())-2;  
	       currentPage=prev;  
	       $(this).css({"background":"#000000"});  
	       if(currentPage<0) {  
	         $(this).css({"background":"#c0c0c0"});  
	         return;  
	 }  
	       $("#"+(prev+1)).attr("class","click_page");  
	       $("#"+(prev+1)).css({"color":"#FFFFFF"});  
	       $(".page a span").not($("#"+(prev+1))).attr("class","");  
	       $(".page a span").not($("#"+(prev+1))).css({"color":"#1155BB"});  
	       //console.log(currentPage);  
	       $table.trigger("repaginate");  
	    });  
	     $("#Next").bind("click",function(){  
	       var next=$(".click_page").attr("id");  
	       currentPage=Number(next);  
	       //console.log($(".click_page").text());  
	       $(this).css({"background":"#FFFFFF"});  
	       if((currentPage+1)>numPages) {  
	         $(this).css({"background":"#c0c0c0"});  
	         return;  
	         }  
	       $("#"+(currentPage+1)).attr("class","click_page");  
	       $("#"+(currentPage+1)).css({"color":"#FFFFFF"});  
	       $(".page a span").not($("#"+(currentPage+1))).attr("class","");  
	       $(".page a span").not($("#"+(currentPage+1))).css({"color":"#1155BB"});  
	       $table.trigger("repaginate");  
	    });  
	      
	 }
</script>