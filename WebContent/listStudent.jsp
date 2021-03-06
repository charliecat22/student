<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<div align="center">
 <form action="searchUser" method="post" >
 	 <input type="text" name="keyword">
 	 <button type="submit">搜索</button>
</form>
<c:if test="${user.role==1}">
<a href="UnExaminedUser">审核列表</a>
</c:if>
</div>
<br>
<table align='center' border='1' cellspacing='0' >
   	<tr>
        <td>头像</td>
        <td>姓名</td>
        <td>性别</td>
        <td>班级</td>
        <td>学院</td>
        <td>编辑</td>
        <td>分数</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
         	<td><img src="<%=basePath%>${c.img}"/></td>
            <td>${c.name}</td>
            <td>${c.sex}</td>
            <td>${c.cid}</td>
            <td>${c.iid}</td>
           	<td><a href ="editUserInfo?id=${c.id}">编辑</a></td>
           	<td>
           	<c:if test="${user.role==1}">
           	<a href ="editScore?id=${c.id}">评分</a>
           	</c:if>
           	
           	<br>
           	
           	<a href="checkScore?id=${c.id}">查看</a></td>
        </tr>
    </c:forEach>
    <table>
    <br>
    <br>
    <div style="width:100%;text-align:center">
    <div>
    	<a href="?start=0">首页</a>
    	<a href="?start=${page.start-page.count}">上一页</a>
    	<a href="?start=${page.start+page.count}">下一页</a>
    	<a href="?start=${page.last}">末页</a>
    </div>
    </div>
    </table>
</table>
</body>