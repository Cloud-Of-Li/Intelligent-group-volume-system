$(function() {
	
	
	$.getUrlParam = function(name) {  
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");  
		var r = window.location.search.substr(1).match(reg);  
		if (r!=null) return decodeURI(r[2]); return null;  
	}
	
	/*function toRed(content,fanwei){
        var bodyHtml = $("body").html();
        var x = bodyHtml.replace(new RegExp(content,"gm"),"<font color='red' size='18px' >"+content+"</font>")
        $("body").html(x);
    }*/
	
	function highlight(xuanze){ 
      clearSelection();//先清空一下上次高亮显示的内容； 
      var searchText = xinxi;//获取你输入的关键字； 
      var regExp = new RegExp(searchText, 'g');//创建正则表达式，g表示全局的，如果不用g，则查找到第一个就不会继续向下查找了； 
      $(xuanze).each(function() {//遍历文章； 
        var html = $(this).html(); 
        var newHtml = html.replace(regExp, '<span style="background-color:yellow">'+searchText+'</span>');//将找到的关键字替换，加上highlight属性； 
   
        $(this).html(newHtml);//更新文章； 
      }); 
    } 
    function clearSelection(xuanze){ 
      $(xuanze).each(function(){//遍历 
        $(this).find('.highlight').each(function()//找到所有highlight属性的元素； 
        { 
          $(this).replaceWith($(this).html());//将他们的属性去掉； 
        }); 
      }); 
    } 
	
	
	
	var op = $.getUrlParam('op');
	var xingshi = $.getUrlParam('xingshi');
	var foronekecheng = $.getUrlParam('kecheng');
	var leixing = $.getUrlParam('leixing');
	
	
	/*表示是现在的操作是搜索*/
	if(op == "search") {
		$("#shijuanlistId").css("display" ,"block");
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#search_danxuan").css("display", "block");
		
		if (xingshi == "1") {
			var xinxi = $.getUrlParam('search');
			clearSelection(".searched_content");
			highlight(".searched_content");
		} else if (xingshi == "3") {
			var xinxi = $.getUrlParam('search');
			clearSelection(".searched_score");
			highlight(".searched_score");
		} else if(xingshi == "2") {
			var xinxi = $.getUrlParam('search');
			clearSelection(".searched_nandu");
			highlight(".searched_nandu");
		} 
	} else if(op == "paper" || op == "paper4manager") {
		$("#shijuanlistId").css("display" ,"block");
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#list_shijuan").css("display", "block");
	} else if(op == "list") {
		 if(leixing == "单选题") {
			$("#shitilistId").css("display", "block");
			$(".content_right").css("display", "none");
			$(".content_right_1").css("display", "none");
			$(".content_right_2").css("display", "none");
			$("#list_danxuan").css("display", "block");
		 }else if(leixing == "多选题") {
				$("#shitilistId").css("display", "block");
				$(".content_right").css("display", "none");
				$(".content_right_1").css("display", "none");
				$(".content_right_2").css("display", "none");
				$("#list_duoxuan").css("display", "block");
		 } else if(leixing == "判断题") {
				$("#shitilistId").css("display", "block");
				$(".content_right").css("display", "none");
				$(".content_right_1").css("display", "none");
				$(".content_right_2").css("display", "none");
				$("#list_panduan").css("display", "block");
		 }else  if(leixing == "填空题") {
				$("#shitilistId").css("display", "block");
				$(".content_right").css("display", "none");
				$(".content_right_1").css("display", "none");
				$(".content_right_2").css("display", "none");
				$("#list_tiankong").css("display", "block");
		 }else  if(leixing == "简答题") {
				$("#shitilistId").css("display", "block");
				$(".content_right").css("display", "none");
				$(".content_right_1").css("display", "none");
				$(".content_right_2").css("display", "none");
				$("#list_jianda").css("display", "block");
		 }
	}
	
	
	
	
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
		$(".content_right_1_update").css("display", "none");
		if ($(this).children("span").text() == "搜索试题") {
			$("#search_danxuan").css("display", "block");
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
			dataType:'json',
			data : '{"count_danxuan":' + count_danxuan +
				',"count_duoxuan":' + count_duoxuan +
				',"count_panduan":' + count_panduan +
				',"count_tiankong":' + count_tiankong +
				',"count_jianda":' + count_jianda +
				',"op":"ifcreate"}',
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				var jsonData = data;
				if(jsonData.flag == "danxuan_error") {
					$("#chucuola span").text("*组卷出错，题库单选题数量不足" + count_danxuan + "个," + "单选题数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ; 
				} else if(jsonData.flag == "duoxuan_error") {
					$("#chucuola span").text("*组卷出错，题库多选题数量不足" + count_duoxuan + "个," + "多选题数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ;
				}  else if(jsonData.flag == "tiankong_error") {
					$("#chucuola span").text("*组卷出错，题库填空题数量不足" + count_tiankong + "个," + "填空题数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ;
				}  else if(jsonData.flag == "panduan_error") {
					$("#chucuola span").text("*组卷出错，题库判断题数量不足" + count_panduan + "个," + "判断题数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ;
				}  else if(jsonData.flag == "jianda_error") {
					$("#chucuola span").text("*组卷出错，题库简答题数量不足" + count_jianda + "个," + "简答题数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ;
				} else {
					alert("组卷成功!!!");
					var b = $.ajax({
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
							location.href = "http://localhost:8080/zujuanxitong/examServlet";
						}
					});
				}
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
		var kecheng = $("#serch4kecheng option:checked").val();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=search&leixing=" + leixing + "&search=" + xinxi + "&xingshi=" + xingshi+ "&kecheng=" + kecheng;
	})
	
	
	/*查找试卷信息*/
	$(".querenchazhao").click(function() {
		var paperName = $("#list_shijuan_list2 option:checked").text();
		if (paperName == "--请选择--") {
			$("#tishi4nanduxishu2").css("display", "table-cell");
			return;
		}
		
		location.href = "http://localhost:8080/zujuanxitong/paperServlet?op=paper4manager&paperName=" + paperName;
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
		
		$("#form_add_shiti").attr("action", "mexamServlet?op=add");
		
	})
	
	/**/

	
	$("#danxuan_search_querenchazhao").click(function() {
		var kecheng = $("#danxuan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=list&kecheng=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#duoxuan_search_querenchazhao").click(function() {
		var kecheng = $("#duoxuan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=list&kecheng=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#panduan_search_querenchazhao").click(function() {
		var kecheng = $("#panduan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=list&kecheng=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#tiankong_search_querenchazhao").click(function() {
		var kecheng = $("#tiankong_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=list&kecheng=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#jianda_search_querenchazhao").click(function() {
		var kecheng = $("#jianda_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=list&kecheng=" + kecheng + "&leixing=" + leixing;
	})
	
	$(".foronekecheng").text(foronekecheng);
	
	
	$(".delete_teacher").click(function() {
		var teacherName = $(this).parents("tr").children("td").eq(1).children("pre").text();
		var teacherid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		var flag = confirm("确定删除吗? 提示：删除之后无法恢复!!!");
		if(flag) {
			alert("确认删除 " + teacherName + "老师!!!");
			location.href = "http://localhost:8080/zujuanxitong/mexamServlet?op=delete&teacherid=" + teacherid;
		}
	})
	
	
	$(".update_teacher").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display","block");
		var teacherName = $(this).parents("tr").children("td").eq(1).children("pre").text();
		var teacherid = $(this).parents("tr").children("td").eq(0).children("pre").text();
		var teacherphone = $(this).parents("tr").children("td").eq(5).children("pre").text();
		var teacherid_4 = $('input[name="update_teacherid"]').val(teacherid);
		var teachername_4 = $('input[name="update_teachername"]').val(teacherName);
		var teacherphoto_4 = ($("#update_teacherphoto").attr('src',"image/"+ teacherName +".jpg"));
		var teacherphone_4 = ($('input[name="update_teacherphone"]').val(teacherphone));
		
	})
	
	$("#queren_update").click(function() {
		var teacherid = $('input[name="update_teacherid"]').val();
		var teachername = $('input[name="update_teachername"]').val();
		var teachersex = $('input[name="selector2"]:checked').val();
		var teachermajorid = $('#update_major option:checked').val();
		
		if(teachersex == null) {
			$("#jiaohsixingbiequeren").prev().css("display","table-cell");
			$("#jiaohsixingbiequeren").css("display","table-cell");
			return;
		}
		
		var techercourseid = $("input:checkbox[name='chc_kecheng']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		if(techercourseid == '') {
			$("#suojiaokechengqueren").prev().css("display","table-cell");
			$("#suojiaokechengqueren").css("display","table-cell");
			return;
		}
		
		var teacherphone = $('input[name="update_teacherphone"]').val();
		if(teacherphone == "") {
			$("#dianhuaqueren").prev().css("display","table-cell");
			$("#dianhuaqueren").children("span").text("*请输入电话号码！");
			$("#dianhuaqueren").css("display","table-cell");
			return;
		} else if(!teacherphone.match(/^(((13[0-9]{1})|159|153|(18[0-9]{1}))+\d{8})$/)) { 
			$("#dianhuaqueren").prev().css("display","table-cell");
			$("#dianhuaqueren").children("span").text("*该电话号码不存在！");
			$("#dianhuaqueren").css("display","table-cell");
			return;
		}
		
		var a = $.ajax({
			
			url : 'mexamServlet?op=update',
			type : 'post',
			data : '{"teacherid":"' + teacherid + '","teachername":"' + teachername + '","teachersex":"' + teachersex 
					+ '","teacherphone":"' +teacherphone + '","techercourse":"' + techercourseid + '","teachermajorid":"' + teachermajorid +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("教师信息修改成功！！！！");
					location.href = "http://localhost:8080/zujuanxitong/mexamServlet";
			}
		});
		
		
		
	})
	 $('input[name="update_teacherphone"]').click(function() {
		 	$("#dianhuaqueren").prev().css("display","none");
			$("#dianhuaqueren").css("display","none");
	 })
	
	 $("input:checkbox[name='chc_kecheng']").click(function() {
		 	$("#suojiaokechengqueren").prev().css("display","none");
			$("#suojiaokechengqueren").css("display","none");
	 })
	
	$('input[name="selector2"]').click(function() {
		 	$("#jiaohsixingbiequeren").prev().css("display","none");
			$("#jiaohsixingbiequeren").css("display","none");
	 })
	
	
	
	
	
});





















