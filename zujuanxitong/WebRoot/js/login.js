$(function() {
	$(".login_logo img").css("cursor", "pointer");
	$(".login_logo img").click(function() {
		location.href = "indexServlet";
	});

	$(".content_header span").first().click(function() {
		$(".content_header span").last().css("border-bottom", "3px solid #ccc");
		$(".content_header span").last().css("color", "#ccc")
		$(this).css("border-bottom", "3px solid rgb(85,166,206)");
		$(this).css("color", "rgb(85,166,206)")
		$(".adminLogin_page").hide();
		$(".login_page").show();
	});

	$(".content_header span").last().click(function() {
		$(".content_header span").first().css("border-bottom", "3px solid #ccc");
		$(".content_header span").first().css("color", "#ccc");
		$(this).css("border-bottom", "3px solid rgb(85,166,206)");
		$(this).css("color", "rgb(85,166,206)")
		$(".login_page").hide();
		$(".adminLogin_page").show();

	});

	$(".adminLogin_button").click(function() {
		var managementName = $('.adminLogin_page input[name=name]').val();
		var managementPassword = $('.adminLogin_page input[name=password]').val();
		var managementLoginError = $(".login_error").last();
		if (managementName == null || managementName == "") {
			managementLoginError.children("span").first().text("管理员名不能为空");
			managementLoginError.css("display", "block");
			return;
		}
		if (managementPassword == null || managementPassword == "") {
			managementLoginError.children("span").first().text("密码不能为空");
			managementLoginError.css("display", "block");
			return;
		}

		var a = $.ajax({
			url : 'managementServlet',
			type : 'post',
			data : '{"managementName":"' + managementName + '","managementPassword":"' + managementPassword + '","op":"login"}',
			//dataType:'json',   //指定返回值类型 */
			contentType : 'application/json;charset=utf-8',
			success : function(data, responseXML) {
				if (data == "error") {
					managementLoginError.children("span").first().text("用户名或密码错误");
					managementLoginError.css("display", "block");
				} else
					location.href = "http://localhost:8080/zujuanxitong/test.jsp";
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