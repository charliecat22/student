<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title >审核页面</title>
<style type="text/css">
td{
   width:150px;
   height:40px;
}
</style>
</head>
<body>
<h2 align="center">审核页面</h2>
<br>
<table align='center' border='1' cellspacing='0' >
   	<tr>
        <td>ID</td>
        <td>用户名</td>
       	<td>审核</td>
    </tr>
    <c:forEach items="${us}" var="u" varStatus="st">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
           	<td><a href ="examined?id=${u.id}">审核通过</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<div align="center">
<a href="listStudent">返回</a>
</div>
</body>