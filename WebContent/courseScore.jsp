<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评分页面</title>
<style type="text/css">
	td{
   width:150px;
   height:40px;
}
</style>
<%
String path = request.getContextPath();
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath

String basePath = request.getScheme()+"://"+request.getServerName()

+":"+request.getServerPort()+path+"/";
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
pageContext.setAttribute("basePath",basePath);
%> 
</head>
<body>
<h2 align="center">评分页面</h2>
<table align="center" border='1' cellspacing='0'>
    <tr>
        <td>头像</td>
        <td>姓名</td>
        <td>性别</td>
        <td>班级</td>
        <td>学院</td>
    </tr>
    
	<tr>
		<td><img src="<%=basePath%>${student.img}"/></td>
        <td>${student.name}</td>
        <td>${student.sex}</td>
        <td>${student.cid}</td>
        <td>${student.iid}</td>
	</tr>		
</table>
<br>
<div align="center">
<form action="saveScore" method="post">
语文：<input type="text" name="score1"/><input type="hidden" name="cid1" value="语文"/><br>
数学：<input type="text" name="score2"/><input type="hidden" name="cid2" value="数学"/><br>
英语：<input type="text" name="score3"/><input type="hidden" name="cid3" value="英语"/><br>
<input type="hidden" name="uid" value="${student.id}"/>
<input type="submit" value="确认"/> 
</form>
</div>
</body>
</html>