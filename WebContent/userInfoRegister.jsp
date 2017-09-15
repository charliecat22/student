<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息补完</title>
</head>
<body>
<h3 align="center">学生信息注册</h3>
<div style="width:100%;text-align:center">
<form action="addUserInfo" method="post" enctype="multipart/form-data">
	姓名：<input type="text" name="name"/><br>
	性别：<input type="radio" name="sex" value="男"/>男
	<input type="radio" name="sex" value="女"/>女<br>
	班级：<input type="text" name="cid"/><br>
	学院：<input type="text" name="iid"/><br>
	<br>
	头像：<input type="file" name="image" accept="image/*" /><br>
	<br>
	<input type="hidden" name="uid" value="${user.id}"/>
	<input type="submit" value="提交"/><br>
</form>
</div>
</body>
</html>