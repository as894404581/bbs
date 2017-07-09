<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>发表帖子-Powered by ZHTBBS Alpha</title>
<link rel="stylesheet" href="static/css/endit.css" />
<link rel="stylesheet" href="static/css/style.css" />
<script>
		var fid=${param.fid};
		var vid=
		<c:choose>
			<c:when test="${empty param.vid}">
				-1
			</c:when>
			<c:otherwise>
				${param.vid}
			</c:otherwise>
		</c:choose>;
		var userid=
		<c:choose>
			<c:when test="${empty param.userid}">
				-1
			</c:when>
			<c:otherwise>
				${param.userid}
			</c:otherwise>
		</c:choose>;
		var rid=
		<c:choose>
			<c:when test="${empty param.rid}">
				-1
			</c:when>
			<c:otherwise>
				${param.rid}
			</c:otherwise>
		</c:choose>;
		var  type=
		<c:choose>
			<c:when test="${empty param.type}">
				""
			</c:when>
			<c:otherwise>
				"${param.type}"
			</c:otherwise>
		</c:choose>;
</script>
</head>

<body>

	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<form id="uploadForm">
		<a href="javascript:;" class="a-upload" id="upload"
			onchange="upload()"> <input type="file" name="files"
			multiple="multiple" id="file_upload">上传附件
		</a> <label id="prog" style="padding: 0px; margin: 0px;"> <progress
				id="progresss" max="100"></progress> <font id="percent">0%</font>
		</label> <span id="error"></span>
	</form>

	<div id="imageList" style="display: none;"></div>
	<c:if test="${empty param.rid}">
		<span id="titlspan">标题:<input type="text" id="titl"
			value="${POST.title}" /></span>
	</c:if>
	<br />
	<div class="wysiwyg-editor">
		<div class="wysiwyg-controls">
			<a href='#' data-role='h1'>h1</a> <a href='#' data-role='h2'>h2</a> <a
				href='#' data-role='h3'>h3</a> <a href='#' data-role='bold'>B</a> <a
				href='#' data-role='italic'>I</a> <a href='#' data-role='underline'>U</a>
			<a href='#' data-role='justifyleft'><i class="menu-left"></i></a> <a
				href='#' data-role='justifycenter'><i class="menu-center"></i></a> <a
				href='#' data-role='justifyright'><i class="menu-right"></i></a>

		</div>

		<div class="wysiwyg-content" id="endit" contenteditable="true">

			<c:if test="${not empty POST}">
				${POST.content}
			</c:if>
			<c:if test="${not empty REPLY_POST}">
				${REPLY_POST.content}
			</c:if>
		</div>
	</div>

	<c:if test="${empty REPLY_POST}">
	<div id="pSetting">
		主题售价:<input type="text" id="price" style="width: 20px;"
			value="${POST.price eq null?0:POST.price}">&nbsp; 阅读权限: <select id="groupId">
			<c:forEach items="${USER_GROUP }" var="name">
			<c:choose>
					<c:when test="${ACCESS_NAME eq name}">
						<option selected = 'selected'>${name }</option>
					</c:when>
					<c:otherwise>
						<option>${name }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
	</div>
	</c:if>
	<input type="button" id="sub" value="发表" />

	<p></p>
	<jsp:include page="comm/botton.html"></jsp:include>


</body>
<script src="static/js/editFrame.js"></script>
<script type="text/javascript" src="static/js/endit.js"></script>

</html>