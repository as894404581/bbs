<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误-Powered by ZHTBBS Alpha</title>
</head>
<body>
	<h1>${error }</h1>
	错误:<%=exception.getMessage()%>
	
</body>
</html>