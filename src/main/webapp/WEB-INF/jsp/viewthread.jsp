<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${VIEW['title'] }-Powered by ZHTBBS Alpha</title>
<script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="static/css/viewthread.css" />
<link rel="stylesheet" href="static/css/style.css" />
<script type="text/javascript" src="static/js/viewthread.js"></script>
<script type="text/javascript">
var vid=${param.vid};
var fid=${param.fid};
var page=${param.page};
var count=parseInt(eval(((${VIEW.reply_count} - 1) / 9) + 1));
</script>

</head>

<body>

	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<div class="c">
		<a href="index.do">首页</a>
		<em>></em>
		<a href="pc.go?pcid=${PC_NAME['id'] }">${PC_NAME['plate_name'] }</a>
		<em>></em> 
		<a href="forum.go?fid=${PLATE_NAME['id'] }&page=1">${PLATE_NAME['plate_name']}</a>
		<em>></em>
		<a href="viewthread.go?vid=${param.vid }&fid=${param.fid }&page=1">${VIEW['title']}</a>
	</div>
	<div style="height: 35px; margin-top: 15px">
		<a class="post" href="cedit.go?fid=${param.fid }">发帖</a>
	</div>
	<div id="ct">
		<table>
			<thead>
				<tr>
					<td><span>查看:${VIEW['see_count']}</span></td>
					<td><span>${VIEW['title']}</span></td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty VIEW['content'] }">
					<tr>
						<td align="left" valign="top">
							<div class="users">
								<div class="pi">
									<div class="authi">
										<a href="">${ACTION['user'] }</a>
									</div>
								</div>
								<div>
									<div class="avatar">
										<img src="${ACTION['portrait'] }" width="120px" height="120px" />
									</div>
								</div>
							</div>
						</td>
						<td style="width: 100%; height: 100%;" align="left" valign="top">
							<div class="pi">
								<div class="authi">发表于:<span class="time">${VIEW['issue_time']}</span></div>
							</div> 
							<span>
								${VIEW['content'] }
								
							</span> 
							
						</td>
						
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${ACTION['user']==USER['user'] }">
								<div class="post_option">
									<a class="post_option_a"
										href="cedit.go?fid=${param.fid }&vid=${param.vid}&userid=${USER['id']}&type=post">编辑</a>
									<a class="post_option_a" href="postdelete.do?vid=${param.vid }">删除</a>
								</div>
							</c:if>
						</td>
					</tr>
				</c:if>
				<c:forEach items="${REPLY }" var="r">
					<tr>
						<td align="left" valign="top">
							<div class="users">
								<div class="pi">
									<div class="authi">
										<a href="">${r.ue['user'] }</a>
									</div>
								</div>
								<div>
									<div class="avatar">
										<img src="${r.ue['portrait'] }" width="120px" height="120px" />
									</div>
								</div>
							</div>
						</td>
						<td style="width: 100%; height: 100%;" align="left" valign="top">
							<div class="pi">
								<div class="authi">回复于:<span class="time">${r['issue_time']}</span></div>
							</div> <span>${r['content'] }</span> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${r.ue['user']==USER['user'] }">
								<div class="post_option">
									<a class="post_option_a"
										href="cedit.go?fid=${param.fid }&vid=${param.vid}&rid=${r['id'] }&type=rep">编辑</a>
									<a class="post_option_a"
										href="replydelete.do?rid=${r['id'] }&vid=${param.vid}">删除</a>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>

				<tr id="page" style="display: none;">
					<td colspan="2" style="text-align: right;" id="pagings"></td>
				</tr>

			</tbody>

		</table>
		<c:if test="${not empty USER }">
			<form id="uploadForm">
				<input onchange="upload()" type="file" name="files"
					multiple="multiple" id="file_upload"> <label id="prog"
					style="display: none;"> <progress id="progresss" max="100"></progress>
					<font id="percent">0%</font>
				</label> <span id="error"></span> <input type="text" value="rep" name="type"
					style="display: none" />
			</form>
			<div id="imageList" style="display: none;"></div>
			<div class="wysiwyg-editor">
				<div class="wysiwyg-controls">
					<a href='#' data-role='h1'>h1</a> <a href='#' data-role='h2'>h2</a>
					<a href='#' data-role='h3'>h3</a> <a href='#' data-role='bold'>B</a>
					<a href='#' data-role='italic'>I</a> <a href='#'
						data-role='underline'>U</a> <a href='#' data-role='justifyleft'><i
						class="menu-left"></i></a> <a href='#' data-role='justifycenter'><i
						class="menu-center"></i></a> <a href='#' data-role='justifyright'><i
						class="menu-right"></i></a>

				</div>

				<div class="wysiwyg-content" id="endit" contenteditable="true">

				</div>
			</div>
			<input type="button" id="rep" onclick="reply()" value="回复" />
			
		</c:if>
		<c:if test="${empty USER }">
			<div class="wysiwyg-editor">
				请登录之后再回复<b><em><a style="color: blue;"
						href="login.html?type=log">登录</a></em></b>
			</div>
		</c:if>
	</div>
	<jsp:include page="comm/botton.html"></jsp:include>


</body>

<script src="static/js/editFrame.js"></script>
<script type="text/javascript" src="static/js/FormatTime.js" ></script>

</html>