<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body onload="shownum()">
<p align="center">Login Fail</p>
<div id="showTimes" align="center"></div>
<script type="text/javascript">
	var i =5;
	function shownum(){
		i=i-1;
		if(i<0){
			i=0;
		}
		document.getElementById("showTimes").innerHTML=i+"秒后自动跳转";
		setTimeout('shownum()',1000);
	}
</script>
<meta http-equiv="refresh" content ="4;url=login.jsp">
</body>
</html>