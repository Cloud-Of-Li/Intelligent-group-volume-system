<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script src='js/listPaper.js'></script>
	<link rel="stylesheet" type="text/css" href="css\listPaper.css">
	<title>智能组卷系统</title>
</head>
<body>
	<div class="tite">
		<div class="coment_all">
			<div id="exit">
			<span id="userName">${sessionScope.teacher.teacherName }</span>
				<a href="login.html">退出</a></div>
			<div class="coment">智能组卷系统</div>
		</div>
	</div>
	<div class="content">

	<!-- ==========================以下是左边部分=====================================-->
	<div class="content">

	<!-- ==========================以下是左边部分=====================================-->


		<div class="content_left">
		
		<!-- 教师信息部分 -->
			<div class="menue">
				教师信息		
			</div>

		<!-- 后台管理部分 -->
			<div class="houtai">
			<!-- 后台内容==章节试题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						<span>章节试题</span>
					</div>
					<div class="houtai_all">
						<c:forEach items="${chapterList}" var="chapter">
		
							<div class="houtai_all_neirong">
								<img class="folder" src="image/folder.png" />&nbsp; <span id="${chapter }">${chapter}</span>
							</div>	
						
						</c:forEach>
					</div>
				</div>	
				
			<!-- 后台内容==单选题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						单&nbsp;选&nbsp;题
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>搜索单选题</span>
						</div>
			
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>单选题列表</span>
						</div>
					</div>
				</div>

			<!-- 后台内容==多选题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						多&nbsp;选&nbsp;题
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>搜索多选题</span>
						</div>
			
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>多选题列表</span>
						</div>
					</div>
				</div>

			<!-- 后台内容==填空题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						填&nbsp;空&nbsp;题&nbsp;
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>搜索填空题</span>
						</div>
			
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>填空题列表</span>
						</div>
					</div>
				</div>
			
			<!-- 后台内容==判断题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						判&nbsp;断&nbsp;题
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>搜索判断题</span>
						</div>
			
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>判断题列表</span>
						</div>
					</div>
				</div>
			
			<!-- 后台内容==简答题 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						简&nbsp;答&nbsp;题
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>搜索简答题</span>
						</div>
			
						<div class="houtai_all_neirong">
							<img class="folder" src="image/folder.png">&nbsp; <span>简答题列表</span>
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
							<img class="folder" src="image/folder.png">&nbsp; <span>添加试题</span>
						</div>
			
						<div class="houtai_all_neirong" >
							<img class="folder" src="image/folder.png">&nbsp; <span>智能组卷</span>
						</div>

						<div class="houtai_all_neirong" >
							<img class="folder" src="image/folder.png">&nbsp; <span>试卷列表</span>
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
								<th class="th4neirong">教师编号：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.teacher.teacherId}</pre>	
								</td>

								<td rowspan="6"><img src="image/${sessionScope.teacher.teacherName}.jpg" class="teacher_photo"></td>
						</tr>
						<tr>
								<th class="th4neirong">教师姓名：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.teacher.teacherName}</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">教师性别：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.teacher.teacherSex}</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">所属专业：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.major.majorName}</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">所教课程：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.course.courseName}</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">教师电话：</th>
								<td>
									<pre style="font-size: 18px">${sessionScope.teacher.teacherPhone}</pre>	
								</td>
						</tr>
					</table>
				</div>
	
			</div>
	
		</div>
	
	<!-- 章节信息 -->	
		<c:forEach items="${examList}" var="exam_list" >
		 <%-- <c:forEach var="i" begin="0" end="${exam_list.size()-1 }" > --%>
			<div class="content_right_2">
			<div class="${exam_list.get(0).getExamChapter() }" style="display:block">
				<div class="content4houtai">
					&nbsp;&nbsp;&nbsp;&nbsp;<span>章节列表</span>
					<hr>
				</div>	
				
				<div class="content_main">
					<div class="content_main_title">
						&nbsp;&nbsp;&nbsp;&nbsp;内容列表
					</div>
					
					<c:forEach items="${exam_list}" var="exam">
					<div class="content_main_content"  >
						<table class="table_infomations_list">
							
							<tr>
									<th class="th4neirong">试题类型：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamKind() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题内容：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamContent() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题答案：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamAnwser() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong" >所属章节：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamChapter() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题难度：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamDegree() }</pre>	
									</td>
							</tr>
							<tr>
									<th class="th4neirong">试题分数：</th>
									<td>
										<pre style="font-size: 18px">${exam.getExamScore() }</pre>	
									</td>
							</tr>
							
						</table>
						<hr /><br>
					</div>
					</c:forEach>

				</div>
		
			</div>	
			</div>
		<%-- </c:forEach> --%>
		</c:forEach>
		
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
					<table class="table_infomations_list">
						
						<tr>
								<th class="th4neirong">试题内容：</th>
								<td>
									<pre style="font-size: 18px">${danxuan_exam_var.getExamContent() }</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">试题答案：</th>
								<td>
									<pre style="font-size: 18px">${danxuan_exam_var.getExamAnwser() }</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">所属章节：</th>
								<td>
									<pre style="font-size: 18px">${danxuan_exam_var.getExamChapter() }</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">试题难度：</th>
								<td>
									<pre style="font-size: 18px">${danxuan_exam_var.getExamDegree() }</pre>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">试题分数：</th>
								<td>
									<pre style="font-size: 18px">${danxuan_exam_var.getExamScore() }</pre>	
								</td>
						</tr>
						
					</table>
					<hr /><br>
				</div>
			</c:forEach>
	
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
				&nbsp;&nbsp;&nbsp;&nbsp;<span>搜索单选题</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
				<c:set var="index" value="0" />
				<c:set var="bigIndex" value="-1" />
					<form method="post" action="javascript:void(0)">
					<table class="table_infomations_list">
					
						<tr>
							<th>搜索形式:</th>
							<td>
								<select name="search_xingshi"  id="serch4xingshi">
										<option value="根据内容" >&nbsp;&nbsp;根据试题内容搜索&nbsp;&nbsp;</option>
										<option value="根据难度" >&nbsp;&nbsp;根据难度搜索&nbsp;&nbsp;</option>
										<option value="根据分数" >&nbsp;&nbsp;根据分数搜索&nbsp;&nbsp;</option>
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
						</tr>
						
						<tr>
							<th>搜索内容:</th>
							<td>
								<input type="text" name="search_danxuan_input" class="class_search_input"/>
								<button class="search_querenchazhao">确认查找</button>
							</td>
							<td>试题数量：<span id="onePaper_totalScore">0个</span></td>
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
												<pre style="font-size: 18px">${x+1 }.  ${examforSeacher_var.getExamContent() }</pre>	
											</td>
									</tr>
									<tr>
											<th class="th4neirong">试题难度：</th>
											<td>
												<pre style="font-size: 18px">    ${examforSeacher_var.getExamDegree() }</pre>	
											</td>
									</tr>
									<hr /><br>
							</c:forEach>
						</c:if>
						
						
						
					</table>
					</form>
				</div>
	
			</div>
	
		</div>		
		
		
		
