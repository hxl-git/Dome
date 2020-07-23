<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", path);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<script src="${path}/statics/js/jquery-3.2.1.js"></script>
	<script src="${path}/statics/js/jquery.js"></script>
	<link rel="stylesheet" href="${path}/statics/css/bootstrap.css">  
  <body>
    <span>姓名: </span><input id="name" type="text" value="${user.name}"/><br/>
    <span>性别: </span>
    <c:if test="${user==null}"><input name="sex" type="radio" value="1" checked="checked"/>男
    <input  name="sex"type="radio" value="0"/>女<br/></c:if>
    
    <c:if test="${user.sex==1}"><input name="sex" type="radio" value="1" checked="checked"/>男
    <input name="sex" type="radio" value="0"/>女</c:if>
     <c:if test="${user.sex==0 }"><input name="sex" type="radio" value="1" />男
     <input name="sex" type="radio" value="0" checked="checked"/>女<br/></c:if>
   
    
    <br/>
    
    
    <c:if test="${show =='show' }">
    <input type="button" class="container" value="保存" onclick="update('<%=path%>','${user.id}')" />
    </c:if>
    <c:if test="${show !='show' }">
  	<input type="button" class="container" value="保存" onclick="add('<%=path%>')" />
    </c:if>
    <input type="button" class="container" onclick="tz('${path}','/index.html')" value="返回"/>
 
  </body>

  
</html>
