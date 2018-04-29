$(function() {
	

	$(".adminlogin_button").click(function() {
		var managerName = $('.login_page input[name=name]').val();
		var managerPasspwrd = $('.login_page input[name=password]').val();
		var teacherLoginError = $(".login_error").first();
		if (managerName == null || managerName == "") {
			teacherLoginError.children("span").first().text("管理员名不能为空");
			teacherLoginError.css("display", "block");
			return;
		}
		if (managerPasspwrd == null || managerPasspwrd == "") {
			teacherLoginError.children("span").first().text("密码不能为空");
			teacherLoginError.css("display", "block");
			return;
		}
		var a = $.ajax({
			url : 'managerServlet',
			type : 'post',
			data : '{"managerName":"' + managerName + '","managerPassword":"' + managerPasspwrd + '","op":"login"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				if (data == "error") {
					teacherLoginError.children("span").first().text("用户名或密码错误");
					teacherLoginError.css("display", "block");
				} else{
					location.href = "http://localhost:8080/zujuanxitong/examServlet";
//					alert(data[0].examKind);
				/*	var jsonData = JSON.parse(data); 
					console.log(jsonData[0]);*/
				} 					
			}
		});
	});

	$(".login_button").click(function() {
		var teacherName = $('.login_page input[name=name]').val();
		var teacherPassword = $('.login_page input[name=password]').val();
		var teacherLoginError = $(".login_error").first();
		if (teacherName == null || teacherName == "") {
			teacherLoginError.children("span").first().text("教师名不能为空");
			teacherLoginError.css("display", "block");
			return;
		}
		if (teacherPassword == null || teacherPassword == "") {
			teacherLoginError.children("span").first().text("密码不能为空");
			teacherLoginError.css("display", "block");
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
					teacherLoginError.children("span").first().text("用户名或密码错误");
					teacherLoginError.css("display", "block");
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