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
		var coursename = $(this).parents("tr").children("td").eq(2).children("span").text();
		var examAnswer = $(this).parents("tr").children("td").eq(3).children("span").text();
		var examChapter = $(this).parents("tr").children("td").eq(4).children("span").text();
		var examkind = $(this).parents("tr").children("td").eq(5).children("span").text();
		var examScore = $(this).parents("tr").children("td").eq(6).children("span").text();
		var examdegree = $(this).parents("tr").children("td").eq(7).children("span").text();
		alert(coursename);
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display", "none");
		$("#update_shiti_1").css("display", "block");
		$("input[name='update_examid'").val(examid);
		$("input[name='update_nandu'").val(examdegree);
		$("#up_shiti4kecheng").val(coursename);
		$("#up_zhangjie").val(examChapter);
		$("#up_leixinge").val(examdegree);
		
		
		
		
		
		
		
		
		

	})

	$(".returnbacktoupexam").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#update_shiti").css("display", "block");
		$("#update_shiti_1").css("display", "none");
	})

});