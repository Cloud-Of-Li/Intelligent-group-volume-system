$(function() {
	if ($("#userName").text() == "") {
		location.href = "http://localhost:8080/zujuanxitong/login.html"
	}

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
		if ($(this).children("span").text() == "搜索单选题") {
			$("#search_danxuan").css("display", "block");
		} else if ($(this).children("span").text() == "搜索多选题") {
			$("#search_duoxuan").css("display", "block");
		} else if ($(this).children("span").text() == "搜索填空题") {
			$("#search_tiankong").css("display", "block");
		} else if ($(this).children("span").text() == "搜索判断题") {
			$("#search_panduan").css("display", "block");
		} else if ($(this).children("span").text() == "搜索简答题") {
			$("#search_jianda").css("display", "block");
		} else if ($(this).children("span").text() == "单选题列表") {
			$("#list_danxuan").css("display", "block");
		} else if ($(this).children("span").text() == "多选题列表") {
			$("#list_duoxuan").css("display", "block");
		} else if ($(this).children("span").text() == "填空题列表") {
			$("#list_tiankong").css("display", "block");
		} else if ($(this).children("span").text() == "判断题列表") {
			$("#list_panduan").css("display", "block");
		} else if ($(this).children("span").text() == "简答题列表") {
			$("#list_jianda").css("display", "block");
		} else if ($(this).children("span").text() == "试卷列表") {
			$("#list_shijuan").css("display", "block");
			
			
			
			
			
			
		} else if ($(this).children("span").text() == "智能组卷") {
			$("#add_zhineng_shijuan").css("display", "block");
		} else if ($(this).children("span").text() == "添加试题") {
			$("#add_shiti").css("display", "block");
		} else {
			//表示点击的是章节试题的其中一个
			var zhangjie = $(this).children("span").text();
			//			alert(zhangjie);
			$(".content_right_2").css("display", "block");
			$(".content_right_2").children("div").css("display", "none");
			$("." + zhangjie).css("display", "block");
		}

	})


	$(".input_check").click(function() {
		if ($(this).is(":checked")) {
			var abc = $(this).next().text();
			$("." + abc).css("display", "table-row");

		} else {
			var abc = $(this).next().text();
			$("." + abc).find("input").each(function() {
				$(this).val(0);
			})
			$("." + abc).css("display", "none");
		}

	})

	$('input[name="auto_nandu"]').click(function() {
		$(".tishi4nanduxishu").css("display", "none");
	})

	$("#danxuan_kecheng").click(function() {
		$(".tishi4nanduxishu").css("display", "none");
	})

	$("#submit4auto").click(function() {

		var totalScore = $('input[name="scores"]').val();

		var diffculty = $('input[name="auto_nandu"]').val();
		if (diffculty == "") {
			$(".tishi4nanduxishu span").text("*请输入正确的难度系数设定值");
			$(".tishi4nanduxishu").css("display", "table-cell");
			return;
		}

		var object = $("#danxuan_kecheng option:checked").text();

		if (object == "--请选择--") {
			$(".tishi4nanduxishu span").text("*请选择要组卷的课程");
			$(".tishi4nanduxishu").css("display", "table-cell");
			return;
		}
		if (totalScore == 0) {
			alert("组卷失败： 试卷总分为0，请重新规定试题");
			return;
		}

		alert("组卷成功!!!");
		var count_danxuan = $('input[name="count_danxuan"]').val();
		var count_duoxuan = $('input[name="count_duoxuan"]').val();
		var count_panduan = $('input[name="count_panduan"]').val();
		var count_tiankong = $('input[name="count_tiankong"]').val();
		var count_jianda = $('input[name="count_jianda"]').val();

		var score_danxuan = $('input[name="score_danxuan"]').val();
		var score_duoxuan = $('input[name="score_duoxuan"]').val();
		var score_panduan = $('input[name="score_panduan"]').val();
		var score_tiankong = $('input[name="score_tiankong"]').val();
		var score_jianda = $('input[name="score_jianda"]').val();

		var a = $.ajax({
			url : 'createPaperServlet',
			type : 'post',
			data : '{"count_danxuan":' + count_danxuan +
				',"count_duoxuan":' + count_duoxuan +
				',"count_panduan":' + count_panduan +
				',"count_tiankong":' + count_tiankong +
				',"count_jianda":' + count_jianda +
				',"score_danxuan":' + score_danxuan +
				',"score_duoxuan":' + score_duoxuan +
				',"score_panduan":' + score_panduan +
				',"score_tiankong":' + score_tiankong +
				',"score_jianda":' + score_jianda +
				',"diffculty":' + diffculty +
				',"totalScore":' + totalScore +
				',"op":"auto"}',
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				location.href = "http://localhost:8080/zujuanxitong/test.jsp";
			}
		});
	})

	$(".count_all").on("input", function() {

		var total_score = 0;
		if ($('input[name="count_danxuan"]').val() != "")
			total_score += $('input[name="count_danxuan"]').val() * $('input[name="score_danxuan"]').val();
		if ($('input[name="count_duoxuan"]').val() != "")
			total_score += $('input[name="count_duoxuan"]').val() * $('input[name="score_duoxuan"]').val();
		if ($('input[name="count_panduan"]').val() != "")
			total_score += $('input[name="count_panduan"]').val() * $('input[name="score_panduan"]').val();
		if ($('input[name="count_tiankong"]').val() != "")
			total_score += $('input[name="count_tiankong"]').val() * $('input[name="score_tiankong"]').val();
		if ($('input[name="count_jianda"]').val() != "")
			total_score += $('input[name="count_jianda"]').val() * $('input[name="score_jianda"]').val();
		$("#shijuanzongfen").val(total_score);
	/*alert(total_score);*/
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
	
	
	
	
	
/*=============================以下是添加部分=================================*/
	
	$("#list_shijuan_list2").click(function() {
		$("#tishi4nanduxishu2").css("display", "none");
	})
	
	
	
	
	
	/*按题型查找试题*/
	$(".class_search_input").click(function() {
		$(this).parents("td").parent("tr").next().children("td").css("display", "none");
	})
	
	$(".search_querenchazhao").click(function() {
		if($('input[name="search_danxuan_input"]').val() == "") {
			$(".sousuokuang").prev().css("display","table-cell");
			$(".sousuokuang").css("display","table-cell");
			return;
		}
		var leixing =$("#serch4leixing option:checked").val();
		var xingshi =$("#serch4xingshi option:checked").val();
		var xinxi = $(this).prev().val();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=search&leixing=" + leixing + "&search=" + xinxi + "&xingshi=" + xingshi;
	})
	
	
	/*查找试卷信息*/
	$(".querenchazhao").click(function() {
		var paperName = $("#list_shijuan_list2 option:checked").text();
		if (paperName == "--请选择--") {
			$("#tishi4nanduxishu2").css("display", "table-cell");
			return;
		}
		
		location.href = "http://localhost:8080/zujuanxitong/paperServlet?paperName=" + paperName;
	})
	
	
	
	/*添加试题*/
	$(".add_shiti_list").click(function() {
		$(this).parents("td").parent("tr").next().children("td").css("display", "none");
	})
	
	$("#add_shitineirong").click(function() {
		$("#tishi4neirong").css("display", "none");
	}) 
	
	
	$(".tianjaishiti").click(function() {
		var a = $("#shiti4kecheng option:checked").text();
		if (a == "--请选择--") {
			$("#tishi4kecheng").css("display", "table-cell");
			return;
		}
		
		a = $("#zhangjie option:checked").text();
		if (a == "--请选择--") {
			$("#tishi4zhangjie").css("display", "table-cell");
			return;
		}
		
		a = $("#leixing option:checked").text();
		if (a == "--请选择--") {
			$("#tishi4lexing").css("display", "table-cell");
			return;
		}
		
		a = $('input[name ="add_nandu"]').val();
		if(a == "" || a == 0) {
			$("#tishi4nandu").css("display", "table-cell");
			return;
		}
		
		a = $('input[name ="add_fenzhi"]').val();
		if(a == "" || a == 0) {
			$("#tishi4fenzhi").css("display", "table-cell");
			return;
		}
		
		a = $('textarea[name ="add_shitineirong"]').val();
		if(a == "") {
			$("#tishi4neirong").css("display", "table-cell");
			return;
		}
		
		a = $('input[name ="add_shiti_daan"]').val();
		if(a == "") {
			$("#tishi4daan").css("display", "table-cell");
			return;
		}
		alert("添加试题成功!!!");
		
		$("#form_add_shiti").attr("action", "examServlet?op=add");
		
	})
	
	
	
	
});














