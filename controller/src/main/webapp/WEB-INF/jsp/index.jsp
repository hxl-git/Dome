<%@page import="cn.hxl.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="${path}/statics/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${path}/statics/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${path}/statics/css/layui.css">
<script src="${path}/statics/js/layui.all.js"></script>
<script type="text/javascript" src="${path}/statics/js/jquery-3.2.1.js"></script>
<script src="${path}/statics/js/ui.js"></script>
<script src="${path}/statics/js/jquery.js"></script>
<script src="${path}/statics/js/layui.js"></script>

</head>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="javascript:void(0)" onclick="tz('${path}','/add')">新增</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0)" onclick="tz('${path}','/up)">修改</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0)" onclick="del('${path}')">删除</a></li>
			</ul>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div id="span10" style="padding: 15px;">
				<button type="button" class="layui-btn" onclick="select()">查询</button>
				姓名:<input type="text" id="name1" value="${name}"/>
				<table class="layui-table" lay-even="" lay-skin="row">

					<thead>
						<tr>
							<th>选择</th>
							<th>姓名</th>
							<th>性别</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="u">
							<tr>
								<td><input type="checkbox" name="ids" value="${u.id}" /></td>
								<td>${u.name}</td>
								<td><c:forEach items="${sexList}" var="s">
									<c:if test="${u.sex==s.id}">${s.name} </c:if>	

      						</c:forEach></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
	</script>


</body>
</html>
