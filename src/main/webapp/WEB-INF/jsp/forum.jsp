<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${FORUM_INFO['plate_name']}-Powered by ZHTBBS Alpha</title>
<link rel="stylesheet" href="static/css/forum.css" />
<script type="text/javascript" src="static/js/forum.js"></script>
<script>
	var pageCount = ${PAGE_COUNT};
	var fid = ${param['fid']};
	var page = ${param['page']};
	var postCount=${FORUM_INFO['post_count']};
</script>
</head>

<body>

	<jsp:include page="comm/forumHead.jsp"></jsp:include>
	<div class="c">
		<a href="index.do">首页</a>
		<em>></em> 
		<a href="pc.go?pcid=${PC_NAME['pup'] }">${PC_NAME['plate_name'] }</a>
		<em>></em>  
		<a class="forumInfo plateName">${FORUM_INFO['plate_name']}</a>
	</div>
	<div class="bm">
		<a class="forumInfo plateName">${FORUM_INFO['plate_name']}</a>| <span>主题:
			<em> <strong class="forumInfo platePlacedCount">${FORUM_INFO['post_count']}</strong>
		</em>
		</span>
	</div>
	<a class="post" href="cedit.go?fid=${param['fid']}">发帖</a>
	<div id="mess">
		<table style="width: 100%">
			<thead style="background-color: #f2f2f2">
				<tr>
					<td colspan="2" width="55%">全部主题</td>
					<td width="15%">作者</td>
					<td width="10%">回复/人气</td>
					<td width="20%">最后发表</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="5">此板块暂无帖子</td>
				</tr>

			</tbody>
		</table>

		<div id="paging"></div>

	</div>

	<jsp:include page="comm/botton.html"></jsp:include>


</body>

</html>