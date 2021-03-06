$(function() {
	
	$(".add_course").mouseout(function() {
		$(this).css("color", "white");
	})
	$(".add_course").mouseover(function() {
		$(this).css("color", "red");
	})
	
	
	/*课程的添加*/
	$(".add_course").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#content_right_add_course").css("display","block");
		$("#content_right_update_course").css("display","none");
	})
	
	 $("#queren_addcourse").click(function() {
		var coursename = $('input[name="add_coursername"]').val();
		var coursemajorid = $('#add_coursemajor option:checked').val();
		
		if(coursename.replace(/(^\s*)|(\s*$)/g, "")=="") {
			alert("课程名不能为空");
			return;
		}
		
		var coursetecherid = $("input:checkbox[name='chc_tea']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		var a = $.ajax({
			
			url : 'mexamServlet?op=addCourse',
			type : 'post',
			data : '{"coursename":"' + coursename + '","coursemajorid":"' + coursemajorid + '","coursetecherid":"' + coursetecherid +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("课程信息添加成功！！！！");
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
			}
		});
	})
	
	
	$(".returnBack").click(function(){
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#list_kecheng").css("display","block");
	})
	
	/*删除课程信息操作*/
	
	$(".delete_course").click(function() {
		var courseName = $(this).parents("tr").children("td").eq(1).children("pre").text();
		var courseid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		
		var flag = confirm("确定删除吗? 提示：删除之后无法恢复!!!");
		if(flag) {
			alert("确认删除 " + courseName + "课程!!!");
			location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=deleteCourse&courseid=" + courseid;
		}
	})
	
	/*课程的修改*/
	$(".update_course").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#content_right_add_course").css("display","none");
		$("#content_right_update_course").css("display","block");
		var courseid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		var coursename = $(this).parents("tr").children("td").eq(1).children("pre").text();
		var courseid_4 = ($('input[name="update_courseid"]').val(courseid));
		var coursename_4 = ($('input[name="update_coursename"]').val(coursename));
	})
	$("#queren_update_course").click(function() {
		
		var courseid = ($('input[name="update_courseid"]').val());
		var coursename = ($('input[name="update_coursename"]').val());
		var coursemajorid = $('#update_coursemajor option:checked').val();

		if(coursename.replace(/(^\s*)|(\s*$)/g, "")=="") {
			alert("课程名不能为空");
			return;
		}
		
		var coursetecherid = $("input:checkbox[name='chc_tea_up']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		var a = $.ajax({
			
			url : 'mexamServlet?op=updateCourse',
			type : 'post',
			data : '{"coursename":"' + coursename + '","coursemajorid":' + coursemajorid + ',"courseid":' + courseid  + ',"coursetecherid":"' + coursetecherid +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("课程信息修改成功！！！！");
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
			}
		});
	})
	
	
	
	/*专业信息*/
	$(".returnBacktomajorlist").click(function(){
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#list_major").css("display","block");
	})
	$(".update_major").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#content_right_add_course").css("display","none");
		$("#content_right_update_course").css("display","none");
		$("#content_right_update_major").css("display","block");
		var majorid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		var majorname = $(this).parents("tr").children("td").eq(1).children("pre").text();
		var courseid_4 = ($('input[name="update_majorid"]').val(majorid));
		var coursename_4 = ($('input[name="update_majorname"]').val(majorname));
	})
	
	$("#queren_update_major").click(function() {
		
		var majorid = ($('input[name="update_majorid"]').val());
		var majorname = ($('input[name="update_majorname"]').val());

		if(majorname.replace(/(^\s*)|(\s*$)/g, "")=="") {
			alert("专业名不能为空");
			return;
		}
		
		var majortecherid = $("input:checkbox[name='major_tea_up']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		var a = $.ajax({
			
			url : 'mexamServlet?op=updatemajor',
			type : 'post',
			data : '{"majorname":"' + majorname + '","majorid":' + majorid + ',"majortecherid":"' + majortecherid +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("教师及专业信息修改成功！！！！");
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
			}
		});
	})
	
	/*专业信息删除*/
	$(".delete_major").click(function() {
		var majorid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		var majorname = $(this).parents("tr").children("td").eq(1).children("pre").text();
		
		var flag = confirm("确定删除吗? 提示：删除之后无法恢复!!!");
		if(flag) {
			alert("确认删除 " + majorname + "课程!!!");
			location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=deleteMajor&majorid=" + majorid;
		}
	})
	/*专业添加*/
		
	$(".add_major").mouseout(function() {
		$(this).css("color", "white");
	})
	$(".add_major").mouseover(function() {
		$(this).css("color", "red");
	})
	
	

	$(".add_major").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","none");
		$("#content_right_add_course").css("display","none");
		$("#content_right_update_course").css("display","none");
		$("#content_right_add_major").css("display","block");
	})
	
	 $("#queren_addmajor").click(function() {
		var majorename = $('input[name="add_majorname"]').val();
		
		if(majorename.replace(/(^\s*)|(\s*$)/g, "")=="") {
			alert("课程名不能为空");
			return;
		}
		
		var majortecherid = $("input:checkbox[name='m_tea']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		var a = $.ajax({
			
			url : 'mexamServlet?op=addMajor',
			type : 'post',
			data : '{"majorname":"' + majorename + '","majortecherid":"' + majortecherid +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("课程信息添加成功！！！！");
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
			}
		});
	})
	
	
});





















