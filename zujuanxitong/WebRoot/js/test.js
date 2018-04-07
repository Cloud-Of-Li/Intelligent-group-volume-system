$(function() {
	$("#exit a").mouseover(function() {
		$("#exit a").css("color", "red");
	})
	$("#exit a").mouseout(function() {
		$("#exit a").css("color", "pink");
	})
	$(".menue").mouseover(function() {
		$(".menue").css("background-color", "#174C76");
		$(".menue").css("color", "white");

	})

	$(".menue").mouseout(function() {
		$(".menue").css("background", "url('../image/contentjianbian2.jpg')");
		$(".menue").css("color", "black");
	})

	$(".houtai_coment_all").mouseout(function() {
		$(this).css("background", "url('../image/contentjianbian2.jpg')");
		$(this).css("color", "black");
		
	})

	$(".houtai_coment_all").mouseover(function() {
		$(this).css("background-color", "#174C76");
		$(this).css("color", "white");
	})


	$(".houtai_keyan_all").mouseover(function() {
		$(".houtai_keyan_all").css("background-color", "#174C76");
		$(".houtai_keyan_all").css("color", "white");
	})

	$(".houtai_keyan_all").mouseout(function() {
		$(".houtai_keyan_all").css("background", "url('../image/contentjianbian2.jpg')");
		$(".houtai_keyan_all").css("color", "black");
	})



	$(".houtai_coment_all").click(function() {
		/*$(".houtai_all").css("display", "none");*/
		if ($(this).next().css("display") == "none") {
			$(this).next().show();
		} else {
			$(this).next().hide();
		}
	})
	
	
	
	


	$(".menue").click(function() {
		$(".content_right_1").css("display", "block");
		$(".content_right").css("display", "none");
		$(".content_right_2").css("display", "none");
	})

	$(".houtai_all_neirong").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		if($(this).children("span").text() == "添加单选题") {
			$("#add_danxuan").css("display", "block");
		} else if($(this).children("span").text() == "添加多选题"){
			$("#add_duoxuan").css("display", "block");
		} else if($(this).children("span").text() == "添加填空题"){
			$("#add_tiankong").css("display", "block");
		} else if($(this).children("span").text() == "添加判断题"){
			$("#add_panduan").css("display", "block");
		} else if($(this).children("span").text() == "添加简答题"){
			$("#add_jianda").css("display", "block");
		} else if($(this).children("span").text() == "单选题列表"){
			$("#list_danxuan").css("display", "block");
			
//			var a = $.ajax({
//				url : 'examServlet',
//				type : 'post',
//				data : '{"examkind":"danxuan"}',
//				/* dataType:'json',   //指定返回值类型 */
//				contentType : 'application/json;charset=utf-8',
//				success : function(data) {
//					var jsonData = JSON.parse(data); 
//					console.log(jsonData[0]);
//					alert(jsonData[0].examId);
//				}
//			});
			
			
			
		} else if($(this).children("span").text() == "多选题列表"){
			$("#list_duoxuan").css("display", "block");
		} else if($(this).children("span").text() == "填空题列表"){
			$("#list_tiankong").css("display", "block");
		} else if($(this).children("span").text() == "判断题列表"){
			$("#list_panduan").css("display", "block");
		} else if($(this).children("span").text() == "简答题列表"){
			$("#list_jianda").css("display", "block");
		} else if($(this).children("span").text() == "试卷列表"){
			$("#list_shijuan").css("display", "block");
		} else if($(this).children("span").text() == "智能组卷"){
			$("#add_zhineng_shijuan").css("display", "block");
		} else if($(this).children("span").text() == "手动组卷"){
			$("#add_shoudong_shijuan").css("display", "block"); 
		}else {
			//表示点击的是章节试题的其中一个
			var zhangjie = $(this).children("span").text();
//			alert(zhangjie);
			$(".content_right_2").css("display","block");
			$(".content_right_2").children("div").css("display","none");
			$("."+zhangjie).css("display", "block");
		}
		
	})


	$(".input_check").click(function() {
		if ($(this).is(":checked")) {
			var abc = $(this).next().text();
			$("."+abc).css("display","table-row");

		} else {
			var abc = $(this).next().text();
			$("."+abc).css("display","none");
		}
		
	})















	$(".houtai_approve_prj").click(function() {
		$(".content4houtai span").text("项目申请");
	})
	$(".houtai_add_prj").click(function() {
		$(".content4houtai span").text("立项统计");
	})

	$(".houtai_end_prj").click(function() {
		$(".content4houtai span").text("结题查询");
	})
	$(".houtai_achieve_prj").click(function() {
		$(".content4houtai span").text("科研成果");
	})



	$(".houtai_all_neirong").mouseout(function() {
		$(this).css("color", "black");
	})
	$(".houtai_all_neirong").mouseover(function() {
		$(this).css("color", "red");
	})

	$(".houtai_approve_prj").click(function() {
		$(".content_right_0").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})



	$(".houtai_add_prj").mouseout(function() {
		$(".houtai_add_prj").css("color", "black");
	})
	$(".houtai_add_prj").mouseover(function() {
		$(".houtai_add_prj").css("color", "red");
	})
	$(".houtai_add_prj").click(function() {
		$(".content_right_2").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})





	$(".houtai_end_prj").mouseout(function() {
		$(".houtai_end_prj").css("color", "black");
	})
	$(".houtai_end_prj").mouseover(function() {
		$(".houtai_end_prj").css("color", "red");
	})
	$(".houtai_end_prj").click(function() {
		$(".content_right_3").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})






	$(".houtai_achieve_prj").mouseout(function() {
		$(".houtai_achieve_prj").css("color", "black");
	})
	$(".houtai_achieve_prj").mouseover(function() {
		$(".houtai_achieve_prj").css("color", "red");
	})
	$(".houtai_achieve_prj").click(function() {
		$(".content_right_4").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_5").css("display", "none");

	})

	$(".shenqing").click(function() {
		var projectTitle = $('.ptitle input[name=ptitleName]').val();
		var projectContent = $('.pcontent input[name=pcontentName]').val();
		var ptitleError = $(".error").val();

		if (projectTitle == null || projectTitle == "") {
			ptitleError.css("display", "block");
			return;
		}

		alert("申请成功");
		var a = $.ajax({
			url : 'projectServlet',
			type : 'post',
			data : '{"projectTitle":"' + projectTitle + '","projectContent":"' + projectContent + '","op":"add"}',
			/* dataType:'json',   //指定返回值类型 */
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				location.href = "http://localhost:8080/Gaoxiaokeyan/teacher.jsp";
			}
		});
	});







});