<!-- =============================================================================================================================================================== -->
 <!-- 添加试卷 -->
		<div class="content_right" id="add_zhineng_shijuan">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>智能组卷</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form method="post" action="javascript:void(0)">
						<table class="table_infomations_autoadd">
							<tr>
								<th>所属课程：</th>
								<td>
									<select id="danxuan_kecheng" class="kecheng">
										<option value="#">--请选择--</option>
										<option value="lisan">&nbsp;&nbsp;${sessionScope.course.courseName}&nbsp;&nbsp;</option>
									</select>
								</td>

								<!-- <td class="tishi">*只能选择当前所有的课程</td> -->
							
								<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;试卷总分：</th>
								<td>
									<input id="shijuanzongfen" value="0" type="text" name="scores" disabled="disabled"/>
								</td>

								<!-- <td class="tishi">*请输入正确分数</td> -->

								<th>试卷期望难度系数：</th>
								<td>
									<input type="number" step="0.01" name="auto_nandu" />
								</td>

								<!-- <td class="tishi">*请输入正确值</td> -->
							
							</tr>
							
							<tr>
								<td colspan="6" align="right" class="tishi4nanduxishu" ><span>*请输入正确的难度系数设定值</span></td>
								
							</tr>
							
							<tr>
								<th>试卷包含的题型：</th>
								<td colspan="5">
									<div id="check">
										<span>	
											<input type="checkbox" class="input_check" id="check1">
											<label for="check1">单选题</label>
										</span>
										&nbsp;&nbsp;
										&nbsp;&nbsp;
										<span>	
											<input type="checkbox" class="input_check" id="check2">
											<label for="check2">多选题</label>
										</span>
										&nbsp;&nbsp;
										&nbsp;&nbsp;
										<span>	
											<input type="checkbox" class="input_check" id="check3">
											<label for="check3">填空题</label>
										</span>
										&nbsp;&nbsp;
										&nbsp;&nbsp;
										<span>	
											<input type="checkbox" class="input_check" id="check4">
											<label for="check4">判断题</label>
										</span>
										&nbsp;&nbsp;
										&nbsp;&nbsp;
										<span>	
											<input type="checkbox" class="input_check" id="check5">
											<label for="check5">简答题</label>
										</span>
									</div>
								</td>
								<td class="tishi" colspan="3" >*请输入正确值</td>
							</tr>
							



							
							<tr class="单选题">
								<th>单选题数量：</th>
								<td>
									<input type="number" name="count_danxuan" class="count_all" value=0 />
								</td>
								<td class="tishi">*请输入正确值</td>
							
								<th colspan="4" style="text-align: left">单选题单个分数分值：
									<input type="number" step="0.01" name="score_danxuan" class="count_all" value=0 />
								</th>
								<td class="tishi">*请输入正确值</td>
							</tr>

							<tr  class="多选题">
								<th>多选题数量：</th>
								<td>
									<input type="number" name="count_duoxuan" class="count_all" value=0 />
								</td>
								<td class="tishi">*请输入正确值</td>
							
								<th colspan="4" style="text-align: left">多选题单个分数分值：
									<input type="number" step="0.01" name="score_duoxuan" class="count_all" value=0 />
								</th>
								<td class="tishi">*请输入正确值</td>
							</tr>
							
							<tr class="填空题">
								<th>填空题题数量：</th>
								<td>
									<input type="number" name="count_tiankong" class="count_all" value=0 />
								</td>
								<td class="tishi">*请输入正确值</td>
							
								<th colspan="4" style="text-align: left">填空题单个分数分值：
									<input type="number" step="0.01" name="score_tiankong" class="count_all" value=0 />
								</th>
								<td class="tishi">*请输入正确值</td>
							</tr>

							<tr class="判断题">
								<th>判断题数量：</th>
								<td>
									<input type="number" name="count_panduan" class="count_all" value=0 />
								</td>
								<td class="tishi">*请输入正确值</td>
							
								<th colspan="4" style="text-align: left" >判断题单个分数分值：
									<input type="number" step="0.01" name="score_panduan" class="count_all" value=0 />
								</th>
								<td class="tishi">*请输入正确值</td>
							</tr>

							<tr class="简答题">
								<th>简答题数量：</th>
								<td>
									<input type="number" name="count_jianda" class="count_all" value=0 />
								</td>
								<td class="tishi">*请输入正确值</td>
							
								<th colspan="4" style="text-align: left">简答题单个分数分值：
									<input type="number" step="0.01" name="score_jianda"  class="count_all" value=0 />
								</th>
								<td class="tishi">*请输入正确值</td>
							</tr>
							
							<tr>
								<td colspan="4" id="chucuola" class="tishi" style="display:table-cell"><span>*</span></td>
							</tr>
							
							
							<tr>
								<td align="center" colspan="6">
									<button id="submit4auto" class="submit_button" type="submit">确认提交</button>&nbsp;&nbsp;
									<button class="reset_button" type="reset">重新设定</button>
								</td>
							</tr>
							
						</table>
					</form>
					
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
						
						<tr>
							<td colspan="3" id="tishi4nanduxishu3"><span>试卷名称：${paper.getPaperName()}</span></td>
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
						
						
					</table>
				</div>
	
			</div>
	
		</div>
	</div>
</body>
</html>