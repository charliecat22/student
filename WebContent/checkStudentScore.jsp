<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分数页面</title>
<style type="text/css">
	td{
   width:100px;
   height:40px;
}
</style>
</head>
<body>
<h3 align="center">成绩查询</h3>
<br>
<table align="center" border='1' cellspacing='0'>
    <tr>
        <td>姓名</td>
        <c:forEach items="${cs}" var="c" varStatus="st">
        <td>${c.cid}</td>
        </c:forEach>
    </tr>
    
	<tr>
        <td>${student.name}</td>
        <c:forEach items="${cs}" var="s" varStatus="st">
        <td>${s.score}</td>
        </c:forEach>
	</tr>		
</table>

</body>
</html>