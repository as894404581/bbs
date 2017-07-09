<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>找回密码-Powered by ZHTBBS Alpha</title>
		<link rel="stylesheet" href="static/css/updatePass.css" />
	</head>

	<body>
		<div id="all">
			<img src="static/image/logo.png" width="400px" height="100px" />
			<p>修改密码</p>
			<form action="alterPassworld.do?userId=${userId}&email_url=${email_url}" method="post" id="form1">
				<table>
					<tr>
						<td>用户编号:</td>
						<td>${userId }</td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="pass" /></td>
					</tr>
					<tr>
						<td>确认密码:</td>
						<td><input type="password" name="checkPass" /></td>
					</tr>
					<tr  style="height: 50px;">
						<td colspan="2">
							<a href="javascript:;" onclick="document.getElementById('form1').submit()">提交</a>
						</td>
					</tr>
				</table>

			</form>
		</div>
	</body>

</html>