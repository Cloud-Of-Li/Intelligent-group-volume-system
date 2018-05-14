$(function() {


	$(".menue").click(function() {
		$(".content_right_1").css("display", "block");
		$(".content_right").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display", "none");
		$(".content_right_1_add").css("display", "none");
		$(".content_right_course_add").css("display", "none");
		$(".content_right_update_course").css("display", "none");
	})

	$(".houtai_all_neirong").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display", "none");
		$(".content_right_1_add").css("display", "none");
		$(".content_right_course_add").css("display", "none");
		if ($(this).children("span").text() == "搜索试题") {
			$("#search_danxuan").css("display", "block");
		} else if ($(this).children("span").text() == "课程列表") {
			$("#list_kecheng").css("display", "block");
		} else if ($(this).children("span").text() == "多选题列表") {
			$("#list_duoxuan").css("display", "block");
		} else if ($(this).children("span").text() == "试卷列表") {
			$("#list_shijuan").css("display", "block");
		} else if ($(this).children("span").text() == "试卷清理") {
			$("#delete_zhineng_shijuan").css("display", "block");
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



	$(".houtai_approve_prj").click(function() {
		$(".content_right_0").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})
	
	$(".houtai_add_prj").click(function() {
		$(".content_right_2").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})
	
	$(".houtai_end_prj").click(function() {
		$(".content_right_3").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_4").css("display", "none");
		$(".content_right_5").css("display", "none");

	})
	$(".houtai_achieve_prj").click(function() {
		$(".content_right_4").css("display", "block");
		$(".content_right_1").css("display", "none");
		$(".content_right_0").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_3").css("display", "none");
		$(".content_right_5").css("display", "none");

	})
	
});





















