<%@page import="xyz.zhtdemo.bbs.entity.UserEnt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${BBS_FORUM_NAME}-Powered by ZHTBBS Alpha</title>
<link rel="stylesheet" href="static/css/index.css" />
</head>

<body>

	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<div id="infobody">
		<div id="info">

			<p class="statistics">
				主题: <em>${BBS_FORUM_POST_COUNT}</em> <span>|</span> 用户: <em>${BBS_USER_COUNT}</em>
				<span>|</span> 今日: <em>${ToDayPostCount }</em> <span>|</span> 昨日: <em>${YesterdayPostCount }</em>
				<span>|</span>
			</p>

			<div id="infoAll">
				<c:forEach items="${PLATE }" var="pcl">
					<div
						style="margin: auto; margin-top: 0px; height: 30px; background-color: #f2f2f2">
						<a style="position: absolute; margin-top: 5px;margin-left:5px;" href="">${pcl.key.plate_name }</a>
						<!--<div style=" margin: auto;padding-top:10px ;">
								
							</div>-->
					</div>

					<div style="width: 100%; margin: auto;">
						<table style="width: 100%">
							<c:forEach items="${pcl.value }" var="pl">
								<tr>
									<td width="5%" align="center"><img id="hpImg" src="${pl['img_url'] }" width="30" height="30" /></td>
									<td width="70%"><a href="forum.go?fid=${pl['id'] }&page=1">${pl['plate_name'] }</a></td>
									<td width="5%">${pl['post_count'] }/<em class="c">${pl['reply_count'] }</em></td>
									<td width="20%" >最后发表:<span class="time">t${pl['last_issue'] }</span></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div>
		当前在线:${count }人<span>|</span>在线会员:${UserCount }
	</div>
	<jsp:include page="comm/botton.html"></jsp:include>
</body>
<script type="text/javascript" src="static/js/FormatTime.js" ></script>

</html>