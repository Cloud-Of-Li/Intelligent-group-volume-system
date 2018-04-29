$(function() {
	
	$('input[name=name]').click(function() {
		$("input[name='shuruxingming'").css("display", "none");
	})
	
	$('input[name=password]').click(function() {
		$("input[name='shuruxingming'").css("display", "none");
	})
	
	
	$(".adminlogin_button").click(function() {
	
		var managerName = $('input[name=name]').val();
		var managerPassword = $('input[name=password]').val();
		var teacherLoginError = $(".login_error").first();
		if (managerName == null || managerName == "" || managerName == "Username" ) {
			$("input[name='shuruxingming'").css("display", "block");
			return;
		}
		if (managerPassword == null || managerPassword == "" || managerPassword == "Password") {
			$("input[name='shuruxingming'").val("请输入密码");
			$("input[name='shuruxingming'").css("display", "block");
			return;
		}
		
		var a = $.ajax({
			
			url : 'managerServlet',
			type : 'post',
			data : '{"managerName":"' + managerName + '","managerPassword":"' + managerPassword + '","op":"login"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				if (data == "error") {
					$("input[name='shuruxingming'").val("用户名或者密码错误");
					$("input[name='shuruxingming'").css("display", "block");
				} else{
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
				} 					
			}
		});
	});
	
	$(".login_button").click(function() {
		var teacherName = $('input[name=name]').val();
		var teacherPassword = $('input[name=password]').val();
		var teacherLoginError = $(".login_error").first();
		if (teacherName == null || teacherName == "" || teacherName == "Username" ) {
			$("input[name='shuruxingming'").css("display", "block");
			return;
		}
		if (teacherPassword == null || teacherPassword == "" || teacherPassword == "Password") {
			$("input[name='shuruxingming'").val("请输入密码");
			$("input[name='shuruxingming'").css("display", "block");
			return;
		}
		var a = $.ajax({
			url : 'teacherServlet',
			type : 'post',
			data : '{"teacherName":"' + teacherName + '","teacherPassword":"' + teacherPassword + '","op":"login"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				if (data == "error") {
					$("input[name='shuruxingming'").val("用户名或者密码错误");
					$("input[name='shuruxingming'").css("display", "block");
				} else{
					location.href = "http://localhost:8080/zujuanxitong/examServlet";
//					alert(data[0].examKind);
				/*	var jsonData = JSON.parse(data); 
					console.log(jsonData[0]);*/
				} 					
			}
		});
	});
});