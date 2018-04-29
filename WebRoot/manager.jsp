<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script src='js/manager.js'></script>
	<link rel="stylesheet" type="text/css" href="css\manager.css">
	<title>智能组卷系统</title>
</head>
<body>
	<div class="tite">
		<div class="coment_all">
			<div id="exit">
			<span id="userName">${sessionScope.manager.managerName }</span>
				<a href="login.html">退出</a></div>
			<div class="coment">智能组卷系统</div>
		</div>
	</div>
	<div class="content">

	<!-- ==========================以下是左边部分=====================================-->


		<div class="content_left">
		
		<!-- 教师信息部分 -->
			<div class="menue">
				教师信息		
			</div>

		<!-- 后台管理部分 -->
			<div class="houtai">
			
				
			<!-- 后台内容==单选题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						题库管理
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>添加试题</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>搜索试题</span>
						</div>
					</div>
				</div>

			<!-- 后台内容==多选题 -->
				 <div class="houtai_coment">
					<div class="houtai_coment_all">
						试题列表
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>单选题列表</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>多选题列表</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>填空题列表</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>判断题列表</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>简答题列表</span>
						</div>
					</div>
				</div>

			<!-- 后台内容==试卷组成 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						试卷组成
					</div>
					<div class="houtai_all" id="shijuanlistId">

						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>试卷清理</span>
						</div>

						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="folder" src="image/folder.png">-><span>试卷列表</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	<!-- =============================================================================以下是右边部分=================================================================-->

	<!-- 教师信息 -->
		<div class="content_right_1">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>教师信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<table class="table_infomations_teacher">
						<tr>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师编号</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师姓名</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师性别</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所属专业</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所教课程</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师电话</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">相关操作 </th>		
						</tr>
						<c:forEach items="${teacherlist}" var="teacher" >
						
						<tr>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherId()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherName()}</pre>	
								</td>								
								<td>
									<c:if >
										
									</c:if>	
								</td>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherId()}</pre>	
								</td>	
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherPhone()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherId()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red">删除</a> | <a style="color: red">修改</a></pre>	
								</td>
						</tr>
						</c:forEach>
					</table>
				</div>
	
			</div>
	
		</div>
	
	
		
	<!-- 单选题列表 -->
		<div class="content_right" id="list_danxuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>单选题列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
			<c:forEach items="${danxuan_exam}" var="danxuan_exam_var" >
				<div class="content_main_content">
					<form method="post" action="javascript:void(0)">
					<table class="table_infomations_list">
						<tr>
							<th>所属课程:</th>
							<td>
								<select name="search_xingshi"  id="serch4xingshi">
										<option value="1" >&nbsp;&nbsp;离散数学&nbsp;&nbsp;</option>
										<option value="2" >&nbsp;&nbsp;计算机组成原理&nbsp;&nbsp;</option>
										<option value="3" >&nbsp;&nbsp;高等数学&nbsp;&nbsp;</option>
								</select>
								<button class="search_querenchazhao">确认查找</button>
							</td>
						</tr>
						
						
						
						<tr>
							<td colspan="3" style="height:30px; padding:0 100px;"><hr></td>
						</tr>
						
						
											
						<c:if test="${examforSeacher.size() != 0}">
							<c:set var="x" value="0"/>
							<c:forEach items="${examforSeacher}" var="examforSeacher_var" >
								<c:set var="x" value="${x+1 }"/>
									<tr>
											<th class="th4neirong">试题内容：</th>
											<td>
												<pre style="font-size: 18px" class="searched_content">${x }.  ${examforSeacher_var.getExamContent() }</pre>	
											</td>
									</tr>
									<tr>
											<th class="th4neirong">试题难度：</th>
											<td>
												<pre style="font-size: 18px" class="searched_nandu">${examforSeacher_var.getExamDegree() }</pre>	
											</td>
									</tr>
									<tr>
											<th class="th4neirong">试题分数：</th>
											<td>
												<pre style="font-size: 18px" class="searched_score">${examforSeacher_var.getExamScore() }</pre>	
											</td>
									</tr>
									<tr>
										<td colspan="3" style="height:30px; padding:0 100px;"><hr></td>
									</tr>
							</c:forEach>
						</c:if>
						
						
						
					</table>
					</form>
				</div>
	
			</div>
	
		</div>		
		
	<!-- 多选题列表 -->
		<div class="content_right" id="list_duoxuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>多选题列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<c:forEach items="${duoxuan_exam}" var="duoxuan_exam_var" >
					<div class="content_main_content">
						<table class="table_infomations_list">
							
							<tr>
									<th class="th4neirong">试题内容：</th>
									<td>
										<pre style="font-size: 18px">${duoxuan_exam_var.getExamContent() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题答案：</th>
									<td>
										<pre style="font-size: 18px">${duoxuan_exam_var.getExamAnwser() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">所属章节：</th>
									<td>
										<pre style="font-size: 18px">${duoxuan_exam_var.getExamChapter() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题难度：</th>
									<td>
										<pre style="font-size: 18px">${duoxuan_exam_var.getExamDegree() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题分数：</th>
									<td>
										<pre style="font-size: 18px">${duoxuan_exam_var.getExamScore() }</pre>	
									</td>
							</tr>
							
						</table>
					<hr /><br>
				</div>
			</c:forEach>
	
			</div>

		</div>

	<!-- 填空题列表 -->
		<div class="content_right" id="list_tiankong">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>填空题列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<c:forEach items="${tiankong_exam}" var="tiankong_exam_var" >
					<div class="content_main_content">
							<table class="table_infomations_list">
								
								<tr>
										<th class="th4neirong">试题内容：</th>
										<td>
											<pre style="font-size: 18px">${tiankong_exam_var.getExamContent() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题答案：</th>
										<td>
											<pre style="font-size: 18px">${tiankong_exam_var.getExamAnwser() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">所属章节：</th>
										<td>
											<pre style="font-size: 18px">${tiankong_exam_var.getExamChapter() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题难度：</th>
										<td>
											<pre style="font-size: 18px">${tiankong_exam_var.getExamDegree() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题分数：</th>
										<td>
											<pre style="font-size: 18px">${tiankong_exam_var.getExamScore() }</pre>	
										</td>
								</tr>
								
							</table>
						<hr /><br>
					</div>
				</c:forEach>
	
	
			</div>

	
		</div>

	<!-- 判断题列表  -->
		<div class="content_right" id="list_panduan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>判断题列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<c:forEach items="${panduan_exam}" var="panduan_exam_var" >
					<div class="content_main_content">
							<table class="table_infomations_list">
								
								<tr>
										<th class="th4neirong">试题内容：</th>
										<td>
											<pre style="font-size: 18px">${panduan_exam_var.getExamContent() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题答案：</th>
										<td>
											<pre style="font-size: 18px">${panduan_exam_var.getExamAnwser() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">所属章节：</th>
										<td>
											<pre style="font-size: 18px">${panduan_exam_var.getExamChapter() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题难度：</th>
										<td>
											<pre style="font-size: 18px">${panduan_exam_var.getExamDegree() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题分数：</th>
										<td>
											<pre style="font-size: 18px">${panduan_exam_var.getExamScore() }</pre>	
										</td>
								</tr>
								
							</table>
						<hr /><br>
					</div>
				</c:forEach>
	
			</div>

	
		</div>

	<!-- 简答题列表 -->
		<div class="content_right" id="list_jianda">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>简答题列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
					<c:forEach items="${jianda_exam}" var="jianda_exam_var" >
					<div class="content_main_content">
							<table class="table_infomations_list">
								
								<tr>
										<th class="th4neirong">试题内容：</th>
										<td>
											<pre style="font-size: 18px">${jianda_exam_var.getExamContent() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题答案：</th>
										<td>
											<pre style="font-size: 18px">${jianda_exam_var.getExamAnwser() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">所属章节：</th>
										<td>
											<pre style="font-size: 18px">${jianda_exam_var.getExamChapter() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题难度：</th>
										<td>
											<pre style="font-size: 18px">${jianda_exam_var.getExamDegree() }</pre>	
										</td>
								</tr>
								<tr>
										<th class="th4neirong">试题分数：</th>
										<td>
											<pre style="font-size: 18px">${jianda_exam_var.getExamScore() }</pre>	
										</td>
								</tr>
								
							</table>
						<hr /><br>
					</div>
				</c:forEach>
			</div>

	
		</div>
	
	<!-- 搜索试题 -->
		<div class="content_right" id="search_danxuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>搜索所有试题</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form method="post" action="javascript:void(0)">
					<table class="table_infomations_list">
						<tr>
							<th>搜索形式:</th>
							<td>
								<select name="search_xingshi"  id="serch4xingshi">
										<option value="1" >&nbsp;&nbsp;根据试题内容搜索&nbsp;&nbsp;</option>
										<option value="2" >&nbsp;&nbsp;根据难度搜索&nbsp;&nbsp;</option>
										<option value="3" >&nbsp;&nbsp;根据分数搜索&nbsp;&nbsp;</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<th>试题类型:</th>
							<td>
								<select name="seatch_leixing" id="serch4leixing">
									<option value="单选题" >&nbsp;&nbsp;单选题&nbsp;&nbsp;</option>
									<option value="多选题" >&nbsp;&nbsp;多选题&nbsp;&nbsp;</option>
									<option value="填空题" >&nbsp;&nbsp;填空题&nbsp;&nbsp;</option>
									<option value="判断题" >&nbsp;&nbsp;判断题&nbsp;&nbsp;</option>
									<option value="简答题" >&nbsp;&nbsp;简答题&nbsp;&nbsp;</option>
								</select>
							</td>
							<td>所属课程:&nbsp;&nbsp;
								<select name="search_xingshi"  id="serch4xingshi">
										<option value="1" >&nbsp;&nbsp;离散数学&nbsp;&nbsp;</option>
										<option value="2" >&nbsp;&nbsp;计算机组成原理&nbsp;&nbsp;</option>
										<option value="3" >&nbsp;&nbsp;高等数学&nbsp;&nbsp;</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<th>搜索内容:</th>
							<td>
								<input type="text" name="search_danxuan_input" class="class_search_input"/>
								<button class="search_querenchazhao">确认查找</button>
							</td>
							<td>试题数量：<span id="onePaper_totalScore">${examforSeacher.size() }个</span></td>
						</tr>
						
						<tr>
							<td style="display:none"></td>
							<td colspan="5" class="sousuokuang" style="display:none;"><span>*请输入查询关键字</span></td>
						</tr>
						
						<tr>
							<td colspan="3" style="height:30px; padding:0 100px;"><hr></td>
						</tr>
						
						<c:if test="${examforSeacher.size() == 0}">
							<tr>
								<td></td>
								<td>
									<pre style="font-size: 18px; color:red" >*没有查询到任何相关试题</pre>	
								</td>
							</tr>
						</c:if>	
											
						<c:if test="${examforSeacher.size() != 0}">
							<c:set var="x" value="0"/>
							<c:forEach items="${examforSeacher}" var="examforSeacher_var" >
								<c:set var="x" value="${x+1 }"/>
									<tr>
											<th class="th4neirong">试题内容：</th>
											<td>
												<pre style="font-size: 18px" class="searched_content">${x }.  ${examforSeacher_var.getExamContent() }</pre>	
											</td>
									</tr>
									<tr>
											<th class="th4neirong">试题难度：</th>
											<td>
												<pre style="font-size: 18px" class="searched_nandu">${examforSeacher_var.getExamDegree() }</pre>	
											</td>
									</tr>
									<tr>
											<th class="th4neirong">试题分数：</th>
											<td>
												<pre style="font-size: 18px" class="searched_score">${examforSeacher_var.getExamScore() }</pre>	
											</td>
									</tr>
									<tr>
										<td colspan="3" style="height:30px; padding:0 100px;"><hr></td>
									</tr>
							</c:forEach>
						</c:if>
						
						
						
					</table>
					</form>
				</div>
	
			</div>
	
		</div>		
		
		
		
<!-- =============================================================================================================================================================== -->
	<!-- 添加试卷 -->
		<div class="content_right" id="delete_zhineng_shijuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>试卷清理</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<table class="table_infomations_teacher">
						<tr>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">试卷名称</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所属课程</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">适应度值</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">试卷总分</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">创建时间</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">难度系数</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">相关操作</th>		
						</tr>
						<tr>
								<td>
									<pre style="font-size: 18px">001</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">坚铨</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">男</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">计算机科学与技术</pre>	
								</td>	
								<td>
									<pre style="font-size: 18px">心理学</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">18826497005</pre>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red">删除</a> | <a style="color: red">修改</a></pre>	
								</td>
						</tr>
						<tr>
								<td>
									<pre style="font-size: 18px">001</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">坚铨</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">男</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">计算机科学与技术</pre>	
								</td>	
								<td>
									<pre style="font-size: 18px">心理学</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">18826497005</pre>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red">删除</a> | <a style="color: red">修改</a></pre>	
								</td>
						</tr>
						<tr>
								<td>
									<pre style="font-size: 18px">001</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">坚铨</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">男</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">计算机科学与技术</pre>	
								</td>	
								<td>
									<pre style="font-size: 18px">心理学</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">18826497005</pre>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red">删除</a> | <a style="color: red">修改</a></pre>	
								</td>
						</tr>
						
					</table>
				</div>
			</div>
		</div>

	<!-- 添加试题 -->
		<div class="content_right" id="add_shiti">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>添加试题</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form id="form_add_shiti" method="post" action="javascript:void(0)">
						<table class="table_infomations">
							<tr>
								<th>所属课程：</th>
								<td>
									<select name="add_kecheng" id="shiti4kecheng" class="add_shiti_list">
										<option value="#">--请选择--</option>
										<option value="${sessionScope.course.courseName}">&nbsp;&nbsp;${sessionScope.course.courseName}&nbsp;&nbsp;</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2" class="tishi" id="tishi4kecheng">*只能选择当前所有的课程</td>
							</tr>

							<tr>
								<th>所属章节：</th>
								<td>
									<select name="add_zhangjie" id="zhangjie" class="add_shiti_list">
										<option value="#">--请选择--</option>
										<c:forEach items="${chapterList }" var="chapter">
											<option value="${chapter }">&nbsp;&nbsp;${chapter }&nbsp;&nbsp;</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td  colspan="2" class="tishi" id="tishi4zhangjie">*只能选择当前所有的章节</td>
							</tr>
							
							<tr>
								<th>试题类型：</th>
								<td>
									<select name="add_leixing" id="leixing" class="add_shiti_list">
										<option value="#">--请选择--</option>
										<option value="单选题" >&nbsp;&nbsp;单选题&nbsp;&nbsp;</option>
										<option value="多选题" >&nbsp;&nbsp;多选题&nbsp;&nbsp;</option>
										<option value="填空题" >&nbsp;&nbsp;填空题&nbsp;&nbsp;</option>
										<option value="判断题" >&nbsp;&nbsp;判断题&nbsp;&nbsp;</option>
										<option value="简答题" >&nbsp;&nbsp;简答题&nbsp;&nbsp;</option>
									</select>
								</td>
							</tr>
							<tr>
								<td  colspan="2" class="tishi" id="tishi4lexing">*请选择试题类型</td>
							</tr>
							
							<tr>
								<th>试题难度：</th>
								<td>
									<input type="number" step="0.01" name="add_nandu" class="add_shiti_list" />
								</td>
							</tr>
							<tr>
								<td  colspan="2" class="tishi" id="tishi4nandu">*请输入正确值</td>
							</tr>
							
							<tr>
								<th>试题分值：</th>
								<td>
									<input type="number" step="0.1" name="add_fenzhi" class="add_shiti_list" />
								</td>
							</tr>
							<tr>
								<td colspan="2"  class="tishi" id="tishi4fenzhi">*请输入试题分值</td>
							</tr>
							
							<tr>
								<th class="th4neirong">试题内容：</th>
								<td>
									<textarea id="add_shitineirong"  name="add_shitineirong_name" class="textArea" cols="37" rows="6"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2"  class="tishi" id="tishi4neirong">*请输入正确试题内容</td>
							</tr>
							
							<tr>
								<th>试题答案：</th>
								<td>
									<input type="text" name="add_shiti_daan" class="add_shiti_list"/>
								</td>
							</tr>
							<tr>
								<td  colspan="2" class="tishi" id="tishi4daan">*请输入试题答案</td>
							</tr>
							
							<tr>
								<td align="center" colspan="2">
									<button class="tianjaishiti">确认添加</button>&nbsp;&nbsp;
									<button type="reset">重新设定</button>
								</td>
							</tr>
							
						</table>
					</form>
					
				</div>
	
			</div>
	
		</div>

	<!-- 试卷列表 -->
		<div class="content_right" id="list_shijuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>试卷列表</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
				<c:set var="index" value="0" />
				<c:set var="bigIndex" value="-1" />
					<table class="table_infomations_list">
						<tr>
							<th>试 卷 列 表:</th>
							<td>
								<select id="list_shijuan_list2" class="list_shijuan_class" >
									<option value="#">--请选择--</option>
									<c:forEach items="${paperList }" var="p">
											<option value="one">${p.getPaperName() }</option>
									</c:forEach>
								</select>
								<button class="querenchazhao">确认查找</button>
							</td>
							<td>试卷总分：<span id="onePaper_totalScore">${paper.getTotalScore()}</span></td>
						</tr>
						
						<tr>
							<td colspan="2" align="right" id="tishi4nanduxishu2"><span>*请选择正确的试卷信息</span></td>
						</tr>
						
						<tr>
							<td colspan="3" style="height:30px; padding:0 100px;"><hr></td>
						</tr>
						
						<c:if test="${paper!=null }" >
						
						<tr>
							<td colspan="3" id="tishi4nanduxishu3" ><span>试卷名称：${paper.getPaperName()}</span></td>
						</tr>
						
						<c:if test="${paper_danxuan_exam.size() != 0}">
						<tr>
							<th></th>
							<c:set var="bigIndex" value="${bigIndex+1}" />
							<th colspan="2" style="vertical-align: top; text-align:left">${xuliehao.get(bigIndex) }、单项选择题（每小题${singleScore }分，共${paper_danxuan_exam.size()*singleScore }分）</th>
						</tr>
						<tr>
							<td></td>
							<td>
								<table class="last_table_list">
									
									<c:forEach items="${paper_danxuan_exam }" var="p_danxuan">
									<c:set var="index" value="${index+1}" />  
									<tr>
										<!-- <td style=" width: 60px; padding:0 6px; vertical-align: top;"><button style="width:80px">修改题目</button></td>	 -->
										<td style="padding-left: 5px;">
											<pre style="font-size: 18px">${index }. ${p_danxuan.getExamContent() }</pre>
										</td>
										<!-- <td style="width:25px; padding:7px 0 0 0 ; vertical-align: top;">
											<input type="checkbox" class="input_check" id="danxuan_1" style="width:20px">
										</td> -->
									</tr>
									</c:forEach>
								</table>												
							</td>
						</tr>
						<tr><td style="height:30px;"></td></tr>
						<%-- </c:set> --%>
						</c:if>
						
						
						<c:if test="${paper_duoxuan_exam.size() != 0}">
							<tr>
								<th></th>
								<c:set var="bigIndex" value="${bigIndex+1}" />
								<th colspan="2" style="vertical-align: top; text-align:left">${xuliehao.get(bigIndex) }、多项选择题（每小题${multiScore }分，共${paper_duoxuan_exam.size()*multiScore }分）</th>
							</tr>
							<tr>
							<td></td>
							<td>
								<table class="last_table_list">
								
									<c:forEach items="${paper_duoxuan_exam }" var="p_danxuan">
									<c:set var="index" value="${index+1 }" />
									<tr>
										<!-- <td style=" width: 60px; padding:0 6px; vertical-align: top;"><button style="width:80px">修改题目</button></td>	 -->
										<td style="padding-left: 5px;">
											<pre style="font-size: 18px">${index }. ${p_danxuan.getExamContent() }</pre>
										</td>
									</tr>
									</c:forEach>
								</table>													
								</td>
							</tr>
						<tr><td style="height:30px;"></td></tr>
						</c:if>
						
						
						<c:if test="${paper_tiankong_exam.size() != 0}">
							<tr>
								<th></th>
								<c:set var="bigIndex" value="${bigIndex+1}" />
								<th colspan="2" style="vertical-align: top; text-align:left">${xuliehao.get(bigIndex) }、填空题（每小题${completeScore }分，共${paper_tiankong_exam.size()*completeScore }分）
								</th>
							</tr>
							
							<tr>
							<td></td>
							<td>
								<table class="last_table_list">

									<c:forEach items="${paper_tiankong_exam }" var="p_danxuan">
									<c:set var="index" value="${index+1 }" />
									<tr>
										<!-- <td style=" width: 60px; padding:0 6px; vertical-align: top;"><button style="width:80px">修改题目</button></td> -->	
										<td style="padding-left: 5px;">
											<pre style="font-size: 18px">${index }. ${p_danxuan.getExamContent() }</pre>
										</td>
									</tr>
									</c:forEach>
								</table>													
								</td>
							</tr>
						<tr><td style="height:30px;"></td></tr>
						</c:if>
						
						
						<c:if test="${paper_pandaunxuan_exam.size() != 0}">
							<tr>
								<th></th>
								<c:set var="bigIndex" value="${bigIndex+1}" />
								<th colspan="2" style="vertical-align: top; text-align:left">${xuliehao.get(bigIndex) }、判断题（每小题${tfScore }分，共${paper_pandaunxuan_exam.size()*tfScore }分）
								</th>
							</tr>
							
							<tr>
							<td></td>
								<td>
								<table class="last_table_list">

									<c:forEach items="${paper_pandaunxuan_exam }" var="p_danxuan">
									<c:set var="index" value="${index+1 }" />
									<tr>
										<!-- <td style=" width: 60px; padding:0 6px; vertical-align: top;"><button style="width:80px">修改题目</button></td> -->	
										<td style="padding-left: 5px;">
											<pre style="font-size: 18px">${index }. ${p_danxuan.getExamContent() }</pre>
										</td>
									</tr>
									</c:forEach>
								</table>													
								</td>
							</tr>
						<tr><td style="height:30px;"></td></tr>
						</c:if>
						
						
						<c:if test="${paper_jianda_exam.size() != 0}">
							<tr>
								<th></th>
								<c:set var="bigIndex" value="${bigIndex+1}" />
								<th colspan="2" style="vertical-align: top; text-align:left">${xuliehao.get(bigIndex) }、简答题（每小题${subjectScore }分，共${paper_jianda_exam.size()*subjectScore }分）
								</th>
							</tr>
							
							<tr>
							<td></td>
							<td>
								<table class="last_table_list">
								
									<c:forEach items="${paper_jianda_exam }" var="p_danxuan">
									<c:set var="index" value="${index+1}" />  
									<tr>
									<!-- 	<td style=" width: 60px; padding:0 6px; vertical-align: top;"><button style="width:80px">修改题目</button></td>	 -->
										<td style="padding-left: 5px;">
											<pre style="font-size: 18px">${index }. ${p_danxuan.getExamContent() }</pre>
										</td>
									</tr>
									</c:forEach>
								</table>													
								</td>
							</tr>
							<tr><td style="height:30px;"></td></tr>
						</c:if>
						</c:if>
						
					</table>
				</div>
	
			</div>
	
		</div>
	</div>
</body>
</html>