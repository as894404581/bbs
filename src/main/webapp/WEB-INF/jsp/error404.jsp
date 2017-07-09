<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404-Powered by ZHTBBS Alpha</title>
<style>
	.error404{
		margin: auto;
		width: 500px;
		text-align: center;
		
	}
	.error404 a{
		color: #CCCCCC;
	}
	.error404 a:hover{
		color: black;
	}
</style>
</head>
<body>
	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<div class="error404">error:404 未找到页面,可能已经被删除或等待审核 <a href="index.do">点击返回首页</a></div>
	
	<jsp:include page="comm/botton.html"></jsp:include>
</body>
</html>