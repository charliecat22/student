<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body >
<h1 align="center">学生注册信息管理系统</h1>
<div style="width:100%;text-align:center">
<form action="userLogin" method="post">
	用户名：<input  type="text" name="username"/><br>
	密码：<input  type="password" name="password"/><br>
	<input type="submit" value="登录"/><br>
	
</form>
<br>
新用户请点击<a href="register.jsp">注册</a>
</div>
</body>
</html>