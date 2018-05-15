$(function() {
	
	$('input[name="delete_1_shiti"]').click(function() {
		/*$("#selecttoDel$").text($("input[name='delete_1_shiti']:checked").length);*/
		var len = $("input[name='delete_1_shiti']:checked").length;
		$("#selecttoDel").text(len);
		/*alert($(this).val());*/
	})
	
});





















