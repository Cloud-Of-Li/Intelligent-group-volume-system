$(function() {

	$('input[name="delete_1_shiti"]').click(function() {
		/*$("#selecttoDel$").text($("input[name='delete_1_shiti']:checked").length);*/
		var len = $("input[name='delete_1_shiti']:checked").length;
		$("#selecttoDel").text(len);
	})


	$(".delet_select_shiti").click(function() {

		var examCheckBox = $("input[name='delete_1_shiti']:checked");
		var examidstr = $("input:checkbox[name='delete_1_shiti']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		var confirmdel = confirm('确认要删除吗?');
		if (confirmdel) {
			//开始请求删除  
			alert("删除成功");
			location.href = "http://localhost:8080/zujuanxitong/examServlet?op=deleteExam&examidstr="+examidstr;
		}

	})


});