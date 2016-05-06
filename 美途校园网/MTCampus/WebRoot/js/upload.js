$(document).ready(function() {
var srctouxiang=null;
	$("#uploadBtn").click(function() {
		ajaxFileUpload();
	});

});
function ajaxFileUpload() {
	var elementIds = [ "file" ]; //flag为id、name属性名
	$.ajaxFileUpload( {
		url : 'upload_exec',
		type : 'post',
		secureuri : false, //一般设置为false
		fileElementId : 'file', // 上传文件的id、name属性名
		dataType : 'text', //返回值类型，一般设置为json、application/json
		elementIds : elementIds, //传递参数到服务器
		success : function(data, status) {
		$data = $(data);
		
		$("#headimg").attr("src","upload/"+data);
		$("input[name='#request.student.UTouxiang']").val(data);
		$.ajax({
			url:'stu_update',
			data:{"touxiang":data},
			success: function (obj){
				
			}
		});
		
		},
		error : function(data, status, e) {
			alert(e);
		}
	});
	//return false;
}