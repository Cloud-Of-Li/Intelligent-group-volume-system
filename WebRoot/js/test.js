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
	var leixing = $.getUrlParam('leixing');
	var foronekecheng = $.getUrlParam('courseName');
	
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
	} else if(op == "paper") {
		$("#shijuanlistId").css("display" ,"block");
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#list_shijuan").css("display", "block");
	}  else if(op == "paperlist") {
		$("#shijuanlistId").css("display" ,"block");
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$("#list_shijuan_daan").css("display", "block");
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
	
	
	
	$("#logout").click(function() {
		var a = $.ajax({
			url : 'teacherServlet',
			type : 'post',
			data : '{"op":"logout"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					location.href = "http://localhost:8080/zujuanxitong/login.html";
			}
		});
		
	})
	
	
	
	
	
	
	
	

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
		$(".menue").css("color", "white");
	})

	$(".houtai_coment_all").mouseout(function() {
		$(this).css("background", "url('../image/contentjianbian2.jpg')");
		$(this).css("color", "white");

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
		$(".houtai_keyan_all").css("color", "white");
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
		$(".content_right_1_update").css("display", "none");
	})

	$(".houtai_all_neirong").click(function() {
		$(".content_right").css("display", "none");
		$(".content_right_1").css("display", "none");
		$(".content_right_2").css("display", "none");
		$(".content_right_1_update").css("display", "none");
		if ($(this).children("span").text() == "搜索试题") {
			$("#search_danxuan").css("display", "block");
		} else if ($(this).children("span").text() == "题型添加") {
			$("#add_parten").css("display", "block");
		}  else if ($(this).children("span").text() == "题型列表") {
			$("#list_parten").css("display", "block");
		} else if ($(this).children("span").text() == "试卷列表") {
			$("#list_shijuan").css("display", "block");
		}  else if ($(this).children("span").text() == "试卷答案") {
			$("#list_shijuan_daan").css("display", "block");
		} else if ($(this).children("span").text() == "智能组卷") {
			$("#add_zhineng_shijuan").css("display", "block");
		} else if ($(this).children("span").text() == "添加试题") {
			$("#add_shiti").css("display", "block");
		} else if ($(this).children("span").text() == "试题删除") {
			$("#delete_shiti").css("display", "block");
		}  else if ($(this).children("span").text() == "修改试题") {
			$("#update_shiti").css("display", "block");
		} else {
			//表示点击的是章节试题的其中一个
			var zhangjie = $(this).children("span").text();
			//			alert(zhangjie);
			$(".content_right_2").css("display", "block");
			$(".content_right_2").children("div").css("display", "none");
			$("." + zhangjie).css("display", "block");
		}

	})


	$('input[name="auto_nandu"]').click(function() {
		$(".tishi4nanduxishu").css("display", "none");
	})

	$("#danxuan_kecheng").click(function() {
		$(".tishi4nanduxishu").css("display", "none");
	})

	
	/*试题查询*/
		
	$("#danxuan_search_querenchazhao").click(function() {
		var kecheng = $("#danxuan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=list&courseName=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#duoxuan_search_querenchazhao").click(function() {
		var kecheng = $("#duoxuan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=list&courseName=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#panduan_search_querenchazhao").click(function() {
		var kecheng = $("#panduan_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=list&courseName=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#tiankong_search_querenchazhao").click(function() {
		var kecheng = $("#tiankong_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=list&courseName=" + kecheng + "&leixing=" + leixing;
	})
	
	$("#jianda_search_querenchazhao").click(function() {
		var kecheng = $("#jianda_serch4kecheng option:checked").val();
		var leixing = $(this).children("span").text();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=list&courseName=" + kecheng + "&leixing=" + leixing;
	})
	
	
	$(".foronekecheng").text(foronekecheng);
	
	
	var pertenlen = $("input[name='input_checkbox']:checked").length;

	
	$("#submit4auto").click(function() {

		var totalScore = $('input[name="scores"]').val();

		var diffculty = $('input[name="auto_nandu"]').val();
		if (diffculty == "") {
			$(".tishi4nanduxishu span").text("*请输入正确的难度系数设定值");
			$(".tishi4nanduxishu").css("display", "table-cell");
			return;
		}
		var partenstr = $("input:checkbox[name='input_checkbox']:checked").map(function(index,elem) {
            return $(elem).val();
        }).get().join('_');
		
		var pratenCount = $("input[name='input_checkbox']:checked").map(function(index,elem) {
			return ($('input[name="count_'+$(elem).val()+'"]').val());
		}).get().join('_');
		
		var pratenScore = $("input[name='input_checkbox']:checked").map(function(index,elem) {
			return ($('input[name="score_'+$(elem).val()+'"]').val());
		}).get().join('_');
		
		/*alert(partenstr +"-----"+ pratenCount+"-----"+pratenScore);*/

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

		/*var count_danxuan = $('input[name="count_danxuan"]').val();
		var count_duoxuan = $('input[name="count_duoxuan"]').val();
		var count_panduan = $('input[name="count_panduan"]').val();
		var count_tiankong = $('input[name="count_tiankong"]').val();
		var count_jianda = $('input[name="count_jianda"]').val();

		var score_danxuan = $('input[name="score_danxuan"]').val();
		var score_duoxuan = $('input[name="score_duoxuan"]').val();
		var score_panduan = $('input[name="score_panduan"]').val();
		var score_tiankong = $('input[name="score_tiankong"]').val();
		var score_jianda = $('input[name="score_jianda"]').val();*/
		
		var courseName = $("#danxuan_kecheng option:checked").val();

		var a = $.ajax({
			url : 'createPaperServlet',
			type : 'post',
			dataType:'json',
			data : '{"courseName":"' + courseName +
				'","partenstr":"' + partenstr +
				'","pratenCount":"' + pratenCount +
				'","pratenScore":"' + pratenScore +
				'","op":"ifcreate"}',
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
				var jsonData = data;
				if(jsonData.flag != "ok") {
					$("#chucuola span").text("*组卷出错，题库" + data.flag + "数量不足" + data.num_error + "个," 
							+ courseName +""+data.flag+"数量共" + jsonData.num  + "个," + "请输入小于" + jsonData.num +"的值");
					$("#chucuola").css("display","table-cell");
					return ; 
				} else {
					alert("组卷成功!!!");
					var b = $.ajax({
						url : 'createPaperServlet',
						type : 'post',
						data : '{"courseName":"' + courseName +
							'","partenstr":"' + partenstr +
							'","pratenCount":"' + pratenCount +
							'","pratenScore":"' + pratenScore +
							'","diffculty":' + diffculty +
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

	/*获取试卷总分*/
	$(".count_all").on("input", function() {
		var total_score = 0;

		var adIds={};
		var partens = $("input[name='input_checkbox']:checked").each(function(i) {
			adIds[i]=$(this).val();
			if ($('input[name="count_'+adIds[i]+'"]').val() != "")
				total_score += $('input[name="count_'+adIds[i]+'"]').val() * $('input[name="score_'+adIds[i]+'"]').val();
			$("#shijuanzongfen").val(total_score);
		})
	/*alert(total_score);*/
	})


	$(".houtai_all_neirong").mouseout(function() {
		$(this).css("color", "white");
	})
	$(".houtai_all_neirong").mouseover(function() {
		$(this).css("color", "red");
	})
	
	/*=============================以下是添加部分=================================*/
	
	$("#list_shijuan_list2").click(function() {
		$("#tishi4nanduxishu2").css("display", "none");
	})
	
	$("#list_shijuan_list2_daan").click(function() {
		$("#tishi4nanduxishu2_daan").css("display", "none");
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
		var courseName = $("#serch4kecheng option:checked").val();
		location.href = "http://localhost:8080/zujuanxitong/examServlet?op=search&leixing=" + leixing + "&search=" + xinxi + "&xingshi=" + xingshi + "&courseName=" + courseName;
	})
	
	
	/*查找试卷信息*/
	$(".querenchazhao").click(function() {
		var paperName = $("#list_shijuan_list2 option:checked").text();
		if (paperName == "--请选择--") {
			$("#tishi4nanduxishu2").css("display", "table-cell");
			return;
		}
		
		location.href = "http://localhost:8080/zujuanxitong/paperServlet?op=paper&paperName=" + paperName;
	})
	/*查找试卷答案信息*/
	$(".querenchazhao_daan").click(function() {
		var paperName = $("#list_shijuan_list2_daan option:checked").text();
		if (paperName == "--请选择--") {
			$("#tishi4nanduxishu2").css("display", "table-cell");
			return;
		}
		
		location.href = "http://localhost:8080/zujuanxitong/paperServlet?op=paperlist&paperName=" + paperName;
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
	
	/**/

	/*修改教师信息*/
		$(".update_teacher").click(function() {
			$(".content_right").css("display", "none");
			$(".content_right_1").css("display", "none");
			$(".content_right_2").css("display", "none");
			$(".content_right_1_update").css("display","block");
		})
	
	$("#queren_update").click(function() {
		var teacherid = $('input[name="update_teacherid"]').val();
		var teachername = $('input[name="update_teachername"]').val();
		var teachersex = $('input[name="selector2"]:checked').val();
		var teachermajorid = $('#input[name="update_major"]').val();
		
		if(teachersex == null) {
			$("#jiaohsixingbiequeren").prev().css("display","table-cell");
			$("#jiaohsixingbiequeren").css("display","table-cell");
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
			
			url : 'examServlet?op=update',
			type : 'post',
			data : '{"teacherid":"' + teacherid + '","teachername":"' + teachername + '","teachersex":"' + teachersex 
					+ '","teacherphone":"' +teacherphone +'"}',
			//dataType:'json',   //指定返回值类型 
			contentType : 'application/json;charset=utf-8',
			success : function(data) {
					alert("教师信息修改成功！！！！");
					var b = $.ajax({
						
						url : 'teacherServlet',
						type : 'post',
						data : '{"op":refresh,' + data,
						//dataType:'json',   //指定返回值类型 
						contentType : 'application/json;charset=utf-8',
						success : function(data) {
								location.href = "http://localhost:8080/zujuanxitong/examServlet";
						}
					})
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
	
	 /*添加题型*/
	 $("#queren_addparten").click(function(){
		 var partenName = $('input[name="add_parten"]').val();
		 if(partenName.replace(/(^\s*)|(\s*$)/g, "")=="") {
				alert("题型名称不能为空");
				return;
			}
		 var a = $.ajax({
				
				url : 'examServlet?op=addParten&partenName=' + partenName,
				type : 'post',
				contentType : 'application/json;charset=utf-8',
				success : function(data) {
					console.log(data);
					if(data != "ok") {
						alert("添加失败，题型已存在");
					} else{
						alert("题型添加成功");
						location.href = "http://localhost:8080/zujuanxitong/examServlet";
					}
				}
			});
		 
		 
		 
		 
	 })
	 
	 
	
	//智能组卷中组卷要求的显示（单选题，多选题。。。）
	$(".input_check").click(function() {
		pertenlen = $("input[name='input_checkbox']:checked").length;
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
	
	
	
	
	
	
});





















