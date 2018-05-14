$(function() {
	$('input[name="password').click(function() {
		$("#toCmpar").css("display","none");
	})
	
	$('input[name="comfirmpassword').click(function() {
		$("#toCmpar").css("display","none");
	})
	
	
	$('input[name="toc"]').click(function() {
		var teacherName = $('input[name=name]').val();
		var identity = $('input[name=identity]').val();
		var phone = $('input[name=number]').val();
		var password = $('input[name=password]').val();
		var comfirmPassword = $('input[name=comfirmpassword]').val();
		
		if(comfirmPassword != password) {
			$("#toCmpar").text("*两次输入的密码不同");
			$("#toCmpar").css("display","block");
			return;
		}
		
		
		var a = $.ajax({
			url : 'registerServlet',
			type : 'post',
			data : '{"teacherName":"' + teacherName 
					+ '","teacherPassword":"' + password 
					+ '","identity":"' + identity
					+ '","phone":"' + phone
					+ '","op":"changepsw"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				if (data == "id_error") {
					$("#toCmpar").text("*身份证号码不匹配");
					$("#toCmpar").css("display","block");
				} else if(data == "phone_error") {
					$("#toCmpar").text("*手机号码不匹配");
					$("#toCmpar").css("display","block");
				} else{
					alert("修改密码成功");
					location.href = "http://localhost:8080/zujuanxitong/login.html";
				} 					
			}
		});
	});
});