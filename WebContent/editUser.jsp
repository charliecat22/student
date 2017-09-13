<%@page import="com.student.pojo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑学生信息</title>
</head>
<body>
<div style="width:100%;text-align:center">
<form action="updateUserInfo" method="post" enctype="multipart/form-data">
	姓名：<input type="text" name="name" value="${student.name}"/><br>
	班级：<input type="text" name="cid" value="${student.cid}"/><br>
	学院：<input type="text" name="iid" value="${student.iid}"/><br>
	<br>
	头像：<input type="file" name="image" accept="image/*" /><br>
	
	 <input type="hidden" name="id" value="${student.id}"><br>
	 <br>
	<input type="submit" value="提交"/><br>
</form>
</div>
</body>
</html>