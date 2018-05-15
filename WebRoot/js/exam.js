$(function() {

	/*删除试题*/
	$('input[name="delete_1_shiti"]').click(function() {
		/*$("#selecttoDel$").text($("input[name='delete_1_shiti']:checked").length);*/
		var len = $("input[name='delete_1_shiti']:checked").length;
		$("#selecttoDel").text(len);
	})


	$(".delet_select_shiti").click(function() {

		var examCheckBox = $("input[name='delete_1_shiti']:checked");
		var examidstr = $("input:checkbox[name='delete_1_shiti']:checked").map(function(index, elem) {
			return $(elem).val();
		}).get().join('_');
		var confirmdel = confirm('确认要删除吗?');
		if (confirmdel) {
			//开始请求删除  
			alert("删除成功");
			location.href = "http://localhost:8080/zujuanxitong/examServlet?op=deleteExam&examidstr=" + examidstr;
		}

	})

	var isCheckAll = false;
	$("input[name='selectall_delete_shiti']").click(function() {
		if (isCheckAll) {
			$("input[name='delete_1_shiti']").each(function() {
				this.checked = false;
			});
			isCheckAll = false;
		} else {
			$("input[name='delete_1_shiti']").each(function() {
				this.checked = true;
			});
			isCheckAll = true;
		}
	})

	/*修改试题*/
	$(".a_update_exam").click(function() {
		var examid = $(this).parents("tr").children("td").eq(0).children("span").text();
		var examContent = $(this).parents("tr").children("td").eq(1).children("span").text();
		
		var examdegree = $(this).parents("tr").children("td").eq(1).children("span").eq(1).text();
		var examAnwser = $(this).parents("tr").children("td").eq(1).children("span").eq(2).text();
		var examchapter = $(this).parents("tr").children("td").eq(1).children("span").eq(3).text();
		var examkind = $(this).parents("tr").children("td").eq(1).children("span").eq(4).text();
		var examscore = $(this).parents("tr").children("td").eq(1).children("span").eq(5).text();
		var examDegree = $(this).parents("tr").children("td").eq(1).children("span").eq(6).text();
		var courseid = $(this).parents("tr").children("td").eq(1).children("span").eq(7).text();
		
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display", "none");
		$("#update_shiti_1").css("display", "block");
		
		$("input[name='update_examid'").val(examid);
		$("select[name='update_zhangjie'").val(examchapter);
		$("select[name='update_leixing'").val(examkind);
		$("select[name='update_kecheng'").val(courseid);
		$("input[name='update_nandu'").val(examdegree);
		$("input[name='update_fenzhi'").val(examscore);
		$("input[name='update_shiti_daan'").val(examAnwser);
		$("input[name='update_shiti_daan'").val(courseid);
		$("textarea[name='update_shitineirong_name'").text(examContent);
	})
	
	$(".up_confirm").click(function() {
		var examid = $("input[name='update_examid'").val();
		alert("试题修改成功!!!");
		$("#form_update_shiti").attr("action", "examServlet?op=updateExamforDB&examid=" + examid);
		
	})
	

	$(".returnbacktoupexam").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#update_shiti").css("display", "block");
		$("#update_shiti_1").css("display", "none");
	})

});