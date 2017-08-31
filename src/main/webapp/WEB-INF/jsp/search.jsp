<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索-Powered by ZHTBBS Alpha</title>
<link rel="stylesheet" href="static/css/search.css" />
<link rel="stylesheet" href="static/css/head.css" />
<script type="text/javascript" src="static/js/search.js" /></script>
<script type="text/javascript">
var SearchName="${NAME }";
var num=${param['page']};
var PageCount=${PAGE_COUNT};
</script>

</head>

<body>
	
		<jsp:include page="comm/forumHead.jsp"></jsp:include>
		<ul id="se">
			<c:forEach items="${SEARCH_RES }" var="i">
				<li>
					<h3>
						<font color="#ffoooo">
							<a href="viewthread.go?vid=${i['vid'] }&fid=${i['fid'] }&page=1">${i['title'] }</a>
						</font>
					</h3>
					<p class="lip">
						${i['see_count'] }次查看</p>
					<p>
						<span class="time">t${i['issue_time'] }</span>
						 - 
						<span>${i['action'] }</span>
					</p>
				</li>
					
			</c:forEach>
		</ul>

		<div id="paging">
			
			
		</div>

		<jsp:include page="comm/botton.html"></jsp:include>
	
</body>
<script type="text/javascript" src="static/js/FormatTime.js" ></script>

</html>