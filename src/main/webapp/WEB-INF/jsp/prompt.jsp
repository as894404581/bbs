<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${TITL}-Powered by ZHTBBS Alpha</title>
		<style>
			.prompt_smg {
				margin: auto;
				width: 500px;
				text-align: center;
			}
		</style>
	</head>

	<body>
		<jsp:include page="comm/forumHead.jsp"></jsp:include>
		<div class="prompt_smg">
			${MSG }
			<br />
			<a href="${A_URL}">点击此返回主页</a>
		</div>
		<jsp:include page="comm/botton.html"></jsp:include>
	</body>

</html>