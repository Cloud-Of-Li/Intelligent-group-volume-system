<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <script src='js/jquery-3.1.1.min.js'></script>
    <script src='js/manager.js'></script>
    <script src='js/addCourse.js'></script>
    <script src='js/show.js'></script>
	<link rel="stylesheet" type="text/css" href="css\manager.css">
	<link rel="stylesheet" type="text/css" href="css\style.css">
	<title>智能组卷系统</title>
</head>
<body>
	<div class="tite">
		<div class="coment_all">
			<div>
				<div id="exit">
					<a href="login.html" id="logout" style="font-size:15px; margin-right:0px" ><span class="icon-switch"></span> 退出登陆</a>
				</div>
				<div id="welcome">
					<span id="userName" style="font-size:18px; /* color:white */"><span class="icon-user" style="font-size:16px;"></span>  ${sessionScope.manager.managerName  }，欢迎进入智能组卷系统！</span> 
				</div>
			</div>
			
			<div class="coment">基于遗传算法的智能组卷系统 （管理员）</div>
		</div>
	</div>
	<div class="content">

	<!-- ==========================以下是左边部分=====================================-->


		<div class="content_left">
		
		<!-- 教师信息部分 -->
			<div class="menue">
				<span class="icon-user-tie"></span> &nbsp;教师信息		
			</div>

		<!-- 后台管理部分 -->
			<div class="houtai">
			
				
			<!-- 后台内容==题库管理 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						<span class="icon-file-text"></span> &nbsp;题库管理
					</div>
					<div class="houtai_all">
						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-quill"></span> &nbsp;<span>添加试题</span>
						</div>
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-compass"></span> &nbsp;<span>搜索试题</span>
						</div>
					</div>
				</div>

			<!-- 后台内容==课程管理 -->
				 <div class="houtai_coment">
					<div class="houtai_coment_all">
						<span class="icon-newspaper"></span> &nbsp;<!-- 试题列表 -->课程管理
					</div>
					<div class="houtai_all" id="shitilistId">
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-link"></span> &nbsp;<span>课程列表</span>
						</div>
						<div class="add_course">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-link"></span> &nbsp;<span>添加课程</span>
						</div>
					</div>
				</div>
				
			<!-- 后台内容==专业管理 -->
				 <div class="houtai_coment">
					<div class="houtai_coment_all">
						<span class="icon-newspaper"></span> &nbsp;<!-- 试题列表 -->专业管理
					</div>
					<div class="houtai_all" id="shitilistId">
						<div class="houtai_all_neirong">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-link"></span> &nbsp;<span>专业列表信息</span>
						</div>
						<div class="add_major">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-link"></span> &nbsp;<span>添加专业信息</span>
						</div>
					</div>
				</div>	

			<!-- 后台内容==试卷组成 -->
				<div class="houtai_coment">
					<div class="houtai_coment_all">
						<span class="icon-list"></span> &nbsp;试卷组成
					</div>
					<div class="houtai_all" id="shijuanlistId">

						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-bin"></span> &nbsp;<span>试卷清理</span>
						</div>

						<div class="houtai_all_neirong" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="icon-list-numbered"></span> &nbsp;<span>试卷列表</span>
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
					<table class="table_infomations_teacher" id="table_info">
						<tr>
							<td colspan="8" style="background-color: silver"><a class="add_teacher" style="font-size:25px;color:red;font-family: '华文正楷';">添加教师</a></td>
						</tr>
						<tr>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师编号</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师姓名</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师性别</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所属专业</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所教课程</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师电话</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">身份证号</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">相关操作 </th>		
						</tr>
						<c:set var="x" value="-1" />
						<c:forEach items="${teacherlist}" var="teacher">
						<c:set var="x" value="${x+1 }" />
						<tr>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherId()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherName()}</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherSex ()}</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">${majorlist.get(x).getMajorName() }</pre>	
								</td>								
								<td>
									<c:forEach items="${courseMap }" var="entry">
										<c:if test="${entry.key == teacher.getTeacherId()}">
											<c:if test="${entry.value.size() == 0 }" >
												<input type="text" name="add_zhuanye" style="width:130px" disabled="disabled"/>
											</c:if>
											<c:forEach items="${entry.value }" var="course">
												${course.getCourseName() }<br/>
											</c:forEach>
										</c:if>
									</c:forEach>	
								</td>
								
								<td>
									<pre style="font-size: 18px">${teacher.getTeacherPhone()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${teacher.identity}</pre>	
								</td>
								
								<td>
									<pre style="font-size: 18px"><a style="color: red" class="delete_teacher">删除</a> | <a style="color: red" class="update_teacher">修改</a></pre>	
								</td>
						</tr>
						</c:forEach>
						
						
						
					</table>
				</div>
	
			</div>
	
		</div>
		
		<!-- ====================================================教师信息内容更改==================================================== -->
		<div class="content_right_1_update" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>教师信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table class="table_infomations_teacher">
						<tr>
								<th class="th4neirong">教师编号：</th>
								<td style="width:500px;">
									<input type="text" name="update_teacherid"  disabled="disabled"/>
								</td>

								<td rowspan="6" ><img id="update_teacherphoto" src="image/${udpate_teacher.teacherName}.jpg" class="teacher_photo"></td>
						</tr>
						<tr>
								<th class="th4neirong">教师姓名：</th>
								<td>
									<input type="text" name="update_teachername"   value="${update_teacher.teacherName }" disabled="disabled"/>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">身份证号：</th>
								<td>
									<input type="text" name="update_teacheridentity"   value="${update_teacher.identity}" disabled="disabled"/>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">教师性别：</th>
								<td>
									<input type="radio" name="selector2" value="男" style="width:12px; weight:12px; height:auto">
											<label class="mm" style="color: black">男</label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="selector2" value="女" style="width:12px; weight:12px;height:auto">
											<label class="mm" style="color: black">女</label>
								</td>
						</tr>
						
						<tr>
							<td style="display:none"></td>
							<td  id="jiaohsixingbiequeren" class="sousuokuang" style="display:none;"><span>*请选择教师性别</span></td>
						</tr>
						
						
						<tr>
								<th class="th4neirong">所属专业：</th>
								<td>
									<select name="update_major_name"  id="update_major">
										<c:forEach items="${majorall }" var="major">
												<option value="${major.getMajorId() }" >&nbsp;&nbsp;${major.getMajorName() }&nbsp;&nbsp;</option>
										</c:forEach>
									</select>
								</td>
						</tr>
						<tr>
								<th class="th4neirong">所教课程：</th>
								<td>
									<table>
										<tr>
											<td style="width:100px"></td>
											<td style="text-align:left"> 
												<c:forEach items="${courselist }" var="course">					
													<input type="checkbox" name="chc_kecheng" value="${course.getCourseId() }"  style="width:12.8px; height:12.8"/>&nbsp;&nbsp;${course.getCourseName() }<br>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
						
						<tr>
							<td style="display:none"></td>
							<td  id="suojiaokechengqueren" class="sousuokuang" style="display:none;"><span>*请选择课程</span></td>
						</tr>
						
						<tr>
								<th class="th4neirong">教师电话：</th>
								<td>
									<input type="number" name="update_teacherphone"  value="${update_teacher.teacherPhone }"/>	
								</td>
						</tr>
						
						
						<tr>
							<td style="display:none"></td>
							<td  id="dianhuaqueren" class="sousuokuang" style="display:none;"><span>*请填写电话号码</span></td>
						</tr>
				
						<tr>
								<td align="center" colspan="2">
									<button id="queren_update">确认修改</button>&nbsp;&nbsp;
									<a href="mexamServlet"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
			</div>
	
		</div>
		
		<!-- ====================================================教师信息添加==================================================== -->
		
		<div class="content_right_1_add" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>教师信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table style="margin:0 auto">
						<tr>
								<th class="th4neirong">教师姓名：</th>
								<td>
									<input type="text" name="add_teachername"  placeholder="教师姓名" required="required"/>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">身份证号：</th>
								<td>
									<input type="text" name="add_teacheridentity"  placeholder="教师身份证号" required="required"/>	
								</td>
						</tr>
						<tr>
								<th class="th4neirong">教师性别：</th>
								<td>
									<input type="radio" name="selector3" value="男" style="width:12px; weight:12px; height:auto" required="required">
											<label class="mm" style="color: black">男</label>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="selector3" value="女" style="width:12px; weight:12px;height:auto" required="required">
											<label class="mm" style="color: black">女</label>
								</td>
						</tr>
						
						<tr>
							<td style="display:none"></td>
							<td  id="jiaohsixingbiequeren_add" class="sousuokuang" style="display:none;"><span>*请选择教师性别</span></td>
						</tr>
						
						
						<tr>
								<th class="th4neirong">所属专业：</th>
								<td>
									<select name="add_major_name"  id="add_major">
										<c:forEach items="${majorall }" var="major">
												<option value="${major.getMajorId() }" >&nbsp;&nbsp;${major.getMajorName() }&nbsp;&nbsp;</option>
										</c:forEach>
									</select>
								</td>
						</tr>
						<tr>
								<th class="th4neirong">所教课程：</th>
								<td>
									<table>
										<tr>
											<td style="width:100px"></td>
											<td style="text-align:left"> 
												<c:forEach items="${courselist }" var="course">					
													<input type="checkbox" name="add_chc_kecheng" value="${course.getCourseId() }"  style="width:12.8px; height:12.8"/>&nbsp;&nbsp;${course.getCourseName() }<br>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
						<tr>
							<td style="display:none"></td>
							<td  id="suojiaokechengqueren_add" class="sousuokuang" style="display:none;"><span>*请选择课程</span></td>
						</tr>
						
						<tr>
								<th class="th4neirong">教师电话：</th>
								<td>
									<input type="number" name="add_teacherphone" placeholder="电话号码" required="required"/>	
								</td>
						</tr>
						
						<tr>
							<td style="display:none"></td>
							<td  id="add_dianhuaqueren" class="sousuokuang" style="display:none;"><span>*请填写电话号码</span></td>
						</tr>
						
						<tr>
								<td align="center" colspan="2">
									<button id="queren_add">确认添加</button>&nbsp;&nbsp;
									<a href="mexamServlet"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
			</div>
	
		</div>
	
	
		
	<!-- 课程列表 -->
		<div class="content_right" id="list_kecheng">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>课程信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<table class="table_infomations_teacher" id="course_info">
						<tr style="border: 1px">
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">课程编号</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">课程名</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">所属专业</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师列表</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">相关操作 </th>		
						</tr>
						<c:set var="x" value="-1" />
						<c:forEach items="${courselist}" var="course">
						<c:set var="x" value="${x+1 }" />
						<tr>
								<td>
									<pre style="font-size: 18px">${course.getCourseId()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${course.getCourseName()}</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">${majorlist4course.get(x).getMajorName() }</pre>	
								</td>								
								<td>
									<c:forEach items="${teacherMap }" var="entry">
										<c:if test="${entry.key == course.getCourseId()}">
											<c:forEach items="${entry.value }" var="teacher">
												${teacher.getTeacherName() }<br/>
											</c:forEach>
										</c:if>
									</c:forEach>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red" class="delete_course">删除</a> | <a style="color: red" class="update_course">修改</a></pre>	
								</td>
						</tr>
						</c:forEach>
						<!-- <tr>
							<td colspan="8"><a class="add_course" style="color:blue;">添加课程</a></td>
						</tr> -->
						
						
					</table>
				</div>
	
			</div>
	
		</div>	
		
	<!--==================================== 课程的添加 ==============================================-->	
	
		<div class="content_right" id="content_right_add_course" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>添加课程</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table style="margin:0 auto">
						<tr>
								<th class="th4neirong">课程名称：</th>
								<td>
									<input type="text" name="add_coursername"  placeholder="课程名称" required="required"/>	
								</td>
						</tr>
						
						<tr>
								<th class="th4neirong">所属专业：</th>
								<td>
									<select name="add_coursemajor_name"  id="add_coursemajor">
										<c:forEach items="${majorall }" var="major">
												<option value="${major.getMajorId() }" >&nbsp;&nbsp;${major.getMajorName() }&nbsp;&nbsp;</option>
										</c:forEach>
									</select>
								</td>
						</tr>
						
						<tr>
								<th class="th4neirong">任课老师：</th>
								<td>
									<table>
										<tr>
											<td style="width:50px"></td>
											<td style="text-align:left"> 
											<c:set var="x" value="${0}" />
												<c:forEach items="${teacherlist }" var="teacher">					
													<input type="checkbox" name="chc_tea" value="${teacher.getTeacherId() }"  style="width:12.8px;" id="teaL"/>${teacher.getTeacherName() }
													&nbsp;&nbsp;&nbsp;&nbsp;
													<c:set var="x" value="${x+1 }"/>
													<c:if test="${(x!=0)&&(x%3==0) }">
														<br>
													</c:if>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
						
						<tr>
								<td align="center" colspan="2">
									<button id="queren_addcourse">确认添加</button>&nbsp;&nbsp;
									<a class="returnBack"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
			</div>
	
		</div>
		
<!--==================================== 课程的修改 ==============================================-->	

		<div class="content_right" id="content_right_update_course" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>课程信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table style="margin:0 auto">
						<tr>
								<th class="th4neirong">课程编号：</th>
								<td style="width:500px;">
									<input type="text" name="update_courseid"  disabled="disabled"/>
								</td>
						</tr>
						<tr>
								<th class="th4neirong">课程名字：</th>
								<td style="width:500px;">
									<input type="text" name="update_coursename" />
								</td>
						</tr>
						
						<tr>
								<th class="th4neirong">所属专业：</th>
								<td>
									<select name="update_courmajor_name"  id="update_coursemajor">
										<c:forEach items="${majorall }" var="major">
												<option value="${major.getMajorId() }" >&nbsp;&nbsp;${major.getMajorName() }&nbsp;&nbsp;</option>
										</c:forEach>
									</select>
								</td>
						</tr>
						<tr>
								<th class="th4neirong">任课老师：</th>
								<td>
									<table>
										<tr>
											<td style="width:100px"></td>
											<td style="text-align:left"> 
												<c:forEach items="${teacherlist }" var="teacher">					
													<input type="checkbox" name="chc_tea_up" value="${teacher.getTeacherId() }"  style="width:12.8px;" id="teaL"/>&nbsp;&nbsp;${teacher.getTeacherName() }<br>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
				
						<tr>
								<td align="center" colspan="2">
									<button id="queren_update_course">确认更新</button>&nbsp;&nbsp;
									<a class="returnBack"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
			</div>
	
		</div>
		
		
	<!--================================================================= 专业信息部分 =============================================================== -->	
	
	<div class="content_right" id="list_major">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>专业信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<table class="table_infomations_teacher" id="course_info">
						<tr style="border: 1px">
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">专业编号</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">专业名称</th>
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">教师列表</th>		
								<th class="th4neirong" style="color: #0067aa; background-color: #ddd">相关操作 </th>		
						</tr>
						<c:set var="x" value="-1" />
						<c:forEach items="${majorall}" var="major">
						<c:set var="x" value="${x+1 }" />
						<tr>
								<td>
									<pre style="font-size: 18px">${major.getMajorId()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${major.getMajorName()}</pre>	
								</td>								
															
								<td>
									<c:forEach items="${teacherMap4Major }" var="entry">
										<c:if test="${entry.key == major.getMajorId()}">
											<c:forEach items="${entry.value }" var="teacher">
												${teacher.getTeacherName() }<br/>
											</c:forEach>	
										</c:if>
									</c:forEach>	
								</td>
								<td>
									<pre style="font-size: 18px"><a style="color: red" class="delete_major">删除</a> | <a style="color: red" class="update_major">修改</a></pre>	
								</td>
						</tr>
						</c:forEach>
						<!-- <tr>
							<td colspan="8"><a class="add_course" style="color:blue;">添加课程</a></td>
						</tr> -->
						
						
					</table>
				</div>
	
			</div>
	
		</div>	
	<!--========================专业信息修改================================-->
	<div class="content_right" id="content_right_update_major" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>专业信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table style="margin:0 auto">
						<tr>
								<th class="th4neirong">专业编号：</th>
								<td style="width:500px;">
									<input type="text" name="update_majorid"  disabled="disabled"/>
								</td>
						</tr>
						<tr>
								<th class="th4neirong">专业名字：</th>
								<td style="width:500px;">
									<input type="text" name="update_majorname" />
								</td>
						</tr>
						
						<tr>
								<th class="th4neirong">任课老师：</th>
								<td>
									<table>
										<tr>
											<td style="width:100px"></td>
											<td style="text-align:left"> 
												<c:forEach items="${teacherlist }" var="teacher">					
													<input type="checkbox" name="major_tea_up" value="${teacher.getTeacherId() }"  style="width:12.8px;" id="teaL"/>&nbsp;&nbsp;${teacher.getTeacherName() }<br>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
				
						<tr>
								<td align="center" colspan="2">
									<button id="queren_update_major">确认更新</button>&nbsp;&nbsp;
									<a class="returnBacktomajorlist"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
			</div>
	
		</div>
	
	
	<!--======================== 专业信息添加============================== -->
		
		<div class="content_right" id="content_right_add_major" style="display:none">
			<div class="content4houtai">
				&nbsp;&nbsp;&nbsp;&nbsp;<span>添加专业信息</span>
				<hr>
			</div>	
			
			<div class="content_main">
				<div class="content_main_title">
					&nbsp;&nbsp;&nbsp;&nbsp;内容列表
				</div>
				
				<div class="content_main_content">
					<form action="javascript:void(0)" method="post">
					<table style="margin:0 auto">
						<tr>
								<th class="th4neirong">专业名称：</th>
								<td>
									<input type="text" name="add_majorname"  placeholder="专业名称" required="required"/>	
								</td>
						</tr>
						
						
						<tr>
								<th class="th4neirong">任课老师：</th>
								<td>
									<table>
										<tr>
											<td style="width:50px"></td>
											<td style="text-align:left"> 
											<c:set var="x" value="${0}" />
												<c:forEach items="${teacherlist }" var="teacher">					
													<input type="checkbox" name="m_tea" value="${teacher.getTeacherId() }"  style="width:12.8px;" id="teaL"/>${teacher.getTeacherName() }
													&nbsp;&nbsp;&nbsp;&nbsp;
													<c:set var="x" value="${x+1 }"/>
													<c:if test="${(x!=0)&&(x%3==0) }">
														<br>
													</c:if>
												</c:forEach>
											</td>
										</tr>
									</table>
								</td>
						</tr>
						
						<tr>
								<td align="center" colspan="2">
									<button id="queren_addmajor">确认添加</button>&nbsp;&nbsp;
									<a class="returnBacktomajorlist"><button type="button">返回上一层</button></a>
								</td>
						</tr>	
					</table>				
					</form>
				</div>
	
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
								<select name="search_xingshi"  id="serch4kecheng">
										<c:forEach items="${courselist }" var="course">
											<option value="${course.getCourseName() }" >&nbsp;&nbsp;${course.getCourseName() }&nbsp;&nbsp;</option>
										</c:forEach>
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
						
							<tr>
								<td colspan="3" style="text-align: center">
									<pre style="font-size: 18px; color:red" >所属课程：<span class="foronekecheng"></span></pre>
								</td>	
							</tr>						
						
						
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
	<!-- delete试卷 -->
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
						
						<c:forEach items="${paperList}" var="paper" >
						<tr>
								<td>
									<pre style="font-size: 14px; width:250px;">${paper.getPaperName()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${paper.getPaperName().substring(0, paper.getPaperName().indexOf("-"))}</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">${paper.getAdaptationDegree() }</pre>	
								</td>								
								<td>
									<pre style="font-size: 18px">${paper.getTotalScore()}</pre>	
								</td>								
								<td>
									<pre style="font-size: 15px">${paper.getCreateTime()}</pre>	
								</td>
								<td>
									<pre style="font-size: 18px">${paper.getDifficulty()}</pre>	
								</td>	
								<td>
									<pre style="font-size: 18px"><a style="color: red" class="delete_paper">删除</a></pre>	
								</td>
						</tr>
						</c:forEach>
						
						
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
										<c:forEach items="${courselist }" var="course">
											<option value="${course.getCourseName() }" >&nbsp;&nbsp;${course.getCourseName() }&nbsp;&nbsp;</option>
										</c:forEach>
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
											<option value="第一章">&nbsp;&nbsp;第一章&nbsp;&nbsp;</option>
											<option value="第二章">&nbsp;&nbsp;第二章&nbsp;&nbsp;</option>
											<option value="第三章">&nbsp;&nbsp;第三章&nbsp;&nbsp;</option>
											<option value="第四章">&nbsp;&nbsp;第四章&nbsp;&nbsp;</option>
											<option value="第五章">&nbsp;&nbsp;第五章&nbsp;&nbsp;</option>
											<option value="第六章">&nbsp;&nbsp;第六章&nbsp;&nbsp;</option>
											<option value="第七章">&nbsp;&nbsp;第七章&nbsp;&nbsp;</option>
											<option value="第八章">&nbsp;&nbsp;第八章&nbsp;&nbsp;</option>
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