<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${USER.user}-Powered by ZHTBBS Alpha</title>
<link rel="stylesheet" href="static/css/UserInfo.css" />
<script type="text/javascript" src="static/js/UserInfo.js" ></script>
<script  type="text/javascript">
	var mods='${param.mods}';
</script>
</head>
<body>
	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<table class="tabl">
		<tr>
			<td style="width: 20%;">
				<ul class="munes">
					<li onclick="Change('info')" id="info"><a href="javascript:;"  class="listA">个人资料</a></li>
					<li onclick="Change('integral')" id="integral"><a href="javascript:;" class="listA">积分</a></li>
					<li onclick="Change('group')" id="group"><a href="javascript:;"  class="listA">用户组</a></li>
					<li onclick="Change('message')" id="message"><a href="javascript:;"  class="listA">消息</a></li>
				</ul>
			</td>
			<td id="result">
				
			</td>
		</tr>
	</table>
	<jsp:include page="comm/botton.html"></jsp:include>
</body>

</html>